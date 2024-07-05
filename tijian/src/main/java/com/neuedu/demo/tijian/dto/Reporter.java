package com.neuedu.demo.tijian.dto;

import com.neuedu.demo.tijian.pojo.Cidetailedreport;
import com.neuedu.demo.tijian.pojo.Cireport;
import com.neuedu.demo.tijian.pojo.Overallresult;

import java.util.List;

public class Reporter {
    private List<Cidetailedreport> errorReports;
    private List<Cireport> cireports;
    private List<Overallresult> overallresults;

    public List<Cireport> getCireports() {
        return cireports;
    }

    public Reporter(){}

    public Reporter(List<Cireport> cireports, List<Overallresult> overallresults, List<Cidetailedreport> errorReports) {
        this.cireports = cireports;
        this.overallresults = overallresults;
        this.errorReports = errorReports;
    }

    public List<Cidetailedreport> getErrorReports() {
        return errorReports;
    }

    public void setErrorReports(List<Cidetailedreport> errorReports) {
        this.errorReports = errorReports;
    }

    public void setCireports(List<Cireport> cireports) {
        this.cireports = cireports;
    }

    public List<Overallresult> getOverallresult() {
        return overallresults;
    }

    public void setOverallresult(List<Overallresult> overallresults) {
        this.overallresults = overallresults;
    }
}
