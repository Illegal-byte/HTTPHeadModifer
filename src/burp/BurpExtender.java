package burp;

import java.io.*;

public class BurpExtender implements IBurpExtender
{
    private IBurpExtenderCallbacks callbacks;
    private IExtensionHelpers helpers;
    private PrintWriter stdout;
    private PrintWriter stderr;
    private String extensionName;
    private String version;
    
    public BurpExtender() {
        this.extensionName = "HTTPHeadModifer";
        this.version = "0.1";
    }
    
    @Override
    public void registerExtenderCallbacks(final IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stderr = new PrintWriter(callbacks.getStderr(), true);
        callbacks.setExtensionName(String.format("%s v%s", this.extensionName, this.version));
        callbacks.registerContextMenuFactory(new Menu(callbacks));
        this.stdout.println(this.getBanner());
    }
    
    public String getBanner() {
        final String bannerInfo = "[+]\n[+] #####################################\n[+]    " + this.extensionName + " v" + this.version + "(changed)\n" + "[+]    anthor: key\n" + "[+]    email: admin@gh0st.cn\n" + "[+]    blog: gh0st.cn\n" + "[+] ####################################";
        return bannerInfo;
    }
}
