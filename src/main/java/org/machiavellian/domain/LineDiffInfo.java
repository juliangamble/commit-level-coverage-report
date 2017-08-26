package org.machiavellian.domain;

/**
 * Copyright [2017] [Julian Gamble]

 Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
 */
/**
 * Retain information from JGit about lines of code that have changed.
 * Created by juliangamble on 16/7/17.
 */
public class LineDiffInfo {
    protected Integer lineNumber;
    protected String filePackagePathName;

    public LineDiffInfo(Integer lineNumber, String filePackagePathName) {
        this.lineNumber = lineNumber;
        this.filePackagePathName = filePackagePathName;
    }

    public Integer getLineNumber() {
        return lineNumber;
    }

    public String getFilePackagePathName() {
        return filePackagePathName;
    }

    @Override
    public String toString() {
        return "LineDiffInfo{" +
                "lineNumber=" + lineNumber +
                ", filePackagePathName='" + filePackagePathName + '\'' +
                '}';
    }

    public String toLineDifferenceString() {
        return filePackagePathName + ":" + lineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LineDiffInfo)) return false;

        LineDiffInfo that = (LineDiffInfo) o;

        if (!lineNumber.equals(that.lineNumber)) return false;
        return filePackagePathName.equals(that.filePackagePathName);
    }

    @Override
    public int hashCode() {
        int result = lineNumber.hashCode();
        result = 31 * result + filePackagePathName.hashCode();
        return result;
    }
}
