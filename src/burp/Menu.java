package burp;

import java.io.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class Menu implements IContextMenuFactory
{
    private IBurpExtenderCallbacks callbacks;
    private final IExtensionHelpers m_helpers;
    private PrintWriter stdout;
    private PrintWriter stderr;
    private JMenu httpHeadModiferMenu;
    private JMenuItem addAllIP;
    private JMenuItem addXFF;
    private JMenuItem addXForwardedHost;
    private JMenuItem addXRI;
    private JMenuItem addXOI;
    private JMenuItem addXRA;
    private JMenuItem addTrueClientIP;
    private JMenuItem addClientIP;
    private JMenuItem addXClientIP;
    private JMenuItem addXRealIP;
    private JMenu firefoxUA;
    private JMenuItem ffAndroidMobileUA;
    private JMenuItem ffAndroidTableUA;
    private JMenuItem ffMacUA;
    private JMenuItem ffUbuntuUA;
    private JMenuItem ffWinUA;
    private JMenu chromeUA;
    private JMenuItem chromeAndroidMobileUA;
    private JMenuItem chromeAndroidTableUA;
    private JMenuItem chromeMacUA;
    private JMenuItem chromeUbuntuUA;
    private JMenuItem chromeWinUA;
    private JMenuItem chromeiPhoneUA;
    private JMenu edgeUA;
    private JMenuItem edge12UA;
    private JMenuItem edge13UA;
    private JMenu ieUA;
    private JMenuItem ie11UA;
    private JMenuItem ie10UA;
    private JMenuItem ie9UA;
    private JMenuItem ie8UA;
    private JMenuItem ie7UA;
    private JMenuItem ie6UA;
    private JMenu operaUA;
    private JMenuItem operaMacUA;
    private JMenuItem operaWinUA;
    private JMenu safariUA;
    private JMenuItem safariMacUA;
    private JMenuItem safariWinUA;
    private JMenuItem safariiPadUA;
    private JMenuItem safariiPhoneUA;
    private JMenu androidUA;
    private JMenuItem androidNexus7UA;
    private JMenuItem androidGalaxyS3UA;
    private JMenuItem androidGalaxyTabUA;
    private JMenu winPhoneUA;
    private JMenuItem win7PhoneUA;
    private JMenuItem win75PhoneUA;
    private JMenuItem win8PhoneUA;
    private JMenu iosUA;
    private JMenuItem iosiPadUA;
    private JMenuItem iosiPhoneUA;
    private JMenuItem iosiPodUA;
    private JMenu spiderUA;
    private JMenuItem baiduSpider4pcUA;
    private JMenuItem baiduSpider4appUA;
    private JMenuItem googleSpiderUA;
    private JMenuItem bingSpiderUA;
    private JMenuItem slurpSpiderUA;
    private JMenuItem addOrigin;
    private JMenuItem updateCookie;
    
    public Menu(final IBurpExtenderCallbacks callbacks) {
        this.callbacks = callbacks;
        this.m_helpers = callbacks.getHelpers();
        this.stdout = new PrintWriter(callbacks.getStdout(), true);
        this.stderr = new PrintWriter(callbacks.getStderr(), true);
    }
    
    @Override
    public List<JMenuItem> createMenuItems(final IContextMenuInvocation invocation) {
        final List<JMenuItem> menus = new ArrayList<JMenuItem>();
        if (invocation.getToolFlag() != 32 && invocation.getInvocationContext() != 0) {
            return menus;
        }
        this.httpHeadModiferMenu = new JMenu("HTTPHeadModifer");
        this.addXFF = new JMenuItem("add X-Forwarded-For");
        this.addXForwardedHost = new JMenuItem("add X-Forwarded-Host");
        this.addXRI = new JMenuItem("add X-remote-IP");
        this.addXOI = new JMenuItem("add X-Originating-IP");
        this.addXRA = new JMenuItem("add X-remote-addr");
        this.addTrueClientIP = new JMenuItem("add True-Client-IP");
        this.addClientIP = new JMenuItem("add Client-IP");
        this.addXClientIP = new JMenuItem("add X-Client-IP");
        this.addXRealIP = new JMenuItem("add X-Real-IP");
        this.addAllIP = new JMenuItem("add ALL(IP)");
        this.firefoxUA = new JMenu("Firefox UserAgent");
        this.ffAndroidMobileUA = new JMenuItem("Firefox on Android Mobile");
        this.ffAndroidTableUA = new JMenuItem("Firefox on Android Tablet");
        this.ffMacUA = new JMenuItem("Firefox on Mac");
        this.ffUbuntuUA = new JMenuItem("Firefox on Ubuntu");
        this.ffWinUA = new JMenuItem("Firefox on Windows");
        this.chromeUA = new JMenu("Chorme UserAgent");
        this.chromeAndroidMobileUA = new JMenuItem("Chrome on Android Mobile");
        this.chromeAndroidTableUA = new JMenuItem("Chrome on Android Tablet");
        this.chromeMacUA = new JMenuItem("Chrome on Mac");
        this.chromeUbuntuUA = new JMenuItem("Chrome on Ubuntu");
        this.chromeWinUA = new JMenuItem("Chrome on Windows");
        this.chromeiPhoneUA = new JMenuItem("Chrome on iPhone");
        this.edgeUA = new JMenu("Edge UserAgent");
        this.edge12UA = new JMenuItem("Edge 12");
        this.edge13UA = new JMenuItem("Edge13");
        this.ieUA = new JMenu("IE UserAgent");
        this.ie11UA = new JMenuItem("Internet Explorer 11");
        this.ie10UA = new JMenuItem("Internet Explorer 10");
        this.ie9UA = new JMenuItem("Internet Explorer 9");
        this.ie8UA = new JMenuItem("Internet Explorer 8");
        this.ie7UA = new JMenuItem("Internet Explorer 7");
        this.ie6UA = new JMenuItem("Internet Explorer 6");
        this.operaUA = new JMenu("Opera UserAgent");
        this.operaMacUA = new JMenuItem("Opera on Mac");
        this.operaWinUA = new JMenuItem("Opera on Windows");
        this.safariUA = new JMenu("Safari UserAgent");
        this.safariMacUA = new JMenuItem("Safari on Mac");
        this.safariWinUA = new JMenuItem("Safari on Windows");
        this.safariiPadUA = new JMenuItem("Safari on iPad");
        this.safariiPhoneUA = new JMenuItem("Safari on iPhone");
        this.androidUA = new JMenu("Android UserAgent");
        this.androidNexus7UA = new JMenuItem("Nexus 7 (Tablet)");
        this.androidGalaxyS3UA = new JMenuItem("Samsung Galaxy S3 (Handset)");
        this.androidGalaxyTabUA = new JMenuItem("Samsung Galaxy Tab (Tablet)");
        this.winPhoneUA = new JMenu("Windows phone UserAgent");
        this.win7PhoneUA = new JMenuItem("Windows Phone 7");
        this.win75PhoneUA = new JMenuItem("Windows Phone 7.5");
        this.win8PhoneUA = new JMenuItem("Windows Phone 8");
        this.iosUA = new JMenu("IOS UserAgent");
        this.iosiPadUA = new JMenuItem("iPad");
        this.iosiPhoneUA = new JMenuItem("iPhone");
        this.iosiPodUA = new JMenuItem("iPod");
        this.spiderUA = new JMenu("Spider UserAgent");
        this.baiduSpider4pcUA = new JMenuItem("Badu Spider PC");
        this.baiduSpider4appUA = new JMenuItem("Badu Spider App");
        this.googleSpiderUA = new JMenuItem("Googlebot (Google's spider)");
        this.bingSpiderUA = new JMenuItem("BingBot (Bing's spider)");
        this.slurpSpiderUA = new JMenuItem("Slurp! (Yahoo's spider)");
        this.addOrigin = new JMenuItem("add Origin");
        this.updateCookie = new JMenuItem("Update Cookie");
        this.firefoxUA.add(this.ffAndroidMobileUA);
        this.firefoxUA.add(this.ffAndroidTableUA);
        this.firefoxUA.add(this.ffMacUA);
        this.firefoxUA.add(this.ffUbuntuUA);
        this.firefoxUA.add(this.ffWinUA);
        this.chromeUA.add(this.chromeAndroidMobileUA);
        this.chromeUA.add(this.chromeAndroidTableUA);
        this.chromeUA.add(this.chromeMacUA);
        this.chromeUA.add(this.chromeUbuntuUA);
        this.chromeUA.add(this.chromeWinUA);
        this.chromeUA.add(this.chromeiPhoneUA);
        this.edgeUA.add(this.edge12UA);
        this.edgeUA.add(this.edge13UA);
        this.ieUA.add(this.ie11UA);
        this.ieUA.add(this.ie10UA);
        this.ieUA.add(this.ie9UA);
        this.ieUA.add(this.ie8UA);
        this.ieUA.add(this.ie7UA);
        this.ieUA.add(this.ie6UA);
        this.operaUA.add(this.operaMacUA);
        this.operaUA.add(this.operaWinUA);
        this.safariUA.add(this.safariMacUA);
        this.safariUA.add(this.safariWinUA);
        this.safariUA.add(this.safariiPadUA);
        this.safariUA.add(this.safariiPhoneUA);
        this.androidUA.add(this.androidNexus7UA);
        this.androidUA.add(this.androidGalaxyS3UA);
        this.androidUA.add(this.androidGalaxyTabUA);
        this.winPhoneUA.add(this.win7PhoneUA);
        this.winPhoneUA.add(this.win75PhoneUA);
        this.winPhoneUA.add(this.win8PhoneUA);
        this.iosUA.add(this.iosiPadUA);
        this.iosUA.add(this.iosiPhoneUA);
        this.iosUA.add(this.iosiPodUA);
        this.spiderUA.add(this.baiduSpider4pcUA);
        this.spiderUA.add(this.baiduSpider4appUA);
        this.spiderUA.add(this.googleSpiderUA);
        this.spiderUA.add(this.bingSpiderUA);
        this.spiderUA.add(this.slurpSpiderUA);
        this.httpHeadModiferMenu.add(this.addXFF);
        this.httpHeadModiferMenu.add(this.addXForwardedHost);
        this.httpHeadModiferMenu.add(this.addXRI);
        this.httpHeadModiferMenu.add(this.addXOI);
        this.httpHeadModiferMenu.add(this.addXRA);
        this.httpHeadModiferMenu.add(this.addTrueClientIP);
        this.httpHeadModiferMenu.add(this.addClientIP);
        this.httpHeadModiferMenu.add(this.addXClientIP);
        this.httpHeadModiferMenu.add(this.addXRealIP);
        this.httpHeadModiferMenu.add(this.addAllIP);
        this.httpHeadModiferMenu.addSeparator();
        this.httpHeadModiferMenu.add(this.firefoxUA);
        this.httpHeadModiferMenu.add(this.chromeUA);
        this.httpHeadModiferMenu.add(this.edgeUA);
        this.httpHeadModiferMenu.add(this.ieUA);
        this.httpHeadModiferMenu.add(this.operaUA);
        this.httpHeadModiferMenu.add(this.safariUA);
        this.httpHeadModiferMenu.add(this.androidUA);
        this.httpHeadModiferMenu.add(this.winPhoneUA);
        this.httpHeadModiferMenu.add(this.iosUA);
        this.httpHeadModiferMenu.add(this.spiderUA);
        this.httpHeadModiferMenu.addSeparator();
        this.httpHeadModiferMenu.add(this.addOrigin);
        this.httpHeadModiferMenu.addSeparator();
        this.httpHeadModiferMenu.add(this.updateCookie);
        this.addXFF.addActionListener(new MenuActionManger(invocation));
        this.addXForwardedHost.addActionListener(new MenuActionManger(invocation));
        this.addXRI.addActionListener(new MenuActionManger(invocation));
        this.addXOI.addActionListener(new MenuActionManger(invocation));
        this.addXRA.addActionListener(new MenuActionManger(invocation));
        this.addTrueClientIP.addActionListener(new MenuActionManger(invocation));
        this.addClientIP.addActionListener(new MenuActionManger(invocation));
        this.addXClientIP.addActionListener(new MenuActionManger(invocation));
        this.addXRealIP.addActionListener(new MenuActionManger(invocation));
        this.addAllIP.addActionListener(new MenuActionManger(invocation));
        this.ffAndroidMobileUA.addActionListener(new MenuActionManger(invocation));
        this.ffAndroidTableUA.addActionListener(new MenuActionManger(invocation));
        this.ffMacUA.addActionListener(new MenuActionManger(invocation));
        this.ffUbuntuUA.addActionListener(new MenuActionManger(invocation));
        this.ffWinUA.addActionListener(new MenuActionManger(invocation));
        this.chromeAndroidMobileUA.addActionListener(new MenuActionManger(invocation));
        this.chromeAndroidTableUA.addActionListener(new MenuActionManger(invocation));
        this.chromeMacUA.addActionListener(new MenuActionManger(invocation));
        this.chromeUbuntuUA.addActionListener(new MenuActionManger(invocation));
        this.chromeWinUA.addActionListener(new MenuActionManger(invocation));
        this.chromeiPhoneUA.addActionListener(new MenuActionManger(invocation));
        this.edge12UA.addActionListener(new MenuActionManger(invocation));
        this.edge13UA.addActionListener(new MenuActionManger(invocation));
        this.ie11UA.addActionListener(new MenuActionManger(invocation));
        this.ie10UA.addActionListener(new MenuActionManger(invocation));
        this.ie9UA.addActionListener(new MenuActionManger(invocation));
        this.ie8UA.addActionListener(new MenuActionManger(invocation));
        this.ie7UA.addActionListener(new MenuActionManger(invocation));
        this.ie6UA.addActionListener(new MenuActionManger(invocation));
        this.operaMacUA.addActionListener(new MenuActionManger(invocation));
        this.operaWinUA.addActionListener(new MenuActionManger(invocation));
        this.safariiPadUA.addActionListener(new MenuActionManger(invocation));
        this.safariiPhoneUA.addActionListener(new MenuActionManger(invocation));
        this.safariMacUA.addActionListener(new MenuActionManger(invocation));
        this.safariWinUA.addActionListener(new MenuActionManger(invocation));
        this.androidNexus7UA.addActionListener(new MenuActionManger(invocation));
        this.androidGalaxyS3UA.addActionListener(new MenuActionManger(invocation));
        this.androidGalaxyTabUA.addActionListener(new MenuActionManger(invocation));
        this.win7PhoneUA.addActionListener(new MenuActionManger(invocation));
        this.win75PhoneUA.addActionListener(new MenuActionManger(invocation));
        this.win8PhoneUA.addActionListener(new MenuActionManger(invocation));
        this.iosiPadUA.addActionListener(new MenuActionManger(invocation));
        this.iosiPhoneUA.addActionListener(new MenuActionManger(invocation));
        this.iosiPodUA.addActionListener(new MenuActionManger(invocation));
        this.baiduSpider4pcUA.addActionListener(new MenuActionManger(invocation));
        this.baiduSpider4appUA.addActionListener(new MenuActionManger(invocation));
        this.googleSpiderUA.addActionListener(new MenuActionManger(invocation));
        this.bingSpiderUA.addActionListener(new MenuActionManger(invocation));
        this.slurpSpiderUA.addActionListener(new MenuActionManger(invocation));
        this.addOrigin.addActionListener(new MenuActionManger(invocation));
        this.updateCookie.addActionListener(new MenuActionManger(invocation));
        menus.add(this.httpHeadModiferMenu);
        return menus;
    }
    
    public class MenuActionManger implements ActionListener
    {
        private IContextMenuInvocation invocation;
        
        public MenuActionManger(final IContextMenuInvocation invocation) {
            this.invocation = invocation;
        }
        
        @Override
        public void actionPerformed(final ActionEvent e) {
            final IHttpRequestResponse iReqResp = this.invocation.getSelectedMessages()[0];
            byte[] request = null;
            try {
                if (e.getSource() == Menu.this.addAllIP) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "AllIP");
                }
                if (e.getSource() == Menu.this.addXFF) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-Forwarded-For");
                }
                if (e.getSource() == Menu.this.addXForwardedHost) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-Forwarded-Host");
                }
                if (e.getSource() == Menu.this.addXRI) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-remote-IP");
                }
                if (e.getSource() == Menu.this.addXOI) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-Originating-IP");
                }
                if (e.getSource() == Menu.this.addXRA) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-remote-addr");
                }
                if (e.getSource() == Menu.this.addTrueClientIP) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "True-Client-IP");
                }
                if (e.getSource() == Menu.this.addClientIP) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "Client-IP");
                }
                if (e.getSource() == Menu.this.addXClientIP) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-Client-IP");
                }
                if (e.getSource() == Menu.this.addXRealIP) {
                    request = Utilities.addIPHead(Menu.this.m_helpers, iReqResp, "X-Real-IP");
                }
                if (e.getSource() == Menu.this.ffAndroidMobileUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "FFAndroidHandset");
                }
                if (e.getSource() == Menu.this.ffAndroidTableUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "FFAndroidTablet");
                }
                if (e.getSource() == Menu.this.ffMacUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "FFMac");
                }
                if (e.getSource() == Menu.this.ffUbuntuUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "FFUbuntu");
                }
                if (e.getSource() == Menu.this.ffWinUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "FFWin");
                }
                if (e.getSource() == Menu.this.chromeAndroidMobileUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "ChromeAndroidMobile");
                }
                if (e.getSource() == Menu.this.chromeAndroidTableUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "ChromeAndroidTablet");
                }
                if (e.getSource() == Menu.this.chromeMacUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "ChromeMac");
                }
                if (e.getSource() == Menu.this.chromeUbuntuUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "ChromeUbuntu");
                }
                if (e.getSource() == Menu.this.chromeWinUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "ChromeWin");
                }
                if (e.getSource() == Menu.this.chromeiPhoneUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "ChromeiPhone");
                }
                if (e.getSource() == Menu.this.edge12UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Edge12");
                }
                if (e.getSource() == Menu.this.edge13UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Edge13");
                }
                if (e.getSource() == Menu.this.ie11UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "IE11");
                }
                if (e.getSource() == Menu.this.ie10UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "IE10");
                }
                if (e.getSource() == Menu.this.ie9UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "IE9");
                }
                if (e.getSource() == Menu.this.ie8UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "IE8");
                }
                if (e.getSource() == Menu.this.ie7UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "IE7");
                }
                if (e.getSource() == Menu.this.ie6UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "IE6");
                }
                if (e.getSource() == Menu.this.operaMacUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "OperaMac");
                }
                if (e.getSource() == Menu.this.operaWinUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "OperaWin");
                }
                if (e.getSource() == Menu.this.safariiPadUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "SafariiPad");
                }
                if (e.getSource() == Menu.this.safariiPhoneUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "SafariiPhone");
                }
                if (e.getSource() == Menu.this.safariMacUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "SafariMac");
                }
                if (e.getSource() == Menu.this.safariWinUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "SafariWin");
                }
                if (e.getSource() == Menu.this.androidNexus7UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Nexus7");
                }
                if (e.getSource() == Menu.this.androidGalaxyS3UA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "AndroidGalaxyS3");
                }
                if (e.getSource() == Menu.this.androidGalaxyTabUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "AndroidGalaxyTab");
                }
                if (e.getSource() == Menu.this.win7PhoneUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Win7Phone");
                }
                if (e.getSource() == Menu.this.win75PhoneUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Win75Phone");
                }
                if (e.getSource() == Menu.this.win8PhoneUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Win8Phone");
                }
                if (e.getSource() == Menu.this.iosiPadUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "iPad");
                }
                if (e.getSource() == Menu.this.iosiPhoneUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "iPhone");
                }
                if (e.getSource() == Menu.this.iosiPodUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "iPod");
                }
                if (e.getSource() == Menu.this.baiduSpider4pcUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Baidu_pc");
                }
                if (e.getSource() == Menu.this.baiduSpider4appUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Baidu_app");
                }
                if (e.getSource() == Menu.this.googleSpiderUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Googlebot");
                }
                if (e.getSource() == Menu.this.bingSpiderUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "BingBot");
                }
                if (e.getSource() == Menu.this.slurpSpiderUA) {
                    request = Utilities.modifyUserAgent(Menu.this.m_helpers, iReqResp, "Slurp");
                }
                if (e.getSource() == Menu.this.addOrigin) {
                    request = Utilities.addOrigin(Menu.this.m_helpers, iReqResp);
                }
                if (e.getSource() == Menu.this.updateCookie) {
                    request = Utilities.updateCookie(Menu.this.callbacks, Menu.this.m_helpers, iReqResp);
                }
            }
            catch (Exception e2) {
                Menu.this.stderr.println(e2.getMessage());
            }
            if (request != null) {
                iReqResp.setRequest(request);
            }
        }
    }
}
