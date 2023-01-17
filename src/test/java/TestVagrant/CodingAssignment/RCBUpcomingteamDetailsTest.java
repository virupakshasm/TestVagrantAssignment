package TestVagrant.CodingAssignment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * 
 * @author Virupaksha M Module Name : RCB upcoming Team Summary : This test
 *         suite contains tests related to RCB team info for upcoming match
 *         Created Date : 01/14/2023
 *
 */

public class RCBUpcomingteamDetailsTest {

	/*
	 * Method is used to validate the team has only 4 foreign players in the team
	 * 
	 * @param None
	 * 
	 * @return void
	 */
	@Test
	public void validateForeignPlayersCountTest() throws FileNotFoundException, IOException, ParseException {
		JSONHelper jsonfile = new JSONHelper();

		int expectedForeignPlayers = 4;
		JSONArray jsonArray = (JSONArray) jsonfile.returJSONnArray();

		ArrayList<String> al = new ArrayList<String>();
		int actualForeignPlayers = 0;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
			String country = (String) jsonObjectRow.get("country");

			if (country.equals("India")) {
				continue;
			} else {
				actualForeignPlayers++;
				al.add(country);
				// Reporter.log("expectedForeignPlayers country is :" +country);

			}
		}

		Reporter.log("ForeignPlayers countries are  :" + al);
		Reporter.log("expectedForeignPlayers count is :" + expectedForeignPlayers);

		Assert.assertEquals(actualForeignPlayers, expectedForeignPlayers);
	}

	/*
	 * Method is used to validate the team has atleast one Wicket-keeper
	 * 
	 * @param None
	 * 
	 * @return void
	 */
	@Test
	public void validateWicketKeeperAvailableTest() throws FileNotFoundException, IOException, ParseException {

		JSONHelper jsonfile = new JSONHelper();

		int expectedWicketKeepers = 1;
		JSONArray jsonArray = (JSONArray) jsonfile.returJSONnArray();
		String wicketKeeperName = null;

		int actualWicketKeepers = 0;
		for (int i = 0; i < jsonArray.size(); i++) {
			JSONObject jsonObjectRow = (JSONObject) jsonArray.get(i);
			String role = (String) jsonObjectRow.get("role");

			if (role.equals("Wicket-keeper")) {
				actualWicketKeepers++;
				wicketKeeperName = (String) jsonObjectRow.get("name");
			}
		}

		Reporter.log("WicketKeepers name is " + wicketKeeperName);
		Reporter.log("expectedWicketKeepers count is more than or equal to :" + expectedWicketKeepers);

		Assert.assertTrue(actualWicketKeepers >= expectedWicketKeepers);

	}
}
