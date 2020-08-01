package org.subhashis;

import java.util.List;

public class CohesionExample {
    public static void main(String[] args) {
        new CohesiveDownloadAndStore().doEverything();
        new BadDesignDownloadAndStore().doEverything();
    }
}

class CohesiveDownloadAndStore {
    void doEverything() {
        System.out.println("This is an example of good design");
        new DownloadLogsFromPCF().downloadPCFLogs();
        new LogParser().parseLogs();
        new DatabaseStorer().storeIntoDatabase();
    }
}

class BadDesignDownloadAndStore {
    void downloadPCFLogs() {}
    void parseLogs() {}
    void storeIntoDatabase() {}
    void doEverything() {
        System.out.println("This is an example of bad design");
        downloadPCFLogs();
        parseLogs();
        storeIntoDatabase();
    }
}

class DownloadLogsFromDocker {
    void downloadPCFLogs() {}
}

class DownloadLogsFromPCF {
    void downloadPCFLogs() {}
}

class LogParser {
    void parseLogs() {}
}

class DatabaseStorer {
    void storeIntoDatabase() {}
}
