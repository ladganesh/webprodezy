package  com.mycompany.webprodezy.processmaster;

public class ProcessmasterDR {
	private String PROCESS_ID,PROCESS_NAME,PROCESS_DETAILS,IS_BATCH,IS_ITEM;

	public ProcessmasterDR(String pROCESS_ID, String pROCESS_NAME, String pROCESS_DETAILS, String iS_BATCH,
			String iS_ITEM) {
		super();
		PROCESS_ID = pROCESS_ID;
		PROCESS_NAME = pROCESS_NAME;
		PROCESS_DETAILS = pROCESS_DETAILS;
		IS_BATCH = iS_BATCH;
		IS_ITEM = iS_ITEM;
	}

	public String getPROCESS_ID() {
		return PROCESS_ID;
	}

	public void setPROCESS_ID(String pROCESS_ID) {
		PROCESS_ID = pROCESS_ID;
	}

	public String getPROCESS_NAME() {
		return PROCESS_NAME;
	}

	public void setPROCESS_NAME(String pROCESS_NAME) {
		PROCESS_NAME = pROCESS_NAME;
	}

	public String getPROCESS_DETAILS() {
		return PROCESS_DETAILS;
	}

	public void setPROCESS_DETAILS(String pROCESS_DETAILS) {
		PROCESS_DETAILS = pROCESS_DETAILS;
	}

	public String getIS_BATCH() {
		return IS_BATCH;
	}

	public void setIS_BATCH(String iS_BATCH) {
		IS_BATCH = iS_BATCH;
	}

	public String getIS_ITEM() {
		return IS_ITEM;
	}

	public void setIS_ITEM(String iS_ITEM) {
		IS_ITEM = iS_ITEM;
	}
	

}
