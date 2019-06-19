package MySupportClasses;

import android.arch.lifecycle.ViewModel;

import com.rti.dds.domain.DomainParticipant;
import com.rti.dds.publication.Publisher;
import com.rti.dds.subscription.Subscriber;

import AutomaticCurrent.AutomaticCurrentDataReader;
import AutomaticCurrent.AutomaticCurrentDataWriter;
import AutomaticCurrent.AutomaticCurrentModel;
import Crew.CrewModel;
import Crew.crewDataReader;
import Crew.crewDataWriter;
import ECLSSuser.ECLSSuserDataReader;
import ECLSSuser.ECLSSuserDataWriter;
import ECLSSuser.ECLSSuserModel;
import FAcommands.FAcommandsDataReader;
import FAcommands.FAcommandsDataWriter;
import FAcommands.FAcommandsModel;
import FAfluids.FAfluidsDataReader;
import FAfluids.FAfluidsDataWriter;
import FAfluids.FAfluidsModel;
import FAon.FAonDataReader;
import FAon.FAonDataWriter;
import FAon.FAonModel;
import FAparams.FAparamsDataReader;
import FAparams.FAparamsDataWriter;
import FAparams.FAparamsModel;
import FAsensors.FAsensorsDataReader;
import FAsensors.FAsensorsDataWriter;
import FAsensors.FAsensorsModel;
import FAuser.FAuserDataReader;
import FAuser.FAuserDataWriter;
import FAuser.FAuserModel;
import HABfluids.HABfluidsDataReader;
import HABfluids.HABfluidsDataWriter;
import HABfluids.HABfluidsModel;
import HABparams.HABparamsDataReader;
import HABparams.HABparamsDataWriter;
import HABparams.HABparamsModel;
import InstantMetRates.InstantMetRatesDataReader;
import InstantMetRates.InstantMetRatesDataWriter;
import InstantMetRates.InstantMetRatesModel;
import OGcomands.OGcommandsDataReader;
import OGcomands.OGcommandsDataWriter;
import OGcomands.OGcommandsModel;
import OGfluids.OGfluidsDataReader;
import OGfluids.OGfluidsDataWriter;
import OGfluids.OGfluidsModel;
import OGon.OGonDataReader;
import OGon.OGonDataWriter;
import OGon.OGonModel;
import OGsensors.OGsensorsDataReader;
import OGsensors.OGsensorsDataWriter;
import OGsensors.OGsensorsModel;
import OGuser.OGuserDataReader;
import OGuser.OGuserDataWriter;
import OGuser.OGuserModel;
import PlannedMetRates.PlannedMetRatesDataReader;
import PlannedMetRates.PlannedMetRatesDataWriter;
import PlannedMetRates.PlannedMetRatesModel;
import UPAcommands.UPAcommandsDataReader;
import UPAcommands.UPAcommandsDataWriter;
import UPAcommands.UPAcommandsModel;
import UPAfluids.UPAfluidsDataReader;
import UPAfluids.UPAfluidsDataWriter;
import UPAfluids.UPAfluidsModel;
import UPAon.UPAonDataReader;
import UPAon.UPAonDataWriter;
import UPAon.UPAonModel;
import UPAsensors.UPAsensorsDataReader;
import UPAsensors.UPAsensorsDataWriter;
import UPAsensors.UPAsensorsModel;
import UWMScommands.UWMScommandsDataReader;
import UWMScommands.UWMScommandsDataWriter;
import UWMScommands.UWMScommandsModel;
import UWMSfluids.UWMSfluidsDataReader;
import UWMSfluids.UWMSfluidsDataWriter;
import UWMSfluids.UWMSfluidsModel;
import UWMSsensors.UWMSsensorsDataReader;
import UWMSsensors.UWMSsensorsDataWriter;
import UWMSsensors.UWMSsensorsModel;
import UWMSuser.UWMSuserDataReader;
import UWMSuser.UWMSuserDataWriter;
import UWMSuser.UWMSuserModel;
import WPcommands.WPcommandsDataReader;
import WPcommands.WPcommandsDataWriter;
import WPcommands.WPcommandsModel;
import WPsensors.WPsensorsDataReader;
import WPsensors.WPsensorsDataWriter;
import WPsensors.WPsensorsModel;
import WPusers.WPuserDataReader;
import WPusers.WPuserDataWriter;
import WPusers.WPuserModel;

public class FragmentsModel extends ViewModel {

    public       int domainId;
    public DomainParticipant participant;
    public Subscriber subscriber;
    public Publisher publisher;

    public Integer startTime;

    public FAsensorsDataReader fAsensorsDataReader;
    public FAsensorsDataWriter fAsensorsDataWriter;

    public FAcommandsDataReader fAcommandsDataReader;
    public FAcommandsDataWriter fAcommandsDataWriter;



    public WPuserDataReader wPuserDataReader;
    public WPuserDataWriter wPuserDataWriter;
    public WPcommandsDataReader wPcommandsDataReader;
    public WPcommandsDataWriter wPcommandsDataWriter;
    public WPsensorsDataReader wPsensorsDataReader;
    public WPsensorsDataWriter wPsensorsDataWriter;


    public UWMSuserDataReader uwmSuserDataReader;
    public UWMSuserDataWriter uwmSuserDataWriter;

    public UWMSsensorsDataReader uwmSsensorsDataReader;
    public UWMSsensorsDataWriter uwmSsensorsDataWriter;

    public UWMScommandsDataReader uwmScommandsDataReader;
    public UWMScommandsDataWriter uwmScommandsDataWriter;

    public UWMSfluidsDataReader uwmSfluidsDataReader;
    public UWMSfluidsDataWriter uwmSfluidsDataWriter;

    public AutomaticCurrentDataReader automaticCurrentDataReader;
    public AutomaticCurrentDataWriter automaticCurrentDataWriter;

    public ECLSSuserDataReader eclsSuserDataReader;
    public ECLSSuserDataWriter eclsSuserDataWriter;

    public FAfluidsDataReader fAfluidsDataReader;
    public FAfluidsDataWriter fAfluidsDataWriter;

    public FAonDataReader fAonDataReader;
    public FAonDataWriter fAonDataWriter;

    public FAparamsDataReader fAparamsDataReader;
    public FAparamsDataWriter fAparamsDataWriter;

    public FAuserDataReader fAuserDataReader;
    public FAuserDataWriter fAuserDataWriter;

    public HABfluidsDataReader haBfluidsDataReader;
    public HABfluidsDataWriter haBfluidsDataWriter;

    public HABparamsDataReader haBparamsDataReader;
    public HABparamsDataWriter haBparamsDataWriter;

    public InstantMetRatesDataReader instantMetRatesDataReader;
    public InstantMetRatesDataWriter instantMetRatesDataWriter;

    public OGcommandsDataReader oGcommandsDataReader;
    public OGcommandsDataWriter oGcommandsDataWriter;

    public OGfluidsDataReader oGfluidsDataReader;
    public OGfluidsDataWriter oGfluidsDataWriter;

    public OGonDataReader oGonDataReader;
    public OGonDataWriter oGonDataWriter;

    public OGsensorsDataReader oGsensorsDataReader;
    public OGsensorsDataWriter oGsensorsDataWriter;

    public OGuserDataReader oGuserDataReader;
    public OGuserDataWriter oGuserDataWriter;

    public PlannedMetRatesDataReader plannedMetRatesDataReader;
    public PlannedMetRatesDataWriter plannedMetRatesDataWriter;

    public UPAcommandsDataReader upAcommandsDataReader;
    public UPAcommandsDataWriter upAcommandsDataWriter;

    public UPAfluidsDataReader upAfluidsDataReader;
    public UPAfluidsDataWriter upAfluidsDataWriter;

    public UPAonDataReader upAonDataReader;
    public UPAonDataWriter upAonDataWriter;

    public UPAsensorsDataReader upAsensorsDataReader;
    public UPAsensorsDataWriter upAsensorsDataWriter;

    public crewDataReader crewwDataReader;
    public crewDataWriter crewwDataWriter;

    public FAcommandsModel fAcommandsModel;
    public FAsensorsModel fAsensorsModel;
    public FAfluidsModel fAfluidsModel;
    public FAonModel fAonModel;
    public FAparamsModel fAparamsModel;
    public FAuserModel fAuserModel;


    public WPuserModel wPuserModel;
    public WPsensorsModel wPsensorsModel;
    public WPcommandsModel wPcommandsModel;

    public UWMSuserModel uwmSuserModel;
    public UWMSsensorsModel uwmSsensorsModel;
    public UWMScommandsModel uwmScommandsModel;
    public UWMSfluidsModel uwmSfluidsModel;

    public AutomaticCurrentModel automaticCurrentModel;
    public ECLSSuserModel eclsSuserModel;

    public HABfluidsModel haBfluidsModel;
    public HABparamsModel haBparamsModel;


    public InstantMetRatesModel instantMetRatesModel;
    public PlannedMetRatesModel plannedMetRatesModel;

    public OGcommandsModel oGcommandsModel;
    public OGfluidsModel oGfluidsModel;
    public OGonModel oGonModel;
    public OGsensorsModel oGsensorsModel;
    public OGuserModel oGuserModel;


    public UPAcommandsModel upAcommandsModel;
    public UPAfluidsModel upAfluidsModel;
    public UPAonModel upAonModel;
    public UPAsensorsModel upAsensorsModel;

    public CrewModel crew;











    public FragmentsModel() {
        domainId = 0;
        participant = null;
        subscriber = null;
        publisher = null;

        fAsensorsDataReader = null;
        fAcommandsDataReader = null;

        fAsensorsDataWriter  = null;
        fAcommandsDataWriter = null;

        uwmSuserDataReader  = null;
        uwmSuserDataWriter  = null;

        wPuserDataReader  = null;
        wPuserDataWriter  = null;

        wPsensorsDataReader  = null;
        wPsensorsDataWriter  = null;

        uwmSsensorsDataReader  = null;
        uwmSsensorsDataWriter  = null;

        uwmScommandsDataReader  = null;
        uwmScommandsDataWriter  = null;

        uwmSfluidsDataReader  = null;
        uwmSfluidsDataWriter  = null;

        automaticCurrentDataReader  = null;
        automaticCurrentDataWriter  = null;

        eclsSuserDataReader  = null;
        eclsSuserDataWriter  = null;

        fAfluidsDataReader  = null;
        fAfluidsDataWriter  = null;

        fAonDataReader  = null;
        fAonDataWriter  = null;

        fAparamsDataReader  = null;
        fAparamsDataWriter  = null;

        fAuserDataReader  = null;
        fAuserDataWriter  = null;

        haBfluidsDataReader  = null;
        haBfluidsDataWriter  = null;

        haBparamsDataReader  = null;
        haBparamsDataWriter  = null;

        instantMetRatesDataReader  = null;
        instantMetRatesDataWriter  = null;

        oGcommandsDataReader  = null;
        oGcommandsDataWriter  = null;

        oGfluidsDataReader  = null;
        oGfluidsDataWriter  = null;

        oGonDataReader  = null;
        oGonDataWriter  = null;

        oGsensorsDataReader  = null;
        oGsensorsDataWriter  = null;

        oGuserDataReader  = null;
        oGuserDataWriter  = null;

        plannedMetRatesDataReader  = null;
        plannedMetRatesDataWriter  = null;

        upAcommandsDataReader  = null;
        upAcommandsDataWriter  = null;

        upAfluidsDataReader  = null;
        upAfluidsDataWriter  = null;

        upAonDataReader  = null;
        upAonDataWriter  = null;

        upAsensorsDataReader  = null;
        upAsensorsDataWriter  = null;


    }



}
