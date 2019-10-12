package com.mycompany.webprodezy.bom;

public class BomDR {

    private String BOM_ID,FG_ID, RM_ID,NT_WT,GS_WT, TOTAL_WT,FG_PART_NO;
    
   

	public BomDR(String bOM_ID, String fG_ID, String rM_ID, String nT_WT, String gS_WT, String tOTAL_WT,
			String fG_PART_NO) {
		super();
		BOM_ID = bOM_ID;
		FG_ID = fG_ID;
		RM_ID = rM_ID;
		NT_WT = nT_WT;
		GS_WT = gS_WT;
		TOTAL_WT = tOTAL_WT;
		FG_PART_NO = fG_PART_NO;
	}

	public String getFG_PART_NO() {
			return FG_PART_NO;
		}

	public void setFG_PART_NO(String fG_PART_NO) {
			FG_PART_NO = fG_PART_NO;
		}
	public String getBOM_ID() {
		return BOM_ID;
	}

	public void setBOM_ID(String bOM_ID) {
		BOM_ID = bOM_ID;
	}

	public String getFG_ID() {
		return FG_ID;
	}

	public void setFG_ID(String fG_ID) {
		FG_ID = fG_ID;
	}

	public String getRM_ID() {
		return RM_ID;
	}

	public void setRM_ID(String rM_ID) {
		RM_ID = rM_ID;
	}

	public String getNT_WT() {
		return NT_WT;
	}

	public void setNT_WT(String nT_WT) {
		NT_WT = nT_WT;
	}

	public String getGS_WT() {
		return GS_WT;
	}

	public void setGS_WT(String gS_WT) {
		GS_WT = gS_WT;
	}

	public String getTOTAL_WT() {
		return TOTAL_WT;
	}

	public void setTOTAL_WT(String tOTAL_WT) {
		TOTAL_WT = tOTAL_WT;
	}

	

	
}
