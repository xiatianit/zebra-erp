package com.zebra.zebraerp.common.Exception;

/**
 * printerp 统一用这异常 自定义
 */
public class ZebraerpException extends RuntimeException {
	/**
     * 
     */
    private static final long serialVersionUID = -2638435419503787392L;
    
    /*** 异常status默认值为－1，普通异常：－1 */
    private int status;
	private String msg;

	public ZebraerpException() {
		this(-1);
	}

	public ZebraerpException(int status) {
		this(status, null);
	}

	public ZebraerpException(String msg){
		this(-1,msg);
	}

	public ZebraerpException(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public String getMsg() {
		if (msg != null) {
			return msg;
		} else {
			return getMessage();
		}
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
