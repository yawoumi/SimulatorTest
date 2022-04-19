package discreteBehaviorSimulator;

import static org.junit.jupiter.api.Assertions.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

import org.junit.jupiter.api.Test;


class LogFormatterTest {

	private LogFormatter logFormat;

	
	@Test
	void FormatLogRecordtest() {
		logFormat = new LogFormatter();
		Level level = Level.FINER ;	
		LogRecord rec = new LogRecord(level, "");
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

		SimpleDateFormat date_format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss.SS");
	    Date resultdate = new Date(millis);
	    return date_format.format(resultdate);
	}

	@Test
	void testGetHeadHandler() {
		Handler h = new ConsoleHandler();
		h.setLevel(Level.FINER);
		assertEquals("",logFormat.getHead(h));
	}

	@Test
	void testGetTailHandler() {
		Handler h = new ConsoleHandler();
		h.setLevel(Level.FINER);
		assertEquals("",logFormat.getTail(h));
	}

}
