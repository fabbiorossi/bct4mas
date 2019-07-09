package behav;


import agents.TAgent;
import controllers.TAgentController;
import jade.core.behaviours.OneShotBehaviour;

public class InitTAgent extends OneShotBehaviour {

    private static final long serialVersionUID = -5824153372874943556L;
    TAgent tAgent;

  public InitTAgent(TAgent a) {
    super(a);
    tAgent = a;
  }

  @Override
  public void action() {

      try {
          TAgentController.setTAgentValues(tAgent);
      } catch (Exception e) {
          e.printStackTrace();
      }

  }

}
