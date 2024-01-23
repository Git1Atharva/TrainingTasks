package org.training.core.interceptors;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.PrepareInterceptor;
import de.hybris.platform.servicelayer.model.ModelService;
import org.training.core.model.PostsModel;

import javax.annotation.Resource;
import java.util.Locale;

public class PrepareInterceptorDemo implements PrepareInterceptor {

    @Resource
    private ModelService modelService;
    @Override
    public void onPrepare(Object model, InterceptorContext ctx) throws InterceptorException {
        if (model instanceof PostsModel){
            final PostsModel posts= (PostsModel) model;
            String title=posts.getTitle();

            if (title.equals(title.toLowerCase())){
                title=title.toUpperCase();
                posts.setTitle(title);
                modelService.save(posts);

            }
        }
    }
}
