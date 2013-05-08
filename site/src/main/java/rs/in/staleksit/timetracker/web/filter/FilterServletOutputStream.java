/**
 * 
 */
package rs.in.staleksit.timetracker.web.filter;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletOutputStream;

/**
 * @author aleksandar
 *
 */
public class FilterServletOutputStream extends ServletOutputStream {

	private DataOutputStream stream;

	/**
	 * constructor
	 * @param output
	 */
	public FilterServletOutputStream(OutputStream output) {
		stream = new DataOutputStream(output);
	}

	/**
	 * @param b
	 */
	@Override
	public void write(int b) throws IOException {
		stream.write(b);
	}

	/**
	 * @param b
	 */
	@Override
	public void write(byte[] b) throws IOException {
		stream.write(b);
	}

	/**
	 * @param b
	 * @param off
	 * @param len
	 */
	@Override
	public void write(byte[] b, int off, int len) throws IOException {
		stream.write(b, off, len);
	}

	/**
	 * 
	 * @return
	 */
	protected OutputStream getOutputStream() {
		return stream;
	}
}
