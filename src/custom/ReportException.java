package custom;

public class ReportException extends Exception {

	private static final long serialVersionUID = 1L;
	private String errorCode;

	public ReportException() {
		super();
	}

	public ReportException(String message, Throwable cause) {
		super(message, cause);
	}

	public ReportException(String message) {
		super(message);
	}

	public ReportException(Throwable cause) {
		super(cause);
	}

	/*
	 * Set ERROR CODE
	 */
	public ReportException(String message, String errorCode) {
		super(message);
		this.errorCode = errorCode;
	}

	public String getErrorCode() {
		return errorCode;
	}

}
