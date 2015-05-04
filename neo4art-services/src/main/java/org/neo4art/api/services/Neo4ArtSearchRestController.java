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
package org.neo4art.api.services;

import java.util.List;

import org.neo4art.api.domain.SearchDomain;
import org.neo4art.api.domain.SearchResult;
import org.neo4art.api.transformer.SearchDomainTransformer;
import org.neo4art.api.transformer.SearchResultTransformer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Enrico De Benetti
 * @since 25 Apr 2015
 *
 */
@Controller
@RequestMapping("/api/services/search")
public class Neo4ArtSearchRestController {

	
	@RequestMapping(value = "/domains.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SearchDomain> getDomains(Model model) {

	  return SearchDomainTransformer.buildDomains();
	}

	@RequestMapping(value = "/artists-domain.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SearchDomain> getArtistsDomain(Model model) {

	  return SearchDomainTransformer.buildDomainArtists();
	}
	
	@RequestMapping(value = "/artworks-domain.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SearchDomain> getArtworkDomain(Model model) {

	  return SearchDomainTransformer.buildDomainArtworks();
	}
	
	@RequestMapping(value = "/museums-domain.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SearchDomain> getMuseumsDomain(Model model) {

	  return SearchDomainTransformer.buildDomainMuseums();
	}
	
	@RequestMapping(value = "/colours-domain.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SearchDomain> getColoursDomain(Model model) {

	  return SearchDomainTransformer.buildDomainColors();
	}
	
	@RequestMapping(value = "/sentiments-domain.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody List<SearchDomain> getSentimentsDomain(Model model) {

	  return SearchDomainTransformer.buildDomainSentiments();
	}
	
	@RequestMapping(value = "/search-results.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody SearchResult getResults(Model model,
			                                     @RequestParam(value="searchInput", required=true) String searchInput) {

	 System.out.println("Input search: "+searchInput);
		
	 return SearchResultTransformer.buildSearchResult();
	}
	
	
	@RequestMapping(value = "/node-explode.json", method = RequestMethod.GET, produces = "application/json")
	public @ResponseBody SearchResult getDetailNodeSearch(Model model,
			                                     @RequestParam(value="nodeId", required=true) Long nodeId) {

	 System.out.println("Input nodeId: "+nodeId);
		
	 return SearchResultTransformer.buildDetailNodeSearch();
	}
	
}