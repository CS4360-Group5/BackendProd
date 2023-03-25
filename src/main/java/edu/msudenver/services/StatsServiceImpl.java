package edu.msudenver.services;

import edu.msudenver.models.Stats;
import edu.msudenver.repository.StatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatsServiceImpl implements StatsService {

    private final StatsRepository statsRepository;

    @Autowired
    public StatsServiceImpl(StatsRepository statsRepository) {
        this.statsRepository = statsRepository;
    }

    @Override
    public Stats createStats(Stats stats) {
        return statsRepository.save(stats);
    }

    @Override
    public List<Stats> getStatsList() {
        return statsRepository.findAll();
    }
}
