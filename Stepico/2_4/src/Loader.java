public class Loader {

    private static String printTextPerRole(String[] roles,String[] textLines) {
        int ind=0;
        StringBuffer sbuf = new StringBuffer();
        StringBuffer text = new StringBuffer();
        String bufRole = new String();
        String bufText = new String();
        for (int l=0;l<roles.length; l++){
            bufText="";
            for (int k=0; k<textLines.length; k++) {
                ind = textLines[k].indexOf(':');
                bufRole = textLines[k].substring(0, ind);
                if (bufRole.equals(roles[l])) {
                    bufText = textLines[k].substring(ind + 1);
                    text.append((k + 1) + ")" + bufText + '\n');
                }
            }
            sbuf.append('\n'+roles[l]+":"+'\n'+text);
            text.delete(0,text.length());
        }

        return sbuf.toString();
    }

    public static void main(String[] args) {

    }
}
