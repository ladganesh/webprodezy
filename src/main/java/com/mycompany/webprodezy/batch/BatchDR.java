package com.mycompany.webprodezy.batch;

public class BatchDR {
	
	private String BATCH_ID,BATCH_NAME,BATCH_QTY,BATCH_CREATE,BATCH_EXPIRE;

	public BatchDR(String bATCH_ID, String bATCH_NAME, String bATCH_QTY, String bATCH_CREATE, String bATCH_EXPIRE) {
		super();
		BATCH_ID = bATCH_ID;
		BATCH_NAME = bATCH_NAME;
		BATCH_QTY = bATCH_QTY;
		BATCH_CREATE = bATCH_CREATE;
		BATCH_EXPIRE = bATCH_EXPIRE;
	}

	public String getBATCH_ID() {
		return BATCH_ID;
	}

	public void setBATCH_ID(String bATCH_ID) {
		BATCH_ID = bATCH_ID;
	}

	public String getBATCH_NAME() {
		return BATCH_NAME;
	}

	public void setBATCH_NAME(String bATCH_NAME) {
		BATCH_NAME = bATCH_NAME;
	}

	public String getBATCH_QTY() {
		return BATCH_QTY;
	}

	public void setBATCH_QTY(String bATCH_QTY) {
		BATCH_QTY = bATCH_QTY;
	}

	public String getBATCH_CREATE() {
		return BATCH_CREATE;
	}

	public void setBATCH_CREATE(String bATCH_CREATE) {
		BATCH_CREATE = bATCH_CREATE;
	}

	public String getBATCH_EXPIRE() {
		return BATCH_EXPIRE;
	}

	public void setBATCH_EXPIRE(String bATCH_EXPIRE) {
		BATCH_EXPIRE = bATCH_EXPIRE;
	}



}