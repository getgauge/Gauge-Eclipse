package io.getgauge.ui;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;

public class SpecHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
        INode root = resource.getParseResult().getRootNode();
        for(INode node : root.getAsTreeIterable()) {
        	System.out.println(node.getText());
            EObject grammarElement = node.getGrammarElement();
            System.out.println(grammarElement.getClass());
            System.out.println(grammarElement);
            if(grammarElement instanceof RuleCall) {
                RuleCall rc = (RuleCall)grammarElement;
                AbstractRule r = rc.getRule();
                EObject c = grammarElement.eContainer();

                if(r.getName().equals("ID") && c instanceof Assignment && ((Assignment)c).getFeature().equals("text")) {
                    INode p = node.getParent();
                    if (p != null && p.getGrammarElement() instanceof RuleCall) {
                        rc = (RuleCall)p.getGrammarElement();
                        AbstractRule r1 = rc.getRule();
                        System.out.println(r1.getName());
                        if(r1.getName().equals("Spec")) {
                            acceptor.addPosition(node.getOffset(), node.getLength(), SpecHighlightingConfiguration.SPEC);
                        }
                        else if (r1.getName().equals("Scenario")) {
                        	acceptor.addPosition(node.getOffset(), node.getLength(), SpecHighlightingConfiguration.SCENARIO);
                        }
                        else if (r1.getName().equals("Step")) {
                        	acceptor.addPosition(node.getOffset(), node.getLength(), SpecHighlightingConfiguration.STEP);
                        }
                    }
                }
            }
        }
	}
}
