package edu.msudenver.services;

import edu.msudenver.models.Stats;

import java.util.List;

public interface StatsService {

    Stats createStats(Stats stats);

    List<Stats> getStatsList();
}
