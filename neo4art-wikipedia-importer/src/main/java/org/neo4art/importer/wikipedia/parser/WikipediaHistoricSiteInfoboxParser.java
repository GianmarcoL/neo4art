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
package org.neo4art.importer.wikipedia.parser;

import java.util.Map;

import org.neo4art.domain.Coordinate;
import org.neo4art.domain.HistoricSite;
import org.neo4art.importer.wikipedia.parser.util.InfoboxMap;
import org.neo4art.importer.wikipedia.parser.util.InfoboxParserUtil;
import org.neo4art.importer.wikipedia.parser.util.InfoboxUrlParser;

/**
 * 
 * @author Mattia Zaratin
 * @since 30 Apr 2015
 */
public class WikipediaHistoricSiteInfoboxParser
{
  public static final String NAME    = "name";
  public static final String LATD    = "latd";
  public static final String LATM    = "latm";
  public static final String LATS    = "lats";
  public static final String LATNS   = "latNS";
  public static final String LONGD   = "longd";
  public static final String LONGM   = "longm";
  public static final String LONGS   = "longs";
  public static final String LONGEW  = "longEW";
  public static final String LATDL   = "lat_degrees";
  public static final String LATML   = "lat_minutes";
  public static final String LATSL   = "lat_seconds";
  public static final String LATNSL  = "lat_direction";
  public static final String LONGDL  = "long_degrees";
  public static final String LONGML  = "long_minutes";
  public static final String LONGSL  = "long_seconds";
  public static final String LONGEWL = "long_direction";
  public static final String IMAGE   = "image";
  public static final String CAPTION = "caption";
  public static final String STYLE   = "infobox";

  public static HistoricSite parse(String text)
  {
    HistoricSite historicSite = new HistoricSite();
    Coordinate coordinate = new Coordinate();

    Map<String, String> map = InfoboxMap.asMap(text);

    for (String key : map.keySet())
    {
      switch (key)
      {
        case NAME:
          historicSite.setName(InfoboxParserUtil.removeAllParenthesis(map.get(key)));
          break;
        case STYLE:
          historicSite.setType(map.get(key));
          break;
        case CAPTION:
          historicSite.setCaption(map.get(key));
          break;
        case IMAGE:
          historicSite.setImage(InfoboxUrlParser.infoboxUrl(map.get(key)));
          break;
        case LATD:
          coordinate.setLatD(map.get(key));
          break;
        case LATM:
          coordinate.setLatM(map.get(key));
          break;
        case LATS:
          coordinate.setLatS(map.get(key));
          break;
        case LATNS:
          coordinate.setLatNS(map.get(key));
          break;
        case LONGD:
          coordinate.setLongD(map.get(key));
          break;
        case LONGM:
          coordinate.setLongM(map.get(key));
          break;
        case LONGS:
          coordinate.setLongS(map.get(key));
          break;
        case LONGEW:
          coordinate.setLongEW(map.get(key));
          break;
        case LATDL:
          coordinate.setLatD(map.get(key));
          break;
        case LATML:
          coordinate.setLatM(map.get(key));
          break;
        case LATSL:
          coordinate.setLatS(map.get(key));
          break;
        case LATNSL:
          coordinate.setLatNS(map.get(key));
          break;
        case LONGDL:
          coordinate.setLongD(map.get(key));
          break;
        case LONGML:
          coordinate.setLongM(map.get(key));
          break;
        case LONGSL:
          coordinate.setLongS(map.get(key));
          break;
        case LONGEWL:
          coordinate.setLongEW(map.get(key));
          break;
      }
      
      historicSite.setCoordinate(coordinate);
    }
    
    return historicSite;
  }
}
