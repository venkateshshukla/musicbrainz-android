/*
 * Copyright (C) 2010 Jamie McDonald
 * 
 * This file is part of MusicBrainz Mobile (Android).
 * 
 * MusicBrainz Mobile (Android) is free software: you can redistribute 
 * it and/or modify it under the terms of the GNU General Public 
 * License as published by the Free Software Foundation, either 
 * version 3 of the License, or (at your option) any later version.
 * 
 * MusicBrainz Mobile (Android) is distributed in the hope that it 
 * will be useful, but WITHOUT ANY WARRANTY; without even the implied 
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. 
 * See the GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with MusicBrainz Mobile (Android). If not, see 
 * <http://www.gnu.org/licenses/>.
 */

package org.musicbrainz.android.api.handlers;

import org.musicbrainz.android.api.data.UserData;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

public class UserDataHandler extends MBHandler {
	
	private UserData data = new UserData();
	
	public UserData getResult() {
		return data;
	}
	
	public void startElement(String namespaceURI, String localName,
			String qName, Attributes atts) throws SAXException {
		
		if (localName.equals("user-tag")) {
			sb = new StringBuilder();
		} else if (localName.equals("user-rating")) {
			sb = new StringBuilder();
		} 
	}
	
	public void endElement(String namespaceURI, String localName, String qName)
			throws SAXException {
		
		if (localName.equals("user-tag")) {
			data.addTag(sb.toString());
		} else if (localName.equals("user-rating")) {
			float rating = Float.parseFloat(sb.toString());
			data.setRating(rating);
		} 
	}
	
}