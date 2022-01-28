package com.vitormontich.movieapi.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vitormontich.movieapi.entities.WorstMovie;
import com.vitormontich.movieapi.models.Period;
import com.vitormontich.movieapi.repositories.WorstMovieRepository;

public class WorstMovieService {
	
	public Map<String, List<Period>> getMaxAndMinWinPeriods(WorstMovieRepository repository) {
		List<WorstMovie> list = repository.findByWinner(true); // Lista dos registros vencedores
		
		/* Lista dos nomes dos produtores (sem repetição) e seu Iterator*/
		HashSet<String> producersNameList = getProducersNameList(list); 
		Iterator<String> itProducersNameList = producersNameList.iterator();
		
		List<Period> minPeriodsByProducers = new ArrayList<Period>(); // Lista que inicialmente armazenará o menor período entre duas vitórias consecutivas de cada produtor. 
		List<Period> maxPeriodsByProducers = new ArrayList<Period>(); // Lista que inicialmente armazenará o maior período entre duas vitórias consecutivas de cada produtor.
		int minInterval = Integer.MAX_VALUE; // Menor intervalo encontrado na lista
		int maxInterval = Integer.MIN_VALUE; // Maior intervalo encontrado na lista
		
		while(itProducersNameList.hasNext()) {
			String producerName = (String) itProducersNameList.next();
			List<WorstMovie> producerWinner = repository.findByWinnerAndProducersContainingIgnoreCase(true, producerName);
			Collections.sort(producerWinner); // Ordenação por ano para garantir que a comparação será feita entre vitórias consecutivas
			if(producerWinner.size() >= 2) {
				List<Integer> years = new ArrayList<Integer>(); // Lista que armazena todos os anos que cada produtor venceu
				for(int i=0; i<producerWinner.size(); i++) {
					years.add(producerWinner.get(i).getYear());
				}
				List<Period> minPeriodAux = getMinPeriodByProducer(producerName, years);
				List<Period> maxPeriodAux = getMaxPeriodByProducer(producerName, years);
				for(Period period : minPeriodAux) {
					minPeriodsByProducers.add(period);
					if(period.getInterval() < minInterval) minInterval = period.getInterval();
				}
				for(Period period : maxPeriodAux) {
					maxPeriodsByProducers.add(period);
					if(period.getInterval() > maxInterval) maxInterval = period.getInterval();
				}
			}
		}
		
		for (Iterator<Period> itMin = minPeriodsByProducers.iterator(); itMin.hasNext(); ) {
			Period item = itMin.next();
			if(item.getInterval() != minInterval) {
				itMin.remove();
		    }
		}
		
		for (Iterator<Period> itMax = maxPeriodsByProducers.iterator(); itMax.hasNext(); ) {
			Period item = itMax.next();
			if(item.getInterval() != maxInterval) {
				itMax.remove();
		    }
		}
		
		Map<String, List<Period>> minMaxPeriod = new HashMap<String, List<Period>>();
		minMaxPeriod.put("min", minPeriodsByProducers);
		minMaxPeriod.put("max", maxPeriodsByProducers);
		
		return minMaxPeriod;
	}
	
	private List<Period> getMinPeriodByProducer(String producer, List<Integer> years) {
		
		List<Period> list = new ArrayList<Period>();
		
		int interval = Integer.MAX_VALUE;
		int previousWin = 0;
		int followingWin = 0;
		for(int i=0; i<years.size(); i++) {
			if(i == years.size()-1) {
				break;
			}
			int intervalAux = years.get(i+1) - years.get(i);
			if(intervalAux < interval) {
				list.clear();
				interval = intervalAux;
			}
			
			if(intervalAux > interval) { }
			
			previousWin = years.get(i);
			followingWin = years.get(i+1);
			list.add(new Period(producer, intervalAux, previousWin, followingWin));
		}

		return list;
	}
	
	private List<Period> getMaxPeriodByProducer(String producer, List<Integer> years) {
		
		List<Period> list = new ArrayList<Period>();
		
		int interval = Integer.MIN_VALUE;
		int previousWin = 0;
		int followingWin = 0;
		for(int i=0; i<years.size(); i++) {
			if(i == years.size()-1) {
				break;
			}
			int intervalAux = years.get(i+1) - years.get(i);
			if(intervalAux > interval) {
				list.clear();
				interval = intervalAux;
			}
			
			if(intervalAux < interval) { }
			
			previousWin = years.get(i);
			followingWin = years.get(i+1);
			list.add(new Period(producer, intervalAux, previousWin, followingWin));
		}

		return list;
	}
	
	/*
	private Period getMaxPeriodByProducer(String producer, List<Integer> years) {
		int interval = Integer.MIN_VALUE;
		int previousWin = 0;
		int followingWin = 0;
		for(int i=0; i<years.size(); i++) {
			if(i == years.size()-1) {
				break;
			}
			int intervalAux = years.get(i+1) - years.get(i);
			if(intervalAux > interval) {
				interval = intervalAux;
				previousWin = years.get(i);
				followingWin = years.get(i+1);
			}
		}
		Period period = new Period(producer, interval, previousWin, followingWin);
		return period;
	}
	*/
	
	private HashSet<String> getProducersNameList(List<WorstMovie> list) {
		HashSet<String> producers = new HashSet<String>();
		for(int i=0; i<list.size(); i++) {
			WorstMovie worst = list.get(i);
			String[] producerList = worst.getProducers().replace(", and ", ";").replace(", ", ";").replace(" and ", ";").split(";"); /* replace(", and ", ";") adicionado pois foi encontrado um registro assim */
			for(String prod : producerList) {
				producers.add(prod);
			}
		}
		return producers;
	}
}
