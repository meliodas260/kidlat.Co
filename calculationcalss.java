import java.text.DecimalFormat;

public class calculationcalss {
    static double ALLTOTAL;
   static double MyArrears;
static String ToTArea ;
 static DecimalFormat df = new DecimalFormat("0.00");
 static double GenerationS = 8.4979, 
        TransS = .9500,
        SLoss= .8138,
        DistriSystem = .5782,
        SupplySystem = .6001,
        MeterRetail = 5,
        MeterSystem = .4326,
        RFS = .3682,
        MissionaryElec = 0.1544,
        IncentiveRED = 0.0017,
        StrandedDebt = 0.0428,
        TrueUp = 0.0239,
        LifeL = 0.0605,
        SrCitezenSub = .0003,
        GenVat = 1.0568,
        TransmVat = 0.1157,
        SLossVAt = 0.0057,
        DistriVat = .0984,
        OtherVat = .12;
    public static String reciept (double KwUsed){
boolean lol = DBCON.ArrearsCheck(payment.Billnum);
      

        double GenerationS_T = KwUsed * GenerationS;
        double SLoss_T =  KwUsed * SLoss;
        double TransS_T = KwUsed * TransS;
        double GenTrans_subTotal =  SLoss_T + TransS_T + GenerationS_T;
    
        String GenTrans = "--------------------------GENERATION / TRANSMITION-----------------------------\n\nGeneration System\t*\t"+GenerationS+"\t" +df.format(GenerationS_T)+ "\nTransmission System\t*\t"+TransS+"\t" + df.format(TransS_T) + "\nSystem Loss\t\t*\t"+SLoss+"\t" + df.format(SLoss_T)+
        "\n\n\t\t-----------------------------------------------------\n\nGen & Trans. Charges \t\tSubtotal\t" +df.format(GenTrans_subTotal);

        double DistriSystem_T = KwUsed * DistriSystem;
        double SupplySystem_T = KwUsed * SupplySystem;
        double MeterRetail_T =  MeterRetail;
        double MeterSystem_T = KwUsed * MeterSystem;
        double RFS_T = KwUsed * RFS;
        double DistriCharge_Subt = DistriSystem_T + SupplySystem_T + MeterRetail_T + MeterSystem_T + RFS_T;

        String DistriCharge = "\n\n------------------------------DISTRIBUTION CHARGES--------------------------------\n\nDistribution System\t*\t"+DistriSystem+"\t" +df.format(DistriSystem_T)+ "\nSupply System\t*\t"+SupplySystem+"\t" + df.format(SupplySystem_T) + "\nMeter Retial\t\t\t"+MeterRetail_T+"\t" + df.format(MeterRetail_T)+
        "\nMeter System\t*\t\t"+MeterSystem_T+"\t" + df.format(MeterSystem_T)+"\nRFS\t\t*\t"+RFS+"\t" + df.format(RFS_T)+"\n\n\t\t----------------------------------------------------\n\nDistribution Charges \t\tSubtotal\t" +df.format(DistriCharge_Subt);

        double MissionaryElec_T = KwUsed * MissionaryElec;
        double IncentiveRED_T = KwUsed * IncentiveRED;
        double StrandedDebt_T = KwUsed * StrandedDebt;
        double TrueUp_T = KwUsed * TrueUp;
        double UNI_subT = MissionaryElec_T + IncentiveRED_T + StrandedDebt_T + TrueUp_T;

        String UNI_Charges = "\n\n------------------------------UNIVERSAL CHARGES--------------------------------\n\nMissionary Elec\t*\t"+MissionaryElec+"\t" +df.format(MissionaryElec_T)+ "\nIncentive for RED\t*\t"+IncentiveRED+"\t" + df.format(IncentiveRED_T) + "\nStranded Debt\t*\t"+StrandedDebt+"\t" + df.format(StrandedDebt_T)+
        "\nDCHE TrueUp(CY 2012)\t*\t"+TrueUp+"\t" + df.format(TrueUp_T)+"\n\n\t\t----------------------------------------------------\n\nUniversal Charges \t\tSubtotal\t" +df.format(UNI_subT);

        double SrCitezenSub_T = KwUsed * SrCitezenSub; 
        double LifeL_T = KwUsed * LifeL;
        double OtherSub = LifeL_T+SrCitezenSub_T;

        String OtherCharge = "\n\n------------------------------OTHER CHARGES--------------------------------\n\nLifeLine Subsidy\t*\t"+LifeL+"\t" +df.format(LifeL_T)+ "\nSenior Citizen Sub\t*\t"+SrCitezenSub+"\t" + df.format(SrCitezenSub_T) + 
        "\n\n\t\t----------------------------------------------------\n\nOther Charges \t\tSubtotal\t" +df.format(OtherSub);

        double  GenVat_T = KwUsed * GenVat;
        double  TransmVat_T = KwUsed * TransmVat;
        double  SLossVAt_T = KwUsed * SLossVAt;
        double  DistriVat_T = DistriCharge_Subt * DistriVat;
        double OtherVat_T = OtherSub * OtherVat;
        double GovCharge = GenVat_T + TransmVat_T + SLossVAt_T + DistriVat_T +OtherVat_T;

        String GovChargeSub = "\n\n------------------------------GOVERNMENT CHARGES--------------------------------\n\nDistribution VAT Total\t\t"+GenVat+"\t" +df.format(GenVat_T)+ "\nTransmission VAT Total\t\t"+TransmVat+"\t" + df.format(TransmVat_T) + "\nSystem Loss VAT Total\t\t"+SLossVAt+"\t" + df.format(SLossVAt_T)+
        "\nDisTribution VAT Total\t\t"+DistriVat_T+"\t" + df.format(DistriVat_T)+"\nOthers VAT Total\t\t"+OtherVat+"\t" + df.format(OtherVat_T)+"\n\n\t\t----------------------------------------------------\n\nTotal Government Charges \t\t\t" +df.format(GovCharge);


         double Allsubtot =OtherSub + DistriCharge_Subt + UNI_subT + GenTrans_subTotal;

        String billSubTot = "\n\nBILL   SUB   TOTAL\t\tPHP\t"+df.format(Allsubtot);
        
        double CurMonthTotal = Allsubtot + GovCharge;

        String CurMonthTotalString =  "\n\nCURRENT   MONTH   BILL\t\tPHP\t"+df.format(CurMonthTotal);
        
String MyArrearstr = "\n\nArrears\t\t\t"+DBCON.ArrearsNow;


        if(DBCON.ArrearsCheck(payment.Billnum)){
            MyArrears = 0;
             //paid past bill // without arrears
            ToTArea = GenTrans + DistriCharge + UNI_Charges + OtherCharge + billSubTot + GovChargeSub + CurMonthTotalString;

        }
        else{  
            MyArrears = DBCON.ArrearsNow;
           //pastbill not paid with arreaars
        ToTArea = GenTrans + DistriCharge + UNI_Charges + OtherCharge + billSubTot + GovChargeSub + CurMonthTotalString+MyArrearstr;
}
    ALLTOTAL = CurMonthTotal + MyArrears;
String AllTOTALstr = "\nALL  TOTAL   BILL\t\tPHP\t"+ df.format(ALLTOTAL);
        return ToTArea+AllTOTALstr;
    }

    public String total (double KwUsed){

      

        double GenerationS_T = KwUsed * GenerationS;
        double SLoss_T =  KwUsed * SLoss;
        double TransS_T = KwUsed * TransS;
        double GenTrans_subTotal =  SLoss_T + TransS_T + GenerationS_T;

        double DistriSystem_T = KwUsed * DistriSystem;
        double SupplySystem_T = KwUsed * SupplySystem;
        double MeterRetail_T =  MeterRetail;
        double MeterSystem_T = KwUsed * MeterSystem;
        double RFS_T = KwUsed * RFS;
        double DistriCharge_Subt = DistriSystem_T + SupplySystem_T + MeterRetail_T + MeterSystem_T + RFS_T;

        double MissionaryElec_T = KwUsed * MissionaryElec;
        double IncentiveRED_T = KwUsed * IncentiveRED;
        double StrandedDebt_T = KwUsed * StrandedDebt;
        double TrueUp_T = KwUsed * TrueUp;
        double UNI_subT = MissionaryElec_T + IncentiveRED_T + StrandedDebt_T + TrueUp_T;

        double SrCitezenSub_T = KwUsed * SrCitezenSub; 
        double LifeL_T = KwUsed * LifeL;
        double OtherSub = LifeL_T+SrCitezenSub_T;

        double  GenVat_T = KwUsed * GenVat;
        double  TransmVat_T = KwUsed * TransmVat;
        double  SLossVAt_T = KwUsed * SLossVAt;
        double  DistriVat_T = DistriCharge_Subt * DistriVat;
        double OtherVat_T = OtherSub * OtherVat;
        double GovCharge = GenVat_T + TransmVat_T + SLossVAt_T + DistriVat_T +OtherVat_T;

         double Allsubtot =OtherSub + DistriCharge_Subt + UNI_subT + GenTrans_subTotal;
        
        double CurMonthTotal = Allsubtot + GovCharge;

    
        double PWK= 12.5244;

        String toArea = "<html>KILOWATT USED :&emsp;&emsp;"+KwUsed+"<br>PER KILOWATT &emsp;:&emsp;&emsp;"+PWK+"<br><br>TOTAL&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;:&emsp;&emsp;"+df.format(CurMonthTotal)+"</html>";
        return toArea;
    }

}
