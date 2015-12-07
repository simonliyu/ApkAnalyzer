package sk.styk.martin.bakalarka.stats;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import sk.styk.martin.bakalarka.data.AndroidManifestData;
import sk.styk.martin.bakalarka.data.ApkData;
import sk.styk.martin.bakalarka.files.ApkFile;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Martin Styk on 25.11.2015.
 */
public class AndroidManifestProcessor {

    private static final Logger logger = LoggerFactory.getLogger(AndroidManifestProcessor.class);
    private static AndroidManifestProcessor instance = null;
    private Document doc;
    private ApkData data;
    private File manifestFile;
    private AndroidManifestData manifestData;
    private ApkFile apkFile;

    private AndroidManifestProcessor() {
        // Exists only to defeat instantiation.
    }

    public static AndroidManifestProcessor getInstance(ApkData data, ApkFile apkFile) {
        if (data == null) {
            throw new IllegalArgumentException("data null");
        }
        if (apkFile == null) {
            throw new IllegalArgumentException("apkFile null");
        }

        if (instance == null) {
            instance = new AndroidManifestProcessor();
        }
        instance.data = data;
        instance.apkFile = apkFile;
        instance.manifestData = new AndroidManifestData();
        return instance;
    }

    public static AndroidManifestProcessor getInstance(ApkFile apkFile) {
        if (instance == null) {
            instance = new AndroidManifestProcessor();
        }
        if (apkFile == null) {
            throw new IllegalArgumentException("apkFile null");
        }
        instance.data = null;
        instance.apkFile = apkFile;
        instance.manifestData = new AndroidManifestData();
        return instance;
    }

    public AndroidManifestData processAndroidManifest() {

        manifestData = new AndroidManifestData();

        logger.trace("Started processing AndroidManifest");

        try {

            manifestFile = new File(apkFile.getDecompiledDirectoryWithDecompiledData(), "AndroidManifest.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(manifestFile);

            doc.getDocumentElement().normalize();

            getPackage();
            getNumberOfAppComponents();
            getUsedPermissions();
            getUsedLibraries();
            getUsedFeatures();
            getUsesSdk();
            getSupportScreens();

        } catch (Exception e) {
            logger.error(e.toString());
        } finally {
            doc = null;
        }

        if (data != null) {
            data.setAndroidManifest(manifestData);
        }

        logger.trace("Finished processing of AndroidManifest");

        return manifestData;
    }

    public void getPackage() {
        NodeList manifestList = doc.getElementsByTagName("manifest");
        if (manifestList.getLength() != 1)
            return;
        ;

        Node nNode = manifestList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            manifestData.setPackageName(eElement.getAttribute("package"));
        }
    }

    private void getNumberOfAppComponents() {
        NodeList activityList = doc.getElementsByTagName("activity");
        NodeList serviceList = doc.getElementsByTagName("service");
        NodeList receiverList = doc.getElementsByTagName("receiver");
        NodeList providerList = doc.getElementsByTagName("provider");

        manifestData.setNumberOfActivities(activityList.getLength());
        manifestData.setNumberOfServices(serviceList.getLength());
        manifestData.setNumberOfBroadcastReceivers(receiverList.getLength());
        manifestData.setNumberOfContentProviders(providerList.getLength());
    }

    private void getUsedPermissions() {
        NodeList usesPermissionList = doc.getElementsByTagName("uses-permission");
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < usesPermissionList.getLength(); i++) {
            Node nNode = usesPermissionList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String value = eElement.getAttribute("android:name");
                if (value != null && !value.isEmpty())
                    result.add(value);
            }
        }
        manifestData.setUsesPermissions(result);
    }

    private void getUsedLibraries() {
        NodeList usesLibraryList = doc.getElementsByTagName("uses-library");
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < usesLibraryList.getLength(); i++) {
            Node nNode = usesLibraryList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String value = eElement.getAttribute("android:name");
                if (value != null && !value.isEmpty())
                    result.add(value);
            }
        }
        manifestData.setUsesLibrary(result);
    }

    private void getUsedFeatures() {
        NodeList usesLibraryList = doc.getElementsByTagName("uses-feature");
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < usesLibraryList.getLength(); i++) {
            Node nNode = usesLibraryList.item(i);
            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) nNode;
                String value = eElement.getAttribute("android:name");
                if (value != null && !value.isEmpty())
                    result.add(value);
            }
        }
        manifestData.setUsesFeature(result);
    }

    private void getUsesSdk() {
        NodeList sdkList = doc.getElementsByTagName("uses-sdk");
        if (sdkList.getLength() != 1)
            return;
        ;

        Node nNode = sdkList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;
            manifestData.setUsesTargetSdkVersion(eElement.getAttribute("android:targetSdkVersion"));
            manifestData.setUsesMinSdkVersion(eElement.getAttribute("android:minSdkVersion"));
            manifestData.setUsesMaxSdkVersion(eElement.getAttribute("android:maxSdkVersion"));
        }
    }

    private void getSupportScreens() {
        NodeList sdkList = doc.getElementsByTagName("supports-screens");
        if (sdkList.getLength() != 1)
            return;
        ;

        Node nNode = sdkList.item(0);
        if (nNode.getNodeType() == Node.ELEMENT_NODE) {
            Element eElement = (Element) nNode;

            manifestData.setSupportsScreensResizeable(getBooleanElementAtribute(eElement, "android:resizeable"));
            manifestData.setSupportsScreensAnyDensity(getBooleanElementAtribute(eElement, "android:anyDensity"));
            manifestData.setSupportsScreensSmall(getBooleanElementAtribute(eElement, "android:smallScreens"));
            manifestData.setSupportsScreensNormal(getBooleanElementAtribute(eElement, "android:normalScreens"));
            manifestData.setSupportsScreensLarge(getBooleanElementAtribute(eElement, "android:largeScreens"));
            manifestData.setSupportsScreensXlarge(getBooleanElementAtribute(eElement, "android:xlargeScreens"));
        }
    }

    private Boolean getBooleanElementAtribute(Element eElement, String atribute) {
        String atr = eElement.getAttribute(atribute);
        if (atr != null && !atr.isEmpty()) {
            return Boolean.valueOf(atr);
        }
        return null;
    }

}
