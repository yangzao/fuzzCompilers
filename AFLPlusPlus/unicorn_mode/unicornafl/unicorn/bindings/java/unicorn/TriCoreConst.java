// For Unicorn Engine. AUTO-GENERATED FILE, DO NOT EDIT

package unicorn;

public interface TriCoreConst {

// TRICORE CPU

   public static final int UC_CPU_TRICORE_TC1796 = 0;
   public static final int UC_CPU_TRICORE_TC1797 = 1;
   public static final int UC_CPU_TRICORE_TC27X = 2;
   public static final int UC_CPU_TRICORE_ENDING = 3;

// TRICORE registers

   public static final int UC_TRICORE_REG_INVALID = 0;
   public static final int UC_TRICORE_REG_A0 = 1;
   public static final int UC_TRICORE_REG_A1 = 2;
   public static final int UC_TRICORE_REG_A2 = 3;
   public static final int UC_TRICORE_REG_A3 = 4;
   public static final int UC_TRICORE_REG_A4 = 5;
   public static final int UC_TRICORE_REG_A5 = 6;
   public static final int UC_TRICORE_REG_A6 = 7;
   public static final int UC_TRICORE_REG_A7 = 8;
   public static final int UC_TRICORE_REG_A8 = 9;
   public static final int UC_TRICORE_REG_A9 = 10;
   public static final int UC_TRICORE_REG_A10 = 11;
   public static final int UC_TRICORE_REG_A11 = 12;
   public static final int UC_TRICORE_REG_A12 = 13;
   public static final int UC_TRICORE_REG_A13 = 14;
   public static final int UC_TRICORE_REG_A14 = 15;
   public static final int UC_TRICORE_REG_A15 = 16;
   public static final int UC_TRICORE_REG_D0 = 17;
   public static final int UC_TRICORE_REG_D1 = 18;
   public static final int UC_TRICORE_REG_D2 = 19;
   public static final int UC_TRICORE_REG_D3 = 20;
   public static final int UC_TRICORE_REG_D4 = 21;
   public static final int UC_TRICORE_REG_D5 = 22;
   public static final int UC_TRICORE_REG_D6 = 23;
   public static final int UC_TRICORE_REG_D7 = 24;
   public static final int UC_TRICORE_REG_D8 = 25;
   public static final int UC_TRICORE_REG_D9 = 26;
   public static final int UC_TRICORE_REG_D10 = 27;
   public static final int UC_TRICORE_REG_D11 = 28;
   public static final int UC_TRICORE_REG_D12 = 29;
   public static final int UC_TRICORE_REG_D13 = 30;
   public static final int UC_TRICORE_REG_D14 = 31;
   public static final int UC_TRICORE_REG_D15 = 32;
   public static final int UC_TRICORE_REG_PCXI = 33;
   public static final int UC_TRICORE_REG_PSW = 34;
   public static final int UC_TRICORE_REG_PSW_USB_C = 35;
   public static final int UC_TRICORE_REG_PSW_USB_V = 36;
   public static final int UC_TRICORE_REG_PSW_USB_SV = 37;
   public static final int UC_TRICORE_REG_PSW_USB_AV = 38;
   public static final int UC_TRICORE_REG_PSW_USB_SAV = 39;
   public static final int UC_TRICORE_REG_PC = 40;
   public static final int UC_TRICORE_REG_SYSCON = 41;
   public static final int UC_TRICORE_REG_CPU_ID = 42;
   public static final int UC_TRICORE_REG_BIV = 43;
   public static final int UC_TRICORE_REG_BTV = 44;
   public static final int UC_TRICORE_REG_ISP = 45;
   public static final int UC_TRICORE_REG_ICR = 46;
   public static final int UC_TRICORE_REG_FCX = 47;
   public static final int UC_TRICORE_REG_LCX = 48;
   public static final int UC_TRICORE_REG_COMPAT = 49;
   public static final int UC_TRICORE_REG_DPR0_U = 50;
   public static final int UC_TRICORE_REG_DPR1_U = 51;
   public static final int UC_TRICORE_REG_DPR2_U = 52;
   public static final int UC_TRICORE_REG_DPR3_U = 53;
   public static final int UC_TRICORE_REG_DPR0_L = 54;
   public static final int UC_TRICORE_REG_DPR1_L = 55;
   public static final int UC_TRICORE_REG_DPR2_L = 56;
   public static final int UC_TRICORE_REG_DPR3_L = 57;
   public static final int UC_TRICORE_REG_CPR0_U = 58;
   public static final int UC_TRICORE_REG_CPR1_U = 59;
   public static final int UC_TRICORE_REG_CPR2_U = 60;
   public static final int UC_TRICORE_REG_CPR3_U = 61;
   public static final int UC_TRICORE_REG_CPR0_L = 62;
   public static final int UC_TRICORE_REG_CPR1_L = 63;
   public static final int UC_TRICORE_REG_CPR2_L = 64;
   public static final int UC_TRICORE_REG_CPR3_L = 65;
   public static final int UC_TRICORE_REG_DPM0 = 66;
   public static final int UC_TRICORE_REG_DPM1 = 67;
   public static final int UC_TRICORE_REG_DPM2 = 68;
   public static final int UC_TRICORE_REG_DPM3 = 69;
   public static final int UC_TRICORE_REG_CPM0 = 70;
   public static final int UC_TRICORE_REG_CPM1 = 71;
   public static final int UC_TRICORE_REG_CPM2 = 72;
   public static final int UC_TRICORE_REG_CPM3 = 73;
   public static final int UC_TRICORE_REG_MMU_CON = 74;
   public static final int UC_TRICORE_REG_MMU_ASI = 75;
   public static final int UC_TRICORE_REG_MMU_TVA = 76;
   public static final int UC_TRICORE_REG_MMU_TPA = 77;
   public static final int UC_TRICORE_REG_MMU_TPX = 78;
   public static final int UC_TRICORE_REG_MMU_TFA = 79;
   public static final int UC_TRICORE_REG_BMACON = 80;
   public static final int UC_TRICORE_REG_SMACON = 81;
   public static final int UC_TRICORE_REG_DIEAR = 82;
   public static final int UC_TRICORE_REG_DIETR = 83;
   public static final int UC_TRICORE_REG_CCDIER = 84;
   public static final int UC_TRICORE_REG_MIECON = 85;
   public static final int UC_TRICORE_REG_PIEAR = 86;
   public static final int UC_TRICORE_REG_PIETR = 87;
   public static final int UC_TRICORE_REG_CCPIER = 88;
   public static final int UC_TRICORE_REG_DBGSR = 89;
   public static final int UC_TRICORE_REG_EXEVT = 90;
   public static final int UC_TRICORE_REG_CREVT = 91;
   public static final int UC_TRICORE_REG_SWEVT = 92;
   public static final int UC_TRICORE_REG_TR0EVT = 93;
   public static final int UC_TRICORE_REG_TR1EVT = 94;
   public static final int UC_TRICORE_REG_DMS = 95;
   public static final int UC_TRICORE_REG_DCX = 96;
   public static final int UC_TRICORE_REG_DBGTCR = 97;
   public static final int UC_TRICORE_REG_CCTRL = 98;
   public static final int UC_TRICORE_REG_CCNT = 99;
   public static final int UC_TRICORE_REG_ICNT = 100;
   public static final int UC_TRICORE_REG_M1CNT = 101;
   public static final int UC_TRICORE_REG_M2CNT = 102;
   public static final int UC_TRICORE_REG_M3CNT = 103;
   public static final int UC_TRICORE_REG_ENDING = 104;
   public static final int UC_TRICORE_REG_GA0 = 1;
   public static final int UC_TRICORE_REG_GA1 = 2;
   public static final int UC_TRICORE_REG_GA8 = 9;
   public static final int UC_TRICORE_REG_GA9 = 10;
   public static final int UC_TRICORE_REG_SP = 11;
   public static final int UC_TRICORE_REG_LR = 12;
   public static final int UC_TRICORE_REG_IA = 16;
   public static final int UC_TRICORE_REG_ID = 32;

}
