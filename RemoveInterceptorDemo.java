package org.training.core.interceptors;

import de.hybris.platform.servicelayer.interceptor.InterceptorContext;
import de.hybris.platform.servicelayer.interceptor.InterceptorException;
import de.hybris.platform.servicelayer.interceptor.RemoveInterceptor;
import org.training.core.constants.TrainingCoreConstants;
import org.training.core.model.PostsModel;

public class RemoveInterceptorDemo implements RemoveInterceptor {
    @Override
    public void onRemove(Object model, InterceptorContext ctx) throws InterceptorException {
        if (model instanceof PostsModel){
            final PostsModel posts= (PostsModel) model;
            String status= String.valueOf(posts.getStatus());

            if (status.equals("PUBLISHED")){

                throw new InterceptorException(TrainingCoreConstants.INTERCEPTOR_REMOVE_MSG);
            }
        }

    }
}
