package sk.styk.martin.bakalarka.compare.data;

import sk.styk.martin.bakalarka.utils.data.PercentagePair;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by Martin Styk on 06.01.2016.
 */
public class HashCompareResult {

    private Boolean dexIdentical;
    private Boolean arscIdentical;

    private Integer totalDrawablesA;
    private Integer totalDrawablesB;
    private Integer totalLayoutsA;
    private Integer totalLayoutsB;
    private Integer totalOthersA;
    private Integer totalOthersB;

    private PercentagePair identicalDrawables;
    private PercentagePair identicalLayouts;
    private PercentagePair identicalOthers;

    private List<String> modifiedDrawableFiles;
    private List<String> modifiedLayoutFiles;
    private List<String> modifiedOtherFiles;

    private List<String> additionalDrawableFilesA;
    private List<String> additionalDrawableFilesB;

    private List<String> additionaLayoutFilesA;
    private List<String> additionaLayoutFilesB;

    private List<String> additionalOtherFilesA;
    private List<String> additionalOtherFilesB;

    private BigDecimal jaccardIndexDrawables;
    private BigDecimal jaccardIndexLayouts;
    private BigDecimal jaccardIndexOthers;
    private BigDecimal jaccardIndexAll;

    public PercentagePair getIdenticalDrawables() {
        return identicalDrawables;
    }

    public void setIdenticalDrawables(PercentagePair identicalDrawables) {
        this.identicalDrawables = identicalDrawables;
    }

    public PercentagePair getIdenticalLayouts() {
        return identicalLayouts;
    }

    public void setIdenticalLayouts(PercentagePair identicalLayouts) {
        this.identicalLayouts = identicalLayouts;
    }

    public PercentagePair getIdenticalOthers() {
        return identicalOthers;
    }

    public void setIdenticalOthers(PercentagePair identicalOthers) {
        this.identicalOthers = identicalOthers;
    }

    public Integer getTotalFilesA() {
        return totalDrawablesA + totalLayoutsA + totalOthersA;
    }

    public Integer getTotalFilesB() {
        return totalDrawablesB + totalLayoutsB + totalOthersB;
    }

    public Integer getTotalDrawablesA() {
        return totalDrawablesA;
    }

    public void setTotalDrawablesA(Integer totalDrawablesA) {
        this.totalDrawablesA = totalDrawablesA;
    }

    public Integer getTotalDrawablesB() {
        return totalDrawablesB;
    }

    public void setTotalDrawablesB(Integer totalDrawablesB) {
        this.totalDrawablesB = totalDrawablesB;
    }

    public Integer getTotalLayoutsA() {
        return totalLayoutsA;
    }

    public void setTotalLayoutsA(Integer totalLayoutsA) {
        this.totalLayoutsA = totalLayoutsA;
    }

    public Integer getTotalLayoutsB() {
        return totalLayoutsB;
    }

    public void setTotalLayoutsB(Integer totalLayoutsB) {
        this.totalLayoutsB = totalLayoutsB;
    }

    public Integer getTotalOthersA() {
        return totalOthersA;
    }

    public void setTotalOthersA(Integer totalOthersA) {
        this.totalOthersA = totalOthersA;
    }

    public Integer getTotalOthersB() {
        return totalOthersB;
    }

    public void setTotalOthersB(Integer totalOthersB) {
        this.totalOthersB = totalOthersB;
    }

    public Boolean getDexIdentical() {
        return dexIdentical;
    }

    public void setDexIdentical(Boolean dexIdentical) {
        this.dexIdentical = dexIdentical;
    }

    public Boolean getArscIdentical() {
        return arscIdentical;
    }

    public void setArscIdentical(Boolean arscIdentical) {
        this.arscIdentical = arscIdentical;
    }

    public List<String> getAdditionalDrawableFilesA() {
        return additionalDrawableFilesA;
    }

    public void setAdditionalDrawableFilesA(List<String> additionalDrawableFilesA) {
        this.additionalDrawableFilesA = additionalDrawableFilesA;
    }

    public List<String> getAdditionalDrawableFilesB() {
        return additionalDrawableFilesB;
    }

    public void setAdditionalDrawableFilesB(List<String> additionalDrawableFilesB) {
        this.additionalDrawableFilesB = additionalDrawableFilesB;
    }

    public List<String> getAdditionaLayoutFilesA() {
        return additionaLayoutFilesA;
    }

    public void setAdditionaLayoutFilesA(List<String> additionaLayoutFilesA) {
        this.additionaLayoutFilesA = additionaLayoutFilesA;
    }

    public List<String> getAdditionaLayoutFilesB() {
        return additionaLayoutFilesB;
    }

    public void setAdditionaLayoutFilesB(List<String> additionaLayoutFilesB) {
        this.additionaLayoutFilesB = additionaLayoutFilesB;
    }

    public List<String> getAdditionalOtherFilesA() {
        return additionalOtherFilesA;
    }

    public void setAdditionalOtherFilesA(List<String> additionalOtherFilesA) {
        this.additionalOtherFilesA = additionalOtherFilesA;
    }

    public List<String> getAdditionalOtherFilesB() {
        return additionalOtherFilesB;
    }

    public void setAdditionalOtherFilesB(List<String> additionalOtherFilesB) {
        this.additionalOtherFilesB = additionalOtherFilesB;
    }

    public List<String> getModifiedDrawableFiles() {
        return modifiedDrawableFiles;
    }

    public void setModifiedDrawableFiles(List<String> modifiedDrawableFiles) {
        this.modifiedDrawableFiles = modifiedDrawableFiles;
    }

    public List<String> getModifiedLayoutFiles() {
        return modifiedLayoutFiles;
    }

    public void setModifiedLayoutFiles(List<String> modifiedLayoutFiles) {
        this.modifiedLayoutFiles = modifiedLayoutFiles;
    }

    public List<String> getModifiedOtherFiles() {
        return modifiedOtherFiles;
    }

    public void setModifiedOtherFiles(List<String> modifiedOtherFiles) {
        this.modifiedOtherFiles = modifiedOtherFiles;
    }

    public BigDecimal getJaccardIndexDrawables() {
        return jaccardIndexDrawables;
    }

    public void setJaccardIndexDrawables(BigDecimal jaccardIndexDrawables) {
        this.jaccardIndexDrawables = jaccardIndexDrawables;
    }

    public BigDecimal getJaccardIndexLayouts() {
        return jaccardIndexLayouts;
    }

    public void setJaccardIndexLayouts(BigDecimal jaccardIndexLayouts) {
        this.jaccardIndexLayouts = jaccardIndexLayouts;
    }

    public BigDecimal getJaccardIndexOthers() {
        return jaccardIndexOthers;
    }

    public void setJaccardIndexOthers(BigDecimal jaccardIndexOthers) {
        this.jaccardIndexOthers = jaccardIndexOthers;
    }

    public BigDecimal getJaccardIndexAll() {
        return jaccardIndexAll;
    }

    public void setJaccardIndexAll(BigDecimal jaccardIndexAll) {
        this.jaccardIndexAll = jaccardIndexAll;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HashCompareResult that = (HashCompareResult) o;

        if (dexIdentical != null ? !dexIdentical.equals(that.dexIdentical) : that.dexIdentical != null) return false;
        if (arscIdentical != null ? !arscIdentical.equals(that.arscIdentical) : that.arscIdentical != null)
            return false;
        if (totalDrawablesA != null ? !totalDrawablesA.equals(that.totalDrawablesA) : that.totalDrawablesA != null)
            return false;
        if (totalDrawablesB != null ? !totalDrawablesB.equals(that.totalDrawablesB) : that.totalDrawablesB != null)
            return false;
        if (totalLayoutsA != null ? !totalLayoutsA.equals(that.totalLayoutsA) : that.totalLayoutsA != null)
            return false;
        if (totalLayoutsB != null ? !totalLayoutsB.equals(that.totalLayoutsB) : that.totalLayoutsB != null)
            return false;
        if (totalOthersA != null ? !totalOthersA.equals(that.totalOthersA) : that.totalOthersA != null) return false;
        if (totalOthersB != null ? !totalOthersB.equals(that.totalOthersB) : that.totalOthersB != null) return false;
        if (identicalDrawables != null ? !identicalDrawables.equals(that.identicalDrawables) : that.identicalDrawables != null)
            return false;
        if (identicalLayouts != null ? !identicalLayouts.equals(that.identicalLayouts) : that.identicalLayouts != null)
            return false;
        if (identicalOthers != null ? !identicalOthers.equals(that.identicalOthers) : that.identicalOthers != null)
            return false;
        if (modifiedDrawableFiles != null ? !modifiedDrawableFiles.equals(that.modifiedDrawableFiles) : that.modifiedDrawableFiles != null)
            return false;
        if (modifiedLayoutFiles != null ? !modifiedLayoutFiles.equals(that.modifiedLayoutFiles) : that.modifiedLayoutFiles != null)
            return false;
        if (modifiedOtherFiles != null ? !modifiedOtherFiles.equals(that.modifiedOtherFiles) : that.modifiedOtherFiles != null)
            return false;
        if (additionalDrawableFilesA != null ? !additionalDrawableFilesA.equals(that.additionalDrawableFilesA) : that.additionalDrawableFilesA != null)
            return false;
        if (additionalDrawableFilesB != null ? !additionalDrawableFilesB.equals(that.additionalDrawableFilesB) : that.additionalDrawableFilesB != null)
            return false;
        if (additionaLayoutFilesA != null ? !additionaLayoutFilesA.equals(that.additionaLayoutFilesA) : that.additionaLayoutFilesA != null)
            return false;
        if (additionaLayoutFilesB != null ? !additionaLayoutFilesB.equals(that.additionaLayoutFilesB) : that.additionaLayoutFilesB != null)
            return false;
        if (additionalOtherFilesA != null ? !additionalOtherFilesA.equals(that.additionalOtherFilesA) : that.additionalOtherFilesA != null)
            return false;
        if (additionalOtherFilesB != null ? !additionalOtherFilesB.equals(that.additionalOtherFilesB) : that.additionalOtherFilesB != null)
            return false;
        if (jaccardIndexDrawables != null ? !jaccardIndexDrawables.equals(that.jaccardIndexDrawables) : that.jaccardIndexDrawables != null)
            return false;
        if (jaccardIndexLayouts != null ? !jaccardIndexLayouts.equals(that.jaccardIndexLayouts) : that.jaccardIndexLayouts != null)
            return false;
        if (jaccardIndexOthers != null ? !jaccardIndexOthers.equals(that.jaccardIndexOthers) : that.jaccardIndexOthers != null)
            return false;
        return !(jaccardIndexAll != null ? !jaccardIndexAll.equals(that.jaccardIndexAll) : that.jaccardIndexAll != null);

    }

    @Override
    public int hashCode() {
        int result = dexIdentical != null ? dexIdentical.hashCode() : 0;
        result = 31 * result + (arscIdentical != null ? arscIdentical.hashCode() : 0);
        result = 31 * result + (totalDrawablesA != null ? totalDrawablesA.hashCode() : 0);
        result = 31 * result + (totalDrawablesB != null ? totalDrawablesB.hashCode() : 0);
        result = 31 * result + (totalLayoutsA != null ? totalLayoutsA.hashCode() : 0);
        result = 31 * result + (totalLayoutsB != null ? totalLayoutsB.hashCode() : 0);
        result = 31 * result + (totalOthersA != null ? totalOthersA.hashCode() : 0);
        result = 31 * result + (totalOthersB != null ? totalOthersB.hashCode() : 0);
        result = 31 * result + (identicalDrawables != null ? identicalDrawables.hashCode() : 0);
        result = 31 * result + (identicalLayouts != null ? identicalLayouts.hashCode() : 0);
        result = 31 * result + (identicalOthers != null ? identicalOthers.hashCode() : 0);
        result = 31 * result + (modifiedDrawableFiles != null ? modifiedDrawableFiles.hashCode() : 0);
        result = 31 * result + (modifiedLayoutFiles != null ? modifiedLayoutFiles.hashCode() : 0);
        result = 31 * result + (modifiedOtherFiles != null ? modifiedOtherFiles.hashCode() : 0);
        result = 31 * result + (additionalDrawableFilesA != null ? additionalDrawableFilesA.hashCode() : 0);
        result = 31 * result + (additionalDrawableFilesB != null ? additionalDrawableFilesB.hashCode() : 0);
        result = 31 * result + (additionaLayoutFilesA != null ? additionaLayoutFilesA.hashCode() : 0);
        result = 31 * result + (additionaLayoutFilesB != null ? additionaLayoutFilesB.hashCode() : 0);
        result = 31 * result + (additionalOtherFilesA != null ? additionalOtherFilesA.hashCode() : 0);
        result = 31 * result + (additionalOtherFilesB != null ? additionalOtherFilesB.hashCode() : 0);
        result = 31 * result + (jaccardIndexDrawables != null ? jaccardIndexDrawables.hashCode() : 0);
        result = 31 * result + (jaccardIndexLayouts != null ? jaccardIndexLayouts.hashCode() : 0);
        result = 31 * result + (jaccardIndexOthers != null ? jaccardIndexOthers.hashCode() : 0);
        result = 31 * result + (jaccardIndexAll != null ? jaccardIndexAll.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "HashCompareResult{" +
                "dexIdentical=" + dexIdentical +
                ", arscIdentical=" + arscIdentical +
                ", totalDrawablesA=" + totalDrawablesA +
                ", totalDrawablesB=" + totalDrawablesB +
                ", totalLayoutsA=" + totalLayoutsA +
                ", totalLayoutsB=" + totalLayoutsB +
                ", totalOthersA=" + totalOthersA +
                ", totalOthersB=" + totalOthersB +
                ", identicalDrawables=" + identicalDrawables +
                ", identicalLayouts=" + identicalLayouts +
                ", identicalOthers=" + identicalOthers +
                ", modifiedDrawableFiles=" + modifiedDrawableFiles +
                ", modifiedLayoutFiles=" + modifiedLayoutFiles +
                ", modifiedOtherFiles=" + modifiedOtherFiles +
                ", additionalDrawableFilesA=" + additionalDrawableFilesA +
                ", additionalDrawableFilesB=" + additionalDrawableFilesB +
                ", additionaLayoutFilesA=" + additionaLayoutFilesA +
                ", additionaLayoutFilesB=" + additionaLayoutFilesB +
                ", additionalOtherFilesA=" + additionalOtherFilesA +
                ", additionalOtherFilesB=" + additionalOtherFilesB +
                ", jaccardIndexDrawables=" + jaccardIndexDrawables +
                ", jaccardIndexLayouts=" + jaccardIndexLayouts +
                ", jaccardIndexOthers=" + jaccardIndexOthers +
                ", jaccardIndexAll=" + jaccardIndexAll +
                '}';
    }
}
