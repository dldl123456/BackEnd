package service.impl;

import service.AssessmentService;
import view.AssessmentView;
public class AssessmentServiceImpl implements AssessmentService {

	@Override
	public void seeAllAssessmentOperate() throws Exception {
		AssessmentView.AssessmentSeeAllPage();
	}

	@Override
	public void seeSomeMovieAssessmentOperate() throws Exception {
		AssessmentView.AssessmentSeeMovieAllPage();
	}

	@Override
	public void seeSomeCinemaMovieAssessmentOperate() throws Exception {
		AssessmentView.AssessmentSeeCinemaMovieAllPage();
	}

	@Override
	public void seeSomeCinemaAssessmentOperate() throws Exception {
		AssessmentView.AssessmentSeeCinemaAllPage();
	}

	@Override
	public void seeAssessmentOperate() throws Exception {
		AssessmentView.AssessmentSeePage();
	}

	@Override
	public void seeSomeUserAssessmentOperate() throws Exception {
		AssessmentView.AssessmentSeeUserAllPage();
	}
}
