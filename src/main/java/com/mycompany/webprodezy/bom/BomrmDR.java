package com.mycompany.webprodezy.bom;

public class BomrmDR {
	
	
   private String bomrmlable,RMM_UOM_ID,RM_ID,RM_CODE;
   

public BomrmDR(String bomrmlable, String rMM_UOM_ID, String rM_ID,String rM_CODE) {
	super();
	this.bomrmlable = bomrmlable;
	RMM_UOM_ID = rMM_UOM_ID;
	RM_ID = rM_ID;
	RM_CODE=rM_CODE;
}

public String getRM_CODE() {
	return RM_CODE;
}

public void setRM_CODE(String rM_CODE) {
	RM_CODE = rM_CODE;
}

public String getBomrmlable() {
	return bomrmlable;
}

public void setBomrmlable(String bomrmlable) {
	this.bomrmlable = bomrmlable;
}

public String getRMM_UOM_ID() {
	return RMM_UOM_ID;
}

public void setRMM_UOM_ID(String rMM_UOM_ID) {
	RMM_UOM_ID = rMM_UOM_ID;
}

public String getRM_ID() {
	return RM_ID;
}

public void setRM_ID(String rM_ID) {
	RM_ID = rM_ID;
}


}
