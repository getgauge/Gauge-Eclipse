/*
* generated by Xtext
*/
package io.getgauge.services;

import com.google.inject.Singleton;
import com.google.inject.Inject;

import java.util.List;

import org.eclipse.xtext.*;
import org.eclipse.xtext.service.GrammarProvider;
import org.eclipse.xtext.service.AbstractElementFinder.*;


@Singleton
public class SpecGrammarAccess extends AbstractGrammarElementFinder {
	
	
	public class ModelElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Model");
		private final Assignment cDefinitionsAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cDefinitionsAbstractEntityParserRuleCall_0 = (RuleCall)cDefinitionsAssignment.eContents().get(0);
		
		//Model:
		//	definitions+=AbstractEntity*;
		public ParserRule getRule() { return rule; }

		//definitions+=AbstractEntity*
		public Assignment getDefinitionsAssignment() { return cDefinitionsAssignment; }

		//AbstractEntity
		public RuleCall getDefinitionsAbstractEntityParserRuleCall_0() { return cDefinitionsAbstractEntityParserRuleCall_0; }
	}

	public class AbstractEntityElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "AbstractEntity");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSpecParserRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cScenarioParserRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		private final RuleCall cStepParserRuleCall_2 = (RuleCall)cAlternatives.eContents().get(2);
		private final RuleCall cCommentParserRuleCall_3 = (RuleCall)cAlternatives.eContents().get(3);
		private final RuleCall cBlankLineParserRuleCall_4 = (RuleCall)cAlternatives.eContents().get(4);
		
		//AbstractEntity:
		//	Spec | Scenario | Step | Comment | BlankLine;
		public ParserRule getRule() { return rule; }

		//Spec | Scenario | Step | Comment | BlankLine
		public Alternatives getAlternatives() { return cAlternatives; }

		//Spec
		public RuleCall getSpecParserRuleCall_0() { return cSpecParserRuleCall_0; }

		//Scenario
		public RuleCall getScenarioParserRuleCall_1() { return cScenarioParserRuleCall_1; }

		//Step
		public RuleCall getStepParserRuleCall_2() { return cStepParserRuleCall_2; }

		//Comment
		public RuleCall getCommentParserRuleCall_3() { return cCommentParserRuleCall_3; }

		//BlankLine
		public RuleCall getBlankLineParserRuleCall_4() { return cBlankLineParserRuleCall_4; }
	}

	public class SpecElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Spec");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignSpaceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameLINE_TEXTTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Spec:
		//	"# " name=LINE_TEXT;
		public ParserRule getRule() { return rule; }

		//"# " name=LINE_TEXT
		public Group getGroup() { return cGroup; }

		//"# "
		public Keyword getNumberSignSpaceKeyword_0() { return cNumberSignSpaceKeyword_0; }

		//name=LINE_TEXT
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//LINE_TEXT
		public RuleCall getNameLINE_TEXTTerminalRuleCall_1_0() { return cNameLINE_TEXTTerminalRuleCall_1_0; }
	}

	public class ScenarioElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Scenario");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cNumberSignNumberSignSpaceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameLINE_TEXTTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Scenario:
		//	"## " name=LINE_TEXT;
		public ParserRule getRule() { return rule; }

		//"## " name=LINE_TEXT
		public Group getGroup() { return cGroup; }

		//"## "
		public Keyword getNumberSignNumberSignSpaceKeyword_0() { return cNumberSignNumberSignSpaceKeyword_0; }

		//name=LINE_TEXT
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//LINE_TEXT
		public RuleCall getNameLINE_TEXTTerminalRuleCall_1_0() { return cNameLINE_TEXTTerminalRuleCall_1_0; }
	}

	public class StepElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Step");
		private final Group cGroup = (Group)rule.eContents().get(1);
		private final Keyword cAsteriskSpaceKeyword_0 = (Keyword)cGroup.eContents().get(0);
		private final Assignment cNameAssignment_1 = (Assignment)cGroup.eContents().get(1);
		private final RuleCall cNameLINE_TEXTTerminalRuleCall_1_0 = (RuleCall)cNameAssignment_1.eContents().get(0);
		
		//Step:
		//	"* " name=LINE_TEXT;
		public ParserRule getRule() { return rule; }

		//"* " name=LINE_TEXT
		public Group getGroup() { return cGroup; }

		//"* "
		public Keyword getAsteriskSpaceKeyword_0() { return cAsteriskSpaceKeyword_0; }

		//name=LINE_TEXT
		public Assignment getNameAssignment_1() { return cNameAssignment_1; }

		//LINE_TEXT
		public RuleCall getNameLINE_TEXTTerminalRuleCall_1_0() { return cNameLINE_TEXTTerminalRuleCall_1_0; }
	}

	public class CommentElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "Comment");
		private final Assignment cTextAssignment = (Assignment)rule.eContents().get(1);
		private final RuleCall cTextLINE_TEXTTerminalRuleCall_0 = (RuleCall)cTextAssignment.eContents().get(0);
		
		//Comment:
		//	text=LINE_TEXT;
		public ParserRule getRule() { return rule; }

		//text=LINE_TEXT
		public Assignment getTextAssignment() { return cTextAssignment; }

		//LINE_TEXT
		public RuleCall getTextLINE_TEXTTerminalRuleCall_0() { return cTextLINE_TEXTTerminalRuleCall_0; }
	}

	public class BlankLineElements extends AbstractParserRuleElementFinder {
		private final ParserRule rule = (ParserRule) GrammarUtil.findRuleForName(getGrammar(), "BlankLine");
		private final Alternatives cAlternatives = (Alternatives)rule.eContents().get(1);
		private final RuleCall cSINGLE_NLTerminalRuleCall_0 = (RuleCall)cAlternatives.eContents().get(0);
		private final RuleCall cMULTI_NLTerminalRuleCall_1 = (RuleCall)cAlternatives.eContents().get(1);
		
		//BlankLine:
		//	SINGLE_NL | MULTI_NL;
		public ParserRule getRule() { return rule; }

		//SINGLE_NL | MULTI_NL
		public Alternatives getAlternatives() { return cAlternatives; }

		//SINGLE_NL
		public RuleCall getSINGLE_NLTerminalRuleCall_0() { return cSINGLE_NLTerminalRuleCall_0; }

		//MULTI_NL
		public RuleCall getMULTI_NLTerminalRuleCall_1() { return cMULTI_NLTerminalRuleCall_1; }
	}
	
	
	private final ModelElements pModel;
	private final AbstractEntityElements pAbstractEntity;
	private final SpecElements pSpec;
	private final ScenarioElements pScenario;
	private final StepElements pStep;
	private final CommentElements pComment;
	private final BlankLineElements pBlankLine;
	private final TerminalRule tMULTI_NL;
	private final TerminalRule tSINGLE_NL;
	private final TerminalRule tLINE_TEXT;
	
	private final Grammar grammar;

	@Inject
	public SpecGrammarAccess(GrammarProvider grammarProvider) {
		this.grammar = internalFindGrammar(grammarProvider);
		this.pModel = new ModelElements();
		this.pAbstractEntity = new AbstractEntityElements();
		this.pSpec = new SpecElements();
		this.pScenario = new ScenarioElements();
		this.pStep = new StepElements();
		this.pComment = new CommentElements();
		this.pBlankLine = new BlankLineElements();
		this.tMULTI_NL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "MULTI_NL");
		this.tSINGLE_NL = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "SINGLE_NL");
		this.tLINE_TEXT = (TerminalRule) GrammarUtil.findRuleForName(getGrammar(), "LINE_TEXT");
	}
	
	protected Grammar internalFindGrammar(GrammarProvider grammarProvider) {
		Grammar grammar = grammarProvider.getGrammar(this);
		while (grammar != null) {
			if ("io.getgauge.Spec".equals(grammar.getName())) {
				return grammar;
			}
			List<Grammar> grammars = grammar.getUsedGrammars();
			if (!grammars.isEmpty()) {
				grammar = grammars.iterator().next();
			} else {
				return null;
			}
		}
		return grammar;
	}
	
	
	public Grammar getGrammar() {
		return grammar;
	}
	

	
	//Model:
	//	definitions+=AbstractEntity*;
	public ModelElements getModelAccess() {
		return pModel;
	}
	
	public ParserRule getModelRule() {
		return getModelAccess().getRule();
	}

	//AbstractEntity:
	//	Spec | Scenario | Step | Comment | BlankLine;
	public AbstractEntityElements getAbstractEntityAccess() {
		return pAbstractEntity;
	}
	
	public ParserRule getAbstractEntityRule() {
		return getAbstractEntityAccess().getRule();
	}

	//Spec:
	//	"# " name=LINE_TEXT;
	public SpecElements getSpecAccess() {
		return pSpec;
	}
	
	public ParserRule getSpecRule() {
		return getSpecAccess().getRule();
	}

	//Scenario:
	//	"## " name=LINE_TEXT;
	public ScenarioElements getScenarioAccess() {
		return pScenario;
	}
	
	public ParserRule getScenarioRule() {
		return getScenarioAccess().getRule();
	}

	//Step:
	//	"* " name=LINE_TEXT;
	public StepElements getStepAccess() {
		return pStep;
	}
	
	public ParserRule getStepRule() {
		return getStepAccess().getRule();
	}

	//Comment:
	//	text=LINE_TEXT;
	public CommentElements getCommentAccess() {
		return pComment;
	}
	
	public ParserRule getCommentRule() {
		return getCommentAccess().getRule();
	}

	//BlankLine:
	//	SINGLE_NL | MULTI_NL;
	public BlankLineElements getBlankLineAccess() {
		return pBlankLine;
	}
	
	public ParserRule getBlankLineRule() {
		return getBlankLineAccess().getRule();
	}

	//terminal MULTI_NL:
	//	SINGLE_NL SINGLE_NL+;
	public TerminalRule getMULTI_NLRule() {
		return tMULTI_NL;
	} 

	//terminal SINGLE_NL:
	//	"\r"? "\n";
	public TerminalRule getSINGLE_NLRule() {
		return tSINGLE_NL;
	} 

	//terminal LINE_TEXT:
	//	!("#" | "*" | "\r" | "\n")->SINGLE_NL;
	public TerminalRule getLINE_TEXTRule() {
		return tLINE_TEXT;
	} 
}
