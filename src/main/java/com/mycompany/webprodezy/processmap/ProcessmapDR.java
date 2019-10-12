package  com.mycompany.webprodezy.processmap;

public class ProcessmapDR {
	private String process_id, PROCESS_NAME,machine,die_tool,setup_time,ideal_cycle,remarks,tg_hr,tg_shift,tg_day,unit,effective,permissible,ref_fg_id,uom_id,ref_process_id,ref_tool_code;

	public ProcessmapDR(String process_id, String pROCESS_NAME, String machine, String die_tool, String setup_time,
			String ideal_cycle, String remarks, String tg_hr, String tg_shift, String tg_day, String unit,
			String effective, String permissible, String ref_fg_id, String uom_id, String ref_process_id,
			String ref_tool_code) {
		super();
		this.process_id = process_id;
		PROCESS_NAME = pROCESS_NAME;
		this.machine = machine;
		this.die_tool = die_tool;
		this.setup_time = setup_time;
		this.ideal_cycle = ideal_cycle;
		this.remarks = remarks;
		this.tg_hr = tg_hr;
		this.tg_shift = tg_shift;
		this.tg_day = tg_day;
		this.unit = unit;
		this.effective = effective;
		this.permissible = permissible;
		this.ref_fg_id = ref_fg_id;
		this.uom_id = uom_id;
		this.ref_process_id = ref_process_id;
		this.ref_tool_code = ref_tool_code;
	}

	public String getProcess_id() {
		return process_id;
	}

	public void setProcess_id(String process_id) {
		this.process_id = process_id;
	}

	public String getPROCESS_NAME() {
		return PROCESS_NAME;
	}

	public void setPROCESS_NAME(String pROCESS_NAME) {
		PROCESS_NAME = pROCESS_NAME;
	}

	public String getMachine() {
		return machine;
	}

	public void setMachine(String machine) {
		this.machine = machine;
	}

	public String getDie_tool() {
		return die_tool;
	}

	public void setDie_tool(String die_tool) {
		this.die_tool = die_tool;
	}

	public String getSetup_time() {
		return setup_time;
	}

	public void setSetup_time(String setup_time) {
		this.setup_time = setup_time;
	}

	public String getIdeal_cycle() {
		return ideal_cycle;
	}

	public void setIdeal_cycle(String ideal_cycle) {
		this.ideal_cycle = ideal_cycle;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getTg_hr() {
		return tg_hr;
	}

	public void setTg_hr(String tg_hr) {
		this.tg_hr = tg_hr;
	}

	public String getTg_shift() {
		return tg_shift;
	}

	public void setTg_shift(String tg_shift) {
		this.tg_shift = tg_shift;
	}

	public String getTg_day() {
		return tg_day;
	}

	public void setTg_day(String tg_day) {
		this.tg_day = tg_day;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getEffective() {
		return effective;
	}

	public void setEffective(String effective) {
		this.effective = effective;
	}

	public String getPermissible() {
		return permissible;
	}

	public void setPermissible(String permissible) {
		this.permissible = permissible;
	}

	public String getRef_fg_id() {
		return ref_fg_id;
	}

	public void setRef_fg_id(String ref_fg_id) {
		this.ref_fg_id = ref_fg_id;
	}

	public String getUom_id() {
		return uom_id;
	}

	public void setUom_id(String uom_id) {
		this.uom_id = uom_id;
	}

	public String getRef_process_id() {
		return ref_process_id;
	}

	public void setRef_process_id(String ref_process_id) {
		this.ref_process_id = ref_process_id;
	}

	public String getRef_tool_code() {
		return ref_tool_code;
	}

	public void setRef_tool_code(String ref_tool_code) {
		this.ref_tool_code = ref_tool_code;
	}


}