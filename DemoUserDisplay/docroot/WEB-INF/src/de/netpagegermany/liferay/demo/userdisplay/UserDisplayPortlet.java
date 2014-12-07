
package de.netpagegermany.liferay.demo.userdisplay;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class UserDisplayPortlet
 */
public class UserDisplayPortlet extends MVCPortlet {

    private static Log log = LogFactory.getLog(UserDisplayPortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
        throws IOException, PortletException {

        Map<Company, List<User>> users = new HashMap<Company, List<User>>();
        renderRequest.setAttribute("users", users);

        try {
            log.debug("Loading Companies");
            List<Company> companies = CompanyLocalServiceUtil.getCompanies();
            log.debug("Found " + companies.size() + " companies");

            for (Company company : companies) {
                log.debug("Searching for company users: " + company);

                List<User> cusers =
                    UserLocalServiceUtil.getCompanyUsers(company.getCompanyId(), QueryUtil.ALL_POS, QueryUtil.ALL_POS);
                log.debug("Found " + cusers.size() + " users");

                users.put(company, cusers);
            }

            renderRequest.setAttribute("hasElements", users.size() > 0);

            log.debug("Loading completed");
        }
        catch (Exception e) {
            log.fatal("Error while loading users", e);
            throw new PortletException("Error while loading users", e);
        }
        finally {
            super.doView(renderRequest, renderResponse);
        }
    }
}
