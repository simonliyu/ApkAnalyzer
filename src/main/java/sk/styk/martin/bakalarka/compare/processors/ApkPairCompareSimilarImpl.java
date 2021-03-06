package sk.styk.martin.bakalarka.compare.processors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sk.styk.martin.bakalarka.analyze.data.ApkData;
import sk.styk.martin.bakalarka.compare.data.ComparisonResult;

/**
 * Created by Martin Styk on 12.01.2016.
 */
public class ApkPairCompareSimilarImpl implements ApkPairCompare {
    private static final Logger logger = LoggerFactory.getLogger(ApkPairCompare.class);
    private ApkData dataA;
    private ApkData dataB;
    private ComparisonResult comparisonResult;
    private HashPairCompare hashComparator;
    private MetadataPairCompare metadataComparator;
    private SimilarityEvaluator similarityEvaluator;

    public ApkPairCompareSimilarImpl(ApkData dataA, ApkData dataB) {
        if (dataA == null || dataB == null) {
            throw new IllegalArgumentException("data is null");
        }
        this.dataA = dataA;
        this.dataB = dataB;
        this.hashComparator = new HashPairCompare(dataA.getFileDigest(), dataB.getFileDigest());
        this.metadataComparator = new MetadataPairCompare(dataA, dataB);
        this.similarityEvaluator = new SimilarityEvaluator();
    }

    /**
     * Optimized compare of two apks.
     * Performs full compare only on similar apks.
     *
     * @return result of compare
     */
    public ComparisonResult compare() {

        logger.trace("Start compare " + dataA.getFileName() + " and " + dataB.getFileName());

        comparisonResult = new ComparisonResult(dataA.getFileName(), dataB.getFileName());

        //do just basic compare
        comparisonResult.setMetadataCompareResult(metadataComparator.basicCompare());

        //check whether they are similiar
        SimilarityType isBasicallySimilar = similarityEvaluator.basicEvaluate(comparisonResult);

        if (isBasicallySimilar == null || SimilarityType.NOT_SIMILAR.equals(isBasicallySimilar)) { //if they are not similar dont continue
            logger.trace("Basically not similar " + dataA.getFileName() + " and " + dataB.getFileName());
            return comparisonResult;
        }

        //if they are similar get full statistics
        comparisonResult.setMetadataCompareResult(metadataComparator.fullCompare());
        comparisonResult.setHashCompareResult(hashComparator.hashCompare());

        SimilarityType isDetailedSimilar = similarityEvaluator.fullEvaluate(comparisonResult);

        logger.trace("Finished compare " + dataA.getFileName() + " and " + dataB.getFileName() + "with result" + isDetailedSimilar);

        return comparisonResult;
    }

    public SimilarityEvaluator getSimilarityEvaluator() {
        return similarityEvaluator;
    }

    public void setSimilarityEvaluator(SimilarityEvaluator similarityEvaluator) {
        this.similarityEvaluator = similarityEvaluator;
    }
}
