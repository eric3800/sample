package test.usingMATM;

import java.io.StringWriter;

public class CRLFStringWriter extends StringWriter {

	private boolean crfound;

    /**
     * The CR octet.
     */
    public static final char CR = 0xD;
    
    /**
     * The LF octet.
     */
    public static final char LF = 0xA;
    
    public static final String CRx = "&#xd;";

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        StringBuffer buf = this.getBuffer();
        for (int i = 0; i < buf.length(); i++) {
            char c = buf.charAt(i);
            if (c == CR) {
                buffer.append(CRx);
            } else if (c == LF) {
                if (!crfound) {
                    buffer.append(CRx);
                }
            } else if (c == '&') {
                if (crfound = foundCR(buf, i)) {
                    buffer.append(CRx);
                    i += 4;
                    continue;
                } else {
                    buffer.append(c);
                }
            } else if (c == '>') {
                crfound = true;
                buffer.append(c);
                continue;
            } else {
                buffer.append(c);
            }
            crfound = false;
        }
        return buffer.toString();
    }

    private boolean foundCR(StringBuffer buf, int i) {
        try {
            return CRx.equalsIgnoreCase(buf.substring(i, i + 5));
        } catch (Exception e) {
            return false;
        }
    }
}
