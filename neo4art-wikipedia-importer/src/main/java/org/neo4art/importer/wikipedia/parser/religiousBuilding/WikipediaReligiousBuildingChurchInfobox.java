/**
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.neo4art.importer.wikipedia.parser.religiousBuilding;

import java.net.MalformedURLException;
import java.util.Map;

import org.neo4art.domain.Coordinate;
import org.neo4art.domain.ReligiousBuilding;
import org.neo4art.importer.wikipedia.util.WikipediaInfoboxUtils;

/**
 * 
 * @author Mattia Zaratin
 * @since 30 Apr 2015
 */
public class WikipediaReligiousBuildingChurchInfobox
{
  public static final String NAME   = "name";
  public static final String LATD   = "latd";
  public static final String LATM   = "latm";
  public static final String LATS   = "lats";
  public static final String LATNS  = "latNS";
  public static final String LONGD  = "longd";
  public static final String LONGM  = "longm";
  public static final String LONGS  = "longs";
  public static final String LONGEW = "longEW";
  public static final String IMAGE  = "image";
  public static final String STYLE  = "infobox";

  public static ReligiousBuilding parse(String text) throws MalformedURLException
  {
    ReligiousBuilding church = new ReligiousBuilding();
    Coordinate coordinate = new Coordinate();

    Map<String, String> map = WikipediaInfoboxUtils.asMap(text);

    for (String key : map.keySet())
    {
      switch (key)
      {
        case NAME:
          church.setBuildingName(WikipediaInfoboxUtils.removeAllParenthesis(map.get(key)));
          break;
        case STYLE:
          church.setType(map.get(key));
          break;
        case IMAGE:
          church.setImage(WikipediaInfoboxUtils.infoboxImageUrl(map.get(key)));
          break;
        case LATD:
          coordinate.setLatD(Double.parseDouble(map.get(key)));
          church.setCoordinates(coordinate);
          break;
        case LATM:
          coordinate.setLatM(Double.parseDouble(map.get(key)));
          church.setCoordinates(coordinate);
          break;
        case LATS:
          coordinate.setLatS(Double.parseDouble(map.get(key)));
          church.setCoordinates(coordinate);
          break;
        case LATNS:
          coordinate.setLatNS(map.get(key));
          church.setCoordinates(coordinate);
          break;
        case LONGD:
          coordinate.setLongD(Double.parseDouble(map.get(key)));
          church.setCoordinates(coordinate);
          break;
        case LONGM:
          coordinate.setLongM(Double.parseDouble(map.get(key)));
          church.setCoordinates(coordinate);
          break;
        case LONGS:
          coordinate.setLongS(Double.parseDouble(map.get(key)));
          church.setCoordinates(coordinate);
          break;
        case LONGEW:
          coordinate.setLongEW(map.get(key));
          church.setCoordinates(coordinate);
          break;
      }
    }
    return church;
  }
}