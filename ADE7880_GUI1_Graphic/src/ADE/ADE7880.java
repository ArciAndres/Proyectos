/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ADE;

/**
 *
 * @author ANDRES ARCINIEGAS
 */
public class ADE7880 {
        //Convention: 
        //Address of Register = 0xbyte1byte2;
        //byte[][]{ {0xbyte1,0xbyte2} , {BitLength, ByteLengthDuringCommunication, SignedOrUnsigned}   //Signed = 1, Unsigned = 0
        //Refer to ADE7880 Datasheet Table of Registers/
        
        public static final int ADE7880_ADDR = 0x38; // address pin not connected (FLOATING)
        public static final byte[][] TEST	          = new byte[][]{{(byte)0xE5,(byte)0x1F},{4}};
            
        public static final byte[][] AIGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x80} , {24 , 4 , 1} } ;  //  0x4380
        public static final byte[][] AVGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x81} , {24 , 4 , 1} } ;  //  0x4381
        public static final byte[][] BIGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x82} , {24 , 4 , 1} } ;  //  0x4382
        public static final byte[][] BVGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x83} , {24 , 4 , 1} } ;  //  0x4383
        public static final byte[][] CIGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x84} , {24 , 4 , 1} } ;  //  0x4384
        public static final byte[][] CVGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x85} , {24 , 4 , 1} } ;  //  0x4385
        public static final byte[][] NIGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x86} , {24 , 4 , 1} } ;  //  0x4386
        public static final byte[][] DICOEFF              = new byte[][]{ {(byte)0x43,(byte)0x88} , {24 , 4 , 1} } ;  //  0x4388
        public static final byte[][] APGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x89} , {24 , 4 , 1} } ;  //  0x4389
        public static final byte[][] AWATTOS              = new byte[][]{ {(byte)0x43,(byte)0x8A} , {24 , 4 , 1} } ;  //  0x438A
        public static final byte[][] BPGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x8B} , {24 , 4 , 1} } ;  //  0x438B
        public static final byte[][] BWATTOS        	  = new byte[][]{ {(byte)0x43,(byte)0x8C} , {24 , 4 , 1} } ;  //  0x438C
        public static final byte[][] CPGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x8D} , {24 , 4 , 1} } ;  //  0x438D
        public static final byte[][] CWATTOS              = new byte[][]{ {(byte)0x43,(byte)0x8E} , {24 , 4 , 1} } ;  //  0x438E
        public static final byte[][] AIRMSOS              = new byte[][]{ {(byte)0x43,(byte)0x8F} , {24 , 4 , 1} } ;  //  0x438F
        public static final byte[][] AVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0x90} , {24 , 4 , 1} } ;  //  0x4390
        public static final byte[][] BIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0x91} , {24 , 4 , 1} } ;  //  0x4391
        public static final byte[][] BVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0x92} , {24 , 4 , 1} } ;  //  0x4392
        public static final byte[][] CIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0x93} , {24 , 4 , 1} } ;  //  0x4393
        public static final byte[][] CVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0x94} , {24 , 4 , 1} } ;  //  0x4394
        public static final byte[][] NIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0x95} , {24 , 4 , 1} } ;  //  0x4395
        public static final byte[][] HPGAIN	          = new byte[][]{ {(byte)0x43,(byte)0x98} , {24 , 4 , 1} } ;  //  0x4398
        public static final byte[][] ISUMLVL	          = new byte[][]{ {(byte)0x43,(byte)0x99} , {24 , 4 , 1} } ;  //  0x4399
        public static final byte[][] VLEVEL	          = new byte[][]{ {(byte)0x43,(byte)0x9F} , {28 , 4 , 1} } ;  //  0x439F
        public static final byte[][] AFWATTOS	          = new byte[][]{ {(byte)0x43,(byte)0xA2} , {24 , 4 , 1} } ;  //  0x43A2
        public static final byte[][] BFWATTOS	          = new byte[][]{ {(byte)0x43,(byte)0xA3} , {24 , 4 , 1} } ;  //  0x43A3
        public static final byte[][] CFWATTOS	          = new byte[][]{ {(byte)0x43,(byte)0xA4} , {24 , 4 , 1} } ;  //  0x43A4
        public static final byte[][] AFVAROS	          = new byte[][]{ {(byte)0x43,(byte)0xA5} , {24 , 4 , 1} } ;  //  0x43A5
        public static final byte[][] BFVAROS	          = new byte[][]{ {(byte)0x43,(byte)0xA6} , {24 , 4 , 1} } ;  //  0x43A6
        public static final byte[][] CFVAROS	          = new byte[][]{ {(byte)0x43,(byte)0xA7} , {24 , 4 , 1} } ;  //  0x43A7
        public static final byte[][] AFIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xA8} , {24 , 4 , 1} } ;  //  0x43A8
        public static final byte[][] BFIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xA9} , {24 , 4 , 1} } ;  //  0x43A9
        public static final byte[][] CFIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xAA} , {24 , 4 , 1} } ;  //  0x43AA
        public static final byte[][] AFVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xAB} , {24 , 4 , 1} } ;  //  0x43AB
        public static final byte[][] BFVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xAC} , {24 , 4 , 1} } ;  //  0x43AC
        public static final byte[][] CFVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xAD} , {24 , 4 , 1} } ;  //  0x43AD
        public static final byte[][] HXWATTOS	          = new byte[][]{ {(byte)0x43,(byte)0xAE} , {24 , 4 , 1} } ;  //  0x43AE
        public static final byte[][] HYWATTOS	          = new byte[][]{ {(byte)0x43,(byte)0xAF} , {24 , 4 , 1} } ;  //  0x43AF
        public static final byte[][] HZWATTOS	          = new byte[][]{ {(byte)0x43,(byte)0xB0} , {24 , 4 , 1} } ;  //  0x43B0
        public static final byte[][] HXVAROS	          = new byte[][]{ {(byte)0x43,(byte)0xB1} , {24 , 4 , 1} } ;  //  0x43B1
        public static final byte[][] HYVAROS	          = new byte[][]{ {(byte)0x43,(byte)0xB2} , {24 , 4 , 1} } ;  //  0x43B2
        public static final byte[][] HZVAROS	          = new byte[][]{ {(byte)0x43,(byte)0xB3} , {24 , 4 , 1} } ;  //  0x43B3
        public static final byte[][] HXIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xB4} , {24 , 4 , 1} } ;  //  0x43B4
        public static final byte[][] HYIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xB5} , {24 , 4 , 1} } ;  //  0x43B5
        public static final byte[][] HZIRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xB6} , {24 , 4 , 1} } ;  //  0x43B6
        public static final byte[][] HXVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xB7} , {24 , 4 , 1} } ;  //  0x43B7
        public static final byte[][] HYVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xB8} , {24 , 4 , 1} } ;  //  0x43B8
        public static final byte[][] HZVRMSOS	          = new byte[][]{ {(byte)0x43,(byte)0xB9} , {24 , 4 , 1} } ;  //  0x43B9
        public static final byte[][] AIRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC0} , {24 , 4 , 1} } ;  //  0x43C0
        public static final byte[][] AVRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC1} , {24 , 4 , 1} } ;  //  0x43C1
        public static final byte[][] BIRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC2} , {24 , 4 , 1} } ;  //  0x43C2
        public static final byte[][] BVRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC3} , {24 , 4 , 1} } ;  //  0x43C3
        public static final byte[][] CIRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC4} , {24 , 4 , 1} } ;  //  0x43C4
        public static final byte[][] CVRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC5} , {24 , 4 , 1} } ;  //  0x43C5
        public static final byte[][] NIRMS	          = new byte[][]{ {(byte)0x43,(byte)0xC6} , {24 , 4 , 1} } ;  //  0x43C6
        public static final byte[][] ISUM	          = new byte[][]{ {(byte)0x43,(byte)0xC7} , {28 , 4 , 1} } ;  //  0x43C7
        public static final byte[][] RUN	          = new byte[][]{ {(byte)0xE2,(byte)0x28} , {16 , 2 , 0} } ;  //  0xE228
        public static final byte[][] AWATTHR	          = new byte[][]{ {(byte)0xE4,(byte)0x00} , {32 , 4 , 1} } ;  //  0xE400
        public static final byte[][] BWATTHR	          = new byte[][]{ {(byte)0xE4,(byte)0x01} , {32 , 4 , 1} } ;  //  0xE401
        public static final byte[][] CWATTHR	          = new byte[][]{ {(byte)0xE4,(byte)0x02} , {32 , 4 , 1} } ;  //  0xE402
        public static final byte[][] AFWATTHR	          = new byte[][]{ {(byte)0xE4,(byte)0x03} , {32 , 4 , 1} } ;  //  0xE403
        public static final byte[][] BFWATTHR	          = new byte[][]{ {(byte)0xE4,(byte)0x04} , {32 , 4 , 1} } ;  //  0xE404
        public static final byte[][] CFWATTHR	          = new byte[][]{ {(byte)0xE4,(byte)0x05} , {32 , 4 , 1} } ;  //  0xE405
        public static final byte[][] AFVARHR	          = new byte[][]{ {(byte)0xE4,(byte)0x09} , {32 , 4 , 1} } ;  //  0xE409
        public static final byte[][] BFVARHR	          = new byte[][]{ {(byte)0xE4,(byte)0x0A} , {32 , 4 , 1} } ;  //  0xE40A
        public static final byte[][] CFVARHR	          = new byte[][]{ {(byte)0xE4,(byte)0x0B} , {32 , 4 , 1} } ;  //  0xE40B
        public static final byte[][] AVAHR	          = new byte[][]{ {(byte)0xE4,(byte)0x0C} , {32 , 4 , 1} } ;  //  0xE40C
        public static final byte[][] BVAHR	          = new byte[][]{ {(byte)0xE4,(byte)0x0D} , {32 , 4 , 1} } ;  //  0xE40D
        public static final byte[][] CVAHR	          = new byte[][]{ {(byte)0xE4,(byte)0x0E} , {32 , 4 , 1} } ;  //  0xE40E
        public static final byte[][] IPEAK	          = new byte[][]{ {(byte)0xE5,(byte)0x00} , {32 , 4 , 0} } ;  //  0xE500
        public static final byte[][] VPEAK	          = new byte[][]{ {(byte)0xE5,(byte)0x01} , {32 , 4 , 0} } ;  //  0xE501
        public static final byte[][] STATUS0	          = new byte[][]{ {(byte)0xE5,(byte)0x02} , {32 , 4 , 0} } ;  //  0xE502
        public static final byte[][] STATUS1	          = new byte[][]{ {(byte)0xE5,(byte)0x03} , {32 , 4 , 0} } ;  //  0xE503
        public static final byte[][] AIMAV	          = new byte[][]{ {(byte)0xE5,(byte)0x04} , {20 , 4 , 0} } ;  //  0xE504
        public static final byte[][] BIMAV	          = new byte[][]{ {(byte)0xE5,(byte)0x05} , {20 , 4 , 0} } ;  //  0xE505
        public static final byte[][] CIMAV	          = new byte[][]{ {(byte)0xE5,(byte)0x06} , {20 , 4 , 0} } ;  //  0xE506
        public static final byte[][] OILVL	          = new byte[][]{ {(byte)0xE5,(byte)0x07} , {24 , 4 , 0} } ;  //  0xE507
        public static final byte[][] OVLVL	          = new byte[][]{ {(byte)0xE5,(byte)0x08} , {24 , 4 , 0} } ;  //  0xE508
        public static final byte[][] SAGLVL	          = new byte[][]{ {(byte)0xE5,(byte)0x09} , {24 , 4 , 0} } ;  //  0xE509
        public static final byte[][] MASK0	          = new byte[][]{ {(byte)0xE5,(byte)0x0A} , {32 , 4 , 0} } ;  //  0xE50A
        public static final byte[][] MASK1	          = new byte[][]{ {(byte)0xE5,(byte)0x0B} , {32 , 4 , 0} } ;  //  0xE50B
        public static final byte[][] IAWV	          = new byte[][]{ {(byte)0xE5,(byte)0x0C} , {24 , 4 , 1} } ;  //  0xE50C
        public static final byte[][] IBWV	          = new byte[][]{ {(byte)0xE5,(byte)0x0D} , {24 , 4 , 1} } ;  //  0xE50D
        public static final byte[][] ICWV	          = new byte[][]{ {(byte)0xE5,(byte)0x0E} , {24 , 4 , 1} } ;  //  0xE50E
        public static final byte[][] INWV	          = new byte[][]{ {(byte)0xE5,(byte)0x0F} , {24 , 4 , 1} } ;  //  0xE50F
        public static final byte[][] VAWV	          = new byte[][]{ {(byte)0xE5,(byte)0x10} , {24 , 4 , 1} } ;  //  0xE510
        public static final byte[][] VBWV	          = new byte[][]{ {(byte)0xE5,(byte)0x11} , {24 , 4 , 1} } ;  //  0xE511
        public static final byte[][] VCWV	          = new byte[][]{ {(byte)0xE5,(byte)0x12} , {24 , 4 , 1} } ;  //  0xE512
        public static final byte[][] AWATT	          = new byte[][]{ {(byte)0xE5,(byte)0x13} , {24 , 4 , 1} } ;  //  0xE513
        public static final byte[][] BWATT	          = new byte[][]{ {(byte)0xE5,(byte)0x14} , {24 , 4 , 1} } ;  //  0xE514
        public static final byte[][] CWATT	          = new byte[][]{ {(byte)0xE5,(byte)0x15} , {24 , 4 , 1} } ;  //  0xE515
        public static final byte[][] AFVAR	          = new byte[][]{ {(byte)0xE5,(byte)0x16} , {24 , 4 , 1} } ;  //  0xE516
        public static final byte[][] BFVAR	          = new byte[][]{ {(byte)0xE5,(byte)0x17} , {24 , 4 , 1} } ;  //  0xE517
        public static final byte[][] CFVAR	          = new byte[][]{ {(byte)0xE5,(byte)0x18} , {24 , 4 , 1} } ;  //  0xE518
        public static final byte[][] AVA	          = new byte[][]{ {(byte)0xE5,(byte)0x19} , {24 , 4 , 1} } ;  //  0xE519
        public static final byte[][] BVA	          = new byte[][]{ {(byte)0xE5,(byte)0x1A} , {24 , 4 , 1} } ;  //  0xE51A
        public static final byte[][] CVA	          = new byte[][]{ {(byte)0xE5,(byte)0x1B} , {24 , 4 , 1} } ;  //  0xE51B
        public static final byte[][] CHECKSUM	          = new byte[][]{ {(byte)0xE5,(byte)0x1F} , {32 , 4 , 0} } ;  //  0xE51F
        public static final byte[][] VNOM	          = new byte[][]{ {(byte)0xE5,(byte)0x20} , {24 , 4 , 1} } ;  //  0xE520
        public static final byte[][] LAST_RWDATA_24bit    = new byte[][]{ {(byte)0xE5,(byte)0xFF} , {32 , 4 , 0} } ;  //  0xE5FF
        public static final byte[][] PHSTATUS             = new byte[][]{ {(byte)0xE6,(byte)0x00} , {16 , 2 , 0} } ;  //  0xE600
        public static final byte[][] ANGLE0	          = new byte[][]{ {(byte)0xE6,(byte)0x01} , {16 , 2 , 0} } ;  //  0xE601
        public static final byte[][] ANGLE1	          = new byte[][]{ {(byte)0xE6,(byte)0x02} , {16 , 2 , 0} } ;  //  0xE602
        public static final byte[][] ANGLE2	          = new byte[][]{ {(byte)0xE6,(byte)0x03} , {16 , 2 , 0} } ;  //  0xE603
        public static final byte[][] PHNOLOAD	          = new byte[][]{ {(byte)0xE6,(byte)0x08} , {16 , 2 , 0} } ;  //  0xE608
        public static final byte[][] LINECYC	          = new byte[][]{ {(byte)0xE6,(byte)0x0C} , {16 , 2 , 0} } ;  //  0xE60C
        public static final byte[][] ZXTOUT	          = new byte[][]{ {(byte)0xE6,(byte)0x0D} , {16 , 2 , 0} } ;  //  0xE60D
        public static final byte[][] COMPMODE	          = new byte[][]{ {(byte)0xE6,(byte)0x0E} , {16 , 2 , 0} } ;  //  0xE60E
        public static final byte[][] Gain	          = new byte[][]{ {(byte)0xE6,(byte)0x0F} , {16 , 2 , 0} } ;  //  0xE60F
        public static final byte[][] CFMODE	          = new byte[][]{ {(byte)0xE6,(byte)0x10} , {16 , 2 , 0} } ;  //  0xE610
        public static final byte[][] CF1DEN	          = new byte[][]{ {(byte)0xE6,(byte)0x11} , {16 , 2 , 0} } ;  //  0xE611
        public static final byte[][] CF2DEN	          = new byte[][]{ {(byte)0xE6,(byte)0x12} , {16 , 2 , 0} } ;  //  0xE612
        public static final byte[][] CF3DEN	          = new byte[][]{ {(byte)0xE6,(byte)0x13} , {16 , 2 , 0} } ;  //  0xE613
        public static final byte[][] APHCAL	          = new byte[][]{ {(byte)0xE6,(byte)0x14} , {10 , 2 , 1} } ;  //  0xE614
        public static final byte[][] BPHCAL	          = new byte[][]{ {(byte)0xE6,(byte)0x15} , {10 , 2 , 1} } ;  //  0xE615
        public static final byte[][] CPHCAL	          = new byte[][]{ {(byte)0xE6,(byte)0x16} , {10 , 2 , 1} } ;  //  0xE616
        public static final byte[][] PHSIGN	          = new byte[][]{ {(byte)0xE6,(byte)0x17} , {16 , 2 , 0} } ;  //  0xE617
        public static final byte[][] CONFIG	          = new byte[][]{ {(byte)0xE6,(byte)0x18} , {16 , 2 , 0} } ;  //  0xE618
        public static final byte[][] MMODE	          = new byte[][]{ {(byte)0xE7,(byte)0x00} , {8 , 1 , 0} } ;  //  0xE700
        public static final byte[][] ACCMODE	          = new byte[][]{ {(byte)0xE7,(byte)0x01} , {8 , 1 , 0} } ;  //  0xE701
        public static final byte[][] LCYCMODE	          = new byte[][]{ {(byte)0xE7,(byte)0x02} , {8 , 1 , 0} } ;  //  0xE702
        public static final byte[][] PEAKCYC	          = new byte[][]{ {(byte)0xE7,(byte)0x03} , {8 , 1 , 0} } ;  //  0xE703
        public static final byte[][] SAGCYC	          = new byte[][]{ {(byte)0xE7,(byte)0x04} , {8 , 1 , 0} } ;  //  0xE704
        public static final byte[][] CFCYC	          = new byte[][]{ {(byte)0xE7,(byte)0x05} , {8 , 1 , 0} } ;  //  0xE705
        public static final byte[][] HSDC_CFG	          = new byte[][]{ {(byte)0xE7,(byte)0x06} , {8 , 1 , 0} } ;  //  0xE706
        public static final byte[][] Version	          = new byte[][]{ {(byte)0xE7,(byte)0x07} , {8 , 1 , 0} } ;  //  0xE707
        public static final byte[][] LAST_RWDATA_8bit     = new byte[][]{ {(byte)0xE7,(byte)0xFD} , {8 , 1 , 0} } ;  //  0xE7FD
        public static final byte[][] FVRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x80} , {24 , 4 , 1} } ;  //  0xE880
        public static final byte[][] FIRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x81} , {24 , 4 , 1} } ;  //  0xE881
        public static final byte[][] FWATT	          = new byte[][]{ {(byte)0xE8,(byte)0x82} , {24 , 4 , 1} } ;  //  0xE882
        public static final byte[][] FVAR	          = new byte[][]{ {(byte)0xE8,(byte)0x83} , {24 , 4 , 1} } ;  //  0xE883
        public static final byte[][] FVA	          = new byte[][]{ {(byte)0xE8,(byte)0x84} , {24 , 4 , 1} } ;  //  0xE884
        public static final byte[][] FPF	          = new byte[][]{ {(byte)0xE8,(byte)0x85} , {24 , 4 , 1} } ;  //  0xE885
        public static final byte[][] VTHDN	          = new byte[][]{ {(byte)0xE8,(byte)0x86} , {24 , 4 , 1} } ;  //  0xE886
        public static final byte[][] ITHDN	          = new byte[][]{ {(byte)0xE8,(byte)0x87} , {24 , 4 , 1} } ;  //  0xE887
        public static final byte[][] HXVRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x88} , {24 , 4 , 1} } ;  //  0xE888
        public static final byte[][] HXIRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x89} , {24 , 4 , 1} } ;  //  0xE889
        public static final byte[][] HXWATT	          = new byte[][]{ {(byte)0xE8,(byte)0x8A} , {24 , 4 , 1} } ;  //  0xE88A
        public static final byte[][] HXVAR	          = new byte[][]{ {(byte)0xE8,(byte)0x8B} , {24 , 4 , 1} } ;  //  0xE88B
        public static final byte[][] HXVA	          = new byte[][]{ {(byte)0xE8,(byte)0x8C} , {24 , 4 , 1} } ;  //  0xE88C
        public static final byte[][] HXPF	          = new byte[][]{ {(byte)0xE8,(byte)0x8D} , {24 , 4 , 1} } ;  //  0xE88D
        public static final byte[][] HXVHD	          = new byte[][]{ {(byte)0xE8,(byte)0x8E} , {24 , 4 , 1} } ;  //  0xE88E
        public static final byte[][] HXIHD	          = new byte[][]{ {(byte)0xE8,(byte)0x8F} , {24 , 4 , 1} } ;  //  0xE88F
        public static final byte[][] HYVRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x90} , {24 , 4 , 1} } ;  //  0xE890
        public static final byte[][] HYIRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x91} , {24 , 4 , 1} } ;  //  0xE891
        public static final byte[][] HYWATT	          = new byte[][]{ {(byte)0xE8,(byte)0x92} , {24 , 4 , 1} } ;  //  0xE892
        public static final byte[][] HYVAR	          = new byte[][]{ {(byte)0xE8,(byte)0x93} , {24 , 4 , 1} } ;  //  0xE893
        public static final byte[][] HYVA	          = new byte[][]{ {(byte)0xE8,(byte)0x94} , {24 , 4 , 1} } ;  //  0xE894
        public static final byte[][] HYPF	          = new byte[][]{ {(byte)0xE8,(byte)0x95} , {24 , 4 , 1} } ;  //  0xE895
        public static final byte[][] HYVHD	          = new byte[][]{ {(byte)0xE8,(byte)0x96} , {24 , 4 , 1} } ;  //  0xE896
        public static final byte[][] HYIHD	          = new byte[][]{ {(byte)0xE8,(byte)0x97} , {24 , 4 , 1} } ;  //  0xE897
        public static final byte[][] HZVRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x98} , {24 , 4 , 1} } ;  //  0xE898
        public static final byte[][] HZIRMS	          = new byte[][]{ {(byte)0xE8,(byte)0x99} , {24 , 4 , 1} } ;  //  0xE899
        public static final byte[][] HZWATT	          = new byte[][]{ {(byte)0xE8,(byte)0x9A} , {24 , 4 , 1} } ;  //  0xE89A
        public static final byte[][] HZVAR	          = new byte[][]{ {(byte)0xE8,(byte)0x9B} , {24 , 4 , 1} } ;  //  0xE89B
        public static final byte[][] HZVA	          = new byte[][]{ {(byte)0xE8,(byte)0x9C} , {24 , 4 , 1} } ;  //  0xE89C
        public static final byte[][] HZPF	          = new byte[][]{ {(byte)0xE8,(byte)0x9D} , {24 , 4 , 1} } ;  //  0xE89D
        public static final byte[][] HZVHD	          = new byte[][]{ {(byte)0xE8,(byte)0x9E} , {24 , 4 , 1} } ;  //  0xE89E
        public static final byte[][] HZIHD	          = new byte[][]{ {(byte)0xE8,(byte)0x9F} , {24 , 4 , 1} } ;  //  0xE89F
        public static final byte[][] HCONFIG	          = new byte[][]{ {(byte)0xE9,(byte)0x00} , {16 , 2 , 0} } ;  //  0xE900
        public static final byte[][] APF	          = new byte[][]{ {(byte)0xE9,(byte)0x02} , {16 , 2 , 0} } ;  //  0xE902
        public static final byte[][] BPF	          = new byte[][]{ {(byte)0xE9,(byte)0x03} , {16 , 2 , 0} } ;  //  0xE903
        public static final byte[][] CPF	          = new byte[][]{ {(byte)0xE9,(byte)0x04} , {16 , 2 , 0} } ;  //  0xE904
        public static final byte[][] APERIOD	          = new byte[][]{ {(byte)0xE9,(byte)0x05} , {16 , 2 , 0} } ;  //  0xE905
        public static final byte[][] BPERIOD	          = new byte[][]{ {(byte)0xE9,(byte)0x06} , {16 , 2 , 0} } ;  //  0xE906
        public static final byte[][] CPERIOD	          = new byte[][]{ {(byte)0xE9,(byte)0x07} , {16 , 2 , 0} } ;  //  0xE907
        public static final byte[][] APNOLOAD	          = new byte[][]{ {(byte)0xE9,(byte)0x08} , {16 , 2 , 0} } ;  //  0xE908
        public static final byte[][] VARNOLOAD	          = new byte[][]{ {(byte)0xE9,(byte)0x09} , {16 , 2 , 0} } ;  //  0xE909
        public static final byte[][] VANOLOAD	          = new byte[][]{ {(byte)0xE9,(byte)0x0A} , {16 , 2 , 0} } ;  //  0xE90A
        public static final byte[][] LAST_ADD	          = new byte[][]{ {(byte)0xE9,(byte)0xFE} , {16 , 2 , 0} } ;  //  0xE9FE
        public static final byte[][] LAST_RWDATA_16bit    = new byte[][]{ {(byte)0xE9,(byte)0xFF} , {16 , 2 , 0} } ;  //  0xE9FF
        public static final byte[][] CONFIG3	          = new byte[][]{ {(byte)0xEA,(byte)0x00} , {8 , 1 , 0} } ;  //  0xEA00
        public static final byte[][] LAST_OP	          = new byte[][]{ {(byte)0xEA,(byte)0x01} , {8 , 1 , 0} } ;  //  0xEA01
        public static final byte[][] WTHR	          = new byte[][]{ {(byte)0xEA,(byte)0x02} , {8 , 1 , 0} } ;  //  0xEA02
        public static final byte[][] VARTHR	          = new byte[][]{ {(byte)0xEA,(byte)0x03} , {8 , 1 , 0} } ;  //  0xEA03
        public static final byte[][] VATHR	          = new byte[][]{ {(byte)0xEA,(byte)0x04} , {8 , 1 , 0} } ;  //  0xEA04
        public static final byte[][] HX_reg	          = new byte[][]{ {(byte)0xEA,(byte)0x08} , {8 , 1 , 0} } ;  //  0xEA08
        public static final byte[][] HY_reg	          = new byte[][]{ {(byte)0xEA,(byte)0x09} , {8 , 1 , 0} } ;  //  0xEA09
        public static final byte[][] HZ_reg	          = new byte[][]{ {(byte)0xEA,(byte)0x0A} , {8 , 1 , 0} } ;  //  0xEA0A
        public static final byte[][] LPOILVL	          = new byte[][]{ {(byte)0xEC,(byte)0x00} , {8 , 1 , 0} } ;  //  0xEC00
        public static final byte[][] CONFIG2	          = new byte[][]{ {(byte)0xEC,(byte)0x01} , {8 , 1 , 0} } ;  //  0xEC01
        
    public static void main(String[] args){
        System.out.println((byte)0x43);
        System.out.println((byte)0xC1);
        System.out.println(AVRMS);
        String s = "";
        byte[] byte1 = new byte[]{(byte)0x22, (byte)0x11};
        byte[] byte2 = new byte[]{(byte)0x11, (byte)022, (byte)0x33,(byte)0x44};
        
//        long voltageRMS1=(( long)a << 24) & 0x00FF0000;
//      voltageRMS1=voltageRMS1+((( long)b<<16) & 0x0000FF00);
//      voltageRMS1=voltageRMS1+((( long)c<<8) & 0x0000FF00);
//      voltageRMS1=voltageRMS1+((( long)d) & 0x000000FF);
    }
    
        
}
