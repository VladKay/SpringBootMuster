package mainFolder.controller.models;

import java.text.DateFormat;
    public class VisitDto {
        String businessid;
        String visitid;
        String startdatetime;
        String enddatetime;
        String keywords;
        int pages;
        int multi;
        String referrername;
        String referrerlink;

        public void setBusinessid(String businessid) {
            this.businessid = businessid;
        }

        public void setVisitid(String visitid) {
            this.visitid = visitid;
        }

        public void setStartdatetime(String startdatetime) {
            this.startdatetime = startdatetime;
        }

        public void setEnddatetime(String enddatetime) {
            this.enddatetime = enddatetime;
        }

        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        public void setPages(int pages) {
            this.pages = pages;
        }

        public void setMulti(int multi) {
            this.multi = multi;
        }

        public void setReferrername(String referrername) {
            this.referrername = referrername;
        }

        public void setReferrerlink(String referrerlink) {
            this.referrerlink = referrerlink;
        }

        public String getBusinessid() {
            return businessid;
        }

        public String getVisitid() {
            return visitid;
        }

        public String getStartdatetime() {
            return startdatetime;
        }

        public String getEnddatetime() {
            return enddatetime;
        }

        public String getKeywords() {
            return keywords;
        }

        public int getPages() {
            return pages;
        }

        public int getMulti() {
            return multi;
        }

        public String getReferrername() {
            return referrername;
        }

        public String getReferrerlink() {
            return referrerlink;
        }
}
