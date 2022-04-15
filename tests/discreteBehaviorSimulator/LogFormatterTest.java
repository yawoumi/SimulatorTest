package discreteBehaviorSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

import org.junit.jupiter.api.Test;


class LogFormatterTest {

	private LogFormatter logFormat;
	
	void setUp() throws Exception {
		logFormat = new LogFormatter();

	}
	
	@Test
	void testFormatLogRecord() {
		LogRecord rec = new LogRecord(null, null);
		StringBuffer buf = new StringBuffer();
		
		buf.append(calcDate(rec.getMillis()));
		buf.append(": ");
		buf.append(rec.getLevel());
		buf.append(System.getProperty("line.separator"));
		buf.append(logFormat.formatMessage(rec));
		buf.append(System.getProperty("line.separator"));
		String expected = buf.toString();
		assertEquals(expected, logFormat.format(rec));
		
	}

	private Object calcDate(long millis) {
		// TODO Auto-generated method stub
		SimpleDateFormat date_format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SS");
	    Date resultdate = new Date(millis);
	    return date_format.format(resultdate);
	}

	@Test
	void testGetHeadHandler() {
		Handler h = null;
		assertEquals("",logFormat.getHead(h));
	}

	@Test
	void testGetTailHandler() {
		Handler h = null;
		assertEquals("",logFormat.getTail(h));
	}

}
