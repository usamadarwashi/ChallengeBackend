package com.byanatchallenge.celltowersmanager.service;

import com.byanatchallenge.celltowersmanager.Entity.CellTower;
import com.byanatchallenge.celltowersmanager.repo.CellTowerRepo;
import jakarta.transaction.Transactional;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CellTowerService {
    private final CellTowerRepo cellTowerRepo;

    @Autowired
    public CellTowerService(CellTowerRepo cellTowerRepo) {
        this.cellTowerRepo = cellTowerRepo;
    }

    public CellTower addCellTower(@NotNull CellTower cellTower) {
        cellTower.setAddress(UUID.randomUUID().toString());
        return cellTowerRepo.save(cellTower);
    }

    public List<CellTower> findAllCellTowers() {
        return cellTowerRepo.findAll();
    }

    public CellTower updateCellTower(CellTower cellTower) {
        return cellTowerRepo.save(cellTower);
    }

    public CellTower findCellTowerById(Long id) {
        return cellTowerRepo.findCellTowerById(id);
    }
    @Transactional
    public String deleteCellTower(Long id) {
        cellTowerRepo.deleteCellTowerById(id);
        return ("Cell Tower by id " + id +" is deleted");
    }


        public Boolean checkCellTower(CellTower cellTower) {
            if (cellTower == null ||

                    cellTower.getTower_id() == null ||
                    cellTower.getOperator() == null ||
                    cellTower.getAddress() == null ||
                    cellTower.getHeight() == null ||
                    cellTower.getTower_type() == null ||
                    cellTower.getLatitude() == null ||
                    cellTower.getLongitude() == null ||
                    cellTower.getTechnology() == null) {
                return false;
            }
            return true;
        }
}


