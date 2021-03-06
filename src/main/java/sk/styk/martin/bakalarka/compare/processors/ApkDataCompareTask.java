package sk.styk.martin.bakalarka.compare.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.styk.martin.bakalarka.analyze.data.ApkData;
import sk.styk.martin.bakalarka.compare.data.ComparisonResult;
import sk.styk.martin.bakalarka.utils.files.JsonUtils;

import java.io.File;

/**
 * Created by Martin Styk on 07.01.2016.
 */
public class ApkDataCompareTask implements Runnable {

    private static final Logger logger = LoggerFactory.getLogger(ApkDataCompareTask.class);
    private ApkData apkDataA;
    private ApkData apkDataB;
    private File outputDirectoryBase;

    public ApkDataCompareTask(ApkData apkDataA, ApkData apkDataB, File outputDirectory) {
        if (apkDataA == null) {
            throw new IllegalArgumentException("apkDataA null");
        }
        if (apkDataB == null) {
            throw new IllegalArgumentException("apkDataB null");
        }

        this.apkDataA = apkDataA;
        this.apkDataB = apkDataB;
        this.outputDirectoryBase = outputDirectory;
    }

    public void run() {
        logger.trace("start " + apkDataA.getFileName() + " " + apkDataB.getFileName());

        ApkPairCompare apkPairCompare = new ApkPairCompareSimilarImpl(apkDataA, apkDataB);
        ComparisonResult comparisonResult = apkPairCompare.compare();
        SimilarityType similar = comparisonResult.getSimilar();

        if (similar == null || similar.equals(SimilarityType.NOT_SIMILAR)) {
            logger.info("APK A :" + comparisonResult.getNameA() + " APK B : " + comparisonResult.getNameB() + " not similar");
        } else {
            logger.info("APK A :" + comparisonResult.getNameA() + " APK B : " + comparisonResult.getNameB() + " -> " + similar.toString());

            if (isWriteToFile()) {
                JsonUtils.toJson(comparisonResult, new File(outputDirectoryBase, similar.toString()));
            } else {
                logger.info(comparisonResult.toString());
            }
        }

        logger.trace("end " + apkDataA.getFileName() + " " + apkDataB.getFileName());
    }

    private boolean isWriteToFile() {
        return outputDirectoryBase != null;
    }
}
