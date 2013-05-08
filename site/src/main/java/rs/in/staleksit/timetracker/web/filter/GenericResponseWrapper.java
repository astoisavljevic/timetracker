/**
 * 
 */
package rs.in.staleksit.timetracker.web.filter;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

/**
 * @author aleksandar
 *
 */
public class GenericResponseWrapper extends HttpServletResponseWrapper {

	private static final Boolean PRINT_WRITER_AUTO_FLUSH = true;

	private ByteArrayOutputStream output;
	private int contentLength;
	private String contentType;

	/**
	 * constructor
	 * @param response
	 */
	public GenericResponseWrapper(HttpServletResponse response) {
		super(response);
		output = new ByteArrayOutputStream();
	}

	/**
	 * 
	 * @return byte[]
	 */
	public byte[] getData() {
		return output.toByteArray();
	}

	/**
	 * @return {@link ServletOutputStream}
	 */
	@Override
	public ServletOutputStream getOutputStream() {
		return new FilterServletOutputStream(output);
	}

	/**
	 * @return {@link PrintWriter}
	 */
	@Override
	public PrintWriter getWriter() {
		return new PrintWriter(getOutputStream(), PRINT_WRITER_AUTO_FLUSH);
	}

	/**
	 * 
	 * @param legth
	 */
	@Override
	public void setContentLength(int length) {
		contentLength = length;
		super.setContentLength(length);
	}

	/**
	 * @return contentLength
	 */
	public int getContentLength() {
		return contentLength;
	}

	/**
	 * @param contentType
	 */
	@Override
	public void setContentType(String contentType) {
		this.contentType = contentType;
		super.setContentType(contentType);
	}

	/**
	 * @return contentType
	 */
	@Override
	public String getContentType() {
		return contentType;
	}

}
