package com.mycompany.webprodezy.bom;

public class FgCDR {

	private String FG_ID,FG_PART_NO,FG_UOM_ID,ASSEMBLED;

	public FgCDR(String fG_ID, String fG_PART_NO, String fG_UOM_ID, String aSSEMBLED) {
		super();
		FG_ID = fG_ID;
		FG_PART_NO = fG_PART_NO;
		FG_UOM_ID = fG_UOM_ID;
		ASSEMBLED = aSSEMBLED;
	}

	public String getFG_ID() {
		return FG_ID;
	}

	public void setFG_ID(String fG_ID) {
		FG_ID = fG_ID;
	}

	public String getFG_PART_NO() {
		return FG_PART_NO;
	}

	public void setFG_PART_NO(String fG_PART_NO) {
		FG_PART_NO = fG_PART_NO;
	}

	public String getFG_UOM_ID() {
		return FG_UOM_ID;
	}

	public void setFG_UOM_ID(String fG_UOM_ID) {
		FG_UOM_ID = fG_UOM_ID;
	}

	public String getASSEMBLED() {
		return ASSEMBLED;
	}

	public void setASSEMBLED(String aSSEMBLED) {
		ASSEMBLED = aSSEMBLED;
	}
}
