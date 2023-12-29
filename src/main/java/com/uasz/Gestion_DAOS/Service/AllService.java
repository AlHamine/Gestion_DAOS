package com.uasz.Gestion_DAOS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uasz.Gestion_DAOS.Service.Maquette.SemestreService;
import com.uasz.Gestion_DAOS.Service.Maquette.UEService;
import com.uasz.Gestion_DAOS.Service.Repartition.PERService;
import com.uasz.Gestion_DAOS.Service.Repartition.RepartitionService;

import lombok.Data;
// @Data 
@Service
public class AllService {
    @Autowired
    public UEService ueService;
    @Autowired
    public SemestreService semestreService;
    @Autowired
    public PERService perService;
    // private RepartitionService repartitionService;
    // private UEService ueService;
    // private UEService ueService;

    // private UEService ueService;
    // private UEService ueService;
    // private UEService ueService;
    // private UEService ueService;
    // private UEService ueService;
    // private UEService ueService;

}
