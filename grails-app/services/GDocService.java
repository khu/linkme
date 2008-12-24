import com.google.gdata.client.spreadsheet.FeedURLFactory;
import com.google.gdata.client.spreadsheet.SpreadsheetService;
import com.google.gdata.data.spreadsheet.*;

import java.util.List;

public class GDocService {
    private SpreadsheetService speadService;

    public GDocService(String username, String password) throws Exception {
        speadService = new SpreadsheetService("gdoc-clinet");
        speadService.setUserCredentials(username, password);
    }


    public List<ListEntry> entries(String spreadsheet, String worksheet) throws Exception {
        FeedURLFactory feedURLFactory = FeedURLFactory.getDefault();
        SpreadsheetEntry entryIWant = getSpreadFeed(spreadsheet, feedURLFactory);
        WorksheetEntry worksheetIWant = getWorksheet(worksheet, entryIWant);
        return getListEntries(worksheetIWant);
    }

    public List<ListEntry> projects() throws Exception {
        List<ListEntry> schedules = entries("TW China Resource Schedule", "Resource Schedules");
        List<ListEntry> contacts = entries("TW China Resource Schedule", "Resource Schedules");
        Projects projects = new Projects();
        return null;
    }


    private List<ListEntry> getListEntries(WorksheetEntry worksheetIWant) throws Exception {
        ListFeed feeds = speadService.getFeed(worksheetIWant.getListFeedUrl(), ListFeed.class);
        return feeds.getEntries();
    }


    private WorksheetEntry getWorksheet(String worksheet, SpreadsheetEntry entryIWant) throws Exception {
        List<WorksheetEntry> worksheets = entryIWant.getWorksheets();
        WorksheetEntry worksheetIWant = null;
        for (int i = 0; i < worksheets.size(); i++) {
            WorksheetEntry worksheet1 = worksheets.get(i);
            String plainText = worksheet1.getTitle().getPlainText();
            if (plainText.equalsIgnoreCase(worksheet)) {
                worksheetIWant = worksheet1;
            }
        }
        return worksheetIWant;
    }

    private SpreadsheetEntry getSpreadFeed(String spreadsheet, FeedURLFactory feedURLFactory) throws Exception {
        SpreadsheetFeed feed = speadService.getFeed(feedURLFactory.getSpreadsheetsFeedUrl(), SpreadsheetFeed.class);
        List<SpreadsheetEntry> spreadsheets = feed.getEntries();
        SpreadsheetEntry entryIWant = null;
        for (int i = 0; i < spreadsheets.size(); i++) {
            SpreadsheetEntry entry = spreadsheets.get(i);
            String plainText = entry.getTitle().getPlainText();
            if (plainText.equalsIgnoreCase(spreadsheet)) {
                entryIWant = entry;
            }
        }
        return entryIWant;
    }

}
