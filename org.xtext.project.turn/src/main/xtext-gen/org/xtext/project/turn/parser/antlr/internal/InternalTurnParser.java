package org.xtext.project.turn.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.project.turn.services.TurnGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalTurnParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'urnModel'", "'showAsMeansEnd'", "'{'", "'description'", "'author'", "'created'", "'modified'", "'version'", "'urnVersion'", "'}'", "'concern'", "':'", "','", "'#'", "'['", "']'", "'link'", "'type'", "'-->'", "'metadata'", "'='", "'actor'", "'importance'", "'unit'", "'contributesTo'", "'correlated'", "'with'", "'decomposes'", "'dependsOn'", "'strategiesGroup'", "'strategy'", "'includes'", "'exceeding'", "'evaluation'", "'convertedWith'", "'real'", "'linearConversion'", "'target'", "'threshold'", "'worst'", "'mappingConversion'", "'contributionContextGroup'", "'contributionContext'", "'-'", "'+'", "'singleton'", "'map'", "'start'", "'catches'", "'[['", "']]'", "'abort'", "'failure'", "';'", "'in'", "'->'", "'X'", "'join'", "'synch'", "'sync'", "'|'", "'wait'", "'timer'", "'timeout'", "'trigger'", "'fail'", "'end'", "'.'", "'or'", "'[else]'", "'and'", "'*'", "'stub'", "'synchronizing'", "'blocking'", "'('", "')'", "'out'", "'replication'", "'protected'", "'..'", "'scenarioGroup'", "'scenario'", "'pre'", "'post'", "'initialize'", "'bool'", "'int'", "'enum'", "'@'", "'!'", "'%'", "'&'", "'denied'", "'weaklyDenied'", "'weaklySatisfied'", "'satisfied'", "'conflict'", "'unknown'", "'none'", "'softgoal'", "'goal'", "'task'", "'resource'", "'belief'", "'indicator'", "'make'", "'help'", "'somePositive'", "'someNegative'", "'hurt'", "'break'", "'high'", "'medium'", "'low'", "'xor'", "'persistent'", "'transient'", "'team'", "'object'", "'process'", "'agent'", "'parent'"
    };
    public static final int T__50=50;
    public static final int T__59=59;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__133=133;
    public static final int T__132=132;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int T__131=131;
    public static final int T__130=130;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__129=129;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__126=126;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__128=128;
    public static final int T__65=65;
    public static final int T__127=127;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__91=91;
    public static final int T__100=100;
    public static final int T__92=92;
    public static final int T__93=93;
    public static final int T__102=102;
    public static final int T__94=94;
    public static final int T__101=101;
    public static final int T__90=90;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__99=99;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int T__95=95;
    public static final int T__96=96;
    public static final int T__97=97;
    public static final int T__98=98;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__122=122;
    public static final int T__70=70;
    public static final int T__121=121;
    public static final int T__71=71;
    public static final int T__124=124;
    public static final int T__72=72;
    public static final int T__123=123;
    public static final int T__120=120;
    public static final int RULE_STRING=4;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__77=77;
    public static final int T__119=119;
    public static final int T__78=78;
    public static final int T__118=118;
    public static final int T__79=79;
    public static final int T__73=73;
    public static final int T__115=115;
    public static final int EOF=-1;
    public static final int T__74=74;
    public static final int T__114=114;
    public static final int T__75=75;
    public static final int T__117=117;
    public static final int T__76=76;
    public static final int T__116=116;
    public static final int T__80=80;
    public static final int T__111=111;
    public static final int T__81=81;
    public static final int T__110=110;
    public static final int T__82=82;
    public static final int T__113=113;
    public static final int T__83=83;
    public static final int T__112=112;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__88=88;
    public static final int T__108=108;
    public static final int T__89=89;
    public static final int T__107=107;
    public static final int T__109=109;
    public static final int T__84=84;
    public static final int T__104=104;
    public static final int T__85=85;
    public static final int T__103=103;
    public static final int T__86=86;
    public static final int T__106=106;
    public static final int T__87=87;
    public static final int T__105=105;

    // delegates
    // delegators


        public InternalTurnParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTurnParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTurnParser.tokenNames; }
    public String getGrammarFileName() { return "InternalTurn.g"; }



     	private TurnGrammarAccess grammarAccess;

        public InternalTurnParser(TokenStream input, TurnGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "URNspec";
       	}

       	@Override
       	protected TurnGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleURNspec"
    // InternalTurn.g:65:1: entryRuleURNspec returns [EObject current=null] : iv_ruleURNspec= ruleURNspec EOF ;
    public final EObject entryRuleURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNspec = null;


        try {
            // InternalTurn.g:65:48: (iv_ruleURNspec= ruleURNspec EOF )
            // InternalTurn.g:66:2: iv_ruleURNspec= ruleURNspec EOF
            {
             newCompositeNode(grammarAccess.getURNspecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURNspec=ruleURNspec();

            state._fsp--;

             current =iv_ruleURNspec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURNspec"


    // $ANTLR start "ruleURNspec"
    // InternalTurn.g:72:1: ruleURNspec returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) ) ;
    public final EObject ruleURNspec() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_showAsMeansEnd_5_0=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_info_3_0 = null;

        EObject lv_actors_4_0 = null;

        EObject lv_stratGroups_6_0 = null;

        EObject lv_strategies_7_0 = null;

        EObject lv_indConversions_8_0 = null;

        EObject lv_contribContextGroups_9_0 = null;

        EObject lv_contribContexts_10_0 = null;

        EObject lv_ucmMaps_11_0 = null;

        EObject lv_scenGroups_12_0 = null;

        EObject lv_scenDefs_13_0 = null;

        EObject lv_variables_14_0 = null;

        EObject lv_enumTypes_15_0 = null;

        EObject lv_concerns_16_0 = null;

        EObject lv_urnlinks_17_0 = null;

        EObject lv_metadata_18_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) ) )
            // InternalTurn.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) )
            {
            // InternalTurn.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) )
            // InternalTurn.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) )
            {
            // InternalTurn.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?) )
            // InternalTurn.g:81:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			
            // InternalTurn.g:84:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?)
            // InternalTurn.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+ {...}?
            {
            // InternalTurn.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+
            int cnt16=0;
            loop16:
            do {
                int alt16=17;
                alt16 = dfa16.predict(input);
                switch (alt16) {
            	case 1 :
            	    // InternalTurn.g:86:3: ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) )
            	    {
            	    // InternalTurn.g:86:3: ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) )
            	    // InternalTurn.g:87:4: {...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0)");
            	    }
            	    // InternalTurn.g:87:101: ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) )
            	    // InternalTurn.g:88:5: ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0);
            	    				
            	    // InternalTurn.g:91:8: ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) )
            	    // InternalTurn.g:91:9: {...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTurn.g:91:18: (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? )
            	    // InternalTurn.g:91:19: otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )?
            	    {
            	    otherlv_1=(Token)match(input,11,FOLLOW_3); 

            	    								newLeafNode(otherlv_1, grammarAccess.getURNspecAccess().getUrnModelKeyword_0_0());
            	    							
            	    // InternalTurn.g:95:8: ( (lv_name_2_0= ruleQualifiedName ) )
            	    // InternalTurn.g:96:9: (lv_name_2_0= ruleQualifiedName )
            	    {
            	    // InternalTurn.g:96:9: (lv_name_2_0= ruleQualifiedName )
            	    // InternalTurn.g:97:10: lv_name_2_0= ruleQualifiedName
            	    {

            	    										newCompositeNode(grammarAccess.getURNspecAccess().getNameQualifiedNameParserRuleCall_0_1_0());
            	    									
            	    pushFollow(FOLLOW_4);
            	    lv_name_2_0=ruleQualifiedName();

            	    state._fsp--;


            	    										if (current==null) {
            	    											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    										}
            	    										set(
            	    											current,
            	    											"name",
            	    											lv_name_2_0,
            	    											"org.xtext.project.turn.Turn.QualifiedName");
            	    										afterParserOrEnumRuleCall();
            	    									

            	    }


            	    }

            	    // InternalTurn.g:114:8: ( (lv_info_3_0= ruleConcreteURNspec ) )?
            	    int alt1=2;
            	    int LA1_0 = input.LA(1);

            	    if ( (LA1_0==13) ) {
            	        alt1=1;
            	    }
            	    switch (alt1) {
            	        case 1 :
            	            // InternalTurn.g:115:9: (lv_info_3_0= ruleConcreteURNspec )
            	            {
            	            // InternalTurn.g:115:9: (lv_info_3_0= ruleConcreteURNspec )
            	            // InternalTurn.g:116:10: lv_info_3_0= ruleConcreteURNspec
            	            {

            	            										newCompositeNode(grammarAccess.getURNspecAccess().getInfoConcreteURNspecParserRuleCall_0_2_0());
            	            									
            	            pushFollow(FOLLOW_4);
            	            lv_info_3_0=ruleConcreteURNspec();

            	            state._fsp--;


            	            										if (current==null) {
            	            											current = createModelElementForParent(grammarAccess.getURNspecRule());
            	            										}
            	            										set(
            	            											current,
            	            											"info",
            	            											lv_info_3_0,
            	            											"org.xtext.project.turn.Turn.ConcreteURNspec");
            	            										afterParserOrEnumRuleCall();
            	            									

            	            }


            	            }
            	            break;

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // InternalTurn.g:139:3: ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) )
            	    {
            	    // InternalTurn.g:139:3: ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) )
            	    // InternalTurn.g:140:4: {...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1)");
            	    }
            	    // InternalTurn.g:140:101: ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ )
            	    // InternalTurn.g:141:5: ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1);
            	    				
            	    // InternalTurn.g:144:8: ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+
            	    int cnt2=0;
            	    loop2:
            	    do {
            	        int alt2=2;
            	        int LA2_0 = input.LA(1);

            	        if ( (LA2_0==32) ) {
            	            int LA2_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt2=1;
            	            }


            	        }


            	        switch (alt2) {
            	    	case 1 :
            	    	    // InternalTurn.g:144:9: {...}? => ( (lv_actors_4_0= ruleActor ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:144:18: ( (lv_actors_4_0= ruleActor ) )
            	    	    // InternalTurn.g:144:19: (lv_actors_4_0= ruleActor )
            	    	    {
            	    	    // InternalTurn.g:144:19: (lv_actors_4_0= ruleActor )
            	    	    // InternalTurn.g:145:9: lv_actors_4_0= ruleActor
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getActorsActorParserRuleCall_1_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_actors_4_0=ruleActor();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"actors",
            	    	    										lv_actors_4_0,
            	    	    										"org.xtext.project.turn.Turn.Actor");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt2 >= 1 ) break loop2;
            	                EarlyExitException eee =
            	                    new EarlyExitException(2, input);
            	                throw eee;
            	        }
            	        cnt2++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 3 :
            	    // InternalTurn.g:167:3: ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) )
            	    {
            	    // InternalTurn.g:167:3: ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) )
            	    // InternalTurn.g:168:4: {...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2)");
            	    }
            	    // InternalTurn.g:168:101: ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) )
            	    // InternalTurn.g:169:5: ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) )
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2);
            	    				
            	    // InternalTurn.g:172:8: ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) )
            	    // InternalTurn.g:172:9: {...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) )
            	    {
            	    if ( !((true)) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    }
            	    // InternalTurn.g:172:18: ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) )
            	    // InternalTurn.g:172:19: (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' )
            	    {
            	    // InternalTurn.g:172:19: (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' )
            	    // InternalTurn.g:173:9: lv_showAsMeansEnd_5_0= 'showAsMeansEnd'
            	    {
            	    lv_showAsMeansEnd_5_0=(Token)match(input,12,FOLLOW_4); 

            	    									newLeafNode(lv_showAsMeansEnd_5_0, grammarAccess.getURNspecAccess().getShowAsMeansEndShowAsMeansEndKeyword_2_0());
            	    								

            	    									if (current==null) {
            	    										current = createModelElement(grammarAccess.getURNspecRule());
            	    									}
            	    									setWithLastConsumed(current, "showAsMeansEnd", true, "showAsMeansEnd");
            	    								

            	    }


            	    }


            	    }

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 4 :
            	    // InternalTurn.g:190:3: ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) )
            	    {
            	    // InternalTurn.g:190:3: ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) )
            	    // InternalTurn.g:191:4: {...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3)");
            	    }
            	    // InternalTurn.g:191:101: ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ )
            	    // InternalTurn.g:192:5: ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3);
            	    				
            	    // InternalTurn.g:195:8: ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+
            	    int cnt3=0;
            	    loop3:
            	    do {
            	        int alt3=2;
            	        int LA3_0 = input.LA(1);

            	        if ( (LA3_0==40) ) {
            	            int LA3_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt3=1;
            	            }


            	        }


            	        switch (alt3) {
            	    	case 1 :
            	    	    // InternalTurn.g:195:9: {...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:195:18: ( (lv_stratGroups_6_0= ruleStrategiesGroup ) )
            	    	    // InternalTurn.g:195:19: (lv_stratGroups_6_0= ruleStrategiesGroup )
            	    	    {
            	    	    // InternalTurn.g:195:19: (lv_stratGroups_6_0= ruleStrategiesGroup )
            	    	    // InternalTurn.g:196:9: lv_stratGroups_6_0= ruleStrategiesGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getStratGroupsStrategiesGroupParserRuleCall_3_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_stratGroups_6_0=ruleStrategiesGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"stratGroups",
            	    	    										lv_stratGroups_6_0,
            	    	    										"org.xtext.project.turn.Turn.StrategiesGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt3 >= 1 ) break loop3;
            	                EarlyExitException eee =
            	                    new EarlyExitException(3, input);
            	                throw eee;
            	        }
            	        cnt3++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 5 :
            	    // InternalTurn.g:218:3: ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) )
            	    {
            	    // InternalTurn.g:218:3: ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) )
            	    // InternalTurn.g:219:4: {...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4)");
            	    }
            	    // InternalTurn.g:219:101: ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ )
            	    // InternalTurn.g:220:5: ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4);
            	    				
            	    // InternalTurn.g:223:8: ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+
            	    int cnt4=0;
            	    loop4:
            	    do {
            	        int alt4=2;
            	        int LA4_0 = input.LA(1);

            	        if ( (LA4_0==41) ) {
            	            int LA4_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt4=1;
            	            }


            	        }


            	        switch (alt4) {
            	    	case 1 :
            	    	    // InternalTurn.g:223:9: {...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:223:18: ( (lv_strategies_7_0= ruleEvaluationStrategy ) )
            	    	    // InternalTurn.g:223:19: (lv_strategies_7_0= ruleEvaluationStrategy )
            	    	    {
            	    	    // InternalTurn.g:223:19: (lv_strategies_7_0= ruleEvaluationStrategy )
            	    	    // InternalTurn.g:224:9: lv_strategies_7_0= ruleEvaluationStrategy
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getStrategiesEvaluationStrategyParserRuleCall_4_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_strategies_7_0=ruleEvaluationStrategy();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"strategies",
            	    	    										lv_strategies_7_0,
            	    	    										"org.xtext.project.turn.Turn.EvaluationStrategy");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt4 >= 1 ) break loop4;
            	                EarlyExitException eee =
            	                    new EarlyExitException(4, input);
            	                throw eee;
            	        }
            	        cnt4++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 6 :
            	    // InternalTurn.g:246:3: ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) )
            	    {
            	    // InternalTurn.g:246:3: ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) )
            	    // InternalTurn.g:247:4: {...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5)");
            	    }
            	    // InternalTurn.g:247:101: ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ )
            	    // InternalTurn.g:248:5: ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5);
            	    				
            	    // InternalTurn.g:251:8: ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+
            	    int cnt5=0;
            	    loop5:
            	    do {
            	        int alt5=2;
            	        int LA5_0 = input.LA(1);

            	        if ( (LA5_0==47) ) {
            	            int LA5_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt5=1;
            	            }


            	        }
            	        else if ( (LA5_0==51) ) {
            	            int LA5_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt5=1;
            	            }


            	        }


            	        switch (alt5) {
            	    	case 1 :
            	    	    // InternalTurn.g:251:9: {...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:251:18: ( (lv_indConversions_8_0= ruleIndicatorConversion ) )
            	    	    // InternalTurn.g:251:19: (lv_indConversions_8_0= ruleIndicatorConversion )
            	    	    {
            	    	    // InternalTurn.g:251:19: (lv_indConversions_8_0= ruleIndicatorConversion )
            	    	    // InternalTurn.g:252:9: lv_indConversions_8_0= ruleIndicatorConversion
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getIndConversionsIndicatorConversionParserRuleCall_5_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_indConversions_8_0=ruleIndicatorConversion();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"indConversions",
            	    	    										lv_indConversions_8_0,
            	    	    										"org.xtext.project.turn.Turn.IndicatorConversion");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt5 >= 1 ) break loop5;
            	                EarlyExitException eee =
            	                    new EarlyExitException(5, input);
            	                throw eee;
            	        }
            	        cnt5++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 7 :
            	    // InternalTurn.g:274:3: ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) )
            	    {
            	    // InternalTurn.g:274:3: ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) )
            	    // InternalTurn.g:275:4: {...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6)");
            	    }
            	    // InternalTurn.g:275:101: ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ )
            	    // InternalTurn.g:276:5: ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6);
            	    				
            	    // InternalTurn.g:279:8: ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+
            	    int cnt6=0;
            	    loop6:
            	    do {
            	        int alt6=2;
            	        int LA6_0 = input.LA(1);

            	        if ( (LA6_0==52) ) {
            	            int LA6_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt6=1;
            	            }


            	        }


            	        switch (alt6) {
            	    	case 1 :
            	    	    // InternalTurn.g:279:9: {...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:279:18: ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) )
            	    	    // InternalTurn.g:279:19: (lv_contribContextGroups_9_0= ruleContributionContextGroup )
            	    	    {
            	    	    // InternalTurn.g:279:19: (lv_contribContextGroups_9_0= ruleContributionContextGroup )
            	    	    // InternalTurn.g:280:9: lv_contribContextGroups_9_0= ruleContributionContextGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getContribContextGroupsContributionContextGroupParserRuleCall_6_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_contribContextGroups_9_0=ruleContributionContextGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"contribContextGroups",
            	    	    										lv_contribContextGroups_9_0,
            	    	    										"org.xtext.project.turn.Turn.ContributionContextGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt6 >= 1 ) break loop6;
            	                EarlyExitException eee =
            	                    new EarlyExitException(6, input);
            	                throw eee;
            	        }
            	        cnt6++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 8 :
            	    // InternalTurn.g:302:3: ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) )
            	    {
            	    // InternalTurn.g:302:3: ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) )
            	    // InternalTurn.g:303:4: {...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7)");
            	    }
            	    // InternalTurn.g:303:101: ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ )
            	    // InternalTurn.g:304:5: ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7);
            	    				
            	    // InternalTurn.g:307:8: ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+
            	    int cnt7=0;
            	    loop7:
            	    do {
            	        int alt7=2;
            	        int LA7_0 = input.LA(1);

            	        if ( (LA7_0==53) ) {
            	            int LA7_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt7=1;
            	            }


            	        }


            	        switch (alt7) {
            	    	case 1 :
            	    	    // InternalTurn.g:307:9: {...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:307:18: ( (lv_contribContexts_10_0= ruleContributionContext ) )
            	    	    // InternalTurn.g:307:19: (lv_contribContexts_10_0= ruleContributionContext )
            	    	    {
            	    	    // InternalTurn.g:307:19: (lv_contribContexts_10_0= ruleContributionContext )
            	    	    // InternalTurn.g:308:9: lv_contribContexts_10_0= ruleContributionContext
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getContribContextsContributionContextParserRuleCall_7_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_contribContexts_10_0=ruleContributionContext();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"contribContexts",
            	    	    										lv_contribContexts_10_0,
            	    	    										"org.xtext.project.turn.Turn.ContributionContext");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt7 >= 1 ) break loop7;
            	                EarlyExitException eee =
            	                    new EarlyExitException(7, input);
            	                throw eee;
            	        }
            	        cnt7++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 9 :
            	    // InternalTurn.g:330:3: ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) )
            	    {
            	    // InternalTurn.g:330:3: ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) )
            	    // InternalTurn.g:331:4: {...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8)");
            	    }
            	    // InternalTurn.g:331:101: ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ )
            	    // InternalTurn.g:332:5: ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8);
            	    				
            	    // InternalTurn.g:335:8: ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+
            	    int cnt8=0;
            	    loop8:
            	    do {
            	        int alt8=2;
            	        int LA8_0 = input.LA(1);

            	        if ( (LA8_0==56) ) {
            	            int LA8_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }
            	        else if ( (LA8_0==57) ) {
            	            int LA8_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt8=1;
            	            }


            	        }


            	        switch (alt8) {
            	    	case 1 :
            	    	    // InternalTurn.g:335:9: {...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:335:18: ( (lv_ucmMaps_11_0= ruleUCMmap ) )
            	    	    // InternalTurn.g:335:19: (lv_ucmMaps_11_0= ruleUCMmap )
            	    	    {
            	    	    // InternalTurn.g:335:19: (lv_ucmMaps_11_0= ruleUCMmap )
            	    	    // InternalTurn.g:336:9: lv_ucmMaps_11_0= ruleUCMmap
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUcmMapsUCMmapParserRuleCall_8_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_ucmMaps_11_0=ruleUCMmap();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"ucmMaps",
            	    	    										lv_ucmMaps_11_0,
            	    	    										"org.xtext.project.turn.Turn.UCMmap");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt8 >= 1 ) break loop8;
            	                EarlyExitException eee =
            	                    new EarlyExitException(8, input);
            	                throw eee;
            	        }
            	        cnt8++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 10 :
            	    // InternalTurn.g:358:3: ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) )
            	    {
            	    // InternalTurn.g:358:3: ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) )
            	    // InternalTurn.g:359:4: {...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9)");
            	    }
            	    // InternalTurn.g:359:101: ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ )
            	    // InternalTurn.g:360:5: ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9);
            	    				
            	    // InternalTurn.g:363:8: ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==92) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalTurn.g:363:9: {...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:363:18: ( (lv_scenGroups_12_0= ruleScenarioGroup ) )
            	    	    // InternalTurn.g:363:19: (lv_scenGroups_12_0= ruleScenarioGroup )
            	    	    {
            	    	    // InternalTurn.g:363:19: (lv_scenGroups_12_0= ruleScenarioGroup )
            	    	    // InternalTurn.g:364:9: lv_scenGroups_12_0= ruleScenarioGroup
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getScenGroupsScenarioGroupParserRuleCall_9_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_scenGroups_12_0=ruleScenarioGroup();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"scenGroups",
            	    	    										lv_scenGroups_12_0,
            	    	    										"org.xtext.project.turn.Turn.ScenarioGroup");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt9 >= 1 ) break loop9;
            	                EarlyExitException eee =
            	                    new EarlyExitException(9, input);
            	                throw eee;
            	        }
            	        cnt9++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 11 :
            	    // InternalTurn.g:386:3: ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) )
            	    {
            	    // InternalTurn.g:386:3: ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) )
            	    // InternalTurn.g:387:4: {...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10)");
            	    }
            	    // InternalTurn.g:387:102: ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ )
            	    // InternalTurn.g:388:5: ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10);
            	    				
            	    // InternalTurn.g:391:8: ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==93) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalTurn.g:391:9: {...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:391:18: ( (lv_scenDefs_13_0= ruleScenarioDef ) )
            	    	    // InternalTurn.g:391:19: (lv_scenDefs_13_0= ruleScenarioDef )
            	    	    {
            	    	    // InternalTurn.g:391:19: (lv_scenDefs_13_0= ruleScenarioDef )
            	    	    // InternalTurn.g:392:9: lv_scenDefs_13_0= ruleScenarioDef
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getScenDefsScenarioDefParserRuleCall_10_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_scenDefs_13_0=ruleScenarioDef();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"scenDefs",
            	    	    										lv_scenDefs_13_0,
            	    	    										"org.xtext.project.turn.Turn.ScenarioDef");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt10 >= 1 ) break loop10;
            	                EarlyExitException eee =
            	                    new EarlyExitException(10, input);
            	                throw eee;
            	        }
            	        cnt10++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 12 :
            	    // InternalTurn.g:414:3: ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) )
            	    {
            	    // InternalTurn.g:414:3: ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) )
            	    // InternalTurn.g:415:4: {...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11)");
            	    }
            	    // InternalTurn.g:415:102: ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ )
            	    // InternalTurn.g:416:5: ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11);
            	    				
            	    // InternalTurn.g:419:8: ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        switch ( input.LA(1) ) {
            	        case 97:
            	            {
            	            int LA11_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	            }
            	            break;
            	        case 98:
            	            {
            	            int LA11_3 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	            }
            	            break;
            	        case RULE_ID:
            	            {
            	            int LA11_4 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	            }
            	            break;

            	        }

            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalTurn.g:419:9: {...}? => ( (lv_variables_14_0= ruleVariable ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:419:18: ( (lv_variables_14_0= ruleVariable ) )
            	    	    // InternalTurn.g:419:19: (lv_variables_14_0= ruleVariable )
            	    	    {
            	    	    // InternalTurn.g:419:19: (lv_variables_14_0= ruleVariable )
            	    	    // InternalTurn.g:420:9: lv_variables_14_0= ruleVariable
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getVariablesVariableParserRuleCall_11_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_variables_14_0=ruleVariable();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"variables",
            	    	    										lv_variables_14_0,
            	    	    										"org.xtext.project.turn.Turn.Variable");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt11 >= 1 ) break loop11;
            	                EarlyExitException eee =
            	                    new EarlyExitException(11, input);
            	                throw eee;
            	        }
            	        cnt11++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 13 :
            	    // InternalTurn.g:442:3: ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) )
            	    {
            	    // InternalTurn.g:442:3: ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) )
            	    // InternalTurn.g:443:4: {...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12)");
            	    }
            	    // InternalTurn.g:443:102: ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ )
            	    // InternalTurn.g:444:5: ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12);
            	    				
            	    // InternalTurn.g:447:8: ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+
            	    int cnt12=0;
            	    loop12:
            	    do {
            	        int alt12=2;
            	        int LA12_0 = input.LA(1);

            	        if ( (LA12_0==99) ) {
            	            int LA12_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt12=1;
            	            }


            	        }


            	        switch (alt12) {
            	    	case 1 :
            	    	    // InternalTurn.g:447:9: {...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:447:18: ( (lv_enumTypes_15_0= ruleEnumerationType ) )
            	    	    // InternalTurn.g:447:19: (lv_enumTypes_15_0= ruleEnumerationType )
            	    	    {
            	    	    // InternalTurn.g:447:19: (lv_enumTypes_15_0= ruleEnumerationType )
            	    	    // InternalTurn.g:448:9: lv_enumTypes_15_0= ruleEnumerationType
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getEnumTypesEnumerationTypeParserRuleCall_12_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_enumTypes_15_0=ruleEnumerationType();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"enumTypes",
            	    	    										lv_enumTypes_15_0,
            	    	    										"org.xtext.project.turn.Turn.EnumerationType");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt12 >= 1 ) break loop12;
            	                EarlyExitException eee =
            	                    new EarlyExitException(12, input);
            	                throw eee;
            	        }
            	        cnt12++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 14 :
            	    // InternalTurn.g:470:3: ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) )
            	    {
            	    // InternalTurn.g:470:3: ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) )
            	    // InternalTurn.g:471:4: {...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13)");
            	    }
            	    // InternalTurn.g:471:102: ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ )
            	    // InternalTurn.g:472:5: ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13);
            	    				
            	    // InternalTurn.g:475:8: ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+
            	    int cnt13=0;
            	    loop13:
            	    do {
            	        int alt13=2;
            	        int LA13_0 = input.LA(1);

            	        if ( (LA13_0==21) ) {
            	            int LA13_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt13=1;
            	            }


            	        }


            	        switch (alt13) {
            	    	case 1 :
            	    	    // InternalTurn.g:475:9: {...}? => ( (lv_concerns_16_0= ruleConcern ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:475:18: ( (lv_concerns_16_0= ruleConcern ) )
            	    	    // InternalTurn.g:475:19: (lv_concerns_16_0= ruleConcern )
            	    	    {
            	    	    // InternalTurn.g:475:19: (lv_concerns_16_0= ruleConcern )
            	    	    // InternalTurn.g:476:9: lv_concerns_16_0= ruleConcern
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getConcernsConcernParserRuleCall_13_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_concerns_16_0=ruleConcern();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"concerns",
            	    	    										lv_concerns_16_0,
            	    	    										"org.xtext.project.turn.Turn.Concern");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt13 >= 1 ) break loop13;
            	                EarlyExitException eee =
            	                    new EarlyExitException(13, input);
            	                throw eee;
            	        }
            	        cnt13++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 15 :
            	    // InternalTurn.g:498:3: ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) )
            	    {
            	    // InternalTurn.g:498:3: ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) )
            	    // InternalTurn.g:499:4: {...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14)");
            	    }
            	    // InternalTurn.g:499:102: ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ )
            	    // InternalTurn.g:500:5: ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14);
            	    				
            	    // InternalTurn.g:503:8: ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+
            	    int cnt14=0;
            	    loop14:
            	    do {
            	        int alt14=2;
            	        int LA14_0 = input.LA(1);

            	        if ( (LA14_0==27) ) {
            	            int LA14_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt14=1;
            	            }


            	        }


            	        switch (alt14) {
            	    	case 1 :
            	    	    // InternalTurn.g:503:9: {...}? => ( (lv_urnlinks_17_0= ruleURNlink ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:503:18: ( (lv_urnlinks_17_0= ruleURNlink ) )
            	    	    // InternalTurn.g:503:19: (lv_urnlinks_17_0= ruleURNlink )
            	    	    {
            	    	    // InternalTurn.g:503:19: (lv_urnlinks_17_0= ruleURNlink )
            	    	    // InternalTurn.g:504:9: lv_urnlinks_17_0= ruleURNlink
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUrnlinksURNlinkParserRuleCall_14_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_urnlinks_17_0=ruleURNlink();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"urnlinks",
            	    	    										lv_urnlinks_17_0,
            	    	    										"org.xtext.project.turn.Turn.URNlink");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt14 >= 1 ) break loop14;
            	                EarlyExitException eee =
            	                    new EarlyExitException(14, input);
            	                throw eee;
            	        }
            	        cnt14++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;
            	case 16 :
            	    // InternalTurn.g:526:3: ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) )
            	    {
            	    // InternalTurn.g:526:3: ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) )
            	    // InternalTurn.g:527:4: {...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15)");
            	    }
            	    // InternalTurn.g:527:102: ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ )
            	    // InternalTurn.g:528:5: ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15);
            	    				
            	    // InternalTurn.g:531:8: ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+
            	    int cnt15=0;
            	    loop15:
            	    do {
            	        int alt15=2;
            	        int LA15_0 = input.LA(1);

            	        if ( (LA15_0==30) ) {
            	            int LA15_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt15=1;
            	            }


            	        }


            	        switch (alt15) {
            	    	case 1 :
            	    	    // InternalTurn.g:531:9: {...}? => ( (lv_metadata_18_0= ruleMetadata ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:531:18: ( (lv_metadata_18_0= ruleMetadata ) )
            	    	    // InternalTurn.g:531:19: (lv_metadata_18_0= ruleMetadata )
            	    	    {
            	    	    // InternalTurn.g:531:19: (lv_metadata_18_0= ruleMetadata )
            	    	    // InternalTurn.g:532:9: lv_metadata_18_0= ruleMetadata
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getMetadataMetadataParserRuleCall_15_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_metadata_18_0=ruleMetadata();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"metadata",
            	    	    										lv_metadata_18_0,
            	    	    										"org.xtext.project.turn.Turn.Metadata");
            	    	    									afterParserOrEnumRuleCall();
            	    	    								

            	    	    }


            	    	    }


            	    	    }
            	    	    break;

            	    	default :
            	    	    if ( cnt15 >= 1 ) break loop15;
            	                EarlyExitException eee =
            	                    new EarlyExitException(15, input);
            	                throw eee;
            	        }
            	        cnt15++;
            	    } while (true);

            	     
            	    					getUnorderedGroupHelper().returnFromSelection(grammarAccess.getURNspecAccess().getUnorderedGroup());
            	    				

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt16 >= 1 ) break loop16;
                        EarlyExitException eee =
                            new EarlyExitException(16, input);
                        throw eee;
                }
                cnt16++;
            } while (true);

            if ( ! getUnorderedGroupHelper().canLeave(grammarAccess.getURNspecAccess().getUnorderedGroup()) ) {
                throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canLeave(grammarAccess.getURNspecAccess().getUnorderedGroup())");
            }

            }


            }

             
            			  getUnorderedGroupHelper().leave(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURNspec"


    // $ANTLR start "entryRuleConcreteURNspec"
    // InternalTurn.g:565:1: entryRuleConcreteURNspec returns [EObject current=null] : iv_ruleConcreteURNspec= ruleConcreteURNspec EOF ;
    public final EObject entryRuleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteURNspec = null;


        try {
            // InternalTurn.g:565:56: (iv_ruleConcreteURNspec= ruleConcreteURNspec EOF )
            // InternalTurn.g:566:2: iv_ruleConcreteURNspec= ruleConcreteURNspec EOF
            {
             newCompositeNode(grammarAccess.getConcreteURNspecRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteURNspec=ruleConcreteURNspec();

            state._fsp--;

             current =iv_ruleConcreteURNspec; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteURNspec"


    // $ANTLR start "ruleConcreteURNspec"
    // InternalTurn.g:572:1: ruleConcreteURNspec returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) ;
    public final EObject ruleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_description_2_0=null;
        Token otherlv_3=null;
        Token lv_author_4_0=null;
        Token otherlv_5=null;
        Token lv_created_6_0=null;
        Token otherlv_7=null;
        Token lv_modified_8_0=null;
        Token otherlv_9=null;
        Token lv_specVersion_10_0=null;
        Token otherlv_11=null;
        Token lv_urnVersion_12_0=null;
        Token otherlv_13=null;


        	enterRule();

        try {
            // InternalTurn.g:578:2: ( (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) )
            // InternalTurn.g:579:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            {
            // InternalTurn.g:579:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            // InternalTurn.g:580:3: otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteURNspecAccess().getLeftCurlyBracketKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getConcreteURNspecAccess().getDescriptionKeyword_1());
            		
            // InternalTurn.g:588:3: ( (lv_description_2_0= RULE_STRING ) )
            // InternalTurn.g:589:4: (lv_description_2_0= RULE_STRING )
            {
            // InternalTurn.g:589:4: (lv_description_2_0= RULE_STRING )
            // InternalTurn.g:590:5: lv_description_2_0= RULE_STRING
            {
            lv_description_2_0=(Token)match(input,RULE_STRING,FOLLOW_7); 

            					newLeafNode(lv_description_2_0, grammarAccess.getConcreteURNspecAccess().getDescriptionSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_3, grammarAccess.getConcreteURNspecAccess().getAuthorKeyword_3());
            		
            // InternalTurn.g:610:3: ( (lv_author_4_0= RULE_STRING ) )
            // InternalTurn.g:611:4: (lv_author_4_0= RULE_STRING )
            {
            // InternalTurn.g:611:4: (lv_author_4_0= RULE_STRING )
            // InternalTurn.g:612:5: lv_author_4_0= RULE_STRING
            {
            lv_author_4_0=(Token)match(input,RULE_STRING,FOLLOW_8); 

            					newLeafNode(lv_author_4_0, grammarAccess.getConcreteURNspecAccess().getAuthorSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"author",
            						lv_author_4_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_5=(Token)match(input,16,FOLLOW_6); 

            			newLeafNode(otherlv_5, grammarAccess.getConcreteURNspecAccess().getCreatedKeyword_5());
            		
            // InternalTurn.g:632:3: ( (lv_created_6_0= RULE_STRING ) )
            // InternalTurn.g:633:4: (lv_created_6_0= RULE_STRING )
            {
            // InternalTurn.g:633:4: (lv_created_6_0= RULE_STRING )
            // InternalTurn.g:634:5: lv_created_6_0= RULE_STRING
            {
            lv_created_6_0=(Token)match(input,RULE_STRING,FOLLOW_9); 

            					newLeafNode(lv_created_6_0, grammarAccess.getConcreteURNspecAccess().getCreatedSTRINGTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"created",
            						lv_created_6_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_7=(Token)match(input,17,FOLLOW_6); 

            			newLeafNode(otherlv_7, grammarAccess.getConcreteURNspecAccess().getModifiedKeyword_7());
            		
            // InternalTurn.g:654:3: ( (lv_modified_8_0= RULE_STRING ) )
            // InternalTurn.g:655:4: (lv_modified_8_0= RULE_STRING )
            {
            // InternalTurn.g:655:4: (lv_modified_8_0= RULE_STRING )
            // InternalTurn.g:656:5: lv_modified_8_0= RULE_STRING
            {
            lv_modified_8_0=(Token)match(input,RULE_STRING,FOLLOW_10); 

            					newLeafNode(lv_modified_8_0, grammarAccess.getConcreteURNspecAccess().getModifiedSTRINGTerminalRuleCall_8_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"modified",
            						lv_modified_8_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_9=(Token)match(input,18,FOLLOW_6); 

            			newLeafNode(otherlv_9, grammarAccess.getConcreteURNspecAccess().getVersionKeyword_9());
            		
            // InternalTurn.g:676:3: ( (lv_specVersion_10_0= RULE_STRING ) )
            // InternalTurn.g:677:4: (lv_specVersion_10_0= RULE_STRING )
            {
            // InternalTurn.g:677:4: (lv_specVersion_10_0= RULE_STRING )
            // InternalTurn.g:678:5: lv_specVersion_10_0= RULE_STRING
            {
            lv_specVersion_10_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_specVersion_10_0, grammarAccess.getConcreteURNspecAccess().getSpecVersionSTRINGTerminalRuleCall_10_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"specVersion",
            						lv_specVersion_10_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_11=(Token)match(input,19,FOLLOW_6); 

            			newLeafNode(otherlv_11, grammarAccess.getConcreteURNspecAccess().getUrnVersionKeyword_11());
            		
            // InternalTurn.g:698:3: ( (lv_urnVersion_12_0= RULE_STRING ) )
            // InternalTurn.g:699:4: (lv_urnVersion_12_0= RULE_STRING )
            {
            // InternalTurn.g:699:4: (lv_urnVersion_12_0= RULE_STRING )
            // InternalTurn.g:700:5: lv_urnVersion_12_0= RULE_STRING
            {
            lv_urnVersion_12_0=(Token)match(input,RULE_STRING,FOLLOW_12); 

            					newLeafNode(lv_urnVersion_12_0, grammarAccess.getConcreteURNspecAccess().getUrnVersionSTRINGTerminalRuleCall_12_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteURNspecRule());
            					}
            					setWithLastConsumed(
            						current,
            						"urnVersion",
            						lv_urnVersion_12_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_13=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_13, grammarAccess.getConcreteURNspecAccess().getRightCurlyBracketKeyword_13());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteURNspec"


    // $ANTLR start "entryRuleConcern"
    // InternalTurn.g:724:1: entryRuleConcern returns [EObject current=null] : iv_ruleConcern= ruleConcern EOF ;
    public final EObject entryRuleConcern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcern = null;


        try {
            // InternalTurn.g:724:48: (iv_ruleConcern= ruleConcern EOF )
            // InternalTurn.g:725:2: iv_ruleConcern= ruleConcern EOF
            {
             newCompositeNode(grammarAccess.getConcernRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcern=ruleConcern();

            state._fsp--;

             current =iv_ruleConcern; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcern"


    // $ANTLR start "ruleConcern"
    // InternalTurn.g:731:1: ruleConcern returns [EObject current=null] : (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* ) ;
    public final EObject ruleConcern() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:737:2: ( (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* ) )
            // InternalTurn.g:738:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalTurn.g:738:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )
            // InternalTurn.g:739:3: otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConcernAccess().getConcernKeyword_0());
            		
            // InternalTurn.g:743:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:744:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:744:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:745:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getConcernAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcernRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:762:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:763:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:763:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:764:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getConcernAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConcernRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_15); 

            			newLeafNode(otherlv_3, grammarAccess.getConcernAccess().getColonKeyword_3());
            		
            // InternalTurn.g:785:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==25) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalTurn.g:786:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTurn.g:786:4: (lv_condition_4_0= ruleCondition )
                    // InternalTurn.g:787:5: lv_condition_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getConcernAccess().getConditionConditionParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_condition_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getConcernRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_4_0,
                    						"org.xtext.project.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:804:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:805:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:805:4: ( ruleQualifiedName )
            // InternalTurn.g:806:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcernRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConcernAccess().getElementURNmodelElementCrossReference_5_0());
            				
            pushFollow(FOLLOW_16);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:820:3: (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==23) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // InternalTurn.g:821:4: otherlv_6= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getConcernAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTurn.g:825:4: ( ( ruleQualifiedName ) )
            	    // InternalTurn.g:826:5: ( ruleQualifiedName )
            	    {
            	    // InternalTurn.g:826:5: ( ruleQualifiedName )
            	    // InternalTurn.g:827:6: ruleQualifiedName
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getConcernRule());
            	    						}
            	    					

            	    						newCompositeNode(grammarAccess.getConcernAccess().getElementsURNmodelElementCrossReference_6_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    ruleQualifiedName();

            	    state._fsp--;


            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcern"


    // $ANTLR start "entryRuleLongName"
    // InternalTurn.g:846:1: entryRuleLongName returns [EObject current=null] : iv_ruleLongName= ruleLongName EOF ;
    public final EObject entryRuleLongName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongName = null;


        try {
            // InternalTurn.g:846:49: (iv_ruleLongName= ruleLongName EOF )
            // InternalTurn.g:847:2: iv_ruleLongName= ruleLongName EOF
            {
             newCompositeNode(grammarAccess.getLongNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongName=ruleLongName();

            state._fsp--;

             current =iv_ruleLongName; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongName"


    // $ANTLR start "ruleLongName"
    // InternalTurn.g:853:1: ruleLongName returns [EObject current=null] : ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleLongName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_longname_2_1=null;
        Token lv_longname_2_2=null;


        	enterRule();

        try {
            // InternalTurn.g:859:2: ( ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) )
            // InternalTurn.g:860:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            {
            // InternalTurn.g:860:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            // InternalTurn.g:861:3: () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            {
            // InternalTurn.g:861:3: ()
            // InternalTurn.g:862:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLongNameAccess().getLongNameAction_0(),
            					current);
            			

            }

            // InternalTurn.g:868:3: (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==24) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTurn.g:869:4: otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getLongNameAccess().getNumberSignKeyword_1_0());
                    			
                    // InternalTurn.g:873:4: ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    // InternalTurn.g:874:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    {
                    // InternalTurn.g:874:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    // InternalTurn.g:875:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    {
                    // InternalTurn.g:875:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    int alt19=2;
                    int LA19_0 = input.LA(1);

                    if ( (LA19_0==RULE_ID) ) {
                        alt19=1;
                    }
                    else if ( (LA19_0==RULE_STRING) ) {
                        alt19=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 19, 0, input);

                        throw nvae;
                    }
                    switch (alt19) {
                        case 1 :
                            // InternalTurn.g:876:7: lv_longname_2_1= RULE_ID
                            {
                            lv_longname_2_1=(Token)match(input,RULE_ID,FOLLOW_2); 

                            							newLeafNode(lv_longname_2_1, grammarAccess.getLongNameAccess().getLongnameIDTerminalRuleCall_1_1_0_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLongNameRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"longname",
                            								lv_longname_2_1,
                            								"org.eclipse.xtext.common.Terminals.ID");
                            						

                            }
                            break;
                        case 2 :
                            // InternalTurn.g:891:7: lv_longname_2_2= RULE_STRING
                            {
                            lv_longname_2_2=(Token)match(input,RULE_STRING,FOLLOW_2); 

                            							newLeafNode(lv_longname_2_2, grammarAccess.getLongNameAccess().getLongnameSTRINGTerminalRuleCall_1_1_0_1());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getLongNameRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"longname",
                            								lv_longname_2_2,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongName"


    // $ANTLR start "entryRuleCondition"
    // InternalTurn.g:913:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalTurn.g:913:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalTurn.g:914:2: iv_ruleCondition= ruleCondition EOF
            {
             newCompositeNode(grammarAccess.getConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleCondition=ruleCondition();

            state._fsp--;

             current =iv_ruleCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCondition"


    // $ANTLR start "ruleCondition"
    // InternalTurn.g:920:1: ruleCondition returns [EObject current=null] : (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) ;
    public final EObject ruleCondition() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_expression_1_0 = null;

        EObject lv_info_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:926:2: ( (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) )
            // InternalTurn.g:927:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            {
            // InternalTurn.g:927:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            // InternalTurn.g:928:3: otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalTurn.g:932:3: ( (lv_expression_1_0= ruleText ) )
            // InternalTurn.g:933:4: (lv_expression_1_0= ruleText )
            {
            // InternalTurn.g:933:4: (lv_expression_1_0= ruleText )
            // InternalTurn.g:934:5: lv_expression_1_0= ruleText
            {

            					newCompositeNode(grammarAccess.getConditionAccess().getExpressionTextParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_19);
            lv_expression_1_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getConditionRule());
            					}
            					set(
            						current,
            						"expression",
            						lv_expression_1_0,
            						"org.xtext.project.turn.Turn.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_20); 

            			newLeafNode(otherlv_2, grammarAccess.getConditionAccess().getRightSquareBracketKeyword_2());
            		
            // InternalTurn.g:955:3: (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==13) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // InternalTurn.g:956:4: otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalTurn.g:960:4: ( (lv_info_4_0= ruleConcreteCondition ) )?
                    int alt21=2;
                    int LA21_0 = input.LA(1);

                    if ( (LA21_0==RULE_STRING) ) {
                        alt21=1;
                    }
                    switch (alt21) {
                        case 1 :
                            // InternalTurn.g:961:5: (lv_info_4_0= ruleConcreteCondition )
                            {
                            // InternalTurn.g:961:5: (lv_info_4_0= ruleConcreteCondition )
                            // InternalTurn.g:962:6: lv_info_4_0= ruleConcreteCondition
                            {

                            						newCompositeNode(grammarAccess.getConditionAccess().getInfoConcreteConditionParserRuleCall_3_1_0());
                            					
                            pushFollow(FOLLOW_12);
                            lv_info_4_0=ruleConcreteCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getConditionRule());
                            						}
                            						set(
                            							current,
                            							"info",
                            							lv_info_4_0,
                            							"org.xtext.project.turn.Turn.ConcreteCondition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_2); 

                    				newLeafNode(otherlv_5, grammarAccess.getConditionAccess().getRightCurlyBracketKeyword_3_2());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCondition"


    // $ANTLR start "entryRuleConcreteCondition"
    // InternalTurn.g:988:1: entryRuleConcreteCondition returns [EObject current=null] : iv_ruleConcreteCondition= ruleConcreteCondition EOF ;
    public final EObject entryRuleConcreteCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteCondition = null;


        try {
            // InternalTurn.g:988:58: (iv_ruleConcreteCondition= ruleConcreteCondition EOF )
            // InternalTurn.g:989:2: iv_ruleConcreteCondition= ruleConcreteCondition EOF
            {
             newCompositeNode(grammarAccess.getConcreteConditionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteCondition=ruleConcreteCondition();

            state._fsp--;

             current =iv_ruleConcreteCondition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteCondition"


    // $ANTLR start "ruleConcreteCondition"
    // InternalTurn.g:995:1: ruleConcreteCondition returns [EObject current=null] : ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteCondition() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;
        Token lv_description_1_0=null;


        	enterRule();

        try {
            // InternalTurn.g:1001:2: ( ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) )
            // InternalTurn.g:1002:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // InternalTurn.g:1002:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            // InternalTurn.g:1003:3: ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) )
            {
            // InternalTurn.g:1003:3: ( (lv_label_0_0= RULE_STRING ) )
            // InternalTurn.g:1004:4: (lv_label_0_0= RULE_STRING )
            {
            // InternalTurn.g:1004:4: (lv_label_0_0= RULE_STRING )
            // InternalTurn.g:1005:5: lv_label_0_0= RULE_STRING
            {
            lv_label_0_0=(Token)match(input,RULE_STRING,FOLLOW_6); 

            					newLeafNode(lv_label_0_0, grammarAccess.getConcreteConditionAccess().getLabelSTRINGTerminalRuleCall_0_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"label",
            						lv_label_0_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTurn.g:1021:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalTurn.g:1022:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalTurn.g:1022:4: (lv_description_1_0= RULE_STRING )
            // InternalTurn.g:1023:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_description_1_0, grammarAccess.getConcreteConditionAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteConditionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteCondition"


    // $ANTLR start "entryRuleURNlink"
    // InternalTurn.g:1043:1: entryRuleURNlink returns [EObject current=null] : iv_ruleURNlink= ruleURNlink EOF ;
    public final EObject entryRuleURNlink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNlink = null;


        try {
            // InternalTurn.g:1043:48: (iv_ruleURNlink= ruleURNlink EOF )
            // InternalTurn.g:1044:2: iv_ruleURNlink= ruleURNlink EOF
            {
             newCompositeNode(grammarAccess.getURNlinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleURNlink=ruleURNlink();

            state._fsp--;

             current =iv_ruleURNlink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleURNlink"


    // $ANTLR start "ruleURNlink"
    // InternalTurn.g:1050:1: ruleURNlink returns [EObject current=null] : (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleURNlink() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_type_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1056:2: ( (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:1057:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:1057:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:1058:3: otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getURNlinkAccess().getLinkKeyword_0());
            		
            // InternalTurn.g:1062:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?
            int alt23=2;
            alt23 = dfa23.predict(input);
            switch (alt23) {
                case 1 :
                    // InternalTurn.g:1063:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':'
                    {
                    // InternalTurn.g:1063:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:1064:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1064:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:1065:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1082:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:1083:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:1083:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:1084:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_14);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_3=(Token)match(input,22,FOLLOW_22); 

                    				newLeafNode(otherlv_3, grammarAccess.getURNlinkAccess().getColonKeyword_1_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:1106:3: (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==28) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalTurn.g:1107:4: otherlv_4= 'type' ( (lv_type_5_0= ruleText ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getURNlinkAccess().getTypeKeyword_2_0());
                    			
                    // InternalTurn.g:1111:4: ( (lv_type_5_0= ruleText ) )
                    // InternalTurn.g:1112:5: (lv_type_5_0= ruleText )
                    {
                    // InternalTurn.g:1112:5: (lv_type_5_0= ruleText )
                    // InternalTurn.g:1113:6: lv_type_5_0= ruleText
                    {

                    						newCompositeNode(grammarAccess.getURNlinkAccess().getTypeTextParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_type_5_0=ruleText();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getURNlinkRule());
                    						}
                    						set(
                    							current,
                    							"type",
                    							lv_type_5_0,
                    							"org.xtext.project.turn.Turn.Text");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:1131:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1132:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1132:4: ( ruleQualifiedName )
            // InternalTurn.g:1133:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURNlinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getURNlinkAccess().getFromElemURNmodelElementCrossReference_3_0());
            				
            pushFollow(FOLLOW_23);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_7=(Token)match(input,29,FOLLOW_3); 

            			newLeafNode(otherlv_7, grammarAccess.getURNlinkAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_4());
            		
            // InternalTurn.g:1151:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1152:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1152:4: ( ruleQualifiedName )
            // InternalTurn.g:1153:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getURNlinkRule());
            					}
            				

            					newCompositeNode(grammarAccess.getURNlinkAccess().getToElemURNmodelElementCrossReference_5_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleURNlink"


    // $ANTLR start "entryRuleMetadata"
    // InternalTurn.g:1171:1: entryRuleMetadata returns [EObject current=null] : iv_ruleMetadata= ruleMetadata EOF ;
    public final EObject entryRuleMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadata = null;


        try {
            // InternalTurn.g:1171:49: (iv_ruleMetadata= ruleMetadata EOF )
            // InternalTurn.g:1172:2: iv_ruleMetadata= ruleMetadata EOF
            {
             newCompositeNode(grammarAccess.getMetadataRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMetadata=ruleMetadata();

            state._fsp--;

             current =iv_ruleMetadata; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleMetadata"


    // $ANTLR start "ruleMetadata"
    // InternalTurn.g:1178:1: ruleMetadata returns [EObject current=null] : (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) ) ;
    public final EObject ruleMetadata() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1184:2: ( (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) ) )
            // InternalTurn.g:1185:2: (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) )
            {
            // InternalTurn.g:1185:2: (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) )
            // InternalTurn.g:1186:3: otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMetadataAccess().getMetadataKeyword_0());
            		
            // InternalTurn.g:1190:3: ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_ID) ) {
                int LA25_1 = input.LA(2);

                if ( (LA25_1==22||LA25_1==78) ) {
                    alt25=1;
                }
            }
            switch (alt25) {
                case 1 :
                    // InternalTurn.g:1191:4: ( ( ruleQualifiedName ) ) otherlv_2= ':'
                    {
                    // InternalTurn.g:1191:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:1192:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:1192:5: ( ruleQualifiedName )
                    // InternalTurn.g:1193:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getMetadataRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getMetadataAccess().getElemURNmodelElementCrossReference_1_0_0());
                    					
                    pushFollow(FOLLOW_14);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_2=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getMetadataAccess().getColonKeyword_1_1());
                    			

                    }
                    break;

            }

            // InternalTurn.g:1212:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTurn.g:1213:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTurn.g:1213:4: (lv_name_3_0= RULE_ID )
            // InternalTurn.g:1214:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_24); 

            					newLeafNode(lv_name_3_0, grammarAccess.getMetadataAccess().getNameIDTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getMetadataRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_4=(Token)match(input,31,FOLLOW_18); 

            			newLeafNode(otherlv_4, grammarAccess.getMetadataAccess().getEqualsSignKeyword_3());
            		
            // InternalTurn.g:1234:3: ( (lv_value_5_0= ruleText ) )
            // InternalTurn.g:1235:4: (lv_value_5_0= ruleText )
            {
            // InternalTurn.g:1235:4: (lv_value_5_0= ruleText )
            // InternalTurn.g:1236:5: lv_value_5_0= ruleText
            {

            					newCompositeNode(grammarAccess.getMetadataAccess().getValueTextParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_2);
            lv_value_5_0=ruleText();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getMetadataRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_5_0,
            						"org.xtext.project.turn.Turn.Text");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleMetadata"


    // $ANTLR start "entryRuleActor"
    // InternalTurn.g:1257:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTurn.g:1257:46: (iv_ruleActor= ruleActor EOF )
            // InternalTurn.g:1258:2: iv_ruleActor= ruleActor EOF
            {
             newCompositeNode(grammarAccess.getActorRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActor=ruleActor();

            state._fsp--;

             current =iv_ruleActor; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleActor"


    // $ANTLR start "ruleActor"
    // InternalTurn.g:1264:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) ;
    public final EObject ruleActor() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        Enumerator lv_importance_5_0 = null;

        AntlrDatatypeRuleToken lv_importanceQuantitative_6_0 = null;

        EObject lv_elems_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1270:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) )
            // InternalTurn.g:1271:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            {
            // InternalTurn.g:1271:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            // InternalTurn.g:1272:3: otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalTurn.g:1276:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1277:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1277:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1278:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getActorAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1295:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1296:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1296:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1297:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getActorAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getActorRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_27); 

            			newLeafNode(otherlv_3, grammarAccess.getActorAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:1318:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==33) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTurn.g:1319:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_28); 

                    				newLeafNode(otherlv_4, grammarAccess.getActorAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTurn.g:1323:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt26=2;
                    int LA26_0 = input.LA(1);

                    if ( (LA26_0==110||(LA26_0>=123 && LA26_0<=125)) ) {
                        alt26=1;
                    }
                    else if ( (LA26_0==RULE_INT||(LA26_0>=54 && LA26_0<=55)) ) {
                        alt26=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 26, 0, input);

                        throw nvae;
                    }
                    switch (alt26) {
                        case 1 :
                            // InternalTurn.g:1324:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTurn.g:1324:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTurn.g:1325:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTurn.g:1325:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTurn.g:1326:7: lv_importance_5_0= ruleImportanceType
                            {

                            							newCompositeNode(grammarAccess.getActorAccess().getImportanceImportanceTypeEnumRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_29);
                            lv_importance_5_0=ruleImportanceType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getActorRule());
                            							}
                            							set(
                            								current,
                            								"importance",
                            								lv_importance_5_0,
                            								"org.xtext.project.turn.Turn.ImportanceType");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTurn.g:1344:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:1344:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:1345:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:1345:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTurn.g:1346:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
                            {

                            							newCompositeNode(grammarAccess.getActorAccess().getImportanceQuantitativeQuantitativeValueParserRuleCall_4_1_1_0());
                            						
                            pushFollow(FOLLOW_29);
                            lv_importanceQuantitative_6_0=ruleQuantitativeValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getActorRule());
                            							}
                            							set(
                            								current,
                            								"importanceQuantitative",
                            								lv_importanceQuantitative_6_0,
                            								"org.xtext.project.turn.Turn.QuantitativeValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalTurn.g:1365:3: ( (lv_elems_7_0= ruleIntentionalElement ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( ((LA28_0>=111 && LA28_0<=116)) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalTurn.g:1366:4: (lv_elems_7_0= ruleIntentionalElement )
            	    {
            	    // InternalTurn.g:1366:4: (lv_elems_7_0= ruleIntentionalElement )
            	    // InternalTurn.g:1367:5: lv_elems_7_0= ruleIntentionalElement
            	    {

            	    					newCompositeNode(grammarAccess.getActorAccess().getElemsIntentionalElementParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_29);
            	    lv_elems_7_0=ruleIntentionalElement();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getActorRule());
            	    					}
            	    					add(
            	    						current,
            	    						"elems",
            	    						lv_elems_7_0,
            	    						"org.xtext.project.turn.Turn.IntentionalElement");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop28;
                }
            } while (true);

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getActorAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleActor"


    // $ANTLR start "entryRuleIntentionalElement"
    // InternalTurn.g:1392:1: entryRuleIntentionalElement returns [EObject current=null] : iv_ruleIntentionalElement= ruleIntentionalElement EOF ;
    public final EObject entryRuleIntentionalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentionalElement = null;


        try {
            // InternalTurn.g:1392:59: (iv_ruleIntentionalElement= ruleIntentionalElement EOF )
            // InternalTurn.g:1393:2: iv_ruleIntentionalElement= ruleIntentionalElement EOF
            {
             newCompositeNode(grammarAccess.getIntentionalElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIntentionalElement=ruleIntentionalElement();

            state._fsp--;

             current =iv_ruleIntentionalElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIntentionalElement"


    // $ANTLR start "ruleIntentionalElement"
    // InternalTurn.g:1399:1: ruleIntentionalElement returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) ;
    public final EObject ruleIntentionalElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token lv_unit_8_0=null;
        Token otherlv_10=null;
        Enumerator lv_type_0_0 = null;

        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        Enumerator lv_importance_5_0 = null;

        AntlrDatatypeRuleToken lv_importanceQuantitative_6_0 = null;

        EObject lv_linksSrc_9_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1405:2: ( ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) )
            // InternalTurn.g:1406:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            {
            // InternalTurn.g:1406:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            // InternalTurn.g:1407:3: ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}'
            {
            // InternalTurn.g:1407:3: ( (lv_type_0_0= ruleIntentionalElementType ) )
            // InternalTurn.g:1408:4: (lv_type_0_0= ruleIntentionalElementType )
            {
            // InternalTurn.g:1408:4: (lv_type_0_0= ruleIntentionalElementType )
            // InternalTurn.g:1409:5: lv_type_0_0= ruleIntentionalElementType
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getTypeIntentionalElementTypeEnumRuleCall_0_0());
            				
            pushFollow(FOLLOW_3);
            lv_type_0_0=ruleIntentionalElementType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"type",
            						lv_type_0_0,
            						"org.xtext.project.turn.Turn.IntentionalElementType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1426:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1427:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1427:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1428:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1445:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1446:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1446:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1447:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getIntentionalElementAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_30); 

            			newLeafNode(otherlv_3, grammarAccess.getIntentionalElementAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:1468:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==33) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTurn.g:1469:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_28); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntentionalElementAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTurn.g:1473:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==110||(LA29_0>=123 && LA29_0<=125)) ) {
                        alt29=1;
                    }
                    else if ( (LA29_0==RULE_INT||(LA29_0>=54 && LA29_0<=55)) ) {
                        alt29=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 29, 0, input);

                        throw nvae;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalTurn.g:1474:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTurn.g:1474:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTurn.g:1475:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTurn.g:1475:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTurn.g:1476:7: lv_importance_5_0= ruleImportanceType
                            {

                            							newCompositeNode(grammarAccess.getIntentionalElementAccess().getImportanceImportanceTypeEnumRuleCall_4_1_0_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_importance_5_0=ruleImportanceType();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
                            							}
                            							set(
                            								current,
                            								"importance",
                            								lv_importance_5_0,
                            								"org.xtext.project.turn.Turn.ImportanceType");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTurn.g:1494:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:1494:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:1495:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:1495:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTurn.g:1496:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
                            {

                            							newCompositeNode(grammarAccess.getIntentionalElementAccess().getImportanceQuantitativeQuantitativeValueParserRuleCall_4_1_1_0());
                            						
                            pushFollow(FOLLOW_31);
                            lv_importanceQuantitative_6_0=ruleQuantitativeValue();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
                            							}
                            							set(
                            								current,
                            								"importanceQuantitative",
                            								lv_importanceQuantitative_6_0,
                            								"org.xtext.project.turn.Turn.QuantitativeValue");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalTurn.g:1515:3: (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==34) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTurn.g:1516:4: otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntentionalElementAccess().getUnitKeyword_5_0());
                    			
                    // InternalTurn.g:1520:4: ( (lv_unit_8_0= RULE_STRING ) )
                    // InternalTurn.g:1521:5: (lv_unit_8_0= RULE_STRING )
                    {
                    // InternalTurn.g:1521:5: (lv_unit_8_0= RULE_STRING )
                    // InternalTurn.g:1522:6: lv_unit_8_0= RULE_STRING
                    {
                    lv_unit_8_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

                    						newLeafNode(lv_unit_8_0, grammarAccess.getIntentionalElementAccess().getUnitSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIntentionalElementRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"unit",
                    							lv_unit_8_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:1539:3: ( (lv_linksSrc_9_0= ruleElementLink ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==RULE_ID||LA32_0==35||LA32_0==39||LA32_0==79||LA32_0==81||LA32_0==126) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalTurn.g:1540:4: (lv_linksSrc_9_0= ruleElementLink )
            	    {
            	    // InternalTurn.g:1540:4: (lv_linksSrc_9_0= ruleElementLink )
            	    // InternalTurn.g:1541:5: lv_linksSrc_9_0= ruleElementLink
            	    {

            	    					newCompositeNode(grammarAccess.getIntentionalElementAccess().getLinksSrcElementLinkParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_32);
            	    lv_linksSrc_9_0=ruleElementLink();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getIntentionalElementRule());
            	    					}
            	    					add(
            	    						current,
            	    						"linksSrc",
            	    						lv_linksSrc_9_0,
            	    						"org.xtext.project.turn.Turn.ElementLink");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getIntentionalElementAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentionalElement"


    // $ANTLR start "entryRuleElementLink"
    // InternalTurn.g:1566:1: entryRuleElementLink returns [EObject current=null] : iv_ruleElementLink= ruleElementLink EOF ;
    public final EObject entryRuleElementLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementLink = null;


        try {
            // InternalTurn.g:1566:52: (iv_ruleElementLink= ruleElementLink EOF )
            // InternalTurn.g:1567:2: iv_ruleElementLink= ruleElementLink EOF
            {
             newCompositeNode(grammarAccess.getElementLinkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElementLink=ruleElementLink();

            state._fsp--;

             current =iv_ruleElementLink; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElementLink"


    // $ANTLR start "ruleElementLink"
    // InternalTurn.g:1573:1: ruleElementLink returns [EObject current=null] : (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) ;
    public final EObject ruleElementLink() throws RecognitionException {
        EObject current = null;

        EObject this_Contribution_0 = null;

        EObject this_Decomposition_1 = null;

        EObject this_Dependency_2 = null;



        	enterRule();

        try {
            // InternalTurn.g:1579:2: ( (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) )
            // InternalTurn.g:1580:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            {
            // InternalTurn.g:1580:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            int alt33=3;
            alt33 = dfa33.predict(input);
            switch (alt33) {
                case 1 :
                    // InternalTurn.g:1581:3: this_Contribution_0= ruleContribution
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getContributionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_Contribution_0=ruleContribution();

                    state._fsp--;


                    			current = this_Contribution_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:1590:3: this_Decomposition_1= ruleDecomposition
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getDecompositionParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Decomposition_1=ruleDecomposition();

                    state._fsp--;


                    			current = this_Decomposition_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:1599:3: this_Dependency_2= ruleDependency
                    {

                    			newCompositeNode(grammarAccess.getElementLinkAccess().getDependencyParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Dependency_2=ruleDependency();

                    state._fsp--;


                    			current = this_Dependency_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElementLink"


    // $ANTLR start "entryRuleContribution"
    // InternalTurn.g:1611:1: entryRuleContribution returns [EObject current=null] : iv_ruleContribution= ruleContribution EOF ;
    public final EObject entryRuleContribution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContribution = null;


        try {
            // InternalTurn.g:1611:53: (iv_ruleContribution= ruleContribution EOF )
            // InternalTurn.g:1612:2: iv_ruleContribution= ruleContribution EOF
            {
             newCompositeNode(grammarAccess.getContributionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContribution=ruleContribution();

            state._fsp--;

             current =iv_ruleContribution; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContribution"


    // $ANTLR start "ruleContribution"
    // InternalTurn.g:1618:1: ruleContribution returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContribution() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token lv_correlation_4_0=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_contribution_6_0 = null;

        AntlrDatatypeRuleToken lv_quantitativeContribution_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1624:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:1625:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:1625:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:1626:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:1626:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTurn.g:1627:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1627:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1628:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1628:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1629:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_33);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1646:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1647:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1647:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1648:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_34);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,35,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getContributionAccess().getContributesToKeyword_1());
            		
            // InternalTurn.g:1670:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1671:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1671:4: ( ruleQualifiedName )
            // InternalTurn.g:1672:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContributionAccess().getDestIntentionalElementCrossReference_2_0());
            				
            pushFollow(FOLLOW_35);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1686:3: ( (lv_correlation_4_0= 'correlated' ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==36) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTurn.g:1687:4: (lv_correlation_4_0= 'correlated' )
                    {
                    // InternalTurn.g:1687:4: (lv_correlation_4_0= 'correlated' )
                    // InternalTurn.g:1688:5: lv_correlation_4_0= 'correlated'
                    {
                    lv_correlation_4_0=(Token)match(input,36,FOLLOW_36); 

                    					newLeafNode(lv_correlation_4_0, grammarAccess.getContributionAccess().getCorrelationCorrelatedKeyword_3_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getContributionRule());
                    					}
                    					setWithLastConsumed(current, "correlation", true, "correlated");
                    				

                    }


                    }
                    break;

            }

            otherlv_5=(Token)match(input,37,FOLLOW_37); 

            			newLeafNode(otherlv_5, grammarAccess.getContributionAccess().getWithKeyword_4());
            		
            // InternalTurn.g:1704:3: ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==109||(LA36_0>=117 && LA36_0<=122)) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_INT||(LA36_0>=54 && LA36_0<=55)) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalTurn.g:1705:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    {
                    // InternalTurn.g:1705:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    // InternalTurn.g:1706:5: (lv_contribution_6_0= ruleContributionType )
                    {
                    // InternalTurn.g:1706:5: (lv_contribution_6_0= ruleContributionType )
                    // InternalTurn.g:1707:6: lv_contribution_6_0= ruleContributionType
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getContributionContributionTypeEnumRuleCall_5_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_contribution_6_0=ruleContributionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"contribution",
                    							lv_contribution_6_0,
                    							"org.xtext.project.turn.Turn.ContributionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:1725:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:1725:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:1726:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:1726:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    // InternalTurn.g:1727:6: lv_quantitativeContribution_7_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getContributionAccess().getQuantitativeContributionQuantitativeValueParserRuleCall_5_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_quantitativeContribution_7_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionRule());
                    						}
                    						set(
                    							current,
                    							"quantitativeContribution",
                    							lv_quantitativeContribution_7_0,
                    							"org.xtext.project.turn.Turn.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContribution"


    // $ANTLR start "entryRuleDecomposition"
    // InternalTurn.g:1749:1: entryRuleDecomposition returns [EObject current=null] : iv_ruleDecomposition= ruleDecomposition EOF ;
    public final EObject entryRuleDecomposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecomposition = null;


        try {
            // InternalTurn.g:1749:54: (iv_ruleDecomposition= ruleDecomposition EOF )
            // InternalTurn.g:1750:2: iv_ruleDecomposition= ruleDecomposition EOF
            {
             newCompositeNode(grammarAccess.getDecompositionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDecomposition=ruleDecomposition();

            state._fsp--;

             current =iv_ruleDecomposition; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDecomposition"


    // $ANTLR start "ruleDecomposition"
    // InternalTurn.g:1756:1: ruleDecomposition returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDecomposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_decompositionType_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1762:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:1763:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:1763:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:1764:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:1764:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==RULE_ID) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTurn.g:1765:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1765:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1766:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1766:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1767:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDecompositionAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_38);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecompositionRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1784:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1785:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1785:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1786:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getDecompositionAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_39);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDecompositionRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:1804:3: ( (lv_decompositionType_2_0= ruleDecompositionType ) )
            // InternalTurn.g:1805:4: (lv_decompositionType_2_0= ruleDecompositionType )
            {
            // InternalTurn.g:1805:4: (lv_decompositionType_2_0= ruleDecompositionType )
            // InternalTurn.g:1806:5: lv_decompositionType_2_0= ruleDecompositionType
            {

            					newCompositeNode(grammarAccess.getDecompositionAccess().getDecompositionTypeDecompositionTypeEnumRuleCall_1_0());
            				
            pushFollow(FOLLOW_40);
            lv_decompositionType_2_0=ruleDecompositionType();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getDecompositionRule());
            					}
            					set(
            						current,
            						"decompositionType",
            						lv_decompositionType_2_0,
            						"org.xtext.project.turn.Turn.DecompositionType");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,38,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getDecompositionAccess().getDecomposesKeyword_2());
            		
            // InternalTurn.g:1827:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1828:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1828:4: ( ruleQualifiedName )
            // InternalTurn.g:1829:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDecompositionRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDecompositionAccess().getDestIntentionalElementCrossReference_3_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecomposition"


    // $ANTLR start "entryRuleDependency"
    // InternalTurn.g:1847:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalTurn.g:1847:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalTurn.g:1848:2: iv_ruleDependency= ruleDependency EOF
            {
             newCompositeNode(grammarAccess.getDependencyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDependency=ruleDependency();

            state._fsp--;

             current =iv_ruleDependency; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleDependency"


    // $ANTLR start "ruleDependency"
    // InternalTurn.g:1854:1: ruleDependency returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1860:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:1861:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:1861:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:1862:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:1862:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( (LA38_0==RULE_ID) ) {
                alt38=1;
            }
            switch (alt38) {
                case 1 :
                    // InternalTurn.g:1863:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1863:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1864:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1864:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1865:6: lv_name_0_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getDependencyAccess().getNameQualifiedNameParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_41);
                    lv_name_0_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDependencyRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_0_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:1882:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1883:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1883:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1884:6: lv_longName_1_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getDependencyAccess().getLongNameLongNameParserRuleCall_0_1_0());
                    					
                    pushFollow(FOLLOW_42);
                    lv_longName_1_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getDependencyRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_1_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,39,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getDependencyAccess().getDependsOnKeyword_1());
            		
            // InternalTurn.g:1906:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1907:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1907:4: ( ruleQualifiedName )
            // InternalTurn.g:1908:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getDependencyRule());
            					}
            				

            					newCompositeNode(grammarAccess.getDependencyAccess().getDestIntentionalElementCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDependency"


    // $ANTLR start "entryRuleArtificialRule"
    // InternalTurn.g:1926:1: entryRuleArtificialRule returns [EObject current=null] : iv_ruleArtificialRule= ruleArtificialRule EOF ;
    public final EObject entryRuleArtificialRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtificialRule = null;


        try {
            // InternalTurn.g:1926:55: (iv_ruleArtificialRule= ruleArtificialRule EOF )
            // InternalTurn.g:1927:2: iv_ruleArtificialRule= ruleArtificialRule EOF
            {
             newCompositeNode(grammarAccess.getArtificialRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArtificialRule=ruleArtificialRule();

            state._fsp--;

             current =iv_ruleArtificialRule; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArtificialRule"


    // $ANTLR start "ruleArtificialRule"
    // InternalTurn.g:1933:1: ruleArtificialRule returns [EObject current=null] : ( (lv_longName_0_0= RULE_STRING ) )? ;
    public final EObject ruleArtificialRule() throws RecognitionException {
        EObject current = null;

        Token lv_longName_0_0=null;


        	enterRule();

        try {
            // InternalTurn.g:1939:2: ( ( (lv_longName_0_0= RULE_STRING ) )? )
            // InternalTurn.g:1940:2: ( (lv_longName_0_0= RULE_STRING ) )?
            {
            // InternalTurn.g:1940:2: ( (lv_longName_0_0= RULE_STRING ) )?
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==RULE_STRING) ) {
                alt39=1;
            }
            switch (alt39) {
                case 1 :
                    // InternalTurn.g:1941:3: (lv_longName_0_0= RULE_STRING )
                    {
                    // InternalTurn.g:1941:3: (lv_longName_0_0= RULE_STRING )
                    // InternalTurn.g:1942:4: lv_longName_0_0= RULE_STRING
                    {
                    lv_longName_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    				newLeafNode(lv_longName_0_0, grammarAccess.getArtificialRuleAccess().getLongNameSTRINGTerminalRuleCall_0());
                    			

                    				if (current==null) {
                    					current = createModelElement(grammarAccess.getArtificialRuleRule());
                    				}
                    				setWithLastConsumed(
                    					current,
                    					"longName",
                    					lv_longName_0_0,
                    					"org.eclipse.xtext.common.Terminals.STRING");
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArtificialRule"


    // $ANTLR start "entryRuleStrategiesGroup"
    // InternalTurn.g:1961:1: entryRuleStrategiesGroup returns [EObject current=null] : iv_ruleStrategiesGroup= ruleStrategiesGroup EOF ;
    public final EObject entryRuleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrategiesGroup = null;


        try {
            // InternalTurn.g:1961:56: (iv_ruleStrategiesGroup= ruleStrategiesGroup EOF )
            // InternalTurn.g:1962:2: iv_ruleStrategiesGroup= ruleStrategiesGroup EOF
            {
             newCompositeNode(grammarAccess.getStrategiesGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStrategiesGroup=ruleStrategiesGroup();

            state._fsp--;

             current =iv_ruleStrategiesGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStrategiesGroup"


    // $ANTLR start "ruleStrategiesGroup"
    // InternalTurn.g:1968:1: ruleStrategiesGroup returns [EObject current=null] : (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1974:2: ( (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:1975:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:1975:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:1976:3: otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStrategiesGroupAccess().getStrategiesGroupKeyword_0());
            		
            // InternalTurn.g:1980:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1981:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1981:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1982:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getStrategiesGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStrategiesGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:1999:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2000:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2000:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2001:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getStrategiesGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStrategiesGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getStrategiesGroupAccess().getColonKeyword_3());
            		
            // InternalTurn.g:2022:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:2023:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:2023:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:2024:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStrategiesGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getStrategiesGroupAccess().getEvalStrategyEvaluationStrategyCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:2035:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop40:
            do {
                int alt40=2;
                int LA40_0 = input.LA(1);

                if ( (LA40_0==23) ) {
                    alt40=1;
                }


                switch (alt40) {
            	case 1 :
            	    // InternalTurn.g:2036:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getStrategiesGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:2040:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:2041:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:2041:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:2042:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getStrategiesGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

            	    						newLeafNode(otherlv_6, grammarAccess.getStrategiesGroupAccess().getEvalStrategiesEvaluationStrategyCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop40;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStrategiesGroup"


    // $ANTLR start "entryRuleEvaluationStrategy"
    // InternalTurn.g:2058:1: entryRuleEvaluationStrategy returns [EObject current=null] : iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF ;
    public final EObject entryRuleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluationStrategy = null;


        try {
            // InternalTurn.g:2058:59: (iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF )
            // InternalTurn.g:2059:2: iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF
            {
             newCompositeNode(grammarAccess.getEvaluationStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluationStrategy=ruleEvaluationStrategy();

            state._fsp--;

             current =iv_ruleEvaluationStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluationStrategy"


    // $ANTLR start "ruleEvaluationStrategy"
    // InternalTurn.g:2065:1: ruleEvaluationStrategy returns [EObject current=null] : (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' ) ;
    public final EObject ruleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_info_4_0 = null;

        EObject lv_evaluations_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2071:2: ( (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' ) )
            // InternalTurn.g:2072:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' )
            {
            // InternalTurn.g:2072:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' )
            // InternalTurn.g:2073:3: otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEvaluationStrategyAccess().getStrategyKeyword_0());
            		
            // InternalTurn.g:2077:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2078:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2078:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2079:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2096:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2097:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2097:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2098:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_43); 

            			newLeafNode(otherlv_3, grammarAccess.getEvaluationStrategyAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:2119:3: ( (lv_info_4_0= ruleConcreteStrategy ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==15) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTurn.g:2120:4: (lv_info_4_0= ruleConcreteStrategy )
                    {
                    // InternalTurn.g:2120:4: (lv_info_4_0= ruleConcreteStrategy )
                    // InternalTurn.g:2121:5: lv_info_4_0= ruleConcreteStrategy
                    {

                    					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getInfoConcreteStrategyParserRuleCall_4_0());
                    				
                    pushFollow(FOLLOW_44);
                    lv_info_4_0=ruleConcreteStrategy();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
                    					}
                    					set(
                    						current,
                    						"info",
                    						lv_info_4_0,
                    						"org.xtext.project.turn.Turn.ConcreteStrategy");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:2138:3: ( (lv_evaluations_5_0= ruleEvaluation ) )*
            loop42:
            do {
                int alt42=2;
                int LA42_0 = input.LA(1);

                if ( (LA42_0==RULE_ID) ) {
                    alt42=1;
                }


                switch (alt42) {
            	case 1 :
            	    // InternalTurn.g:2139:4: (lv_evaluations_5_0= ruleEvaluation )
            	    {
            	    // InternalTurn.g:2139:4: (lv_evaluations_5_0= ruleEvaluation )
            	    // InternalTurn.g:2140:5: lv_evaluations_5_0= ruleEvaluation
            	    {

            	    					newCompositeNode(grammarAccess.getEvaluationStrategyAccess().getEvaluationsEvaluationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_44);
            	    lv_evaluations_5_0=ruleEvaluation();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getEvaluationStrategyRule());
            	    					}
            	    					add(
            	    						current,
            	    						"evaluations",
            	    						lv_evaluations_5_0,
            	    						"org.xtext.project.turn.Turn.Evaluation");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop42;
                }
            } while (true);

            // InternalTurn.g:2157:3: (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==42) ) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalTurn.g:2158:4: otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getEvaluationStrategyAccess().getIncludesKeyword_6_0());
                    			
                    // InternalTurn.g:2162:4: ( (otherlv_7= RULE_ID ) )
                    // InternalTurn.g:2163:5: (otherlv_7= RULE_ID )
                    {
                    // InternalTurn.g:2163:5: (otherlv_7= RULE_ID )
                    // InternalTurn.g:2164:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEvaluationStrategyRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_45); 

                    						newLeafNode(otherlv_7, grammarAccess.getEvaluationStrategyAccess().getIncludedStrategyEvaluationStrategyCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:2175:4: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    loop43:
                    do {
                        int alt43=2;
                        int LA43_0 = input.LA(1);

                        if ( (LA43_0==23) ) {
                            alt43=1;
                        }


                        switch (alt43) {
                    	case 1 :
                    	    // InternalTurn.g:2176:5: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getEvaluationStrategyAccess().getCommaKeyword_6_2_0());
                    	    				
                    	    // InternalTurn.g:2180:5: ( (otherlv_9= RULE_ID ) )
                    	    // InternalTurn.g:2181:6: (otherlv_9= RULE_ID )
                    	    {
                    	    // InternalTurn.g:2181:6: (otherlv_9= RULE_ID )
                    	    // InternalTurn.g:2182:7: otherlv_9= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getEvaluationStrategyRule());
                    	    							}
                    	    						
                    	    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_45); 

                    	    							newLeafNode(otherlv_9, grammarAccess.getEvaluationStrategyAccess().getIncludedStrategiesEvaluationStrategyCrossReference_6_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop43;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_10=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_10, grammarAccess.getEvaluationStrategyAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluationStrategy"


    // $ANTLR start "entryRuleConcreteStrategy"
    // InternalTurn.g:2203:1: entryRuleConcreteStrategy returns [EObject current=null] : iv_ruleConcreteStrategy= ruleConcreteStrategy EOF ;
    public final EObject entryRuleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteStrategy = null;


        try {
            // InternalTurn.g:2203:57: (iv_ruleConcreteStrategy= ruleConcreteStrategy EOF )
            // InternalTurn.g:2204:2: iv_ruleConcreteStrategy= ruleConcreteStrategy EOF
            {
             newCompositeNode(grammarAccess.getConcreteStrategyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConcreteStrategy=ruleConcreteStrategy();

            state._fsp--;

             current =iv_ruleConcreteStrategy; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcreteStrategy"


    // $ANTLR start "ruleConcreteStrategy"
    // InternalTurn.g:2210:1: ruleConcreteStrategy returns [EObject current=null] : (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_author_1_0=null;


        	enterRule();

        try {
            // InternalTurn.g:2216:2: ( (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) )
            // InternalTurn.g:2217:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            {
            // InternalTurn.g:2217:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            // InternalTurn.g:2218:3: otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteStrategyAccess().getAuthorKeyword_0());
            		
            // InternalTurn.g:2222:3: ( (lv_author_1_0= RULE_STRING ) )
            // InternalTurn.g:2223:4: (lv_author_1_0= RULE_STRING )
            {
            // InternalTurn.g:2223:4: (lv_author_1_0= RULE_STRING )
            // InternalTurn.g:2224:5: lv_author_1_0= RULE_STRING
            {
            lv_author_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_author_1_0, grammarAccess.getConcreteStrategyAccess().getAuthorSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConcreteStrategyRule());
            					}
            					setWithLastConsumed(
            						current,
            						"author",
            						lv_author_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcreteStrategy"


    // $ANTLR start "entryRuleEvaluation"
    // InternalTurn.g:2244:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalTurn.g:2244:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalTurn.g:2245:2: iv_ruleEvaluation= ruleEvaluation EOF
            {
             newCompositeNode(grammarAccess.getEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvaluation=ruleEvaluation();

            state._fsp--;

             current =iv_ruleEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEvaluation"


    // $ANTLR start "ruleEvaluation"
    // InternalTurn.g:2251:1: ruleEvaluation returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) ;
    public final EObject ruleEvaluation() throws RecognitionException {
        EObject current = null;

        Token lv_exceeds_1_0=null;
        Token otherlv_2=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Enumerator lv_qualitativeEvaluation_3_0 = null;

        AntlrDatatypeRuleToken lv_evaluation_4_0 = null;

        EObject lv_indicatorEval_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2257:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) )
            // InternalTurn.g:2258:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            {
            // InternalTurn.g:2258:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalTurn.g:2259:3: ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalTurn.g:2259:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:2260:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:2260:4: ( ruleQualifiedName )
            // InternalTurn.g:2261:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEvaluationRule());
            					}
            				

            					newCompositeNode(grammarAccess.getEvaluationAccess().getIntElementIntentionalElementCrossReference_0_0());
            				
            pushFollow(FOLLOW_46);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2275:3: ( (lv_exceeds_1_0= 'exceeding' ) )?
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==43) ) {
                alt45=1;
            }
            switch (alt45) {
                case 1 :
                    // InternalTurn.g:2276:4: (lv_exceeds_1_0= 'exceeding' )
                    {
                    // InternalTurn.g:2276:4: (lv_exceeds_1_0= 'exceeding' )
                    // InternalTurn.g:2277:5: lv_exceeds_1_0= 'exceeding'
                    {
                    lv_exceeds_1_0=(Token)match(input,43,FOLLOW_46); 

                    					newLeafNode(lv_exceeds_1_0, grammarAccess.getEvaluationAccess().getExceedsExceedingKeyword_1_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getEvaluationRule());
                    					}
                    					setWithLastConsumed(current, "exceeds", true, "exceeding");
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:2289:3: ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==44) ) {
                alt47=1;
            }
            else if ( (LA47_0==46) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // InternalTurn.g:2290:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    {
                    // InternalTurn.g:2290:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    // InternalTurn.g:2291:5: otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_47); 

                    					newLeafNode(otherlv_2, grammarAccess.getEvaluationAccess().getEvaluationKeyword_2_0_0());
                    				
                    // InternalTurn.g:2295:5: ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    int alt46=2;
                    int LA46_0 = input.LA(1);

                    if ( ((LA46_0>=104 && LA46_0<=110)) ) {
                        alt46=1;
                    }
                    else if ( (LA46_0==RULE_INT||(LA46_0>=54 && LA46_0<=55)) ) {
                        alt46=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 46, 0, input);

                        throw nvae;
                    }
                    switch (alt46) {
                        case 1 :
                            // InternalTurn.g:2296:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            {
                            // InternalTurn.g:2296:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            // InternalTurn.g:2297:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            {
                            // InternalTurn.g:2297:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            // InternalTurn.g:2298:8: lv_qualitativeEvaluation_3_0= ruleQualitativeLabel
                            {

                            								newCompositeNode(grammarAccess.getEvaluationAccess().getQualitativeEvaluationQualitativeLabelEnumRuleCall_2_0_1_0_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_qualitativeEvaluation_3_0=ruleQualitativeLabel();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"qualitativeEvaluation",
                            									lv_qualitativeEvaluation_3_0,
                            									"org.xtext.project.turn.Turn.QualitativeLabel");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;
                        case 2 :
                            // InternalTurn.g:2316:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:2316:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:2317:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:2317:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            // InternalTurn.g:2318:8: lv_evaluation_4_0= ruleQuantitativeValue
                            {

                            								newCompositeNode(grammarAccess.getEvaluationAccess().getEvaluationQuantitativeValueParserRuleCall_2_0_1_1_0());
                            							
                            pushFollow(FOLLOW_2);
                            lv_evaluation_4_0=ruleQuantitativeValue();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getEvaluationRule());
                            								}
                            								set(
                            									current,
                            									"evaluation",
                            									lv_evaluation_4_0,
                            									"org.xtext.project.turn.Turn.QuantitativeValue");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:2338:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalTurn.g:2338:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    // InternalTurn.g:2339:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalTurn.g:2339:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) )
                    // InternalTurn.g:2340:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    {
                    // InternalTurn.g:2340:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    // InternalTurn.g:2341:7: lv_indicatorEval_5_0= ruleIndicatorEvaluation
                    {

                    							newCompositeNode(grammarAccess.getEvaluationAccess().getIndicatorEvalIndicatorEvaluationParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_48);
                    lv_indicatorEval_5_0=ruleIndicatorEvaluation();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getEvaluationRule());
                    							}
                    							set(
                    								current,
                    								"indicatorEval",
                    								lv_indicatorEval_5_0,
                    								"org.xtext.project.turn.Turn.IndicatorEvaluation");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_6=(Token)match(input,45,FOLLOW_3); 

                    					newLeafNode(otherlv_6, grammarAccess.getEvaluationAccess().getConvertedWithKeyword_2_1_1());
                    				
                    // InternalTurn.g:2362:5: ( (otherlv_7= RULE_ID ) )
                    // InternalTurn.g:2363:6: (otherlv_7= RULE_ID )
                    {
                    // InternalTurn.g:2363:6: (otherlv_7= RULE_ID )
                    // InternalTurn.g:2364:7: otherlv_7= RULE_ID
                    {

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getEvaluationRule());
                    							}
                    						
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_2); 

                    							newLeafNode(otherlv_7, grammarAccess.getEvaluationAccess().getConversionIndicatorConversionCrossReference_2_1_2_0());
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEvaluation"


    // $ANTLR start "entryRuleIndicatorEvaluation"
    // InternalTurn.g:2381:1: entryRuleIndicatorEvaluation returns [EObject current=null] : iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF ;
    public final EObject entryRuleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorEvaluation = null;


        try {
            // InternalTurn.g:2381:60: (iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF )
            // InternalTurn.g:2382:2: iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF
            {
             newCompositeNode(grammarAccess.getIndicatorEvaluationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndicatorEvaluation=ruleIndicatorEvaluation();

            state._fsp--;

             current =iv_ruleIndicatorEvaluation; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndicatorEvaluation"


    // $ANTLR start "ruleIndicatorEvaluation"
    // InternalTurn.g:2388:1: ruleIndicatorEvaluation returns [EObject current=null] : (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) ;
    public final EObject ruleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_realWorldLabel_1_0=null;
        Token lv_realWorldValue_2_0=null;


        	enterRule();

        try {
            // InternalTurn.g:2394:2: ( (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) )
            // InternalTurn.g:2395:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            {
            // InternalTurn.g:2395:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            // InternalTurn.g:2396:3: otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getIndicatorEvaluationAccess().getRealKeyword_0());
            		
            // InternalTurn.g:2400:3: ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==RULE_STRING) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_INT) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalTurn.g:2401:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    {
                    // InternalTurn.g:2401:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    // InternalTurn.g:2402:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    {
                    // InternalTurn.g:2402:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    // InternalTurn.g:2403:6: lv_realWorldLabel_1_0= RULE_STRING
                    {
                    lv_realWorldLabel_1_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_realWorldLabel_1_0, grammarAccess.getIndicatorEvaluationAccess().getRealWorldLabelSTRINGTerminalRuleCall_1_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIndicatorEvaluationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"realWorldLabel",
                    							lv_realWorldLabel_1_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:2420:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    {
                    // InternalTurn.g:2420:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    // InternalTurn.g:2421:5: (lv_realWorldValue_2_0= RULE_INT )
                    {
                    // InternalTurn.g:2421:5: (lv_realWorldValue_2_0= RULE_INT )
                    // InternalTurn.g:2422:6: lv_realWorldValue_2_0= RULE_INT
                    {
                    lv_realWorldValue_2_0=(Token)match(input,RULE_INT,FOLLOW_2); 

                    						newLeafNode(lv_realWorldValue_2_0, grammarAccess.getIndicatorEvaluationAccess().getRealWorldValueINTTerminalRuleCall_1_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getIndicatorEvaluationRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"realWorldValue",
                    							lv_realWorldValue_2_0,
                    							"org.eclipse.xtext.common.Terminals.INT");
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndicatorEvaluation"


    // $ANTLR start "entryRuleIndicatorConversion"
    // InternalTurn.g:2443:1: entryRuleIndicatorConversion returns [EObject current=null] : iv_ruleIndicatorConversion= ruleIndicatorConversion EOF ;
    public final EObject entryRuleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorConversion = null;


        try {
            // InternalTurn.g:2443:60: (iv_ruleIndicatorConversion= ruleIndicatorConversion EOF )
            // InternalTurn.g:2444:2: iv_ruleIndicatorConversion= ruleIndicatorConversion EOF
            {
             newCompositeNode(grammarAccess.getIndicatorConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleIndicatorConversion=ruleIndicatorConversion();

            state._fsp--;

             current =iv_ruleIndicatorConversion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIndicatorConversion"


    // $ANTLR start "ruleIndicatorConversion"
    // InternalTurn.g:2450:1: ruleIndicatorConversion returns [EObject current=null] : (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) ;
    public final EObject ruleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject this_LinearConversion_0 = null;

        EObject this_QualToQMappings_1 = null;



        	enterRule();

        try {
            // InternalTurn.g:2456:2: ( (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) )
            // InternalTurn.g:2457:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            {
            // InternalTurn.g:2457:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            int alt49=2;
            int LA49_0 = input.LA(1);

            if ( (LA49_0==47) ) {
                alt49=1;
            }
            else if ( (LA49_0==51) ) {
                alt49=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }
            switch (alt49) {
                case 1 :
                    // InternalTurn.g:2458:3: this_LinearConversion_0= ruleLinearConversion
                    {

                    			newCompositeNode(grammarAccess.getIndicatorConversionAccess().getLinearConversionParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_LinearConversion_0=ruleLinearConversion();

                    state._fsp--;


                    			current = this_LinearConversion_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:2467:3: this_QualToQMappings_1= ruleQualToQMappings
                    {

                    			newCompositeNode(grammarAccess.getIndicatorConversionAccess().getQualToQMappingsParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_QualToQMappings_1=ruleQualToQMappings();

                    state._fsp--;


                    			current = this_QualToQMappings_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIndicatorConversion"


    // $ANTLR start "entryRuleLinearConversion"
    // InternalTurn.g:2479:1: entryRuleLinearConversion returns [EObject current=null] : iv_ruleLinearConversion= ruleLinearConversion EOF ;
    public final EObject entryRuleLinearConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinearConversion = null;


        try {
            // InternalTurn.g:2479:57: (iv_ruleLinearConversion= ruleLinearConversion EOF )
            // InternalTurn.g:2480:2: iv_ruleLinearConversion= ruleLinearConversion EOF
            {
             newCompositeNode(grammarAccess.getLinearConversionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLinearConversion=ruleLinearConversion();

            state._fsp--;

             current =iv_ruleLinearConversion; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLinearConversion"


    // $ANTLR start "ruleLinearConversion"
    // InternalTurn.g:2486:1: ruleLinearConversion returns [EObject current=null] : (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) ;
    public final EObject ruleLinearConversion() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_unit_5_0=null;
        Token otherlv_6=null;
        Token lv_targetValue_7_0=null;
        Token otherlv_8=null;
        Token lv_thresholdValue_9_0=null;
        Token otherlv_10=null;
        Token lv_worstValue_11_0=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2492:2: ( (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) )
            // InternalTurn.g:2493:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            {
            // InternalTurn.g:2493:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            // InternalTurn.g:2494:3: otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLinearConversionAccess().getLinearConversionKeyword_0());
            		
            // InternalTurn.g:2498:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2499:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2499:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2500:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLinearConversionAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinearConversionRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2517:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2518:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2518:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2519:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getLinearConversionAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLinearConversionRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_50); 

            			newLeafNode(otherlv_3, grammarAccess.getLinearConversionAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getLinearConversionAccess().getUnitKeyword_4());
            		
            // InternalTurn.g:2544:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTurn.g:2545:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTurn.g:2545:4: (lv_unit_5_0= RULE_STRING )
            // InternalTurn.g:2546:5: lv_unit_5_0= RULE_STRING
            {
            lv_unit_5_0=(Token)match(input,RULE_STRING,FOLLOW_51); 

            					newLeafNode(lv_unit_5_0, grammarAccess.getLinearConversionAccess().getUnitSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unit",
            						lv_unit_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,48,FOLLOW_52); 

            			newLeafNode(otherlv_6, grammarAccess.getLinearConversionAccess().getTargetKeyword_6());
            		
            // InternalTurn.g:2566:3: ( (lv_targetValue_7_0= RULE_INT ) )
            // InternalTurn.g:2567:4: (lv_targetValue_7_0= RULE_INT )
            {
            // InternalTurn.g:2567:4: (lv_targetValue_7_0= RULE_INT )
            // InternalTurn.g:2568:5: lv_targetValue_7_0= RULE_INT
            {
            lv_targetValue_7_0=(Token)match(input,RULE_INT,FOLLOW_53); 

            					newLeafNode(lv_targetValue_7_0, grammarAccess.getLinearConversionAccess().getTargetValueINTTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"targetValue",
            						lv_targetValue_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_8=(Token)match(input,49,FOLLOW_52); 

            			newLeafNode(otherlv_8, grammarAccess.getLinearConversionAccess().getThresholdKeyword_8());
            		
            // InternalTurn.g:2588:3: ( (lv_thresholdValue_9_0= RULE_INT ) )
            // InternalTurn.g:2589:4: (lv_thresholdValue_9_0= RULE_INT )
            {
            // InternalTurn.g:2589:4: (lv_thresholdValue_9_0= RULE_INT )
            // InternalTurn.g:2590:5: lv_thresholdValue_9_0= RULE_INT
            {
            lv_thresholdValue_9_0=(Token)match(input,RULE_INT,FOLLOW_54); 

            					newLeafNode(lv_thresholdValue_9_0, grammarAccess.getLinearConversionAccess().getThresholdValueINTTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"thresholdValue",
            						lv_thresholdValue_9_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_10=(Token)match(input,50,FOLLOW_52); 

            			newLeafNode(otherlv_10, grammarAccess.getLinearConversionAccess().getWorstKeyword_10());
            		
            // InternalTurn.g:2610:3: ( (lv_worstValue_11_0= RULE_INT ) )
            // InternalTurn.g:2611:4: (lv_worstValue_11_0= RULE_INT )
            {
            // InternalTurn.g:2611:4: (lv_worstValue_11_0= RULE_INT )
            // InternalTurn.g:2612:5: lv_worstValue_11_0= RULE_INT
            {
            lv_worstValue_11_0=(Token)match(input,RULE_INT,FOLLOW_12); 

            					newLeafNode(lv_worstValue_11_0, grammarAccess.getLinearConversionAccess().getWorstValueINTTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getLinearConversionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"worstValue",
            						lv_worstValue_11_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_12=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_12, grammarAccess.getLinearConversionAccess().getRightCurlyBracketKeyword_12());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLinearConversion"


    // $ANTLR start "entryRuleQualToQMappings"
    // InternalTurn.g:2636:1: entryRuleQualToQMappings returns [EObject current=null] : iv_ruleQualToQMappings= ruleQualToQMappings EOF ;
    public final EObject entryRuleQualToQMappings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMappings = null;


        try {
            // InternalTurn.g:2636:56: (iv_ruleQualToQMappings= ruleQualToQMappings EOF )
            // InternalTurn.g:2637:2: iv_ruleQualToQMappings= ruleQualToQMappings EOF
            {
             newCompositeNode(grammarAccess.getQualToQMappingsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualToQMappings=ruleQualToQMappings();

            state._fsp--;

             current =iv_ruleQualToQMappings; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualToQMappings"


    // $ANTLR start "ruleQualToQMappings"
    // InternalTurn.g:2643:1: ruleQualToQMappings returns [EObject current=null] : (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) ;
    public final EObject ruleQualToQMappings() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_unit_5_0=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_mappings_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2649:2: ( (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) )
            // InternalTurn.g:2650:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            {
            // InternalTurn.g:2650:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            // InternalTurn.g:2651:3: otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getQualToQMappingsAccess().getMappingConversionKeyword_0());
            		
            // InternalTurn.g:2655:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2656:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2656:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2657:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2674:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2675:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2675:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2676:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_50); 

            			newLeafNode(otherlv_3, grammarAccess.getQualToQMappingsAccess().getLeftCurlyBracketKeyword_3());
            		
            otherlv_4=(Token)match(input,34,FOLLOW_6); 

            			newLeafNode(otherlv_4, grammarAccess.getQualToQMappingsAccess().getUnitKeyword_4());
            		
            // InternalTurn.g:2701:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTurn.g:2702:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTurn.g:2702:4: (lv_unit_5_0= RULE_STRING )
            // InternalTurn.g:2703:5: lv_unit_5_0= RULE_STRING
            {
            lv_unit_5_0=(Token)match(input,RULE_STRING,FOLLOW_55); 

            					newLeafNode(lv_unit_5_0, grammarAccess.getQualToQMappingsAccess().getUnitSTRINGTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualToQMappingsRule());
            					}
            					setWithLastConsumed(
            						current,
            						"unit",
            						lv_unit_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            // InternalTurn.g:2719:3: ( (lv_mappings_6_0= ruleQualToQMapping ) )+
            int cnt50=0;
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==43||LA50_0==46) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalTurn.g:2720:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    {
            	    // InternalTurn.g:2720:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    // InternalTurn.g:2721:5: lv_mappings_6_0= ruleQualToQMapping
            	    {

            	    					newCompositeNode(grammarAccess.getQualToQMappingsAccess().getMappingsQualToQMappingParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_56);
            	    lv_mappings_6_0=ruleQualToQMapping();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getQualToQMappingsRule());
            	    					}
            	    					add(
            	    						current,
            	    						"mappings",
            	    						lv_mappings_6_0,
            	    						"org.xtext.project.turn.Turn.QualToQMapping");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt50 >= 1 ) break loop50;
                        EarlyExitException eee =
                            new EarlyExitException(50, input);
                        throw eee;
                }
                cnt50++;
            } while (true);

            otherlv_7=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_7, grammarAccess.getQualToQMappingsAccess().getRightCurlyBracketKeyword_7());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualToQMappings"


    // $ANTLR start "entryRuleQualToQMapping"
    // InternalTurn.g:2746:1: entryRuleQualToQMapping returns [EObject current=null] : iv_ruleQualToQMapping= ruleQualToQMapping EOF ;
    public final EObject entryRuleQualToQMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMapping = null;


        try {
            // InternalTurn.g:2746:55: (iv_ruleQualToQMapping= ruleQualToQMapping EOF )
            // InternalTurn.g:2747:2: iv_ruleQualToQMapping= ruleQualToQMapping EOF
            {
             newCompositeNode(grammarAccess.getQualToQMappingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualToQMapping=ruleQualToQMapping();

            state._fsp--;

             current =iv_ruleQualToQMapping; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualToQMapping"


    // $ANTLR start "ruleQualToQMapping"
    // InternalTurn.g:2753:1: ruleQualToQMapping returns [EObject current=null] : ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleQualToQMapping() throws RecognitionException {
        EObject current = null;

        Token lv_exceeds_0_0=null;
        Token otherlv_1=null;
        Token lv_realWorldLabel_2_0=null;
        Token otherlv_3=null;
        Enumerator lv_qualitativeEvaluation_4_0 = null;

        AntlrDatatypeRuleToken lv_evaluation_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2759:2: ( ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:2760:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:2760:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:2761:3: ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:2761:3: ( (lv_exceeds_0_0= 'exceeding' ) )?
            int alt51=2;
            int LA51_0 = input.LA(1);

            if ( (LA51_0==43) ) {
                alt51=1;
            }
            switch (alt51) {
                case 1 :
                    // InternalTurn.g:2762:4: (lv_exceeds_0_0= 'exceeding' )
                    {
                    // InternalTurn.g:2762:4: (lv_exceeds_0_0= 'exceeding' )
                    // InternalTurn.g:2763:5: lv_exceeds_0_0= 'exceeding'
                    {
                    lv_exceeds_0_0=(Token)match(input,43,FOLLOW_57); 

                    					newLeafNode(lv_exceeds_0_0, grammarAccess.getQualToQMappingAccess().getExceedsExceedingKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getQualToQMappingRule());
                    					}
                    					setWithLastConsumed(current, "exceeds", true, "exceeding");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,46,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getQualToQMappingAccess().getRealKeyword_1());
            		
            // InternalTurn.g:2779:3: ( (lv_realWorldLabel_2_0= RULE_STRING ) )
            // InternalTurn.g:2780:4: (lv_realWorldLabel_2_0= RULE_STRING )
            {
            // InternalTurn.g:2780:4: (lv_realWorldLabel_2_0= RULE_STRING )
            // InternalTurn.g:2781:5: lv_realWorldLabel_2_0= RULE_STRING
            {
            lv_realWorldLabel_2_0=(Token)match(input,RULE_STRING,FOLLOW_23); 

            					newLeafNode(lv_realWorldLabel_2_0, grammarAccess.getQualToQMappingAccess().getRealWorldLabelSTRINGTerminalRuleCall_2_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getQualToQMappingRule());
            					}
            					setWithLastConsumed(
            						current,
            						"realWorldLabel",
            						lv_realWorldLabel_2_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_3=(Token)match(input,29,FOLLOW_47); 

            			newLeafNode(otherlv_3, grammarAccess.getQualToQMappingAccess().getHyphenMinusHyphenMinusGreaterThanSignKeyword_3());
            		
            // InternalTurn.g:2801:3: ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( ((LA52_0>=104 && LA52_0<=110)) ) {
                alt52=1;
            }
            else if ( (LA52_0==RULE_INT||(LA52_0>=54 && LA52_0<=55)) ) {
                alt52=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 52, 0, input);

                throw nvae;
            }
            switch (alt52) {
                case 1 :
                    // InternalTurn.g:2802:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    {
                    // InternalTurn.g:2802:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    // InternalTurn.g:2803:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    {
                    // InternalTurn.g:2803:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    // InternalTurn.g:2804:6: lv_qualitativeEvaluation_4_0= ruleQualitativeLabel
                    {

                    						newCompositeNode(grammarAccess.getQualToQMappingAccess().getQualitativeEvaluationQualitativeLabelEnumRuleCall_4_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_qualitativeEvaluation_4_0=ruleQualitativeLabel();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQualToQMappingRule());
                    						}
                    						set(
                    							current,
                    							"qualitativeEvaluation",
                    							lv_qualitativeEvaluation_4_0,
                    							"org.xtext.project.turn.Turn.QualitativeLabel");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:2822:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:2822:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:2823:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:2823:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    // InternalTurn.g:2824:6: lv_evaluation_5_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getQualToQMappingAccess().getEvaluationQuantitativeValueParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_evaluation_5_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getQualToQMappingRule());
                    						}
                    						set(
                    							current,
                    							"evaluation",
                    							lv_evaluation_5_0,
                    							"org.xtext.project.turn.Turn.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualToQMapping"


    // $ANTLR start "entryRuleContributionContextGroup"
    // InternalTurn.g:2846:1: entryRuleContributionContextGroup returns [EObject current=null] : iv_ruleContributionContextGroup= ruleContributionContextGroup EOF ;
    public final EObject entryRuleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContextGroup = null;


        try {
            // InternalTurn.g:2846:65: (iv_ruleContributionContextGroup= ruleContributionContextGroup EOF )
            // InternalTurn.g:2847:2: iv_ruleContributionContextGroup= ruleContributionContextGroup EOF
            {
             newCompositeNode(grammarAccess.getContributionContextGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionContextGroup=ruleContributionContextGroup();

            state._fsp--;

             current =iv_ruleContributionContextGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionContextGroup"


    // $ANTLR start "ruleContributionContextGroup"
    // InternalTurn.g:2853:1: ruleContributionContextGroup returns [EObject current=null] : (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
    public final EObject ruleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2859:2: ( (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:2860:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:2860:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:2861:3: otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextGroupAccess().getContributionContextGroupKeyword_0());
            		
            // InternalTurn.g:2865:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2866:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2866:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2867:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getContributionContextGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2884:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2885:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2885:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2886:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getContributionContextGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getContributionContextGroupAccess().getColonKeyword_3());
            		
            // InternalTurn.g:2907:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:2908:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:2908:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:2909:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionContextGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getContributionContextGroupAccess().getContribContributionContextCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:2920:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop53:
            do {
                int alt53=2;
                int LA53_0 = input.LA(1);

                if ( (LA53_0==23) ) {
                    alt53=1;
                }


                switch (alt53) {
            	case 1 :
            	    // InternalTurn.g:2921:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getContributionContextGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:2925:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:2926:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:2926:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:2927:6: otherlv_6= RULE_ID
            	    {

            	    						if (current==null) {
            	    							current = createModelElement(grammarAccess.getContributionContextGroupRule());
            	    						}
            	    					
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_16); 

            	    						newLeafNode(otherlv_6, grammarAccess.getContributionContextGroupAccess().getContribsContributionContextCrossReference_5_1_0());
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop53;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionContextGroup"


    // $ANTLR start "entryRuleContributionContext"
    // InternalTurn.g:2943:1: entryRuleContributionContext returns [EObject current=null] : iv_ruleContributionContext= ruleContributionContext EOF ;
    public final EObject entryRuleContributionContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContext = null;


        try {
            // InternalTurn.g:2943:60: (iv_ruleContributionContext= ruleContributionContext EOF )
            // InternalTurn.g:2944:2: iv_ruleContributionContext= ruleContributionContext EOF
            {
             newCompositeNode(grammarAccess.getContributionContextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionContext=ruleContributionContext();

            state._fsp--;

             current =iv_ruleContributionContext; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionContext"


    // $ANTLR start "ruleContributionContext"
    // InternalTurn.g:2950:1: ruleContributionContext returns [EObject current=null] : (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' ) ;
    public final EObject ruleContributionContext() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_changes_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2956:2: ( (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' ) )
            // InternalTurn.g:2957:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' )
            {
            // InternalTurn.g:2957:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' )
            // InternalTurn.g:2958:3: otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextAccess().getContributionContextKeyword_0());
            		
            // InternalTurn.g:2962:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2963:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2963:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2964:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getContributionContextAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:2981:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2982:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2982:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2983:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getContributionContextAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_44); 

            			newLeafNode(otherlv_3, grammarAccess.getContributionContextAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:3004:3: ( (lv_changes_4_0= ruleContributionChange ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( (LA54_0==RULE_ID) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalTurn.g:3005:4: (lv_changes_4_0= ruleContributionChange )
            	    {
            	    // InternalTurn.g:3005:4: (lv_changes_4_0= ruleContributionChange )
            	    // InternalTurn.g:3006:5: lv_changes_4_0= ruleContributionChange
            	    {

            	    					newCompositeNode(grammarAccess.getContributionContextAccess().getChangesContributionChangeParserRuleCall_4_0());
            	    				
            	    pushFollow(FOLLOW_44);
            	    lv_changes_4_0=ruleContributionChange();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getContributionContextRule());
            	    					}
            	    					add(
            	    						current,
            	    						"changes",
            	    						lv_changes_4_0,
            	    						"org.xtext.project.turn.Turn.ContributionChange");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
                }
            } while (true);

            // InternalTurn.g:3023:3: (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==42) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // InternalTurn.g:3024:4: otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )*
                    {
                    otherlv_5=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getContributionContextAccess().getIncludesKeyword_5_0());
                    			
                    // InternalTurn.g:3028:4: ( (otherlv_6= RULE_ID ) )
                    // InternalTurn.g:3029:5: (otherlv_6= RULE_ID )
                    {
                    // InternalTurn.g:3029:5: (otherlv_6= RULE_ID )
                    // InternalTurn.g:3030:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContributionContextRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_45); 

                    						newLeafNode(otherlv_6, grammarAccess.getContributionContextAccess().getIncludedContextContributionContextCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:3041:4: (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )*
                    loop55:
                    do {
                        int alt55=2;
                        int LA55_0 = input.LA(1);

                        if ( (LA55_0==23) ) {
                            alt55=1;
                        }


                        switch (alt55) {
                    	case 1 :
                    	    // InternalTurn.g:3042:5: otherlv_7= ',' ( (otherlv_8= RULE_ID ) )
                    	    {
                    	    otherlv_7=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getContributionContextAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalTurn.g:3046:5: ( (otherlv_8= RULE_ID ) )
                    	    // InternalTurn.g:3047:6: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalTurn.g:3047:6: (otherlv_8= RULE_ID )
                    	    // InternalTurn.g:3048:7: otherlv_8= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getContributionContextRule());
                    	    							}
                    	    						
                    	    otherlv_8=(Token)match(input,RULE_ID,FOLLOW_45); 

                    	    							newLeafNode(otherlv_8, grammarAccess.getContributionContextAccess().getIncludedContextsContributionContextCrossReference_5_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop55;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_9, grammarAccess.getContributionContextAccess().getRightCurlyBracketKeyword_6());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionContext"


    // $ANTLR start "entryRuleContributionChange"
    // InternalTurn.g:3069:1: entryRuleContributionChange returns [EObject current=null] : iv_ruleContributionChange= ruleContributionChange EOF ;
    public final EObject entryRuleContributionChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionChange = null;


        try {
            // InternalTurn.g:3069:59: (iv_ruleContributionChange= ruleContributionChange EOF )
            // InternalTurn.g:3070:2: iv_ruleContributionChange= ruleContributionChange EOF
            {
             newCompositeNode(grammarAccess.getContributionChangeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleContributionChange=ruleContributionChange();

            state._fsp--;

             current =iv_ruleContributionChange; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleContributionChange"


    // $ANTLR start "ruleContributionChange"
    // InternalTurn.g:3076:1: ruleContributionChange returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContributionChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_newContribution_2_0 = null;

        AntlrDatatypeRuleToken lv_newQuantitativeContribution_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3082:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:3083:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:3083:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:3084:3: ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:3084:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:3085:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:3085:4: ( ruleQualifiedName )
            // InternalTurn.g:3086:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionChangeRule());
            					}
            				

            					newCompositeNode(grammarAccess.getContributionChangeAccess().getContributionContributionCrossReference_0_0());
            				
            pushFollow(FOLLOW_36);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,37,FOLLOW_37); 

            			newLeafNode(otherlv_1, grammarAccess.getContributionChangeAccess().getWithKeyword_1());
            		
            // InternalTurn.g:3104:3: ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            int alt57=2;
            int LA57_0 = input.LA(1);

            if ( (LA57_0==109||(LA57_0>=117 && LA57_0<=122)) ) {
                alt57=1;
            }
            else if ( (LA57_0==RULE_INT||(LA57_0>=54 && LA57_0<=55)) ) {
                alt57=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 57, 0, input);

                throw nvae;
            }
            switch (alt57) {
                case 1 :
                    // InternalTurn.g:3105:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    {
                    // InternalTurn.g:3105:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    // InternalTurn.g:3106:5: (lv_newContribution_2_0= ruleContributionType )
                    {
                    // InternalTurn.g:3106:5: (lv_newContribution_2_0= ruleContributionType )
                    // InternalTurn.g:3107:6: lv_newContribution_2_0= ruleContributionType
                    {

                    						newCompositeNode(grammarAccess.getContributionChangeAccess().getNewContributionContributionTypeEnumRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_newContribution_2_0=ruleContributionType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionChangeRule());
                    						}
                    						set(
                    							current,
                    							"newContribution",
                    							lv_newContribution_2_0,
                    							"org.xtext.project.turn.Turn.ContributionType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:3125:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:3125:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:3126:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:3126:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    // InternalTurn.g:3127:6: lv_newQuantitativeContribution_3_0= ruleQuantitativeValue
                    {

                    						newCompositeNode(grammarAccess.getContributionChangeAccess().getNewQuantitativeContributionQuantitativeValueParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_newQuantitativeContribution_3_0=ruleQuantitativeValue();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getContributionChangeRule());
                    						}
                    						set(
                    							current,
                    							"newQuantitativeContribution",
                    							lv_newQuantitativeContribution_3_0,
                    							"org.xtext.project.turn.Turn.QuantitativeValue");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionChange"


    // $ANTLR start "entryRuleQuantitativeValue"
    // InternalTurn.g:3149:1: entryRuleQuantitativeValue returns [String current=null] : iv_ruleQuantitativeValue= ruleQuantitativeValue EOF ;
    public final String entryRuleQuantitativeValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQuantitativeValue = null;


        try {
            // InternalTurn.g:3149:57: (iv_ruleQuantitativeValue= ruleQuantitativeValue EOF )
            // InternalTurn.g:3150:2: iv_ruleQuantitativeValue= ruleQuantitativeValue EOF
            {
             newCompositeNode(grammarAccess.getQuantitativeValueRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQuantitativeValue=ruleQuantitativeValue();

            state._fsp--;

             current =iv_ruleQuantitativeValue.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQuantitativeValue"


    // $ANTLR start "ruleQuantitativeValue"
    // InternalTurn.g:3156:1: ruleQuantitativeValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleQuantitativeValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalTurn.g:3162:2: ( ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) )
            // InternalTurn.g:3163:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            {
            // InternalTurn.g:3163:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            // InternalTurn.g:3164:3: (kw= '-' | kw= '+' )? this_INT_2= RULE_INT
            {
            // InternalTurn.g:3164:3: (kw= '-' | kw= '+' )?
            int alt58=3;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==54) ) {
                alt58=1;
            }
            else if ( (LA58_0==55) ) {
                alt58=2;
            }
            switch (alt58) {
                case 1 :
                    // InternalTurn.g:3165:4: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_52); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getHyphenMinusKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3171:4: kw= '+'
                    {
                    kw=(Token)match(input,55,FOLLOW_52); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getPlusSignKeyword_0_1());
                    			

                    }
                    break;

            }

            this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); 

            			current.merge(this_INT_2);
            		

            			newLeafNode(this_INT_2, grammarAccess.getQuantitativeValueAccess().getINTTerminalRuleCall_1());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQuantitativeValue"


    // $ANTLR start "entryRuleUCMmap"
    // InternalTurn.g:3188:1: entryRuleUCMmap returns [EObject current=null] : iv_ruleUCMmap= ruleUCMmap EOF ;
    public final EObject entryRuleUCMmap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCMmap = null;


        try {
            // InternalTurn.g:3188:47: (iv_ruleUCMmap= ruleUCMmap EOF )
            // InternalTurn.g:3189:2: iv_ruleUCMmap= ruleUCMmap EOF
            {
             newCompositeNode(grammarAccess.getUCMmapRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleUCMmap=ruleUCMmap();

            state._fsp--;

             current =iv_ruleUCMmap; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUCMmap"


    // $ANTLR start "ruleUCMmap"
    // InternalTurn.g:3195:1: ruleUCMmap returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) ;
    public final EObject ruleUCMmap() throws RecognitionException {
        EObject current = null;

        Token lv_singleton_0_0=null;
        Token otherlv_1=null;
        Token otherlv_4=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_stubs_5_0 = null;

        EObject lv_paths_6_0 = null;

        EObject lv_components_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3201:2: ( ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) )
            // InternalTurn.g:3202:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            {
            // InternalTurn.g:3202:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            // InternalTurn.g:3203:3: ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}'
            {
            // InternalTurn.g:3203:3: ( (lv_singleton_0_0= 'singleton' ) )?
            int alt59=2;
            int LA59_0 = input.LA(1);

            if ( (LA59_0==56) ) {
                alt59=1;
            }
            switch (alt59) {
                case 1 :
                    // InternalTurn.g:3204:4: (lv_singleton_0_0= 'singleton' )
                    {
                    // InternalTurn.g:3204:4: (lv_singleton_0_0= 'singleton' )
                    // InternalTurn.g:3205:5: lv_singleton_0_0= 'singleton'
                    {
                    lv_singleton_0_0=(Token)match(input,56,FOLLOW_58); 

                    					newLeafNode(lv_singleton_0_0, grammarAccess.getUCMmapAccess().getSingletonSingletonKeyword_0_0());
                    				

                    					if (current==null) {
                    						current = createModelElement(grammarAccess.getUCMmapRule());
                    					}
                    					setWithLastConsumed(current, "singleton", true, "singleton");
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,57,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getUCMmapAccess().getMapKeyword_1());
            		
            // InternalTurn.g:3221:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:3222:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:3222:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:3223:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getUCMmapAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:3240:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:3241:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:3241:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:3242:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getUCMmapAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_4=(Token)match(input,13,FOLLOW_59); 

            			newLeafNode(otherlv_4, grammarAccess.getUCMmapAccess().getLeftCurlyBracketKeyword_4());
            		
            // InternalTurn.g:3263:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*
            loop60:
            do {
                int alt60=2;
                alt60 = dfa60.predict(input);
                switch (alt60) {
            	case 1 :
            	    // InternalTurn.g:3264:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    {
            	    // InternalTurn.g:3264:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    // InternalTurn.g:3265:5: lv_stubs_5_0= ruleStubDeclaration
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getStubsStubDeclarationParserRuleCall_5_0());
            	    				
            	    pushFollow(FOLLOW_59);
            	    lv_stubs_5_0=ruleStubDeclaration();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"stubs",
            	    						lv_stubs_5_0,
            	    						"org.xtext.project.turn.Turn.StubDeclaration");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop60;
                }
            } while (true);

            // InternalTurn.g:3282:3: ( (lv_paths_6_0= rulePath ) )*
            loop61:
            do {
                int alt61=2;
                int LA61_0 = input.LA(1);

                if ( (LA61_0==58||(LA61_0>=62 && LA61_0<=63)) ) {
                    alt61=1;
                }


                switch (alt61) {
            	case 1 :
            	    // InternalTurn.g:3283:4: (lv_paths_6_0= rulePath )
            	    {
            	    // InternalTurn.g:3283:4: (lv_paths_6_0= rulePath )
            	    // InternalTurn.g:3284:5: lv_paths_6_0= rulePath
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getPathsPathParserRuleCall_6_0());
            	    				
            	    pushFollow(FOLLOW_59);
            	    lv_paths_6_0=rulePath();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"paths",
            	    						lv_paths_6_0,
            	    						"org.xtext.project.turn.Turn.Path");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop61;
                }
            } while (true);

            // InternalTurn.g:3301:3: ( (lv_components_7_0= ruleComponentRef ) )*
            loop62:
            do {
                int alt62=2;
                int LA62_0 = input.LA(1);

                if ( (LA62_0==RULE_ID||LA62_0==32||LA62_0==90||(LA62_0>=129 && LA62_0<=133)) ) {
                    alt62=1;
                }


                switch (alt62) {
            	case 1 :
            	    // InternalTurn.g:3302:4: (lv_components_7_0= ruleComponentRef )
            	    {
            	    // InternalTurn.g:3302:4: (lv_components_7_0= ruleComponentRef )
            	    // InternalTurn.g:3303:5: lv_components_7_0= ruleComponentRef
            	    {

            	    					newCompositeNode(grammarAccess.getUCMmapAccess().getComponentsComponentRefParserRuleCall_7_0());
            	    				
            	    pushFollow(FOLLOW_60);
            	    lv_components_7_0=ruleComponentRef();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getUCMmapRule());
            	    					}
            	    					add(
            	    						current,
            	    						"components",
            	    						lv_components_7_0,
            	    						"org.xtext.project.turn.Turn.ComponentRef");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop62;
                }
            } while (true);

            otherlv_8=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_8, grammarAccess.getUCMmapAccess().getRightCurlyBracketKeyword_8());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUCMmap"


    // $ANTLR start "entryRulePath"
    // InternalTurn.g:3328:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalTurn.g:3328:45: (iv_rulePath= rulePath EOF )
            // InternalTurn.g:3329:2: iv_rulePath= rulePath EOF
            {
             newCompositeNode(grammarAccess.getPathRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePath=rulePath();

            state._fsp--;

             current =iv_rulePath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePath"


    // $ANTLR start "rulePath"
    // InternalTurn.g:3335:1: rulePath returns [EObject current=null] : ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        EObject lv_startPoint_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3341:2: ( ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTurn.g:3342:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTurn.g:3342:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTurn.g:3343:3: ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTurn.g:3343:3: ( (lv_startPoint_0_0= ruleStartPoint ) )
            // InternalTurn.g:3344:4: (lv_startPoint_0_0= ruleStartPoint )
            {
            // InternalTurn.g:3344:4: (lv_startPoint_0_0= ruleStartPoint )
            // InternalTurn.g:3345:5: lv_startPoint_0_0= ruleStartPoint
            {

            					newCompositeNode(grammarAccess.getPathAccess().getStartPointStartPointParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_61);
            lv_startPoint_0_0=ruleStartPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathRule());
            					}
            					set(
            						current,
            						"startPoint",
            						lv_startPoint_0_0,
            						"org.xtext.project.turn.Turn.StartPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:3362:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTurn.g:3363:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTurn.g:3363:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTurn.g:3364:5: lv_pathBody_1_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getPathAccess().getPathBodyPathBodyParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_pathBody_1_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getPathRule());
            					}
            					set(
            						current,
            						"pathBody",
            						lv_pathBody_1_0,
            						"org.xtext.project.turn.Turn.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePath"


    // $ANTLR start "entryRuleStartPoint"
    // InternalTurn.g:3385:1: entryRuleStartPoint returns [EObject current=null] : iv_ruleStartPoint= ruleStartPoint EOF ;
    public final EObject entryRuleStartPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartPoint = null;


        try {
            // InternalTurn.g:3385:51: (iv_ruleStartPoint= ruleStartPoint EOF )
            // InternalTurn.g:3386:2: iv_ruleStartPoint= ruleStartPoint EOF
            {
             newCompositeNode(grammarAccess.getStartPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStartPoint=ruleStartPoint();

            state._fsp--;

             current =iv_ruleStartPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStartPoint"


    // $ANTLR start "ruleStartPoint"
    // InternalTurn.g:3392:1: ruleStartPoint returns [EObject current=null] : ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) ) ;
    public final EObject ruleStartPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token lv_catches_9_0=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_precondition_3_0 = null;

        AntlrDatatypeRuleToken lv_failKind_4_0 = null;

        AntlrDatatypeRuleToken lv_name_5_0 = null;

        EObject lv_longName_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3398:2: ( ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) ) )
            // InternalTurn.g:3399:2: ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) )
            {
            // InternalTurn.g:3399:2: ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) )
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==58) ) {
                alt66=1;
            }
            else if ( ((LA66_0>=62 && LA66_0<=63)) ) {
                alt66=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 66, 0, input);

                throw nvae;
            }
            switch (alt66) {
                case 1 :
                    // InternalTurn.g:3400:3: (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? )
                    {
                    // InternalTurn.g:3400:3: (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? )
                    // InternalTurn.g:3401:4: otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )?
                    {
                    otherlv_0=(Token)match(input,58,FOLLOW_62); 

                    				newLeafNode(otherlv_0, grammarAccess.getStartPointAccess().getStartKeyword_0_0());
                    			
                    // InternalTurn.g:3405:4: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==RULE_ID) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // InternalTurn.g:3406:5: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTurn.g:3406:5: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTurn.g:3407:6: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:3407:6: (lv_name_1_0= ruleQualifiedName )
                            // InternalTurn.g:3408:7: lv_name_1_0= ruleQualifiedName
                            {

                            							newCompositeNode(grammarAccess.getStartPointAccess().getNameQualifiedNameParserRuleCall_0_1_0_0());
                            						
                            pushFollow(FOLLOW_63);
                            lv_name_1_0=ruleQualifiedName();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getStartPointRule());
                            							}
                            							set(
                            								current,
                            								"name",
                            								lv_name_1_0,
                            								"org.xtext.project.turn.Turn.QualifiedName");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }

                            // InternalTurn.g:3425:5: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTurn.g:3426:6: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTurn.g:3426:6: (lv_longName_2_0= ruleLongName )
                            // InternalTurn.g:3427:7: lv_longName_2_0= ruleLongName
                            {

                            							newCompositeNode(grammarAccess.getStartPointAccess().getLongNameLongNameParserRuleCall_0_1_1_0());
                            						
                            pushFollow(FOLLOW_64);
                            lv_longName_2_0=ruleLongName();

                            state._fsp--;


                            							if (current==null) {
                            								current = createModelElementForParent(grammarAccess.getStartPointRule());
                            							}
                            							set(
                            								current,
                            								"longName",
                            								lv_longName_2_0,
                            								"org.xtext.project.turn.Turn.LongName");
                            							afterParserOrEnumRuleCall();
                            						

                            }


                            }


                            }
                            break;

                    }

                    // InternalTurn.g:3445:4: ( (lv_precondition_3_0= ruleCondition ) )?
                    int alt64=2;
                    int LA64_0 = input.LA(1);

                    if ( (LA64_0==25) ) {
                        alt64=1;
                    }
                    switch (alt64) {
                        case 1 :
                            // InternalTurn.g:3446:5: (lv_precondition_3_0= ruleCondition )
                            {
                            // InternalTurn.g:3446:5: (lv_precondition_3_0= ruleCondition )
                            // InternalTurn.g:3447:6: lv_precondition_3_0= ruleCondition
                            {

                            						newCompositeNode(grammarAccess.getStartPointAccess().getPreconditionConditionParserRuleCall_0_2_0());
                            					
                            pushFollow(FOLLOW_2);
                            lv_precondition_3_0=ruleCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getStartPointRule());
                            						}
                            						set(
                            							current,
                            							"precondition",
                            							lv_precondition_3_0,
                            							"org.xtext.project.turn.Turn.Condition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:3466:3: ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? )
                    {
                    // InternalTurn.g:3466:3: ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? )
                    // InternalTurn.g:3467:4: ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )?
                    {
                    // InternalTurn.g:3467:4: ( (lv_failKind_4_0= ruleFailureKind ) )
                    // InternalTurn.g:3468:5: (lv_failKind_4_0= ruleFailureKind )
                    {
                    // InternalTurn.g:3468:5: (lv_failKind_4_0= ruleFailureKind )
                    // InternalTurn.g:3469:6: lv_failKind_4_0= ruleFailureKind
                    {

                    						newCompositeNode(grammarAccess.getStartPointAccess().getFailKindFailureKindParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_failKind_4_0=ruleFailureKind();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStartPointRule());
                    						}
                    						set(
                    							current,
                    							"failKind",
                    							lv_failKind_4_0,
                    							"org.xtext.project.turn.Turn.FailureKind");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3486:4: ( (lv_name_5_0= ruleQualifiedName ) )
                    // InternalTurn.g:3487:5: (lv_name_5_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:3487:5: (lv_name_5_0= ruleQualifiedName )
                    // InternalTurn.g:3488:6: lv_name_5_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getStartPointAccess().getNameQualifiedNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_65);
                    lv_name_5_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStartPointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_5_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3505:4: ( (lv_longName_6_0= ruleLongName ) )
                    // InternalTurn.g:3506:5: (lv_longName_6_0= ruleLongName )
                    {
                    // InternalTurn.g:3506:5: (lv_longName_6_0= ruleLongName )
                    // InternalTurn.g:3507:6: lv_longName_6_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getStartPointAccess().getLongNameLongNameParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_66);
                    lv_longName_6_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStartPointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_6_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3524:4: (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==59) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // InternalTurn.g:3525:5: otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]'
                            {
                            otherlv_7=(Token)match(input,59,FOLLOW_67); 

                            					newLeafNode(otherlv_7, grammarAccess.getStartPointAccess().getCatchesKeyword_1_3_0());
                            				
                            otherlv_8=(Token)match(input,60,FOLLOW_6); 

                            					newLeafNode(otherlv_8, grammarAccess.getStartPointAccess().getLeftSquareBracketLeftSquareBracketKeyword_1_3_1());
                            				
                            // InternalTurn.g:3533:5: ( (lv_catches_9_0= RULE_STRING ) )
                            // InternalTurn.g:3534:6: (lv_catches_9_0= RULE_STRING )
                            {
                            // InternalTurn.g:3534:6: (lv_catches_9_0= RULE_STRING )
                            // InternalTurn.g:3535:7: lv_catches_9_0= RULE_STRING
                            {
                            lv_catches_9_0=(Token)match(input,RULE_STRING,FOLLOW_68); 

                            							newLeafNode(lv_catches_9_0, grammarAccess.getStartPointAccess().getCatchesSTRINGTerminalRuleCall_1_3_2_0());
                            						

                            							if (current==null) {
                            								current = createModelElement(grammarAccess.getStartPointRule());
                            							}
                            							setWithLastConsumed(
                            								current,
                            								"catches",
                            								lv_catches_9_0,
                            								"org.eclipse.xtext.common.Terminals.STRING");
                            						

                            }


                            }

                            otherlv_10=(Token)match(input,61,FOLLOW_2); 

                            					newLeafNode(otherlv_10, grammarAccess.getStartPointAccess().getRightSquareBracketRightSquareBracketKeyword_1_3_3());
                            				

                            }
                            break;

                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStartPoint"


    // $ANTLR start "entryRuleFailureKind"
    // InternalTurn.g:3561:1: entryRuleFailureKind returns [String current=null] : iv_ruleFailureKind= ruleFailureKind EOF ;
    public final String entryRuleFailureKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFailureKind = null;


        try {
            // InternalTurn.g:3561:51: (iv_ruleFailureKind= ruleFailureKind EOF )
            // InternalTurn.g:3562:2: iv_ruleFailureKind= ruleFailureKind EOF
            {
             newCompositeNode(grammarAccess.getFailureKindRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailureKind=ruleFailureKind();

            state._fsp--;

             current =iv_ruleFailureKind.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailureKind"


    // $ANTLR start "ruleFailureKind"
    // InternalTurn.g:3568:1: ruleFailureKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abort' | kw= 'failure' ) ;
    public final AntlrDatatypeRuleToken ruleFailureKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:3574:2: ( (kw= 'abort' | kw= 'failure' ) )
            // InternalTurn.g:3575:2: (kw= 'abort' | kw= 'failure' )
            {
            // InternalTurn.g:3575:2: (kw= 'abort' | kw= 'failure' )
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==62) ) {
                alt67=1;
            }
            else if ( (LA67_0==63) ) {
                alt67=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 67, 0, input);

                throw nvae;
            }
            switch (alt67) {
                case 1 :
                    // InternalTurn.g:3576:3: kw= 'abort'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFailureKindAccess().getAbortKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3582:3: kw= 'failure'
                    {
                    kw=(Token)match(input,63,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFailureKindAccess().getFailureKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureKind"


    // $ANTLR start "entryRulePathBody"
    // InternalTurn.g:3591:1: entryRulePathBody returns [EObject current=null] : iv_rulePathBody= rulePathBody EOF ;
    public final EObject entryRulePathBody() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBody = null;


        try {
            // InternalTurn.g:3591:49: (iv_rulePathBody= rulePathBody EOF )
            // InternalTurn.g:3592:2: iv_rulePathBody= rulePathBody EOF
            {
             newCompositeNode(grammarAccess.getPathBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBody=rulePathBody();

            state._fsp--;

             current =iv_rulePathBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBody"


    // $ANTLR start "rulePathBody"
    // InternalTurn.g:3598:1: rulePathBody returns [EObject current=null] : this_PathWithRegularEnd_0= rulePathWithRegularEnd ;
    public final EObject rulePathBody() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithRegularEnd_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3604:2: (this_PathWithRegularEnd_0= rulePathWithRegularEnd )
            // InternalTurn.g:3605:2: this_PathWithRegularEnd_0= rulePathWithRegularEnd
            {

            		newCompositeNode(grammarAccess.getPathBodyAccess().getPathWithRegularEndParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_PathWithRegularEnd_0=rulePathWithRegularEnd();

            state._fsp--;


            		current = this_PathWithRegularEnd_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBody"


    // $ANTLR start "entryRulePathWithRegularEnd"
    // InternalTurn.g:3616:1: entryRulePathWithRegularEnd returns [EObject current=null] : iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF ;
    public final EObject entryRulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithRegularEnd = null;


        try {
            // InternalTurn.g:3616:59: (iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF )
            // InternalTurn.g:3617:2: iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF
            {
             newCompositeNode(grammarAccess.getPathWithRegularEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithRegularEnd=rulePathWithRegularEnd();

            state._fsp--;

             current =iv_rulePathWithRegularEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithRegularEnd"


    // $ANTLR start "rulePathWithRegularEnd"
    // InternalTurn.g:3623:1: rulePathWithRegularEnd returns [EObject current=null] : (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) ;
    public final EObject rulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithReferencedEnd_0 = null;

        EObject lv_pathEnd_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3629:2: ( (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) )
            // InternalTurn.g:3630:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            {
            // InternalTurn.g:3630:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            // InternalTurn.g:3631:3: this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            {

            			newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathWithReferencedEndParserRuleCall_0());
            		
            pushFollow(FOLLOW_69);
            this_PathWithReferencedEnd_0=rulePathWithReferencedEnd();

            state._fsp--;


            			current = this_PathWithReferencedEnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3639:3: ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==77||LA68_0==79||LA68_0==81||(LA68_0>=83 && LA68_0<=85)) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // InternalTurn.g:3640:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    {
                    // InternalTurn.g:3640:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    // InternalTurn.g:3641:5: lv_pathEnd_1_0= ruleRegularEnd
                    {

                    					newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathEndRegularEndParserRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_pathEnd_1_0=ruleRegularEnd();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPathWithRegularEndRule());
                    					}
                    					set(
                    						current,
                    						"pathEnd",
                    						lv_pathEnd_1_0,
                    						"org.xtext.project.turn.Turn.RegularEnd");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithRegularEnd"


    // $ANTLR start "entryRulePathWithReferencedEnd"
    // InternalTurn.g:3662:1: entryRulePathWithReferencedEnd returns [EObject current=null] : iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF ;
    public final EObject entryRulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedEnd = null;


        try {
            // InternalTurn.g:3662:62: (iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF )
            // InternalTurn.g:3663:2: iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF
            {
             newCompositeNode(grammarAccess.getPathWithReferencedEndRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithReferencedEnd=rulePathWithReferencedEnd();

            state._fsp--;

             current =iv_rulePathWithReferencedEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithReferencedEnd"


    // $ANTLR start "rulePathWithReferencedEnd"
    // InternalTurn.g:3669:1: rulePathWithReferencedEnd returns [EObject current=null] : (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) ;
    public final EObject rulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_PathWithReferencedStub_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3675:2: ( (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) )
            // InternalTurn.g:3676:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            {
            // InternalTurn.g:3676:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            // InternalTurn.g:3677:3: this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedEndAccess().getPathWithReferencedStubParserRuleCall_0());
            		
            pushFollow(FOLLOW_70);
            this_PathWithReferencedStub_0=rulePathWithReferencedStub();

            state._fsp--;


            			current = this_PathWithReferencedStub_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3685:3: ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            int alt70=2;
            int LA70_0 = input.LA(1);

            if ( (LA70_0==RULE_ID) ) {
                int LA70_1 = input.LA(2);

                if ( (LA70_1==64) ) {
                    alt70=1;
                }
            }
            else if ( (LA70_0==64) ) {
                alt70=1;
            }
            switch (alt70) {
                case 1 :
                    // InternalTurn.g:3686:4: ( (otherlv_1= RULE_ID ) )? otherlv_2= ';'
                    {
                    // InternalTurn.g:3686:4: ( (otherlv_1= RULE_ID ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==RULE_ID) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalTurn.g:3687:5: (otherlv_1= RULE_ID )
                            {
                            // InternalTurn.g:3687:5: (otherlv_1= RULE_ID )
                            // InternalTurn.g:3688:6: otherlv_1= RULE_ID
                            {

                            						if (current==null) {
                            							current = createModelElement(grammarAccess.getPathWithReferencedEndRule());
                            						}
                            					
                            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_71); 

                            						newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedEndAccess().getReferencedEndReferencedEndCrossReference_1_0_0());
                            					

                            }


                            }
                            break;

                    }

                    otherlv_2=(Token)match(input,64,FOLLOW_2); 

                    				newLeafNode(otherlv_2, grammarAccess.getPathWithReferencedEndAccess().getSemicolonKeyword_1_1());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithReferencedEnd"


    // $ANTLR start "entryRulePathWithReferencedStub"
    // InternalTurn.g:3708:1: entryRulePathWithReferencedStub returns [EObject current=null] : iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF ;
    public final EObject entryRulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedStub = null;


        try {
            // InternalTurn.g:3708:63: (iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF )
            // InternalTurn.g:3709:2: iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF
            {
             newCompositeNode(grammarAccess.getPathWithReferencedStubRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathWithReferencedStub=rulePathWithReferencedStub();

            state._fsp--;

             current =iv_rulePathWithReferencedStub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathWithReferencedStub"


    // $ANTLR start "rulePathWithReferencedStub"
    // InternalTurn.g:3715:1: rulePathWithReferencedStub returns [EObject current=null] : (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) ;
    public final EObject rulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PathBodyNodes_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3721:2: ( (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) )
            // InternalTurn.g:3722:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            {
            // InternalTurn.g:3722:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            // InternalTurn.g:3723:3: this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getPathBodyNodesParserRuleCall_0());
            		
            pushFollow(FOLLOW_72);
            this_PathBodyNodes_0=rulePathBodyNodes();

            state._fsp--;


            			current = this_PathBodyNodes_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3731:3: (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==65) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalTurn.g:3732:4: otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';'
                    {
                    otherlv_1=(Token)match(input,65,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedStubAccess().getInKeyword_1_0());
                    			
                    // InternalTurn.g:3736:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:3737:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:3737:5: ( ruleQualifiedName )
                    // InternalTurn.g:3738:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getPathWithReferencedStubRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getReferencedStubStubCrossReference_1_1_0());
                    					
                    pushFollow(FOLLOW_52);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:3752:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTurn.g:3753:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:3753:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTurn.g:3754:6: lv_index_3_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getIndexPositiveIntegerParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_71);
                    lv_index_3_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPathWithReferencedStubRule());
                    						}
                    						set(
                    							current,
                    							"index",
                    							lv_index_3_0,
                    							"org.xtext.project.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,64,FOLLOW_2); 

                    				newLeafNode(otherlv_4, grammarAccess.getPathWithReferencedStubAccess().getSemicolonKeyword_1_3());
                    			

                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathWithReferencedStub"


    // $ANTLR start "entryRulePathBodyNodes"
    // InternalTurn.g:3780:1: entryRulePathBodyNodes returns [EObject current=null] : iv_rulePathBodyNodes= rulePathBodyNodes EOF ;
    public final EObject entryRulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNodes = null;


        try {
            // InternalTurn.g:3780:54: (iv_rulePathBodyNodes= rulePathBodyNodes EOF )
            // InternalTurn.g:3781:2: iv_rulePathBodyNodes= rulePathBodyNodes EOF
            {
             newCompositeNode(grammarAccess.getPathBodyNodesRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBodyNodes=rulePathBodyNodes();

            state._fsp--;

             current =iv_rulePathBodyNodes; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBodyNodes"


    // $ANTLR start "rulePathBodyNodes"
    // InternalTurn.g:3787:1: rulePathBodyNodes returns [EObject current=null] : ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) ;
    public final EObject rulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_pathNodes_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3793:2: ( ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) )
            // InternalTurn.g:3794:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            {
            // InternalTurn.g:3794:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            // InternalTurn.g:3795:3: () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            {
            // InternalTurn.g:3795:3: ()
            // InternalTurn.g:3796:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getPathBodyNodesAccess().getPathBodyNodesAction_0(),
            					current);
            			

            }


            			newCompositeNode(grammarAccess.getPathBodyNodesAccess().getArrowParserRuleCall_1());
            		
            pushFollow(FOLLOW_73);
            ruleArrow();

            state._fsp--;


            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3809:3: ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            loop72:
            do {
                int alt72=2;
                int LA72_0 = input.LA(1);

                if ( ((LA72_0>=67 && LA72_0<=73)||(LA72_0>=75 && LA72_0<=76)||(LA72_0>=127 && LA72_0<=128)) ) {
                    alt72=1;
                }


                switch (alt72) {
            	case 1 :
            	    // InternalTurn.g:3810:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->'
            	    {
            	    // InternalTurn.g:3810:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) )
            	    // InternalTurn.g:3811:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    {
            	    // InternalTurn.g:3811:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    // InternalTurn.g:3812:6: lv_pathNodes_2_0= rulePathBodyNode
            	    {

            	    						newCompositeNode(grammarAccess.getPathBodyNodesAccess().getPathNodesPathBodyNodeParserRuleCall_2_0_0());
            	    					
            	    pushFollow(FOLLOW_61);
            	    lv_pathNodes_2_0=rulePathBodyNode();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getPathBodyNodesRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pathNodes",
            	    							lv_pathNodes_2_0,
            	    							"org.xtext.project.turn.Turn.PathBodyNode");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }

            	    otherlv_3=(Token)match(input,66,FOLLOW_73); 

            	    				newLeafNode(otherlv_3, grammarAccess.getPathBodyNodesAccess().getHyphenMinusGreaterThanSignKeyword_2_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop72;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBodyNodes"


    // $ANTLR start "entryRuleArrow"
    // InternalTurn.g:3838:1: entryRuleArrow returns [String current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final String entryRuleArrow() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrow = null;


        try {
            // InternalTurn.g:3838:45: (iv_ruleArrow= ruleArrow EOF )
            // InternalTurn.g:3839:2: iv_ruleArrow= ruleArrow EOF
            {
             newCompositeNode(grammarAccess.getArrowRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleArrow=ruleArrow();

            state._fsp--;

             current =iv_ruleArrow.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleArrow"


    // $ANTLR start "ruleArrow"
    // InternalTurn.g:3845:1: ruleArrow returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '->' ;
    public final AntlrDatatypeRuleToken ruleArrow() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:3851:2: (kw= '->' )
            // InternalTurn.g:3852:2: kw= '->'
            {
            kw=(Token)match(input,66,FOLLOW_2); 

            		current.merge(kw);
            		newLeafNode(kw, grammarAccess.getArrowAccess().getHyphenMinusGreaterThanSignKeyword());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleArrow"


    // $ANTLR start "entryRulePathBodyNode"
    // InternalTurn.g:3860:1: entryRulePathBodyNode returns [EObject current=null] : iv_rulePathBodyNode= rulePathBodyNode EOF ;
    public final EObject entryRulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNode = null;


        try {
            // InternalTurn.g:3860:53: (iv_rulePathBodyNode= rulePathBodyNode EOF )
            // InternalTurn.g:3861:2: iv_rulePathBodyNode= rulePathBodyNode EOF
            {
             newCompositeNode(grammarAccess.getPathBodyNodeRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePathBodyNode=rulePathBodyNode();

            state._fsp--;

             current =iv_rulePathBodyNode; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePathBodyNode"


    // $ANTLR start "rulePathBodyNode"
    // InternalTurn.g:3867:1: rulePathBodyNode returns [EObject current=null] : (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) ;
    public final EObject rulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject this_AndJoin_0 = null;

        EObject this_RespRef_1 = null;

        EObject this_OrJoin_2 = null;

        EObject this_WaitingPlace_3 = null;

        EObject this_FailurePoint_4 = null;

        EObject this_Timer_5 = null;

        EObject this_Connect_6 = null;



        	enterRule();

        try {
            // InternalTurn.g:3873:2: ( (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) )
            // InternalTurn.g:3874:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            {
            // InternalTurn.g:3874:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            int alt73=7;
            alt73 = dfa73.predict(input);
            switch (alt73) {
                case 1 :
                    // InternalTurn.g:3875:3: this_AndJoin_0= ruleAndJoin
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getAndJoinParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndJoin_0=ruleAndJoin();

                    state._fsp--;


                    			current = this_AndJoin_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3884:3: this_RespRef_1= ruleRespRef
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getRespRefParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_RespRef_1=ruleRespRef();

                    state._fsp--;


                    			current = this_RespRef_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:3893:3: this_OrJoin_2= ruleOrJoin
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getOrJoinParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrJoin_2=ruleOrJoin();

                    state._fsp--;


                    			current = this_OrJoin_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:3902:3: this_WaitingPlace_3= ruleWaitingPlace
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getWaitingPlaceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_WaitingPlace_3=ruleWaitingPlace();

                    state._fsp--;


                    			current = this_WaitingPlace_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalTurn.g:3911:3: this_FailurePoint_4= ruleFailurePoint
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getFailurePointParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_FailurePoint_4=ruleFailurePoint();

                    state._fsp--;


                    			current = this_FailurePoint_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalTurn.g:3920:3: this_Timer_5= ruleTimer
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getTimerParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Timer_5=ruleTimer();

                    state._fsp--;


                    			current = this_Timer_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalTurn.g:3929:3: this_Connect_6= ruleConnect
                    {

                    			newCompositeNode(grammarAccess.getPathBodyNodeAccess().getConnectParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Connect_6=ruleConnect();

                    state._fsp--;


                    			current = this_Connect_6;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePathBodyNode"


    // $ANTLR start "entryRuleRegularEnd"
    // InternalTurn.g:3941:1: entryRuleRegularEnd returns [EObject current=null] : iv_ruleRegularEnd= ruleRegularEnd EOF ;
    public final EObject entryRuleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEnd = null;


        try {
            // InternalTurn.g:3941:51: (iv_ruleRegularEnd= ruleRegularEnd EOF )
            // InternalTurn.g:3942:2: iv_ruleRegularEnd= ruleRegularEnd EOF
            {
             newCompositeNode(grammarAccess.getRegularEndRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularEnd=ruleRegularEnd();

            state._fsp--;

             current =iv_ruleRegularEnd; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularEnd"


    // $ANTLR start "ruleRegularEnd"
    // InternalTurn.g:3948:1: ruleRegularEnd returns [EObject current=null] : (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) ;
    public final EObject ruleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_EndpointWithConnect_0 = null;

        EObject this_AndFork_1 = null;

        EObject this_OrFork_2 = null;

        EObject this_Stub_3 = null;



        	enterRule();

        try {
            // InternalTurn.g:3954:2: ( (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) )
            // InternalTurn.g:3955:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            {
            // InternalTurn.g:3955:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            int alt74=4;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt74=1;
                }
                break;
            case 81:
                {
                alt74=2;
                }
                break;
            case 79:
                {
                alt74=3;
                }
                break;
            case 83:
            case 84:
            case 85:
                {
                alt74=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 74, 0, input);

                throw nvae;
            }

            switch (alt74) {
                case 1 :
                    // InternalTurn.g:3956:3: this_EndpointWithConnect_0= ruleEndpointWithConnect
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getEndpointWithConnectParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_EndpointWithConnect_0=ruleEndpointWithConnect();

                    state._fsp--;


                    			current = this_EndpointWithConnect_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3965:3: this_AndFork_1= ruleAndFork
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getAndForkParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_AndFork_1=ruleAndFork();

                    state._fsp--;


                    			current = this_AndFork_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:3974:3: this_OrFork_2= ruleOrFork
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getOrForkParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_OrFork_2=ruleOrFork();

                    state._fsp--;


                    			current = this_OrFork_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:3983:3: this_Stub_3= ruleStub
                    {

                    			newCompositeNode(grammarAccess.getRegularEndAccess().getStubParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Stub_3=ruleStub();

                    state._fsp--;


                    			current = this_Stub_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularEnd"


    // $ANTLR start "entryRuleEndpointWithConnect"
    // InternalTurn.g:3995:1: entryRuleEndpointWithConnect returns [EObject current=null] : iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF ;
    public final EObject entryRuleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointWithConnect = null;


        try {
            // InternalTurn.g:3995:60: (iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF )
            // InternalTurn.g:3996:2: iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF
            {
             newCompositeNode(grammarAccess.getEndpointWithConnectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndpointWithConnect=ruleEndpointWithConnect();

            state._fsp--;

             current =iv_ruleEndpointWithConnect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndpointWithConnect"


    // $ANTLR start "ruleEndpointWithConnect"
    // InternalTurn.g:4002:1: ruleEndpointWithConnect returns [EObject current=null] : ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) ;
    public final EObject ruleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_regularEnd_0_0 = null;

        EObject lv_connect_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4008:2: ( ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) )
            // InternalTurn.g:4009:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            {
            // InternalTurn.g:4009:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            // InternalTurn.g:4010:3: ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            {
            // InternalTurn.g:4010:3: ( (lv_regularEnd_0_0= ruleEndPoint ) )
            // InternalTurn.g:4011:4: (lv_regularEnd_0_0= ruleEndPoint )
            {
            // InternalTurn.g:4011:4: (lv_regularEnd_0_0= ruleEndPoint )
            // InternalTurn.g:4012:5: lv_regularEnd_0_0= ruleEndPoint
            {

            					newCompositeNode(grammarAccess.getEndpointWithConnectAccess().getRegularEndEndPointParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_74);
            lv_regularEnd_0_0=ruleEndPoint();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEndpointWithConnectRule());
            					}
            					set(
            						current,
            						"regularEnd",
            						lv_regularEnd_0_0,
            						"org.xtext.project.turn.Turn.EndPoint");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4029:3: (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==66) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalTurn.g:4030:4: otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) )
                    {
                    otherlv_1=(Token)match(input,66,FOLLOW_75); 

                    				newLeafNode(otherlv_1, grammarAccess.getEndpointWithConnectAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                    			
                    // InternalTurn.g:4034:4: ( (lv_connect_2_0= ruleConnect ) )
                    // InternalTurn.g:4035:5: (lv_connect_2_0= ruleConnect )
                    {
                    // InternalTurn.g:4035:5: (lv_connect_2_0= ruleConnect )
                    // InternalTurn.g:4036:6: lv_connect_2_0= ruleConnect
                    {

                    						newCompositeNode(grammarAccess.getEndpointWithConnectAccess().getConnectConnectParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_connect_2_0=ruleConnect();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndpointWithConnectRule());
                    						}
                    						set(
                    							current,
                    							"connect",
                    							lv_connect_2_0,
                    							"org.xtext.project.turn.Turn.Connect");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndpointWithConnect"


    // $ANTLR start "entryRuleRespRef"
    // InternalTurn.g:4058:1: entryRuleRespRef returns [EObject current=null] : iv_ruleRespRef= ruleRespRef EOF ;
    public final EObject entryRuleRespRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRespRef = null;


        try {
            // InternalTurn.g:4058:48: (iv_ruleRespRef= ruleRespRef EOF )
            // InternalTurn.g:4059:2: iv_ruleRespRef= ruleRespRef EOF
            {
             newCompositeNode(grammarAccess.getRespRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRespRef=ruleRespRef();

            state._fsp--;

             current =iv_ruleRespRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRespRef"


    // $ANTLR start "ruleRespRef"
    // InternalTurn.g:4065:1: ruleRespRef returns [EObject current=null] : (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) ;
    public final EObject ruleRespRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4071:2: ( (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) )
            // InternalTurn.g:4072:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4072:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            // InternalTurn.g:4073:3: otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRespRefAccess().getXKeyword_0());
            		
            // InternalTurn.g:4077:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:4078:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:4078:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:4079:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getRespRefAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_76);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRespRefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4096:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:4097:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:4097:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:4098:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getRespRefAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRespRefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRespRef"


    // $ANTLR start "entryRuleOrJoin"
    // InternalTurn.g:4119:1: entryRuleOrJoin returns [EObject current=null] : iv_ruleOrJoin= ruleOrJoin EOF ;
    public final EObject entryRuleOrJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrJoin = null;


        try {
            // InternalTurn.g:4119:47: (iv_ruleOrJoin= ruleOrJoin EOF )
            // InternalTurn.g:4120:2: iv_ruleOrJoin= ruleOrJoin EOF
            {
             newCompositeNode(grammarAccess.getOrJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrJoin=ruleOrJoin();

            state._fsp--;

             current =iv_ruleOrJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrJoin"


    // $ANTLR start "ruleOrJoin"
    // InternalTurn.g:4126:1: ruleOrJoin returns [EObject current=null] : ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) ;
    public final EObject ruleOrJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4132:2: ( ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) )
            // InternalTurn.g:4133:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4133:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            // InternalTurn.g:4134:3: () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
            {
            // InternalTurn.g:4134:3: ()
            // InternalTurn.g:4135:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOrJoinAccess().getOrJoinAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,68,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOrJoinAccess().getJoinKeyword_1());
            		
            // InternalTurn.g:4145:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:4146:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:4146:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:4147:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getOrJoinAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_76);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4164:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:4165:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:4165:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:4166:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getOrJoinAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getOrJoinRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrJoin"


    // $ANTLR start "entryRuleAndJoin"
    // InternalTurn.g:4187:1: entryRuleAndJoin returns [EObject current=null] : iv_ruleAndJoin= ruleAndJoin EOF ;
    public final EObject entryRuleAndJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndJoin = null;


        try {
            // InternalTurn.g:4187:48: (iv_ruleAndJoin= ruleAndJoin EOF )
            // InternalTurn.g:4188:2: iv_ruleAndJoin= ruleAndJoin EOF
            {
             newCompositeNode(grammarAccess.getAndJoinRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndJoin=ruleAndJoin();

            state._fsp--;

             current =iv_ruleAndJoin; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndJoin"


    // $ANTLR start "ruleAndJoin"
    // InternalTurn.g:4194:1: ruleAndJoin returns [EObject current=null] : ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) ;
    public final EObject ruleAndJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_longName_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4200:2: ( ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) )
            // InternalTurn.g:4201:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4201:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            // InternalTurn.g:4202:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
            {
            // InternalTurn.g:4202:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' )
            int alt76=3;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt76=1;
                }
                break;
            case 70:
                {
                alt76=2;
                }
                break;
            case 71:
                {
                alt76=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 76, 0, input);

                throw nvae;
            }

            switch (alt76) {
                case 1 :
                    // InternalTurn.g:4203:4: otherlv_0= 'synch'
                    {
                    otherlv_0=(Token)match(input,69,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getAndJoinAccess().getSynchKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:4208:4: otherlv_1= 'sync'
                    {
                    otherlv_1=(Token)match(input,70,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getAndJoinAccess().getSyncKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalTurn.g:4213:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,71,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAndJoinAccess().getVerticalLineKeyword_0_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:4218:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalTurn.g:4219:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalTurn.g:4219:4: (lv_name_3_0= ruleQualifiedName )
            // InternalTurn.g:4220:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getAndJoinAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_76);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndJoinRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:4237:3: ( (lv_longName_4_0= ruleLongName ) )
            // InternalTurn.g:4238:4: (lv_longName_4_0= ruleLongName )
            {
            // InternalTurn.g:4238:4: (lv_longName_4_0= ruleLongName )
            // InternalTurn.g:4239:5: lv_longName_4_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getAndJoinAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_4_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getAndJoinRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_4_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndJoin"


    // $ANTLR start "entryRuleWaitingPlace"
    // InternalTurn.g:4260:1: entryRuleWaitingPlace returns [EObject current=null] : iv_ruleWaitingPlace= ruleWaitingPlace EOF ;
    public final EObject entryRuleWaitingPlace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWaitingPlace = null;


        try {
            // InternalTurn.g:4260:53: (iv_ruleWaitingPlace= ruleWaitingPlace EOF )
            // InternalTurn.g:4261:2: iv_ruleWaitingPlace= ruleWaitingPlace EOF
            {
             newCompositeNode(grammarAccess.getWaitingPlaceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleWaitingPlace=ruleWaitingPlace();

            state._fsp--;

             current =iv_ruleWaitingPlace; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleWaitingPlace"


    // $ANTLR start "ruleWaitingPlace"
    // InternalTurn.g:4267:1: ruleWaitingPlace returns [EObject current=null] : ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) ;
    public final EObject ruleWaitingPlace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_kind_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4273:2: ( ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) )
            // InternalTurn.g:4274:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            {
            // InternalTurn.g:4274:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            // InternalTurn.g:4275:3: ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )?
            {
            // InternalTurn.g:4275:3: ( (lv_kind_0_0= ruleWAITKIND ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( ((LA77_0>=127 && LA77_0<=128)) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalTurn.g:4276:4: (lv_kind_0_0= ruleWAITKIND )
                    {
                    // InternalTurn.g:4276:4: (lv_kind_0_0= ruleWAITKIND )
                    // InternalTurn.g:4277:5: lv_kind_0_0= ruleWAITKIND
                    {

                    					newCompositeNode(grammarAccess.getWaitingPlaceAccess().getKindWAITKINDEnumRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_77);
                    lv_kind_0_0=ruleWAITKIND();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_0_0,
                    						"org.xtext.project.turn.Turn.WAITKIND");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,72,FOLLOW_62); 

            			newLeafNode(otherlv_1, grammarAccess.getWaitingPlaceAccess().getWaitKeyword_1());
            		
            // InternalTurn.g:4298:3: ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )?
            int alt78=2;
            int LA78_0 = input.LA(1);

            if ( (LA78_0==RULE_ID) ) {
                alt78=1;
            }
            switch (alt78) {
                case 1 :
                    // InternalTurn.g:4299:4: ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4299:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalTurn.g:4300:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4300:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalTurn.g:4301:6: lv_name_2_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getWaitingPlaceAccess().getNameQualifiedNameParserRuleCall_2_0_0());
                    					
                    pushFollow(FOLLOW_63);
                    lv_name_2_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_2_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4318:4: ( (lv_longName_3_0= ruleLongName ) )
                    // InternalTurn.g:4319:5: (lv_longName_3_0= ruleLongName )
                    {
                    // InternalTurn.g:4319:5: (lv_longName_3_0= ruleLongName )
                    // InternalTurn.g:4320:6: lv_longName_3_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getWaitingPlaceAccess().getLongNameLongNameParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_64);
                    lv_longName_3_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_3_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4338:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt79=2;
            int LA79_0 = input.LA(1);

            if ( (LA79_0==25) ) {
                alt79=1;
            }
            switch (alt79) {
                case 1 :
                    // InternalTurn.g:4339:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTurn.g:4339:4: (lv_condition_4_0= ruleCondition )
                    // InternalTurn.g:4340:5: lv_condition_4_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getWaitingPlaceAccess().getConditionConditionParserRuleCall_3_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_condition_4_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getWaitingPlaceRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_4_0,
                    						"org.xtext.project.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWaitingPlace"


    // $ANTLR start "entryRuleTimer"
    // InternalTurn.g:4361:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalTurn.g:4361:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalTurn.g:4362:2: iv_ruleTimer= ruleTimer EOF
            {
             newCompositeNode(grammarAccess.getTimerRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTimer=ruleTimer();

            state._fsp--;

             current =iv_ruleTimer; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTimer"


    // $ANTLR start "ruleTimer"
    // InternalTurn.g:4368:1: ruleTimer returns [EObject current=null] : ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? ) ;
    public final EObject ruleTimer() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_9=null;
        Enumerator lv_kind_1_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_longName_4_0 = null;

        EObject lv_timeoutCondition_7_0 = null;

        EObject lv_timeoutPath_8_0 = null;

        EObject lv_condition_10_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4374:2: ( ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? ) )
            // InternalTurn.g:4375:2: ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? )
            {
            // InternalTurn.g:4375:2: ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? )
            // InternalTurn.g:4376:3: () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )?
            {
            // InternalTurn.g:4376:3: ()
            // InternalTurn.g:4377:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimerAccess().getTimerAction_0(),
            					current);
            			

            }

            // InternalTurn.g:4383:3: ( (lv_kind_1_0= ruleWAITKIND ) )?
            int alt80=2;
            int LA80_0 = input.LA(1);

            if ( ((LA80_0>=127 && LA80_0<=128)) ) {
                alt80=1;
            }
            switch (alt80) {
                case 1 :
                    // InternalTurn.g:4384:4: (lv_kind_1_0= ruleWAITKIND )
                    {
                    // InternalTurn.g:4384:4: (lv_kind_1_0= ruleWAITKIND )
                    // InternalTurn.g:4385:5: lv_kind_1_0= ruleWAITKIND
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getKindWAITKINDEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_78);
                    lv_kind_1_0=ruleWAITKIND();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_1_0,
                    						"org.xtext.project.turn.Turn.WAITKIND");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,73,FOLLOW_79); 

            			newLeafNode(otherlv_2, grammarAccess.getTimerAccess().getTimerKeyword_2());
            		
            // InternalTurn.g:4406:3: ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==RULE_ID) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalTurn.g:4407:4: ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4407:4: ( (lv_name_3_0= ruleQualifiedName ) )
                    // InternalTurn.g:4408:5: (lv_name_3_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4408:5: (lv_name_3_0= ruleQualifiedName )
                    // InternalTurn.g:4409:6: lv_name_3_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getTimerAccess().getNameQualifiedNameParserRuleCall_3_0_0());
                    					
                    pushFollow(FOLLOW_80);
                    lv_name_3_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimerRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_3_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4426:4: ( (lv_longName_4_0= ruleLongName ) )
                    // InternalTurn.g:4427:5: (lv_longName_4_0= ruleLongName )
                    {
                    // InternalTurn.g:4427:5: (lv_longName_4_0= ruleLongName )
                    // InternalTurn.g:4428:6: lv_longName_4_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getTimerAccess().getLongNameLongNameParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_81);
                    lv_longName_4_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getTimerRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_4_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4446:3: (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==13) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalTurn.g:4447:4: otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_82); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimerAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTurn.g:4451:4: (otherlv_6= 'timeout' )?
                    int alt82=2;
                    int LA82_0 = input.LA(1);

                    if ( (LA82_0==74) ) {
                        alt82=1;
                    }
                    switch (alt82) {
                        case 1 :
                            // InternalTurn.g:4452:5: otherlv_6= 'timeout'
                            {
                            otherlv_6=(Token)match(input,74,FOLLOW_83); 

                            					newLeafNode(otherlv_6, grammarAccess.getTimerAccess().getTimeoutKeyword_4_1());
                            				

                            }
                            break;

                    }

                    // InternalTurn.g:4457:4: ( (lv_timeoutCondition_7_0= ruleCondition ) )?
                    int alt83=2;
                    int LA83_0 = input.LA(1);

                    if ( (LA83_0==25) ) {
                        alt83=1;
                    }
                    switch (alt83) {
                        case 1 :
                            // InternalTurn.g:4458:5: (lv_timeoutCondition_7_0= ruleCondition )
                            {
                            // InternalTurn.g:4458:5: (lv_timeoutCondition_7_0= ruleCondition )
                            // InternalTurn.g:4459:6: lv_timeoutCondition_7_0= ruleCondition
                            {

                            						newCompositeNode(grammarAccess.getTimerAccess().getTimeoutConditionConditionParserRuleCall_4_2_0());
                            					
                            pushFollow(FOLLOW_84);
                            lv_timeoutCondition_7_0=ruleCondition();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getTimerRule());
                            						}
                            						set(
                            							current,
                            							"timeoutCondition",
                            							lv_timeoutCondition_7_0,
                            							"org.xtext.project.turn.Turn.Condition");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    // InternalTurn.g:4476:4: ( (lv_timeoutPath_8_0= rulePathBody ) )?
                    int alt84=2;
                    int LA84_0 = input.LA(1);

                    if ( (LA84_0==66) ) {
                        alt84=1;
                    }
                    switch (alt84) {
                        case 1 :
                            // InternalTurn.g:4477:5: (lv_timeoutPath_8_0= rulePathBody )
                            {
                            // InternalTurn.g:4477:5: (lv_timeoutPath_8_0= rulePathBody )
                            // InternalTurn.g:4478:6: lv_timeoutPath_8_0= rulePathBody
                            {

                            						newCompositeNode(grammarAccess.getTimerAccess().getTimeoutPathPathBodyParserRuleCall_4_3_0());
                            					
                            pushFollow(FOLLOW_12);
                            lv_timeoutPath_8_0=rulePathBody();

                            state._fsp--;


                            						if (current==null) {
                            							current = createModelElementForParent(grammarAccess.getTimerRule());
                            						}
                            						set(
                            							current,
                            							"timeoutPath",
                            							lv_timeoutPath_8_0,
                            							"org.xtext.project.turn.Turn.PathBody");
                            						afterParserOrEnumRuleCall();
                            					

                            }


                            }
                            break;

                    }

                    otherlv_9=(Token)match(input,20,FOLLOW_64); 

                    				newLeafNode(otherlv_9, grammarAccess.getTimerAccess().getRightCurlyBracketKeyword_4_4());
                    			

                    }
                    break;

            }

            // InternalTurn.g:4500:3: ( (lv_condition_10_0= ruleCondition ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==25) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalTurn.g:4501:4: (lv_condition_10_0= ruleCondition )
                    {
                    // InternalTurn.g:4501:4: (lv_condition_10_0= ruleCondition )
                    // InternalTurn.g:4502:5: lv_condition_10_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getTimerAccess().getConditionConditionParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_condition_10_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getTimerRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_10_0,
                    						"org.xtext.project.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTimer"


    // $ANTLR start "entryRuleConnect"
    // InternalTurn.g:4523:1: entryRuleConnect returns [EObject current=null] : iv_ruleConnect= ruleConnect EOF ;
    public final EObject entryRuleConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnect = null;


        try {
            // InternalTurn.g:4523:48: (iv_ruleConnect= ruleConnect EOF )
            // InternalTurn.g:4524:2: iv_ruleConnect= ruleConnect EOF
            {
             newCompositeNode(grammarAccess.getConnectRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleConnect=ruleConnect();

            state._fsp--;

             current =iv_ruleConnect; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConnect"


    // $ANTLR start "ruleConnect"
    // InternalTurn.g:4530:1: ruleConnect returns [EObject current=null] : (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTurn.g:4536:2: ( (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalTurn.g:4537:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalTurn.g:4537:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalTurn.g:4538:3: otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConnectAccess().getTriggerKeyword_0());
            		
            // InternalTurn.g:4542:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:4543:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:4543:4: ( ruleQualifiedName )
            // InternalTurn.g:4544:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getConnectRule());
            					}
            				

            					newCompositeNode(grammarAccess.getConnectAccess().getConnectsToConnectElementCrossReference_1_0());
            				
            pushFollow(FOLLOW_71);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,64,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getConnectAccess().getSemicolonKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConnect"


    // $ANTLR start "entryRuleFailurePoint"
    // InternalTurn.g:4566:1: entryRuleFailurePoint returns [EObject current=null] : iv_ruleFailurePoint= ruleFailurePoint EOF ;
    public final EObject entryRuleFailurePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailurePoint = null;


        try {
            // InternalTurn.g:4566:53: (iv_ruleFailurePoint= ruleFailurePoint EOF )
            // InternalTurn.g:4567:2: iv_ruleFailurePoint= ruleFailurePoint EOF
            {
             newCompositeNode(grammarAccess.getFailurePointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailurePoint=ruleFailurePoint();

            state._fsp--;

             current =iv_ruleFailurePoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailurePoint"


    // $ANTLR start "ruleFailurePoint"
    // InternalTurn.g:4573:1: ruleFailurePoint returns [EObject current=null] : (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) ;
    public final EObject ruleFailurePoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;

        EObject lv_failLabel_4_0 = null;

        EObject lv_failLabel_5_0 = null;

        EObject lv_condition_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4579:2: ( (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) )
            // InternalTurn.g:4580:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            {
            // InternalTurn.g:4580:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            // InternalTurn.g:4581:3: otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            {
            otherlv_0=(Token)match(input,76,FOLLOW_85); 

            			newLeafNode(otherlv_0, grammarAccess.getFailurePointAccess().getFailKeyword_0());
            		
            // InternalTurn.g:4585:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt87=2;
            int LA87_0 = input.LA(1);

            if ( (LA87_0==RULE_ID) ) {
                alt87=1;
            }
            switch (alt87) {
                case 1 :
                    // InternalTurn.g:4586:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4586:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:4587:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4587:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:4588:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getFailurePointAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_86);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4605:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:4606:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:4606:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:4607:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getFailurePointAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_87);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4625:3: ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            int alt88=3;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==25) ) {
                alt88=1;
            }
            else if ( (LA88_0==60) ) {
                alt88=2;
            }
            switch (alt88) {
                case 1 :
                    // InternalTurn.g:4626:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    {
                    // InternalTurn.g:4626:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    // InternalTurn.g:4627:5: ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    {
                    // InternalTurn.g:4627:5: ( (lv_condition_3_0= ruleCondition ) )
                    // InternalTurn.g:4628:6: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTurn.g:4628:6: (lv_condition_3_0= ruleCondition )
                    // InternalTurn.g:4629:7: lv_condition_3_0= ruleCondition
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getConditionConditionParserRuleCall_2_0_0_0());
                    						
                    pushFollow(FOLLOW_67);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"condition",
                    								lv_condition_3_0,
                    								"org.xtext.project.turn.Turn.Condition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTurn.g:4646:5: ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    // InternalTurn.g:4647:6: (lv_failLabel_4_0= ruleFailureLabel )
                    {
                    // InternalTurn.g:4647:6: (lv_failLabel_4_0= ruleFailureLabel )
                    // InternalTurn.g:4648:7: lv_failLabel_4_0= ruleFailureLabel
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getFailLabelFailureLabelParserRuleCall_2_0_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_failLabel_4_0=ruleFailureLabel();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"failLabel",
                    								lv_failLabel_4_0,
                    								"org.xtext.project.turn.Turn.FailureLabel");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:4667:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    {
                    // InternalTurn.g:4667:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    // InternalTurn.g:4668:5: ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTurn.g:4668:5: ( (lv_failLabel_5_0= ruleFailureLabel ) )
                    // InternalTurn.g:4669:6: (lv_failLabel_5_0= ruleFailureLabel )
                    {
                    // InternalTurn.g:4669:6: (lv_failLabel_5_0= ruleFailureLabel )
                    // InternalTurn.g:4670:7: lv_failLabel_5_0= ruleFailureLabel
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getFailLabelFailureLabelParserRuleCall_2_1_0_0());
                    						
                    pushFollow(FOLLOW_88);
                    lv_failLabel_5_0=ruleFailureLabel();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"failLabel",
                    								lv_failLabel_5_0,
                    								"org.xtext.project.turn.Turn.FailureLabel");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    // InternalTurn.g:4687:5: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTurn.g:4688:6: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTurn.g:4688:6: (lv_condition_6_0= ruleCondition )
                    // InternalTurn.g:4689:7: lv_condition_6_0= ruleCondition
                    {

                    							newCompositeNode(grammarAccess.getFailurePointAccess().getConditionConditionParserRuleCall_2_1_1_0());
                    						
                    pushFollow(FOLLOW_2);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getFailurePointRule());
                    							}
                    							set(
                    								current,
                    								"condition",
                    								lv_condition_6_0,
                    								"org.xtext.project.turn.Turn.Condition");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailurePoint"


    // $ANTLR start "entryRuleEndPoint"
    // InternalTurn.g:4712:1: entryRuleEndPoint returns [EObject current=null] : iv_ruleEndPoint= ruleEndPoint EOF ;
    public final EObject entryRuleEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndPoint = null;


        try {
            // InternalTurn.g:4712:49: (iv_ruleEndPoint= ruleEndPoint EOF )
            // InternalTurn.g:4713:2: iv_ruleEndPoint= ruleEndPoint EOF
            {
             newCompositeNode(grammarAccess.getEndPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEndPoint=ruleEndPoint();

            state._fsp--;

             current =iv_ruleEndPoint; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEndPoint"


    // $ANTLR start "ruleEndPoint"
    // InternalTurn.g:4719:1: ruleEndPoint returns [EObject current=null] : (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) ;
    public final EObject ruleEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4725:2: ( (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) )
            // InternalTurn.g:4726:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            {
            // InternalTurn.g:4726:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            // InternalTurn.g:4727:3: otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_89); 

            			newLeafNode(otherlv_0, grammarAccess.getEndPointAccess().getEndKeyword_0());
            		
            // InternalTurn.g:4731:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==RULE_ID) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalTurn.g:4732:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4732:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:4733:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4733:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:4734:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getEndPointAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_90);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndPointRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:4751:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:4752:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:4752:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:4753:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getEndPointAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_91);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getEndPointRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4771:3: ( (lv_condition_3_0= ruleCondition ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==25) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalTurn.g:4772:4: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTurn.g:4772:4: (lv_condition_3_0= ruleCondition )
                    // InternalTurn.g:4773:5: lv_condition_3_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getEndPointAccess().getConditionConditionParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_92);
                    lv_condition_3_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getEndPointRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_3_0,
                    						"org.xtext.project.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,78,FOLLOW_2); 

            			newLeafNode(otherlv_4, grammarAccess.getEndPointAccess().getFullStopKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEndPoint"


    // $ANTLR start "entryRuleOrFork"
    // InternalTurn.g:4798:1: entryRuleOrFork returns [EObject current=null] : iv_ruleOrFork= ruleOrFork EOF ;
    public final EObject entryRuleOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrFork = null;


        try {
            // InternalTurn.g:4798:47: (iv_ruleOrFork= ruleOrFork EOF )
            // InternalTurn.g:4799:2: iv_ruleOrFork= ruleOrFork EOF
            {
             newCompositeNode(grammarAccess.getOrForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrFork=ruleOrFork();

            state._fsp--;

             current =iv_ruleOrFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrFork"


    // $ANTLR start "ruleOrFork"
    // InternalTurn.g:4805:1: ruleOrFork returns [EObject current=null] : (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? ) ;
    public final EObject ruleOrFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_body_4_0 = null;

        EObject lv_condition_6_0 = null;

        EObject lv_connectingOrBody_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4811:2: ( (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? ) )
            // InternalTurn.g:4812:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? )
            {
            // InternalTurn.g:4812:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? )
            // InternalTurn.g:4813:3: otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )?
            {
            otherlv_0=(Token)match(input,79,FOLLOW_93); 

            			newLeafNode(otherlv_0, grammarAccess.getOrForkAccess().getOrKeyword_0());
            		
            // InternalTurn.g:4817:3: ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) )
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_ID||LA92_0==13) ) {
                alt92=1;
            }
            else if ( (LA92_0==25) ) {
                alt92=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 92, 0, input);

                throw nvae;
            }
            switch (alt92) {
                case 1 :
                    // InternalTurn.g:4818:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    {
                    // InternalTurn.g:4818:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    // InternalTurn.g:4819:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}'
                    {
                    // InternalTurn.g:4819:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt91=2;
                    int LA91_0 = input.LA(1);

                    if ( (LA91_0==RULE_ID) ) {
                        alt91=1;
                    }
                    switch (alt91) {
                        case 1 :
                            // InternalTurn.g:4820:6: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTurn.g:4820:6: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTurn.g:4821:7: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:4821:7: (lv_name_1_0= ruleQualifiedName )
                            // InternalTurn.g:4822:8: lv_name_1_0= ruleQualifiedName
                            {

                            								newCompositeNode(grammarAccess.getOrForkAccess().getNameQualifiedNameParserRuleCall_1_0_0_0_0());
                            							
                            pushFollow(FOLLOW_25);
                            lv_name_1_0=ruleQualifiedName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOrForkRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_1_0,
                            									"org.xtext.project.turn.Turn.QualifiedName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalTurn.g:4839:6: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTurn.g:4840:7: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTurn.g:4840:7: (lv_longName_2_0= ruleLongName )
                            // InternalTurn.g:4841:8: lv_longName_2_0= ruleLongName
                            {

                            								newCompositeNode(grammarAccess.getOrForkAccess().getLongNameLongNameParserRuleCall_1_0_0_1_0());
                            							
                            pushFollow(FOLLOW_26);
                            lv_longName_2_0=ruleLongName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getOrForkRule());
                            								}
                            								set(
                            									current,
                            									"longName",
                            									lv_longName_2_0,
                            									"org.xtext.project.turn.Turn.LongName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    otherlv_3=(Token)match(input,13,FOLLOW_88); 

                    					newLeafNode(otherlv_3, grammarAccess.getOrForkAccess().getLeftCurlyBracketKeyword_1_0_1());
                    				
                    // InternalTurn.g:4863:5: ( (lv_body_4_0= ruleOrBody ) )
                    // InternalTurn.g:4864:6: (lv_body_4_0= ruleOrBody )
                    {
                    // InternalTurn.g:4864:6: (lv_body_4_0= ruleOrBody )
                    // InternalTurn.g:4865:7: lv_body_4_0= ruleOrBody
                    {

                    							newCompositeNode(grammarAccess.getOrForkAccess().getBodyOrBodyParserRuleCall_1_0_2_0());
                    						
                    pushFollow(FOLLOW_12);
                    lv_body_4_0=ruleOrBody();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getOrForkRule());
                    							}
                    							set(
                    								current,
                    								"body",
                    								lv_body_4_0,
                    								"org.xtext.project.turn.Turn.OrBody");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }

                    otherlv_5=(Token)match(input,20,FOLLOW_74); 

                    					newLeafNode(otherlv_5, grammarAccess.getOrForkAccess().getRightCurlyBracketKeyword_1_0_3());
                    				

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:4888:4: ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTurn.g:4888:4: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTurn.g:4889:5: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTurn.g:4889:5: (lv_condition_6_0= ruleCondition )
                    // InternalTurn.g:4890:6: lv_condition_6_0= ruleCondition
                    {

                    						newCompositeNode(grammarAccess.getOrForkAccess().getConditionConditionParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_74);
                    lv_condition_6_0=ruleCondition();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getOrForkRule());
                    						}
                    						set(
                    							current,
                    							"condition",
                    							lv_condition_6_0,
                    							"org.xtext.project.turn.Turn.Condition");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:4908:3: ( (lv_connectingOrBody_7_0= rulePathBody ) )?
            int alt93=2;
            int LA93_0 = input.LA(1);

            if ( (LA93_0==66) ) {
                alt93=1;
            }
            switch (alt93) {
                case 1 :
                    // InternalTurn.g:4909:4: (lv_connectingOrBody_7_0= rulePathBody )
                    {
                    // InternalTurn.g:4909:4: (lv_connectingOrBody_7_0= rulePathBody )
                    // InternalTurn.g:4910:5: lv_connectingOrBody_7_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getOrForkAccess().getConnectingOrBodyPathBodyParserRuleCall_2_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_connectingOrBody_7_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getOrForkRule());
                    					}
                    					set(
                    						current,
                    						"connectingOrBody",
                    						lv_connectingOrBody_7_0,
                    						"org.xtext.project.turn.Turn.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrFork"


    // $ANTLR start "entryRuleOrBody"
    // InternalTurn.g:4931:1: entryRuleOrBody returns [EObject current=null] : iv_ruleOrBody= ruleOrBody EOF ;
    public final EObject entryRuleOrBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBody = null;


        try {
            // InternalTurn.g:4931:47: (iv_ruleOrBody= ruleOrBody EOF )
            // InternalTurn.g:4932:2: iv_ruleOrBody= ruleOrBody EOF
            {
             newCompositeNode(grammarAccess.getOrBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrBody=ruleOrBody();

            state._fsp--;

             current =iv_ruleOrBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrBody"


    // $ANTLR start "ruleOrBody"
    // InternalTurn.g:4938:1: ruleOrBody returns [EObject current=null] : this_ElseOrForkBody_0= ruleElseOrForkBody ;
    public final EObject ruleOrBody() throws RecognitionException {
        EObject current = null;

        EObject this_ElseOrForkBody_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4944:2: (this_ElseOrForkBody_0= ruleElseOrForkBody )
            // InternalTurn.g:4945:2: this_ElseOrForkBody_0= ruleElseOrForkBody
            {

            		newCompositeNode(grammarAccess.getOrBodyAccess().getElseOrForkBodyParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_ElseOrForkBody_0=ruleElseOrForkBody();

            state._fsp--;


            		current = this_ElseOrForkBody_0;
            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrBody"


    // $ANTLR start "entryRuleElseOrForkBody"
    // InternalTurn.g:4956:1: entryRuleElseOrForkBody returns [EObject current=null] : iv_ruleElseOrForkBody= ruleElseOrForkBody EOF ;
    public final EObject entryRuleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseOrForkBody = null;


        try {
            // InternalTurn.g:4956:55: (iv_ruleElseOrForkBody= ruleElseOrForkBody EOF )
            // InternalTurn.g:4957:2: iv_ruleElseOrForkBody= ruleElseOrForkBody EOF
            {
             newCompositeNode(grammarAccess.getElseOrForkBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleElseOrForkBody=ruleElseOrForkBody();

            state._fsp--;

             current =iv_ruleElseOrForkBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleElseOrForkBody"


    // $ANTLR start "ruleElseOrForkBody"
    // InternalTurn.g:4963:1: ruleElseOrForkBody returns [EObject current=null] : (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) ;
    public final EObject ruleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_OrForkBody_0 = null;

        EObject lv_elseBody_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4969:2: ( (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) )
            // InternalTurn.g:4970:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            {
            // InternalTurn.g:4970:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            // InternalTurn.g:4971:3: this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            {

            			newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getOrForkBodyParserRuleCall_0());
            		
            pushFollow(FOLLOW_94);
            this_OrForkBody_0=ruleOrForkBody();

            state._fsp--;


            			current = this_OrForkBody_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:4979:3: (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==80) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalTurn.g:4980:4: otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) )
                    {
                    otherlv_1=(Token)match(input,80,FOLLOW_61); 

                    				newLeafNode(otherlv_1, grammarAccess.getElseOrForkBodyAccess().getElseKeyword_1_0());
                    			
                    // InternalTurn.g:4984:4: ( (lv_elseBody_2_0= rulePathBody ) )
                    // InternalTurn.g:4985:5: (lv_elseBody_2_0= rulePathBody )
                    {
                    // InternalTurn.g:4985:5: (lv_elseBody_2_0= rulePathBody )
                    // InternalTurn.g:4986:6: lv_elseBody_2_0= rulePathBody
                    {

                    						newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getElseBodyPathBodyParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_elseBody_2_0=rulePathBody();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getElseOrForkBodyRule());
                    						}
                    						set(
                    							current,
                    							"elseBody",
                    							lv_elseBody_2_0,
                    							"org.xtext.project.turn.Turn.PathBody");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleElseOrForkBody"


    // $ANTLR start "entryRuleOrForkBody"
    // InternalTurn.g:5008:1: entryRuleOrForkBody returns [EObject current=null] : iv_ruleOrForkBody= ruleOrForkBody EOF ;
    public final EObject entryRuleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrForkBody = null;


        try {
            // InternalTurn.g:5008:51: (iv_ruleOrForkBody= ruleOrForkBody EOF )
            // InternalTurn.g:5009:2: iv_ruleOrForkBody= ruleOrForkBody EOF
            {
             newCompositeNode(grammarAccess.getOrForkBodyRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOrForkBody=ruleOrForkBody();

            state._fsp--;

             current =iv_ruleOrForkBody; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrForkBody"


    // $ANTLR start "ruleOrForkBody"
    // InternalTurn.g:5015:1: ruleOrForkBody returns [EObject current=null] : ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ ;
    public final EObject ruleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject lv_regularBody_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5021:2: ( ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ )
            // InternalTurn.g:5022:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            {
            // InternalTurn.g:5022:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            int cnt95=0;
            loop95:
            do {
                int alt95=2;
                int LA95_0 = input.LA(1);

                if ( (LA95_0==25) ) {
                    alt95=1;
                }


                switch (alt95) {
            	case 1 :
            	    // InternalTurn.g:5023:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    {
            	    // InternalTurn.g:5023:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    // InternalTurn.g:5024:4: lv_regularBody_0_0= ruleRegularOrFork
            	    {

            	    				newCompositeNode(grammarAccess.getOrForkBodyAccess().getRegularBodyRegularOrForkParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_64);
            	    lv_regularBody_0_0=ruleRegularOrFork();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getOrForkBodyRule());
            	    				}
            	    				add(
            	    					current,
            	    					"regularBody",
            	    					lv_regularBody_0_0,
            	    					"org.xtext.project.turn.Turn.RegularOrFork");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt95 >= 1 ) break loop95;
                        EarlyExitException eee =
                            new EarlyExitException(95, input);
                        throw eee;
                }
                cnt95++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrForkBody"


    // $ANTLR start "entryRuleRegularOrFork"
    // InternalTurn.g:5044:1: entryRuleRegularOrFork returns [EObject current=null] : iv_ruleRegularOrFork= ruleRegularOrFork EOF ;
    public final EObject entryRuleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularOrFork = null;


        try {
            // InternalTurn.g:5044:54: (iv_ruleRegularOrFork= ruleRegularOrFork EOF )
            // InternalTurn.g:5045:2: iv_ruleRegularOrFork= ruleRegularOrFork EOF
            {
             newCompositeNode(grammarAccess.getRegularOrForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRegularOrFork=ruleRegularOrFork();

            state._fsp--;

             current =iv_ruleRegularOrFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRegularOrFork"


    // $ANTLR start "ruleRegularOrFork"
    // InternalTurn.g:5051:1: ruleRegularOrFork returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject ruleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5057:2: ( ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTurn.g:5058:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTurn.g:5058:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTurn.g:5059:3: ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTurn.g:5059:3: ( (lv_condition_0_0= ruleCondition ) )
            // InternalTurn.g:5060:4: (lv_condition_0_0= ruleCondition )
            {
            // InternalTurn.g:5060:4: (lv_condition_0_0= ruleCondition )
            // InternalTurn.g:5061:5: lv_condition_0_0= ruleCondition
            {

            					newCompositeNode(grammarAccess.getRegularOrForkAccess().getConditionConditionParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_61);
            lv_condition_0_0=ruleCondition();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularOrForkRule());
            					}
            					set(
            						current,
            						"condition",
            						lv_condition_0_0,
            						"org.xtext.project.turn.Turn.Condition");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5078:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTurn.g:5079:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTurn.g:5079:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTurn.g:5080:5: lv_pathBody_1_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getRegularOrForkAccess().getPathBodyPathBodyParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_pathBody_1_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getRegularOrForkRule());
            					}
            					set(
            						current,
            						"pathBody",
            						lv_pathBody_1_0,
            						"org.xtext.project.turn.Turn.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRegularOrFork"


    // $ANTLR start "entryRuleAndFork"
    // InternalTurn.g:5101:1: entryRuleAndFork returns [EObject current=null] : iv_ruleAndFork= ruleAndFork EOF ;
    public final EObject entryRuleAndFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndFork = null;


        try {
            // InternalTurn.g:5101:48: (iv_ruleAndFork= ruleAndFork EOF )
            // InternalTurn.g:5102:2: iv_ruleAndFork= ruleAndFork EOF
            {
             newCompositeNode(grammarAccess.getAndForkRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAndFork=ruleAndFork();

            state._fsp--;

             current =iv_ruleAndFork; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndFork"


    // $ANTLR start "ruleAndFork"
    // InternalTurn.g:5108:1: ruleAndFork returns [EObject current=null] : (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? ) ;
    public final EObject ruleAndFork() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_pathbody_5_0 = null;

        EObject lv_connectingAndBody_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5114:2: ( (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? ) )
            // InternalTurn.g:5115:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? )
            {
            // InternalTurn.g:5115:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? )
            // InternalTurn.g:5116:3: otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_95); 

            			newLeafNode(otherlv_0, grammarAccess.getAndForkAccess().getAndKeyword_0());
            		
            // InternalTurn.g:5120:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==RULE_ID) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalTurn.g:5121:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:5121:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:5122:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:5122:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:5123:6: lv_name_1_0= ruleQualifiedName
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getNameQualifiedNameParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_25);
                    lv_name_1_0=ruleQualifiedName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"name",
                    							lv_name_1_0,
                    							"org.xtext.project.turn.Turn.QualifiedName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:5140:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:5141:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:5141:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:5142:6: lv_longName_2_0= ruleLongName
                    {

                    						newCompositeNode(grammarAccess.getAndForkAccess().getLongNameLongNameParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_26);
                    lv_longName_2_0=ruleLongName();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getAndForkRule());
                    						}
                    						set(
                    							current,
                    							"longName",
                    							lv_longName_2_0,
                    							"org.xtext.project.turn.Turn.LongName");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,13,FOLLOW_96); 

            			newLeafNode(otherlv_3, grammarAccess.getAndForkAccess().getLeftCurlyBracketKeyword_2());
            		
            // InternalTurn.g:5164:3: (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )*
            loop97:
            do {
                int alt97=2;
                int LA97_0 = input.LA(1);

                if ( (LA97_0==82) ) {
                    alt97=1;
                }


                switch (alt97) {
            	case 1 :
            	    // InternalTurn.g:5165:4: otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) )
            	    {
            	    otherlv_4=(Token)match(input,82,FOLLOW_61); 

            	    				newLeafNode(otherlv_4, grammarAccess.getAndForkAccess().getAsteriskKeyword_3_0());
            	    			
            	    // InternalTurn.g:5169:4: ( (lv_pathbody_5_0= rulePathBody ) )
            	    // InternalTurn.g:5170:5: (lv_pathbody_5_0= rulePathBody )
            	    {
            	    // InternalTurn.g:5170:5: (lv_pathbody_5_0= rulePathBody )
            	    // InternalTurn.g:5171:6: lv_pathbody_5_0= rulePathBody
            	    {

            	    						newCompositeNode(grammarAccess.getAndForkAccess().getPathbodyPathBodyParserRuleCall_3_1_0());
            	    					
            	    pushFollow(FOLLOW_96);
            	    lv_pathbody_5_0=rulePathBody();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getAndForkRule());
            	    						}
            	    						add(
            	    							current,
            	    							"pathbody",
            	    							lv_pathbody_5_0,
            	    							"org.xtext.project.turn.Turn.PathBody");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop97;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_74); 

            			newLeafNode(otherlv_6, grammarAccess.getAndForkAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalTurn.g:5193:3: ( (lv_connectingAndBody_7_0= rulePathBody ) )?
            int alt98=2;
            int LA98_0 = input.LA(1);

            if ( (LA98_0==66) ) {
                alt98=1;
            }
            switch (alt98) {
                case 1 :
                    // InternalTurn.g:5194:4: (lv_connectingAndBody_7_0= rulePathBody )
                    {
                    // InternalTurn.g:5194:4: (lv_connectingAndBody_7_0= rulePathBody )
                    // InternalTurn.g:5195:5: lv_connectingAndBody_7_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getAndForkAccess().getConnectingAndBodyPathBodyParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_connectingAndBody_7_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getAndForkRule());
                    					}
                    					set(
                    						current,
                    						"connectingAndBody",
                    						lv_connectingAndBody_7_0,
                    						"org.xtext.project.turn.Turn.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndFork"


    // $ANTLR start "entryRuleStub"
    // InternalTurn.g:5216:1: entryRuleStub returns [EObject current=null] : iv_ruleStub= ruleStub EOF ;
    public final EObject entryRuleStub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStub = null;


        try {
            // InternalTurn.g:5216:45: (iv_ruleStub= ruleStub EOF )
            // InternalTurn.g:5217:2: iv_ruleStub= ruleStub EOF
            {
             newCompositeNode(grammarAccess.getStubRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStub=ruleStub();

            state._fsp--;

             current =iv_ruleStub; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStub"


    // $ANTLR start "ruleStub"
    // InternalTurn.g:5223:1: ruleStub returns [EObject current=null] : ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? ) ;
    public final EObject ruleStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        AntlrDatatypeRuleToken lv_stubType_0_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;

        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_longName_5_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_outPaths_9_0 = null;

        EObject lv_connectingStubBody_11_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5229:2: ( ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? ) )
            // InternalTurn.g:5230:2: ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? )
            {
            // InternalTurn.g:5230:2: ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? )
            // InternalTurn.g:5231:3: ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )?
            {
            // InternalTurn.g:5231:3: ( (lv_stubType_0_0= ruleStubType ) )?
            int alt99=2;
            int LA99_0 = input.LA(1);

            if ( ((LA99_0>=84 && LA99_0<=85)) ) {
                alt99=1;
            }
            switch (alt99) {
                case 1 :
                    // InternalTurn.g:5232:4: (lv_stubType_0_0= ruleStubType )
                    {
                    // InternalTurn.g:5232:4: (lv_stubType_0_0= ruleStubType )
                    // InternalTurn.g:5233:5: lv_stubType_0_0= ruleStubType
                    {

                    					newCompositeNode(grammarAccess.getStubAccess().getStubTypeStubTypeParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_97);
                    lv_stubType_0_0=ruleStubType();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStubRule());
                    					}
                    					set(
                    						current,
                    						"stubType",
                    						lv_stubType_0_0,
                    						"org.xtext.project.turn.Turn.StubType");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,83,FOLLOW_98); 

            			newLeafNode(otherlv_1, grammarAccess.getStubAccess().getStubKeyword_1());
            		
            // InternalTurn.g:5254:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==65) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalTurn.g:5255:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubAccess().getInKeyword_2_0());
                    			
                    // InternalTurn.g:5259:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTurn.g:5260:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5260:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTurn.g:5261:6: lv_index_3_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getStubAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
                    					
                    pushFollow(FOLLOW_99);
                    lv_index_3_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubRule());
                    						}
                    						set(
                    							current,
                    							"index",
                    							lv_index_3_0,
                    							"org.xtext.project.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5279:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )
            int alt102=2;
            alt102 = dfa102.predict(input);
            switch (alt102) {
                case 1 :
                    // InternalTurn.g:5280:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    {
                    // InternalTurn.g:5280:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    // InternalTurn.g:5281:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) )
                    {
                    // InternalTurn.g:5281:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )?
                    int alt101=2;
                    int LA101_0 = input.LA(1);

                    if ( (LA101_0==RULE_ID) ) {
                        alt101=1;
                    }
                    switch (alt101) {
                        case 1 :
                            // InternalTurn.g:5282:6: ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) )
                            {
                            // InternalTurn.g:5282:6: ( (lv_name_4_0= ruleQualifiedName ) )
                            // InternalTurn.g:5283:7: (lv_name_4_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:5283:7: (lv_name_4_0= ruleQualifiedName )
                            // InternalTurn.g:5284:8: lv_name_4_0= ruleQualifiedName
                            {

                            								newCompositeNode(grammarAccess.getStubAccess().getNameQualifiedNameParserRuleCall_3_0_0_0_0());
                            							
                            pushFollow(FOLLOW_100);
                            lv_name_4_0=ruleQualifiedName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getStubRule());
                            								}
                            								set(
                            									current,
                            									"name",
                            									lv_name_4_0,
                            									"org.xtext.project.turn.Turn.QualifiedName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }

                            // InternalTurn.g:5301:6: ( (lv_longName_5_0= ruleLongName ) )
                            // InternalTurn.g:5302:7: (lv_longName_5_0= ruleLongName )
                            {
                            // InternalTurn.g:5302:7: (lv_longName_5_0= ruleLongName )
                            // InternalTurn.g:5303:8: lv_longName_5_0= ruleLongName
                            {

                            								newCompositeNode(grammarAccess.getStubAccess().getLongNameLongNameParserRuleCall_3_0_0_1_0());
                            							
                            pushFollow(FOLLOW_99);
                            lv_longName_5_0=ruleLongName();

                            state._fsp--;


                            								if (current==null) {
                            									current = createModelElementForParent(grammarAccess.getStubRule());
                            								}
                            								set(
                            									current,
                            									"longName",
                            									lv_longName_5_0,
                            									"org.xtext.project.turn.Turn.LongName");
                            								afterParserOrEnumRuleCall();
                            							

                            }


                            }


                            }
                            break;

                    }

                    // InternalTurn.g:5321:5: ( (lv_params_6_0= ruleStubParameters ) )
                    // InternalTurn.g:5322:6: (lv_params_6_0= ruleStubParameters )
                    {
                    // InternalTurn.g:5322:6: (lv_params_6_0= ruleStubParameters )
                    // InternalTurn.g:5323:7: lv_params_6_0= ruleStubParameters
                    {

                    							newCompositeNode(grammarAccess.getStubAccess().getParamsStubParametersParserRuleCall_3_0_1_0());
                    						
                    pushFollow(FOLLOW_101);
                    lv_params_6_0=ruleStubParameters();

                    state._fsp--;


                    							if (current==null) {
                    								current = createModelElementForParent(grammarAccess.getStubRule());
                    							}
                    							set(
                    								current,
                    								"params",
                    								lv_params_6_0,
                    								"org.xtext.project.turn.Turn.StubParameters");
                    							afterParserOrEnumRuleCall();
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:5342:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalTurn.g:5342:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:5343:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:5343:5: ( ruleQualifiedName )
                    // InternalTurn.g:5344:6: ruleQualifiedName
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getStubRule());
                    						}
                    					

                    						newCompositeNode(grammarAccess.getStubAccess().getStubRefStubDeclarationCrossReference_3_1_0());
                    					
                    pushFollow(FOLLOW_101);
                    ruleQualifiedName();

                    state._fsp--;


                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5359:3: (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==13) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalTurn.g:5360:4: otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,13,FOLLOW_102); 

                    				newLeafNode(otherlv_8, grammarAccess.getStubAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTurn.g:5364:4: ( (lv_outPaths_9_0= ruleStubOutPath ) )*
                    loop103:
                    do {
                        int alt103=2;
                        int LA103_0 = input.LA(1);

                        if ( (LA103_0==88) ) {
                            alt103=1;
                        }


                        switch (alt103) {
                    	case 1 :
                    	    // InternalTurn.g:5365:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    {
                    	    // InternalTurn.g:5365:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    // InternalTurn.g:5366:6: lv_outPaths_9_0= ruleStubOutPath
                    	    {

                    	    						newCompositeNode(grammarAccess.getStubAccess().getOutPathsStubOutPathParserRuleCall_4_1_0());
                    	    					
                    	    pushFollow(FOLLOW_102);
                    	    lv_outPaths_9_0=ruleStubOutPath();

                    	    state._fsp--;


                    	    						if (current==null) {
                    	    							current = createModelElementForParent(grammarAccess.getStubRule());
                    	    						}
                    	    						add(
                    	    							current,
                    	    							"outPaths",
                    	    							lv_outPaths_9_0,
                    	    							"org.xtext.project.turn.Turn.StubOutPath");
                    	    						afterParserOrEnumRuleCall();
                    	    					

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop103;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_74); 

                    				newLeafNode(otherlv_10, grammarAccess.getStubAccess().getRightCurlyBracketKeyword_4_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5388:3: ( (lv_connectingStubBody_11_0= rulePathBody ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==66) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalTurn.g:5389:4: (lv_connectingStubBody_11_0= rulePathBody )
                    {
                    // InternalTurn.g:5389:4: (lv_connectingStubBody_11_0= rulePathBody )
                    // InternalTurn.g:5390:5: lv_connectingStubBody_11_0= rulePathBody
                    {

                    					newCompositeNode(grammarAccess.getStubAccess().getConnectingStubBodyPathBodyParserRuleCall_5_0());
                    				
                    pushFollow(FOLLOW_2);
                    lv_connectingStubBody_11_0=rulePathBody();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getStubRule());
                    					}
                    					set(
                    						current,
                    						"connectingStubBody",
                    						lv_connectingStubBody_11_0,
                    						"org.xtext.project.turn.Turn.PathBody");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStub"


    // $ANTLR start "entryRuleStubType"
    // InternalTurn.g:5411:1: entryRuleStubType returns [String current=null] : iv_ruleStubType= ruleStubType EOF ;
    public final String entryRuleStubType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStubType = null;


        try {
            // InternalTurn.g:5411:48: (iv_ruleStubType= ruleStubType EOF )
            // InternalTurn.g:5412:2: iv_ruleStubType= ruleStubType EOF
            {
             newCompositeNode(grammarAccess.getStubTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubType=ruleStubType();

            state._fsp--;

             current =iv_ruleStubType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubType"


    // $ANTLR start "ruleStubType"
    // InternalTurn.g:5418:1: ruleStubType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'synchronizing' | kw= 'blocking' ) ;
    public final AntlrDatatypeRuleToken ruleStubType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:5424:2: ( (kw= 'synchronizing' | kw= 'blocking' ) )
            // InternalTurn.g:5425:2: (kw= 'synchronizing' | kw= 'blocking' )
            {
            // InternalTurn.g:5425:2: (kw= 'synchronizing' | kw= 'blocking' )
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==84) ) {
                alt106=1;
            }
            else if ( (LA106_0==85) ) {
                alt106=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 106, 0, input);

                throw nvae;
            }
            switch (alt106) {
                case 1 :
                    // InternalTurn.g:5426:3: kw= 'synchronizing'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStubTypeAccess().getSynchronizingKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:5432:3: kw= 'blocking'
                    {
                    kw=(Token)match(input,85,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStubTypeAccess().getBlockingKeyword_1());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubType"


    // $ANTLR start "entryRuleStubParameters"
    // InternalTurn.g:5441:1: entryRuleStubParameters returns [EObject current=null] : iv_ruleStubParameters= ruleStubParameters EOF ;
    public final EObject entryRuleStubParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubParameters = null;


        try {
            // InternalTurn.g:5441:55: (iv_ruleStubParameters= ruleStubParameters EOF )
            // InternalTurn.g:5442:2: iv_ruleStubParameters= ruleStubParameters EOF
            {
             newCompositeNode(grammarAccess.getStubParametersRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubParameters=ruleStubParameters();

            state._fsp--;

             current =iv_ruleStubParameters; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubParameters"


    // $ANTLR start "ruleStubParameters"
    // InternalTurn.g:5448:1: ruleStubParameters returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) ;
    public final EObject ruleStubParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_plugin_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5454:2: ( ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) )
            // InternalTurn.g:5455:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            {
            // InternalTurn.g:5455:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            // InternalTurn.g:5456:3: () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')'
            {
            // InternalTurn.g:5456:3: ()
            // InternalTurn.g:5457:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStubParametersAccess().getStubParametersAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,86,FOLLOW_103); 

            			newLeafNode(otherlv_1, grammarAccess.getStubParametersAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTurn.g:5467:3: ( (lv_plugin_2_0= rulePluginBinding ) )*
            loop107:
            do {
                int alt107=2;
                int LA107_0 = input.LA(1);

                if ( (LA107_0==RULE_ID||LA107_0==25||LA107_0==89) ) {
                    alt107=1;
                }


                switch (alt107) {
            	case 1 :
            	    // InternalTurn.g:5468:4: (lv_plugin_2_0= rulePluginBinding )
            	    {
            	    // InternalTurn.g:5468:4: (lv_plugin_2_0= rulePluginBinding )
            	    // InternalTurn.g:5469:5: lv_plugin_2_0= rulePluginBinding
            	    {

            	    					newCompositeNode(grammarAccess.getStubParametersAccess().getPluginPluginBindingParserRuleCall_2_0());
            	    				
            	    pushFollow(FOLLOW_103);
            	    lv_plugin_2_0=rulePluginBinding();

            	    state._fsp--;


            	    					if (current==null) {
            	    						current = createModelElementForParent(grammarAccess.getStubParametersRule());
            	    					}
            	    					add(
            	    						current,
            	    						"plugin",
            	    						lv_plugin_2_0,
            	    						"org.xtext.project.turn.Turn.PluginBinding");
            	    					afterParserOrEnumRuleCall();
            	    				

            	    }


            	    }
            	    break;

            	default :
            	    break loop107;
                }
            } while (true);

            otherlv_3=(Token)match(input,87,FOLLOW_2); 

            			newLeafNode(otherlv_3, grammarAccess.getStubParametersAccess().getRightParenthesisKeyword_3());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubParameters"


    // $ANTLR start "entryRuleStubDeclaration"
    // InternalTurn.g:5494:1: entryRuleStubDeclaration returns [EObject current=null] : iv_ruleStubDeclaration= ruleStubDeclaration EOF ;
    public final EObject entryRuleStubDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubDeclaration = null;


        try {
            // InternalTurn.g:5494:56: (iv_ruleStubDeclaration= ruleStubDeclaration EOF )
            // InternalTurn.g:5495:2: iv_ruleStubDeclaration= ruleStubDeclaration EOF
            {
             newCompositeNode(grammarAccess.getStubDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubDeclaration=ruleStubDeclaration();

            state._fsp--;

             current =iv_ruleStubDeclaration; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubDeclaration"


    // $ANTLR start "ruleStubDeclaration"
    // InternalTurn.g:5501:1: ruleStubDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) ;
    public final EObject ruleStubDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        EObject lv_params_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5507:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) )
            // InternalTurn.g:5508:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            {
            // InternalTurn.g:5508:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            // InternalTurn.g:5509:3: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) )
            {
            // InternalTurn.g:5509:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalTurn.g:5510:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:5510:4: (lv_name_0_0= ruleQualifiedName )
            // InternalTurn.g:5511:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_104);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5528:3: ( (lv_longName_1_0= ruleLongName ) )
            // InternalTurn.g:5529:4: (lv_longName_1_0= ruleLongName )
            {
            // InternalTurn.g:5529:4: (lv_longName_1_0= ruleLongName )
            // InternalTurn.g:5530:5: lv_longName_1_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getLongNameLongNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_24);
            lv_longName_1_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_1_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_99); 

            			newLeafNode(otherlv_2, grammarAccess.getStubDeclarationAccess().getEqualsSignKeyword_2());
            		
            // InternalTurn.g:5551:3: ( (lv_params_3_0= ruleStubParameters ) )
            // InternalTurn.g:5552:4: (lv_params_3_0= ruleStubParameters )
            {
            // InternalTurn.g:5552:4: (lv_params_3_0= ruleStubParameters )
            // InternalTurn.g:5553:5: lv_params_3_0= ruleStubParameters
            {

            					newCompositeNode(grammarAccess.getStubDeclarationAccess().getParamsStubParametersParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_2);
            lv_params_3_0=ruleStubParameters();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubDeclarationRule());
            					}
            					set(
            						current,
            						"params",
            						lv_params_3_0,
            						"org.xtext.project.turn.Turn.StubParameters");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubDeclaration"


    // $ANTLR start "entryRuleStubOutPath"
    // InternalTurn.g:5574:1: entryRuleStubOutPath returns [EObject current=null] : iv_ruleStubOutPath= ruleStubOutPath EOF ;
    public final EObject entryRuleStubOutPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubOutPath = null;


        try {
            // InternalTurn.g:5574:52: (iv_ruleStubOutPath= ruleStubOutPath EOF )
            // InternalTurn.g:5575:2: iv_ruleStubOutPath= ruleStubOutPath EOF
            {
             newCompositeNode(grammarAccess.getStubOutPathRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleStubOutPath=ruleStubOutPath();

            state._fsp--;

             current =iv_ruleStubOutPath; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStubOutPath"


    // $ANTLR start "ruleStubOutPath"
    // InternalTurn.g:5581:1: ruleStubOutPath returns [EObject current=null] : ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) ;
    public final EObject ruleStubOutPath() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_index_1_0 = null;

        AntlrDatatypeRuleToken lv_threshold_4_0 = null;

        EObject lv_path_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5587:2: ( ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) )
            // InternalTurn.g:5588:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            {
            // InternalTurn.g:5588:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            // InternalTurn.g:5589:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) )
            {
            // InternalTurn.g:5589:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) )
            // InternalTurn.g:5590:4: otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) )
            {
            otherlv_0=(Token)match(input,88,FOLLOW_52); 

            				newLeafNode(otherlv_0, grammarAccess.getStubOutPathAccess().getOutKeyword_0_0());
            			
            // InternalTurn.g:5594:4: ( (lv_index_1_0= rulePositiveInteger ) )
            // InternalTurn.g:5595:5: (lv_index_1_0= rulePositiveInteger )
            {
            // InternalTurn.g:5595:5: (lv_index_1_0= rulePositiveInteger )
            // InternalTurn.g:5596:6: lv_index_1_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getStubOutPathAccess().getIndexPositiveIntegerParserRuleCall_0_1_0());
            					
            pushFollow(FOLLOW_105);
            lv_index_1_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getStubOutPathRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_1_0,
            							"org.xtext.project.turn.Turn.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }

            // InternalTurn.g:5614:3: (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==49) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalTurn.g:5615:4: otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']'
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_88); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubOutPathAccess().getThresholdKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,25,FOLLOW_52); 

                    				newLeafNode(otherlv_3, grammarAccess.getStubOutPathAccess().getLeftSquareBracketKeyword_1_1());
                    			
                    // InternalTurn.g:5623:4: ( (lv_threshold_4_0= rulePositiveInteger ) )
                    // InternalTurn.g:5624:5: (lv_threshold_4_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5624:5: (lv_threshold_4_0= rulePositiveInteger )
                    // InternalTurn.g:5625:6: lv_threshold_4_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getStubOutPathAccess().getThresholdPositiveIntegerParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_19);
                    lv_threshold_4_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getStubOutPathRule());
                    						}
                    						set(
                    							current,
                    							"threshold",
                    							lv_threshold_4_0,
                    							"org.xtext.project.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_5=(Token)match(input,26,FOLLOW_61); 

                    				newLeafNode(otherlv_5, grammarAccess.getStubOutPathAccess().getRightSquareBracketKeyword_1_3());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5647:3: ( (lv_path_6_0= rulePathBody ) )
            // InternalTurn.g:5648:4: (lv_path_6_0= rulePathBody )
            {
            // InternalTurn.g:5648:4: (lv_path_6_0= rulePathBody )
            // InternalTurn.g:5649:5: lv_path_6_0= rulePathBody
            {

            					newCompositeNode(grammarAccess.getStubOutPathAccess().getPathPathBodyParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_path_6_0=rulePathBody();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getStubOutPathRule());
            					}
            					set(
            						current,
            						"path",
            						lv_path_6_0,
            						"org.xtext.project.turn.Turn.PathBody");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStubOutPath"


    // $ANTLR start "entryRulePluginBinding"
    // InternalTurn.g:5670:1: entryRulePluginBinding returns [EObject current=null] : iv_rulePluginBinding= rulePluginBinding EOF ;
    public final EObject entryRulePluginBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginBinding = null;


        try {
            // InternalTurn.g:5670:54: (iv_rulePluginBinding= rulePluginBinding EOF )
            // InternalTurn.g:5671:2: iv_rulePluginBinding= rulePluginBinding EOF
            {
             newCompositeNode(grammarAccess.getPluginBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePluginBinding=rulePluginBinding();

            state._fsp--;

             current =iv_rulePluginBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePluginBinding"


    // $ANTLR start "rulePluginBinding"
    // InternalTurn.g:5677:1: rulePluginBinding returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) ;
    public final EObject rulePluginBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_0_0 = null;

        AntlrDatatypeRuleToken lv_replication_2_0 = null;

        EObject lv_binding_5_0 = null;

        EObject lv_bindings_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5683:2: ( ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) )
            // InternalTurn.g:5684:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            {
            // InternalTurn.g:5684:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            // InternalTurn.g:5685:3: ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            {
            // InternalTurn.g:5685:3: ( (lv_condition_0_0= ruleCondition ) )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==25) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalTurn.g:5686:4: (lv_condition_0_0= ruleCondition )
                    {
                    // InternalTurn.g:5686:4: (lv_condition_0_0= ruleCondition )
                    // InternalTurn.g:5687:5: lv_condition_0_0= ruleCondition
                    {

                    					newCompositeNode(grammarAccess.getPluginBindingAccess().getConditionConditionParserRuleCall_0_0());
                    				
                    pushFollow(FOLLOW_106);
                    lv_condition_0_0=ruleCondition();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    					}
                    					set(
                    						current,
                    						"condition",
                    						lv_condition_0_0,
                    						"org.xtext.project.turn.Turn.Condition");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:5704:3: (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==89) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalTurn.g:5705:4: otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) )
                    {
                    otherlv_1=(Token)match(input,89,FOLLOW_52); 

                    				newLeafNode(otherlv_1, grammarAccess.getPluginBindingAccess().getReplicationKeyword_1_0());
                    			
                    // InternalTurn.g:5709:4: ( (lv_replication_2_0= rulePositiveInteger ) )
                    // InternalTurn.g:5710:5: (lv_replication_2_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5710:5: (lv_replication_2_0= rulePositiveInteger )
                    // InternalTurn.g:5711:6: lv_replication_2_0= rulePositiveInteger
                    {

                    						newCompositeNode(grammarAccess.getPluginBindingAccess().getReplicationPositiveIntegerParserRuleCall_1_1_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_replication_2_0=rulePositiveInteger();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    						}
                    						set(
                    							current,
                    							"replication",
                    							lv_replication_2_0,
                    							"org.xtext.project.turn.Turn.PositiveInteger");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:5729:3: ( (otherlv_3= RULE_ID ) )
            // InternalTurn.g:5730:4: (otherlv_3= RULE_ID )
            {
            // InternalTurn.g:5730:4: (otherlv_3= RULE_ID )
            // InternalTurn.g:5731:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluginBindingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_107); 

            					newLeafNode(otherlv_3, grammarAccess.getPluginBindingAccess().getMapUCMmapCrossReference_2_0());
            				

            }


            }

            // InternalTurn.g:5742:3: (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==22) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalTurn.g:5743:4: otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPluginBindingAccess().getColonKeyword_3_0());
                    			
                    // InternalTurn.g:5747:4: ( (lv_binding_5_0= ruleBinding ) )
                    // InternalTurn.g:5748:5: (lv_binding_5_0= ruleBinding )
                    {
                    // InternalTurn.g:5748:5: (lv_binding_5_0= ruleBinding )
                    // InternalTurn.g:5749:6: lv_binding_5_0= ruleBinding
                    {

                    						newCompositeNode(grammarAccess.getPluginBindingAccess().getBindingBindingParserRuleCall_3_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_binding_5_0=ruleBinding();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    						}
                    						set(
                    							current,
                    							"binding",
                    							lv_binding_5_0,
                    							"org.xtext.project.turn.Turn.Binding");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:5766:4: (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==23) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // InternalTurn.g:5767:5: otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getPluginBindingAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTurn.g:5771:5: ( (lv_bindings_7_0= ruleBinding ) )
                    	    // InternalTurn.g:5772:6: (lv_bindings_7_0= ruleBinding )
                    	    {
                    	    // InternalTurn.g:5772:6: (lv_bindings_7_0= ruleBinding )
                    	    // InternalTurn.g:5773:7: lv_bindings_7_0= ruleBinding
                    	    {

                    	    							newCompositeNode(grammarAccess.getPluginBindingAccess().getBindingsBindingParserRuleCall_3_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    lv_bindings_7_0=ruleBinding();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getPluginBindingRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"bindings",
                    	    								lv_bindings_7_0,
                    	    								"org.xtext.project.turn.Turn.Binding");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop111;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePluginBinding"


    // $ANTLR start "entryRuleComponentRef"
    // InternalTurn.g:5796:1: entryRuleComponentRef returns [EObject current=null] : iv_ruleComponentRef= ruleComponentRef EOF ;
    public final EObject entryRuleComponentRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentRef = null;


        try {
            // InternalTurn.g:5796:53: (iv_ruleComponentRef= ruleComponentRef EOF )
            // InternalTurn.g:5797:2: iv_ruleComponentRef= ruleComponentRef EOF
            {
             newCompositeNode(grammarAccess.getComponentRefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentRef=ruleComponentRef();

            state._fsp--;

             current =iv_ruleComponentRef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentRef"


    // $ANTLR start "ruleComponentRef"
    // InternalTurn.g:5803:1: ruleComponentRef returns [EObject current=null] : ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) ;
    public final EObject ruleComponentRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Enumerator lv_kind_1_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_element_5_0 = null;

        EObject lv_elements_7_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5809:2: ( ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) )
            // InternalTurn.g:5810:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            {
            // InternalTurn.g:5810:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            // InternalTurn.g:5811:3: (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            {
            // InternalTurn.g:5811:3: (otherlv_0= 'protected' )?
            int alt113=2;
            int LA113_0 = input.LA(1);

            if ( (LA113_0==90) ) {
                alt113=1;
            }
            switch (alt113) {
                case 1 :
                    // InternalTurn.g:5812:4: otherlv_0= 'protected'
                    {
                    otherlv_0=(Token)match(input,90,FOLLOW_108); 

                    				newLeafNode(otherlv_0, grammarAccess.getComponentRefAccess().getProtectedKeyword_0());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5817:3: ( (lv_kind_1_0= ruleCOMPONENTKIND ) )?
            int alt114=2;
            int LA114_0 = input.LA(1);

            if ( (LA114_0==32||(LA114_0>=129 && LA114_0<=133)) ) {
                alt114=1;
            }
            switch (alt114) {
                case 1 :
                    // InternalTurn.g:5818:4: (lv_kind_1_0= ruleCOMPONENTKIND )
                    {
                    // InternalTurn.g:5818:4: (lv_kind_1_0= ruleCOMPONENTKIND )
                    // InternalTurn.g:5819:5: lv_kind_1_0= ruleCOMPONENTKIND
                    {

                    					newCompositeNode(grammarAccess.getComponentRefAccess().getKindCOMPONENTKINDEnumRuleCall_1_0());
                    				
                    pushFollow(FOLLOW_3);
                    lv_kind_1_0=ruleCOMPONENTKIND();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    					}
                    					set(
                    						current,
                    						"kind",
                    						lv_kind_1_0,
                    						"org.xtext.project.turn.Turn.COMPONENTKIND");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalTurn.g:5836:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:5837:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:5837:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:5838:5: lv_name_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getComponentRefAccess().getNameQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_2_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5855:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:5856:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:5856:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:5857:5: lv_longName_3_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getComponentRefAccess().getLongNameLongNameParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_107);
            lv_longName_3_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getComponentRefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_3_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:5874:3: (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            int alt116=2;
            int LA116_0 = input.LA(1);

            if ( (LA116_0==22) ) {
                alt116=1;
            }
            switch (alt116) {
                case 1 :
                    // InternalTurn.g:5875:4: otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getComponentRefAccess().getColonKeyword_4_0());
                    			
                    // InternalTurn.g:5879:4: ( (lv_element_5_0= ruleBoundOption ) )
                    // InternalTurn.g:5880:5: (lv_element_5_0= ruleBoundOption )
                    {
                    // InternalTurn.g:5880:5: (lv_element_5_0= ruleBoundOption )
                    // InternalTurn.g:5881:6: lv_element_5_0= ruleBoundOption
                    {

                    						newCompositeNode(grammarAccess.getComponentRefAccess().getElementBoundOptionParserRuleCall_4_1_0());
                    					
                    pushFollow(FOLLOW_16);
                    lv_element_5_0=ruleBoundOption();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    						}
                    						set(
                    							current,
                    							"element",
                    							lv_element_5_0,
                    							"org.xtext.project.turn.Turn.BoundOption");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:5898:4: (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    loop115:
                    do {
                        int alt115=2;
                        int LA115_0 = input.LA(1);

                        if ( (LA115_0==23) ) {
                            alt115=1;
                        }


                        switch (alt115) {
                    	case 1 :
                    	    // InternalTurn.g:5899:5: otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getComponentRefAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalTurn.g:5903:5: ( (lv_elements_7_0= ruleBoundOption ) )
                    	    // InternalTurn.g:5904:6: (lv_elements_7_0= ruleBoundOption )
                    	    {
                    	    // InternalTurn.g:5904:6: (lv_elements_7_0= ruleBoundOption )
                    	    // InternalTurn.g:5905:7: lv_elements_7_0= ruleBoundOption
                    	    {

                    	    							newCompositeNode(grammarAccess.getComponentRefAccess().getElementsBoundOptionParserRuleCall_4_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_16);
                    	    lv_elements_7_0=ruleBoundOption();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getComponentRefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"elements",
                    	    								lv_elements_7_0,
                    	    								"org.xtext.project.turn.Turn.BoundOption");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop115;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentRef"


    // $ANTLR start "entryRuleBoundOption"
    // InternalTurn.g:5928:1: entryRuleBoundOption returns [EObject current=null] : iv_ruleBoundOption= ruleBoundOption EOF ;
    public final EObject entryRuleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundOption = null;


        try {
            // InternalTurn.g:5928:52: (iv_ruleBoundOption= ruleBoundOption EOF )
            // InternalTurn.g:5929:2: iv_ruleBoundOption= ruleBoundOption EOF
            {
             newCompositeNode(grammarAccess.getBoundOptionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundOption=ruleBoundOption();

            state._fsp--;

             current =iv_ruleBoundOption; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundOption"


    // $ANTLR start "ruleBoundOption"
    // InternalTurn.g:5935:1: ruleBoundOption returns [EObject current=null] : (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) ;
    public final EObject ruleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject this_BoundElement_0 = null;

        EObject this_LongBoundElement_1 = null;



        	enterRule();

        try {
            // InternalTurn.g:5941:2: ( (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) )
            // InternalTurn.g:5942:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            {
            // InternalTurn.g:5942:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            int alt117=2;
            alt117 = dfa117.predict(input);
            switch (alt117) {
                case 1 :
                    // InternalTurn.g:5943:3: this_BoundElement_0= ruleBoundElement
                    {

                    			newCompositeNode(grammarAccess.getBoundOptionAccess().getBoundElementParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_BoundElement_0=ruleBoundElement();

                    state._fsp--;


                    			current = this_BoundElement_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:5952:3: this_LongBoundElement_1= ruleLongBoundElement
                    {

                    			newCompositeNode(grammarAccess.getBoundOptionAccess().getLongBoundElementParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_LongBoundElement_1=ruleLongBoundElement();

                    state._fsp--;


                    			current = this_LongBoundElement_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundOption"


    // $ANTLR start "entryRuleBoundElement"
    // InternalTurn.g:5964:1: entryRuleBoundElement returns [EObject current=null] : iv_ruleBoundElement= ruleBoundElement EOF ;
    public final EObject entryRuleBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundElement = null;


        try {
            // InternalTurn.g:5964:53: (iv_ruleBoundElement= ruleBoundElement EOF )
            // InternalTurn.g:5965:2: iv_ruleBoundElement= ruleBoundElement EOF
            {
             newCompositeNode(grammarAccess.getBoundElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBoundElement=ruleBoundElement();

            state._fsp--;

             current =iv_ruleBoundElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBoundElement"


    // $ANTLR start "ruleBoundElement"
    // InternalTurn.g:5971:1: ruleBoundElement returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleBoundElement() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalTurn.g:5977:2: ( ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:5978:2: ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:5978:2: ( ( ruleQualifiedName ) )
            // InternalTurn.g:5979:3: ( ruleQualifiedName )
            {
            // InternalTurn.g:5979:3: ( ruleQualifiedName )
            // InternalTurn.g:5980:4: ruleQualifiedName
            {

            				if (current==null) {
            					current = createModelElement(grammarAccess.getBoundElementRule());
            				}
            			

            				newCompositeNode(grammarAccess.getBoundElementAccess().getElemReferencedBoundElementCrossReference_0());
            			
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            				afterParserOrEnumRuleCall();
            			

            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBoundElement"


    // $ANTLR start "entryRuleLongBoundElement"
    // InternalTurn.g:5997:1: entryRuleLongBoundElement returns [EObject current=null] : iv_ruleLongBoundElement= ruleLongBoundElement EOF ;
    public final EObject entryRuleLongBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongBoundElement = null;


        try {
            // InternalTurn.g:5997:57: (iv_ruleLongBoundElement= ruleLongBoundElement EOF )
            // InternalTurn.g:5998:2: iv_ruleLongBoundElement= ruleLongBoundElement EOF
            {
             newCompositeNode(grammarAccess.getLongBoundElementRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleLongBoundElement=ruleLongBoundElement();

            state._fsp--;

             current =iv_ruleLongBoundElement; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleLongBoundElement"


    // $ANTLR start "ruleLongBoundElement"
    // InternalTurn.g:6004:1: ruleLongBoundElement returns [EObject current=null] : ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleLongBoundElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_from_0_0 = null;

        AntlrDatatypeRuleToken lv_to_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6010:2: ( ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) )
            // InternalTurn.g:6011:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            {
            // InternalTurn.g:6011:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            // InternalTurn.g:6012:3: ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) )
            {
            // InternalTurn.g:6012:3: ( (lv_from_0_0= ruleQualifiedName ) )
            // InternalTurn.g:6013:4: (lv_from_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:6013:4: (lv_from_0_0= ruleQualifiedName )
            // InternalTurn.g:6014:5: lv_from_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLongBoundElementAccess().getFromQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_109);
            lv_from_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLongBoundElementRule());
            					}
            					set(
            						current,
            						"from",
            						lv_from_0_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,91,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getLongBoundElementAccess().getFullStopFullStopKeyword_1());
            		
            // InternalTurn.g:6035:3: ( (lv_to_2_0= ruleQualifiedName ) )
            // InternalTurn.g:6036:4: (lv_to_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:6036:4: (lv_to_2_0= ruleQualifiedName )
            // InternalTurn.g:6037:5: lv_to_2_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getLongBoundElementAccess().getToQualifiedNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_2);
            lv_to_2_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getLongBoundElementRule());
            					}
            					set(
            						current,
            						"to",
            						lv_to_2_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleLongBoundElement"


    // $ANTLR start "entryRuleBinding"
    // InternalTurn.g:6058:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalTurn.g:6058:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalTurn.g:6059:2: iv_ruleBinding= ruleBinding EOF
            {
             newCompositeNode(grammarAccess.getBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleBinding=ruleBinding();

            state._fsp--;

             current =iv_ruleBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBinding"


    // $ANTLR start "ruleBinding"
    // InternalTurn.g:6065:1: ruleBinding returns [EObject current=null] : (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_InBinding_0 = null;

        EObject this_OutBinding_1 = null;

        EObject this_ComponentBinding_2 = null;



        	enterRule();

        try {
            // InternalTurn.g:6071:2: ( (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) )
            // InternalTurn.g:6072:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            {
            // InternalTurn.g:6072:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            int alt118=3;
            alt118 = dfa118.predict(input);
            switch (alt118) {
                case 1 :
                    // InternalTurn.g:6073:3: this_InBinding_0= ruleInBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getInBindingParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_InBinding_0=ruleInBinding();

                    state._fsp--;


                    			current = this_InBinding_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:6082:3: this_OutBinding_1= ruleOutBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getOutBindingParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_OutBinding_1=ruleOutBinding();

                    state._fsp--;


                    			current = this_OutBinding_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:6091:3: this_ComponentBinding_2= ruleComponentBinding
                    {

                    			newCompositeNode(grammarAccess.getBindingAccess().getComponentBindingParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_ComponentBinding_2=ruleComponentBinding();

                    state._fsp--;


                    			current = this_ComponentBinding_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBinding"


    // $ANTLR start "entryRuleInBinding"
    // InternalTurn.g:6103:1: entryRuleInBinding returns [EObject current=null] : iv_ruleInBinding= ruleInBinding EOF ;
    public final EObject entryRuleInBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInBinding = null;


        try {
            // InternalTurn.g:6103:50: (iv_ruleInBinding= ruleInBinding EOF )
            // InternalTurn.g:6104:2: iv_ruleInBinding= ruleInBinding EOF
            {
             newCompositeNode(grammarAccess.getInBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInBinding=ruleInBinding();

            state._fsp--;

             current =iv_ruleInBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInBinding"


    // $ANTLR start "ruleInBinding"
    // InternalTurn.g:6110:1: ruleInBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleInBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6116:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTurn.g:6117:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTurn.g:6117:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTurn.g:6118:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTurn.g:6118:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6119:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6119:4: ( ruleQualifiedName )
            // InternalTurn.g:6120:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getInBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getInBindingAccess().getMapStartStartPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_24);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_110); 

            			newLeafNode(otherlv_1, grammarAccess.getInBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6138:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTurn.g:6139:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,65,FOLLOW_52); 

            				newLeafNode(otherlv_2, grammarAccess.getInBindingAccess().getInKeyword_2_0());
            			
            // InternalTurn.g:6143:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTurn.g:6144:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTurn.g:6144:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTurn.g:6145:6: lv_index_3_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getInBindingAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_index_3_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getInBindingRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_3_0,
            							"org.xtext.project.turn.Turn.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInBinding"


    // $ANTLR start "entryRuleOutBinding"
    // InternalTurn.g:6167:1: entryRuleOutBinding returns [EObject current=null] : iv_ruleOutBinding= ruleOutBinding EOF ;
    public final EObject entryRuleOutBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutBinding = null;


        try {
            // InternalTurn.g:6167:51: (iv_ruleOutBinding= ruleOutBinding EOF )
            // InternalTurn.g:6168:2: iv_ruleOutBinding= ruleOutBinding EOF
            {
             newCompositeNode(grammarAccess.getOutBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleOutBinding=ruleOutBinding();

            state._fsp--;

             current =iv_ruleOutBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOutBinding"


    // $ANTLR start "ruleOutBinding"
    // InternalTurn.g:6174:1: ruleOutBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleOutBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6180:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTurn.g:6181:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTurn.g:6181:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTurn.g:6182:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTurn.g:6182:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6183:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6183:4: ( ruleQualifiedName )
            // InternalTurn.g:6184:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getOutBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getOutBindingAccess().getMapEndEndPointCrossReference_0_0());
            				
            pushFollow(FOLLOW_24);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_111); 

            			newLeafNode(otherlv_1, grammarAccess.getOutBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6202:3: (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTurn.g:6203:4: otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,88,FOLLOW_52); 

            				newLeafNode(otherlv_2, grammarAccess.getOutBindingAccess().getOutKeyword_2_0());
            			
            // InternalTurn.g:6207:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTurn.g:6208:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTurn.g:6208:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTurn.g:6209:6: lv_index_3_0= rulePositiveInteger
            {

            						newCompositeNode(grammarAccess.getOutBindingAccess().getIndexPositiveIntegerParserRuleCall_2_1_0());
            					
            pushFollow(FOLLOW_2);
            lv_index_3_0=rulePositiveInteger();

            state._fsp--;


            						if (current==null) {
            							current = createModelElementForParent(grammarAccess.getOutBindingRule());
            						}
            						set(
            							current,
            							"index",
            							lv_index_3_0,
            							"org.xtext.project.turn.Turn.PositiveInteger");
            						afterParserOrEnumRuleCall();
            					

            }


            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOutBinding"


    // $ANTLR start "entryRuleComponentBinding"
    // InternalTurn.g:6231:1: entryRuleComponentBinding returns [EObject current=null] : iv_ruleComponentBinding= ruleComponentBinding EOF ;
    public final EObject entryRuleComponentBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentBinding = null;


        try {
            // InternalTurn.g:6231:57: (iv_ruleComponentBinding= ruleComponentBinding EOF )
            // InternalTurn.g:6232:2: iv_ruleComponentBinding= ruleComponentBinding EOF
            {
             newCompositeNode(grammarAccess.getComponentBindingRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleComponentBinding=ruleComponentBinding();

            state._fsp--;

             current =iv_ruleComponentBinding; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComponentBinding"


    // $ANTLR start "ruleComponentBinding"
    // InternalTurn.g:6238:1: ruleComponentBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleComponentBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTurn.g:6244:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:6245:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:6245:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:6246:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:6246:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6247:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6247:4: ( ruleQualifiedName )
            // InternalTurn.g:6248:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentBindingAccess().getComponentInComponentRefCrossReference_0_0());
            				
            pushFollow(FOLLOW_24);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_1=(Token)match(input,31,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getComponentBindingAccess().getEqualsSignKeyword_1());
            		
            // InternalTurn.g:6266:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6267:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6267:4: ( ruleQualifiedName )
            // InternalTurn.g:6268:5: ruleQualifiedName
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getComponentBindingRule());
            					}
            				

            					newCompositeNode(grammarAccess.getComponentBindingAccess().getComponentOutComponentRefCrossReference_2_0());
            				
            pushFollow(FOLLOW_2);
            ruleQualifiedName();

            state._fsp--;


            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComponentBinding"


    // $ANTLR start "entryRuleFailureLabel"
    // InternalTurn.g:6286:1: entryRuleFailureLabel returns [EObject current=null] : iv_ruleFailureLabel= ruleFailureLabel EOF ;
    public final EObject entryRuleFailureLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailureLabel = null;


        try {
            // InternalTurn.g:6286:53: (iv_ruleFailureLabel= ruleFailureLabel EOF )
            // InternalTurn.g:6287:2: iv_ruleFailureLabel= ruleFailureLabel EOF
            {
             newCompositeNode(grammarAccess.getFailureLabelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleFailureLabel=ruleFailureLabel();

            state._fsp--;

             current =iv_ruleFailureLabel; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFailureLabel"


    // $ANTLR start "ruleFailureLabel"
    // InternalTurn.g:6293:1: ruleFailureLabel returns [EObject current=null] : (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) ;
    public final EObject ruleFailureLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_failure_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTurn.g:6299:2: ( (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) )
            // InternalTurn.g:6300:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            {
            // InternalTurn.g:6300:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            // InternalTurn.g:6301:3: otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getFailureLabelAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
            		
            // InternalTurn.g:6305:3: ( (lv_failure_1_0= RULE_STRING ) )
            // InternalTurn.g:6306:4: (lv_failure_1_0= RULE_STRING )
            {
            // InternalTurn.g:6306:4: (lv_failure_1_0= RULE_STRING )
            // InternalTurn.g:6307:5: lv_failure_1_0= RULE_STRING
            {
            lv_failure_1_0=(Token)match(input,RULE_STRING,FOLLOW_68); 

            					newLeafNode(lv_failure_1_0, grammarAccess.getFailureLabelAccess().getFailureSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getFailureLabelRule());
            					}
            					setWithLastConsumed(
            						current,
            						"failure",
            						lv_failure_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,61,FOLLOW_2); 

            			newLeafNode(otherlv_2, grammarAccess.getFailureLabelAccess().getRightSquareBracketRightSquareBracketKeyword_2());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFailureLabel"


    // $ANTLR start "entryRuleScenarioGroup"
    // InternalTurn.g:6331:1: entryRuleScenarioGroup returns [EObject current=null] : iv_ruleScenarioGroup= ruleScenarioGroup EOF ;
    public final EObject entryRuleScenarioGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenarioGroup = null;


        try {
            // InternalTurn.g:6331:54: (iv_ruleScenarioGroup= ruleScenarioGroup EOF )
            // InternalTurn.g:6332:2: iv_ruleScenarioGroup= ruleScenarioGroup EOF
            {
             newCompositeNode(grammarAccess.getScenarioGroupRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenarioGroup=ruleScenarioGroup();

            state._fsp--;

             current =iv_ruleScenarioGroup; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenarioGroup"


    // $ANTLR start "ruleScenarioGroup"
    // InternalTurn.g:6338:1: ruleScenarioGroup returns [EObject current=null] : (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_scenario_4_0= ruleReferenceToScenarioDef ) ) (otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) ) )* ) ;
    public final EObject ruleScenarioGroup() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_scenario_4_0 = null;

        EObject lv_scenarios_6_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6344:2: ( (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_scenario_4_0= ruleReferenceToScenarioDef ) ) (otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) ) )* ) )
            // InternalTurn.g:6345:2: (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_scenario_4_0= ruleReferenceToScenarioDef ) ) (otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) ) )* )
            {
            // InternalTurn.g:6345:2: (otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_scenario_4_0= ruleReferenceToScenarioDef ) ) (otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) ) )* )
            // InternalTurn.g:6346:3: otherlv_0= 'scenarioGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_scenario_4_0= ruleReferenceToScenarioDef ) ) (otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) ) )*
            {
            otherlv_0=(Token)match(input,92,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getScenarioGroupAccess().getScenarioGroupKeyword_0());
            		
            // InternalTurn.g:6350:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:6351:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:6351:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:6352:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getScenarioGroupAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_13);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioGroupRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6369:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:6370:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:6370:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:6371:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getScenarioGroupAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_14);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioGroupRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioGroupAccess().getColonKeyword_3());
            		
            // InternalTurn.g:6392:3: ( (lv_scenario_4_0= ruleReferenceToScenarioDef ) )
            // InternalTurn.g:6393:4: (lv_scenario_4_0= ruleReferenceToScenarioDef )
            {
            // InternalTurn.g:6393:4: (lv_scenario_4_0= ruleReferenceToScenarioDef )
            // InternalTurn.g:6394:5: lv_scenario_4_0= ruleReferenceToScenarioDef
            {

            					newCompositeNode(grammarAccess.getScenarioGroupAccess().getScenarioReferenceToScenarioDefParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_16);
            lv_scenario_4_0=ruleReferenceToScenarioDef();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioGroupRule());
            					}
            					set(
            						current,
            						"scenario",
            						lv_scenario_4_0,
            						"org.xtext.project.turn.Turn.ReferenceToScenarioDef");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6411:3: (otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) ) )*
            loop119:
            do {
                int alt119=2;
                int LA119_0 = input.LA(1);

                if ( (LA119_0==23) ) {
                    alt119=1;
                }


                switch (alt119) {
            	case 1 :
            	    // InternalTurn.g:6412:4: otherlv_5= ',' ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getScenarioGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:6416:4: ( (lv_scenarios_6_0= ruleReferenceToScenarioDef ) )
            	    // InternalTurn.g:6417:5: (lv_scenarios_6_0= ruleReferenceToScenarioDef )
            	    {
            	    // InternalTurn.g:6417:5: (lv_scenarios_6_0= ruleReferenceToScenarioDef )
            	    // InternalTurn.g:6418:6: lv_scenarios_6_0= ruleReferenceToScenarioDef
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioGroupAccess().getScenariosReferenceToScenarioDefParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_scenarios_6_0=ruleReferenceToScenarioDef();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioGroupRule());
            	    						}
            	    						add(
            	    							current,
            	    							"scenarios",
            	    							lv_scenarios_6_0,
            	    							"org.xtext.project.turn.Turn.ReferenceToScenarioDef");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop119;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioGroup"


    // $ANTLR start "entryRuleScenarioDef"
    // InternalTurn.g:6440:1: entryRuleScenarioDef returns [EObject current=null] : iv_ruleScenarioDef= ruleScenarioDef EOF ;
    public final EObject entryRuleScenarioDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleScenarioDef = null;


        try {
            // InternalTurn.g:6440:52: (iv_ruleScenarioDef= ruleScenarioDef EOF )
            // InternalTurn.g:6441:2: iv_ruleScenarioDef= ruleScenarioDef EOF
            {
             newCompositeNode(grammarAccess.getScenarioDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleScenarioDef=ruleScenarioDef();

            state._fsp--;

             current =iv_ruleScenarioDef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleScenarioDef"


    // $ANTLR start "ruleScenarioDef"
    // InternalTurn.g:6447:1: ruleScenarioDef returns [EObject current=null] : (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )* )? (otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )* )? (otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )* )? otherlv_22= '}' ) ;
    public final EObject ruleScenarioDef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        Token otherlv_16=null;
        Token otherlv_18=null;
        Token otherlv_20=null;
        Token otherlv_22=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_preconditions_5_0 = null;

        EObject lv_postconditions_7_0 = null;

        EObject lv_initializations_9_0 = null;

        AntlrDatatypeRuleToken lv_startPoint_11_0 = null;

        AntlrDatatypeRuleToken lv_startPoints_13_0 = null;

        AntlrDatatypeRuleToken lv_endPoint_15_0 = null;

        AntlrDatatypeRuleToken lv_endPoints_17_0 = null;

        EObject lv_includedScenario_19_0 = null;

        EObject lv_includedScenarios_21_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6453:2: ( (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )* )? (otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )* )? (otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )* )? otherlv_22= '}' ) )
            // InternalTurn.g:6454:2: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )* )? (otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )* )? (otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )* )? otherlv_22= '}' )
            {
            // InternalTurn.g:6454:2: (otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )* )? (otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )* )? (otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )* )? otherlv_22= '}' )
            // InternalTurn.g:6455:3: otherlv_0= 'scenario' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )* (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )* (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )* (otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )* )? (otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )* )? (otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )* )? otherlv_22= '}'
            {
            otherlv_0=(Token)match(input,93,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getScenarioDefAccess().getScenarioKeyword_0());
            		
            // InternalTurn.g:6459:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:6460:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:6460:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:6461:5: lv_name_1_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getScenarioDefAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_25);
            lv_name_1_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6478:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:6479:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:6479:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:6480:5: lv_longName_2_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getScenarioDefAccess().getLongNameLongNameParserRuleCall_2_0());
            				
            pushFollow(FOLLOW_26);
            lv_longName_2_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_2_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            otherlv_3=(Token)match(input,13,FOLLOW_112); 

            			newLeafNode(otherlv_3, grammarAccess.getScenarioDefAccess().getLeftCurlyBracketKeyword_3());
            		
            // InternalTurn.g:6501:3: (otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) ) )*
            loop120:
            do {
                int alt120=2;
                int LA120_0 = input.LA(1);

                if ( (LA120_0==94) ) {
                    alt120=1;
                }


                switch (alt120) {
            	case 1 :
            	    // InternalTurn.g:6502:4: otherlv_4= 'pre' ( (lv_preconditions_5_0= ruleCondition ) )
            	    {
            	    otherlv_4=(Token)match(input,94,FOLLOW_88); 

            	    				newLeafNode(otherlv_4, grammarAccess.getScenarioDefAccess().getPreKeyword_4_0());
            	    			
            	    // InternalTurn.g:6506:4: ( (lv_preconditions_5_0= ruleCondition ) )
            	    // InternalTurn.g:6507:5: (lv_preconditions_5_0= ruleCondition )
            	    {
            	    // InternalTurn.g:6507:5: (lv_preconditions_5_0= ruleCondition )
            	    // InternalTurn.g:6508:6: lv_preconditions_5_0= ruleCondition
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioDefAccess().getPreconditionsConditionParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_112);
            	    lv_preconditions_5_0=ruleCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"preconditions",
            	    							lv_preconditions_5_0,
            	    							"org.xtext.project.turn.Turn.Condition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop120;
                }
            } while (true);

            // InternalTurn.g:6526:3: (otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) ) )*
            loop121:
            do {
                int alt121=2;
                int LA121_0 = input.LA(1);

                if ( (LA121_0==95) ) {
                    alt121=1;
                }


                switch (alt121) {
            	case 1 :
            	    // InternalTurn.g:6527:4: otherlv_6= 'post' ( (lv_postconditions_7_0= ruleCondition ) )
            	    {
            	    otherlv_6=(Token)match(input,95,FOLLOW_88); 

            	    				newLeafNode(otherlv_6, grammarAccess.getScenarioDefAccess().getPostKeyword_5_0());
            	    			
            	    // InternalTurn.g:6531:4: ( (lv_postconditions_7_0= ruleCondition ) )
            	    // InternalTurn.g:6532:5: (lv_postconditions_7_0= ruleCondition )
            	    {
            	    // InternalTurn.g:6532:5: (lv_postconditions_7_0= ruleCondition )
            	    // InternalTurn.g:6533:6: lv_postconditions_7_0= ruleCondition
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioDefAccess().getPostconditionsConditionParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_113);
            	    lv_postconditions_7_0=ruleCondition();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"postconditions",
            	    							lv_postconditions_7_0,
            	    							"org.xtext.project.turn.Turn.Condition");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop121;
                }
            } while (true);

            // InternalTurn.g:6551:3: (otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) ) )*
            loop122:
            do {
                int alt122=2;
                int LA122_0 = input.LA(1);

                if ( (LA122_0==96) ) {
                    alt122=1;
                }


                switch (alt122) {
            	case 1 :
            	    // InternalTurn.g:6552:4: otherlv_8= 'initialize' ( (lv_initializations_9_0= ruleInitialization ) )
            	    {
            	    otherlv_8=(Token)match(input,96,FOLLOW_3); 

            	    				newLeafNode(otherlv_8, grammarAccess.getScenarioDefAccess().getInitializeKeyword_6_0());
            	    			
            	    // InternalTurn.g:6556:4: ( (lv_initializations_9_0= ruleInitialization ) )
            	    // InternalTurn.g:6557:5: (lv_initializations_9_0= ruleInitialization )
            	    {
            	    // InternalTurn.g:6557:5: (lv_initializations_9_0= ruleInitialization )
            	    // InternalTurn.g:6558:6: lv_initializations_9_0= ruleInitialization
            	    {

            	    						newCompositeNode(grammarAccess.getScenarioDefAccess().getInitializationsInitializationParserRuleCall_6_1_0());
            	    					
            	    pushFollow(FOLLOW_114);
            	    lv_initializations_9_0=ruleInitialization();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
            	    						}
            	    						add(
            	    							current,
            	    							"initializations",
            	    							lv_initializations_9_0,
            	    							"org.xtext.project.turn.Turn.Initialization");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop122;
                }
            } while (true);

            // InternalTurn.g:6576:3: (otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )* )?
            int alt124=2;
            int LA124_0 = input.LA(1);

            if ( (LA124_0==58) ) {
                alt124=1;
            }
            switch (alt124) {
                case 1 :
                    // InternalTurn.g:6577:4: otherlv_10= 'start' ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) ) (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )*
                    {
                    otherlv_10=(Token)match(input,58,FOLLOW_3); 

                    				newLeafNode(otherlv_10, grammarAccess.getScenarioDefAccess().getStartKeyword_7_0());
                    			
                    // InternalTurn.g:6581:4: ( (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint ) )
                    // InternalTurn.g:6582:5: (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint )
                    {
                    // InternalTurn.g:6582:5: (lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint )
                    // InternalTurn.g:6583:6: lv_startPoint_11_0= ruleQualifiedReferenceToStartPoint
                    {

                    						newCompositeNode(grammarAccess.getScenarioDefAccess().getStartPointQualifiedReferenceToStartPointParserRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_115);
                    lv_startPoint_11_0=ruleQualifiedReferenceToStartPoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
                    						}
                    						set(
                    							current,
                    							"startPoint",
                    							lv_startPoint_11_0,
                    							"org.xtext.project.turn.Turn.QualifiedReferenceToStartPoint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:6600:4: (otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) ) )*
                    loop123:
                    do {
                        int alt123=2;
                        int LA123_0 = input.LA(1);

                        if ( (LA123_0==23) ) {
                            alt123=1;
                        }


                        switch (alt123) {
                    	case 1 :
                    	    // InternalTurn.g:6601:5: otherlv_12= ',' ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) )
                    	    {
                    	    otherlv_12=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_12, grammarAccess.getScenarioDefAccess().getCommaKeyword_7_2_0());
                    	    				
                    	    // InternalTurn.g:6605:5: ( (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint ) )
                    	    // InternalTurn.g:6606:6: (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint )
                    	    {
                    	    // InternalTurn.g:6606:6: (lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint )
                    	    // InternalTurn.g:6607:7: lv_startPoints_13_0= ruleQualifiedReferenceToStartPoint
                    	    {

                    	    							newCompositeNode(grammarAccess.getScenarioDefAccess().getStartPointsQualifiedReferenceToStartPointParserRuleCall_7_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_115);
                    	    lv_startPoints_13_0=ruleQualifiedReferenceToStartPoint();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getScenarioDefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"startPoints",
                    	    								lv_startPoints_13_0,
                    	    								"org.xtext.project.turn.Turn.QualifiedReferenceToStartPoint");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop123;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTurn.g:6626:3: (otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )* )?
            int alt126=2;
            int LA126_0 = input.LA(1);

            if ( (LA126_0==77) ) {
                alt126=1;
            }
            switch (alt126) {
                case 1 :
                    // InternalTurn.g:6627:4: otherlv_14= 'end' ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) ) (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )*
                    {
                    otherlv_14=(Token)match(input,77,FOLLOW_3); 

                    				newLeafNode(otherlv_14, grammarAccess.getScenarioDefAccess().getEndKeyword_8_0());
                    			
                    // InternalTurn.g:6631:4: ( (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint ) )
                    // InternalTurn.g:6632:5: (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint )
                    {
                    // InternalTurn.g:6632:5: (lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint )
                    // InternalTurn.g:6633:6: lv_endPoint_15_0= ruleQualifiedReferenceToEndPoint
                    {

                    						newCompositeNode(grammarAccess.getScenarioDefAccess().getEndPointQualifiedReferenceToEndPointParserRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_116);
                    lv_endPoint_15_0=ruleQualifiedReferenceToEndPoint();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
                    						}
                    						set(
                    							current,
                    							"endPoint",
                    							lv_endPoint_15_0,
                    							"org.xtext.project.turn.Turn.QualifiedReferenceToEndPoint");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:6650:4: (otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) ) )*
                    loop125:
                    do {
                        int alt125=2;
                        int LA125_0 = input.LA(1);

                        if ( (LA125_0==23) ) {
                            alt125=1;
                        }


                        switch (alt125) {
                    	case 1 :
                    	    // InternalTurn.g:6651:5: otherlv_16= ',' ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) )
                    	    {
                    	    otherlv_16=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_16, grammarAccess.getScenarioDefAccess().getCommaKeyword_8_2_0());
                    	    				
                    	    // InternalTurn.g:6655:5: ( (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint ) )
                    	    // InternalTurn.g:6656:6: (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint )
                    	    {
                    	    // InternalTurn.g:6656:6: (lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint )
                    	    // InternalTurn.g:6657:7: lv_endPoints_17_0= ruleQualifiedReferenceToEndPoint
                    	    {

                    	    							newCompositeNode(grammarAccess.getScenarioDefAccess().getEndPointsQualifiedReferenceToEndPointParserRuleCall_8_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_116);
                    	    lv_endPoints_17_0=ruleQualifiedReferenceToEndPoint();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getScenarioDefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"endPoints",
                    	    								lv_endPoints_17_0,
                    	    								"org.xtext.project.turn.Turn.QualifiedReferenceToEndPoint");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop125;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalTurn.g:6676:3: (otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )* )?
            int alt128=2;
            int LA128_0 = input.LA(1);

            if ( (LA128_0==42) ) {
                alt128=1;
            }
            switch (alt128) {
                case 1 :
                    // InternalTurn.g:6677:4: otherlv_18= 'includes' ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) ) (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )*
                    {
                    otherlv_18=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_18, grammarAccess.getScenarioDefAccess().getIncludesKeyword_9_0());
                    			
                    // InternalTurn.g:6681:4: ( (lv_includedScenario_19_0= ruleReferenceToScenarioDef ) )
                    // InternalTurn.g:6682:5: (lv_includedScenario_19_0= ruleReferenceToScenarioDef )
                    {
                    // InternalTurn.g:6682:5: (lv_includedScenario_19_0= ruleReferenceToScenarioDef )
                    // InternalTurn.g:6683:6: lv_includedScenario_19_0= ruleReferenceToScenarioDef
                    {

                    						newCompositeNode(grammarAccess.getScenarioDefAccess().getIncludedScenarioReferenceToScenarioDefParserRuleCall_9_1_0());
                    					
                    pushFollow(FOLLOW_45);
                    lv_includedScenario_19_0=ruleReferenceToScenarioDef();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getScenarioDefRule());
                    						}
                    						set(
                    							current,
                    							"includedScenario",
                    							lv_includedScenario_19_0,
                    							"org.xtext.project.turn.Turn.ReferenceToScenarioDef");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    // InternalTurn.g:6700:4: (otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) ) )*
                    loop127:
                    do {
                        int alt127=2;
                        int LA127_0 = input.LA(1);

                        if ( (LA127_0==23) ) {
                            alt127=1;
                        }


                        switch (alt127) {
                    	case 1 :
                    	    // InternalTurn.g:6701:5: otherlv_20= ',' ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) )
                    	    {
                    	    otherlv_20=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getScenarioDefAccess().getCommaKeyword_9_2_0());
                    	    				
                    	    // InternalTurn.g:6705:5: ( (lv_includedScenarios_21_0= ruleReferenceToScenarioDef ) )
                    	    // InternalTurn.g:6706:6: (lv_includedScenarios_21_0= ruleReferenceToScenarioDef )
                    	    {
                    	    // InternalTurn.g:6706:6: (lv_includedScenarios_21_0= ruleReferenceToScenarioDef )
                    	    // InternalTurn.g:6707:7: lv_includedScenarios_21_0= ruleReferenceToScenarioDef
                    	    {

                    	    							newCompositeNode(grammarAccess.getScenarioDefAccess().getIncludedScenariosReferenceToScenarioDefParserRuleCall_9_2_1_0());
                    	    						
                    	    pushFollow(FOLLOW_45);
                    	    lv_includedScenarios_21_0=ruleReferenceToScenarioDef();

                    	    state._fsp--;


                    	    							if (current==null) {
                    	    								current = createModelElementForParent(grammarAccess.getScenarioDefRule());
                    	    							}
                    	    							add(
                    	    								current,
                    	    								"includedScenarios",
                    	    								lv_includedScenarios_21_0,
                    	    								"org.xtext.project.turn.Turn.ReferenceToScenarioDef");
                    	    							afterParserOrEnumRuleCall();
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop127;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_22=(Token)match(input,20,FOLLOW_2); 

            			newLeafNode(otherlv_22, grammarAccess.getScenarioDefAccess().getRightCurlyBracketKeyword_10());
            		

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleScenarioDef"


    // $ANTLR start "entryRuleInitialization"
    // InternalTurn.g:6734:1: entryRuleInitialization returns [EObject current=null] : iv_ruleInitialization= ruleInitialization EOF ;
    public final EObject entryRuleInitialization() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInitialization = null;


        try {
            // InternalTurn.g:6734:55: (iv_ruleInitialization= ruleInitialization EOF )
            // InternalTurn.g:6735:2: iv_ruleInitialization= ruleInitialization EOF
            {
             newCompositeNode(grammarAccess.getInitializationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleInitialization=ruleInitialization();

            state._fsp--;

             current =iv_ruleInitialization; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleInitialization"


    // $ANTLR start "ruleInitialization"
    // InternalTurn.g:6741:1: ruleInitialization returns [EObject current=null] : ( ( ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) | ( ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) ) ) ) ;
    public final EObject ruleInitialization() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_variable_0_0 = null;

        AntlrDatatypeRuleToken lv_value_2_0 = null;

        AntlrDatatypeRuleToken lv_variable_3_0 = null;

        AntlrDatatypeRuleToken lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6747:2: ( ( ( ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) | ( ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) ) ) ) )
            // InternalTurn.g:6748:2: ( ( ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) | ( ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) ) ) )
            {
            // InternalTurn.g:6748:2: ( ( ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) ) | ( ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) ) ) )
            int alt129=2;
            int LA129_0 = input.LA(1);

            if ( (LA129_0==RULE_ID) ) {
                int LA129_1 = input.LA(2);

                if ( (LA129_1==31) ) {
                    int LA129_2 = input.LA(3);

                    if ( (LA129_2==RULE_STRING) ) {
                        alt129=1;
                    }
                    else if ( (LA129_2==RULE_ID) ) {
                        alt129=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 129, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 129, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 129, 0, input);

                throw nvae;
            }
            switch (alt129) {
                case 1 :
                    // InternalTurn.g:6749:3: ( ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
                    {
                    // InternalTurn.g:6749:3: ( ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) ) )
                    // InternalTurn.g:6750:4: ( (lv_variable_0_0= ruleReferenceToVariable ) ) otherlv_1= '=' ( (lv_value_2_0= ruleExpression ) )
                    {
                    // InternalTurn.g:6750:4: ( (lv_variable_0_0= ruleReferenceToVariable ) )
                    // InternalTurn.g:6751:5: (lv_variable_0_0= ruleReferenceToVariable )
                    {
                    // InternalTurn.g:6751:5: (lv_variable_0_0= ruleReferenceToVariable )
                    // InternalTurn.g:6752:6: lv_variable_0_0= ruleReferenceToVariable
                    {

                    						newCompositeNode(grammarAccess.getInitializationAccess().getVariableReferenceToVariableParserRuleCall_0_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_variable_0_0=ruleReferenceToVariable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitializationRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_0_0,
                    							"org.xtext.project.turn.Turn.ReferenceToVariable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_1=(Token)match(input,31,FOLLOW_6); 

                    				newLeafNode(otherlv_1, grammarAccess.getInitializationAccess().getEqualsSignKeyword_0_1());
                    			
                    // InternalTurn.g:6773:4: ( (lv_value_2_0= ruleExpression ) )
                    // InternalTurn.g:6774:5: (lv_value_2_0= ruleExpression )
                    {
                    // InternalTurn.g:6774:5: (lv_value_2_0= ruleExpression )
                    // InternalTurn.g:6775:6: lv_value_2_0= ruleExpression
                    {

                    						newCompositeNode(grammarAccess.getInitializationAccess().getValueExpressionParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_2_0=ruleExpression();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitializationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_2_0,
                    							"org.xtext.project.turn.Turn.Expression");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6794:3: ( ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) ) )
                    {
                    // InternalTurn.g:6794:3: ( ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) ) )
                    // InternalTurn.g:6795:4: ( (lv_variable_3_0= ruleReferenceToEnumVariable ) ) otherlv_4= '=' ( (lv_value_5_0= ruleEnumLiteral ) )
                    {
                    // InternalTurn.g:6795:4: ( (lv_variable_3_0= ruleReferenceToEnumVariable ) )
                    // InternalTurn.g:6796:5: (lv_variable_3_0= ruleReferenceToEnumVariable )
                    {
                    // InternalTurn.g:6796:5: (lv_variable_3_0= ruleReferenceToEnumVariable )
                    // InternalTurn.g:6797:6: lv_variable_3_0= ruleReferenceToEnumVariable
                    {

                    						newCompositeNode(grammarAccess.getInitializationAccess().getVariableReferenceToEnumVariableParserRuleCall_1_0_0());
                    					
                    pushFollow(FOLLOW_24);
                    lv_variable_3_0=ruleReferenceToEnumVariable();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitializationRule());
                    						}
                    						set(
                    							current,
                    							"variable",
                    							lv_variable_3_0,
                    							"org.xtext.project.turn.Turn.ReferenceToEnumVariable");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }

                    otherlv_4=(Token)match(input,31,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getInitializationAccess().getEqualsSignKeyword_1_1());
                    			
                    // InternalTurn.g:6818:4: ( (lv_value_5_0= ruleEnumLiteral ) )
                    // InternalTurn.g:6819:5: (lv_value_5_0= ruleEnumLiteral )
                    {
                    // InternalTurn.g:6819:5: (lv_value_5_0= ruleEnumLiteral )
                    // InternalTurn.g:6820:6: lv_value_5_0= ruleEnumLiteral
                    {

                    						newCompositeNode(grammarAccess.getInitializationAccess().getValueEnumLiteralParserRuleCall_1_2_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_value_5_0=ruleEnumLiteral();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getInitializationRule());
                    						}
                    						set(
                    							current,
                    							"value",
                    							lv_value_5_0,
                    							"org.xtext.project.turn.Turn.EnumLiteral");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleInitialization"


    // $ANTLR start "entryRuleVariable"
    // InternalTurn.g:6842:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


        try {
            // InternalTurn.g:6842:49: (iv_ruleVariable= ruleVariable EOF )
            // InternalTurn.g:6843:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // InternalTurn.g:6849:1: ruleVariable returns [EObject current=null] : ( (otherlv_0= 'bool' | otherlv_1= 'int' | ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) ) ) ( (lv_name_3_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_enumerationType_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6855:2: ( ( (otherlv_0= 'bool' | otherlv_1= 'int' | ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) ) ) ( (lv_name_3_0= ruleQualifiedName ) ) ) )
            // InternalTurn.g:6856:2: ( (otherlv_0= 'bool' | otherlv_1= 'int' | ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) ) ) ( (lv_name_3_0= ruleQualifiedName ) ) )
            {
            // InternalTurn.g:6856:2: ( (otherlv_0= 'bool' | otherlv_1= 'int' | ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) ) ) ( (lv_name_3_0= ruleQualifiedName ) ) )
            // InternalTurn.g:6857:3: (otherlv_0= 'bool' | otherlv_1= 'int' | ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) ) ) ( (lv_name_3_0= ruleQualifiedName ) )
            {
            // InternalTurn.g:6857:3: (otherlv_0= 'bool' | otherlv_1= 'int' | ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) ) )
            int alt130=3;
            switch ( input.LA(1) ) {
            case 97:
                {
                alt130=1;
                }
                break;
            case 98:
                {
                alt130=2;
                }
                break;
            case RULE_ID:
                {
                alt130=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 130, 0, input);

                throw nvae;
            }

            switch (alt130) {
                case 1 :
                    // InternalTurn.g:6858:4: otherlv_0= 'bool'
                    {
                    otherlv_0=(Token)match(input,97,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getBoolKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:6863:4: otherlv_1= 'int'
                    {
                    otherlv_1=(Token)match(input,98,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getVariableAccess().getIntKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalTurn.g:6868:4: ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) )
                    {
                    // InternalTurn.g:6868:4: ( (lv_enumerationType_2_0= ruleReferenceToEnumerationType ) )
                    // InternalTurn.g:6869:5: (lv_enumerationType_2_0= ruleReferenceToEnumerationType )
                    {
                    // InternalTurn.g:6869:5: (lv_enumerationType_2_0= ruleReferenceToEnumerationType )
                    // InternalTurn.g:6870:6: lv_enumerationType_2_0= ruleReferenceToEnumerationType
                    {

                    						newCompositeNode(grammarAccess.getVariableAccess().getEnumerationTypeReferenceToEnumerationTypeParserRuleCall_0_2_0());
                    					
                    pushFollow(FOLLOW_3);
                    lv_enumerationType_2_0=ruleReferenceToEnumerationType();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getVariableRule());
                    						}
                    						set(
                    							current,
                    							"enumerationType",
                    							lv_enumerationType_2_0,
                    							"org.xtext.project.turn.Turn.ReferenceToEnumerationType");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalTurn.g:6888:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalTurn.g:6889:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalTurn.g:6889:4: (lv_name_3_0= ruleQualifiedName )
            // InternalTurn.g:6890:5: lv_name_3_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getVariableAccess().getNameQualifiedNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_name_3_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getVariableRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_3_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleEnumerationType"
    // InternalTurn.g:6911:1: entryRuleEnumerationType returns [EObject current=null] : iv_ruleEnumerationType= ruleEnumerationType EOF ;
    public final EObject entryRuleEnumerationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationType = null;


        try {
            // InternalTurn.g:6911:56: (iv_ruleEnumerationType= ruleEnumerationType EOF )
            // InternalTurn.g:6912:2: iv_ruleEnumerationType= ruleEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationType=ruleEnumerationType();

            state._fsp--;

             current =iv_ruleEnumerationType; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumerationType"


    // $ANTLR start "ruleEnumerationType"
    // InternalTurn.g:6918:1: ruleEnumerationType returns [EObject current=null] : (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* ) ;
    public final EObject ruleEnumerationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_value_3_0 = null;

        AntlrDatatypeRuleToken lv_values_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6924:2: ( (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* ) )
            // InternalTurn.g:6925:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* )
            {
            // InternalTurn.g:6925:2: (otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )* )
            // InternalTurn.g:6926:3: otherlv_0= 'enum' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_value_3_0= ruleEnumLiteral ) ) (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )*
            {
            otherlv_0=(Token)match(input,99,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEnumerationTypeAccess().getEnumKeyword_0());
            		
            // InternalTurn.g:6930:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalTurn.g:6931:4: (lv_name_1_0= RULE_ID )
            {
            // InternalTurn.g:6931:4: (lv_name_1_0= RULE_ID )
            // InternalTurn.g:6932:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_14); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEnumerationTypeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEnumerationTypeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,22,FOLLOW_3); 

            			newLeafNode(otherlv_2, grammarAccess.getEnumerationTypeAccess().getColonKeyword_2());
            		
            // InternalTurn.g:6952:3: ( (lv_value_3_0= ruleEnumLiteral ) )
            // InternalTurn.g:6953:4: (lv_value_3_0= ruleEnumLiteral )
            {
            // InternalTurn.g:6953:4: (lv_value_3_0= ruleEnumLiteral )
            // InternalTurn.g:6954:5: lv_value_3_0= ruleEnumLiteral
            {

            					newCompositeNode(grammarAccess.getEnumerationTypeAccess().getValueEnumLiteralParserRuleCall_3_0());
            				
            pushFollow(FOLLOW_16);
            lv_value_3_0=ruleEnumLiteral();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            					}
            					set(
            						current,
            						"value",
            						lv_value_3_0,
            						"org.xtext.project.turn.Turn.EnumLiteral");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:6971:3: (otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) ) )*
            loop131:
            do {
                int alt131=2;
                int LA131_0 = input.LA(1);

                if ( (LA131_0==23) ) {
                    alt131=1;
                }


                switch (alt131) {
            	case 1 :
            	    // InternalTurn.g:6972:4: otherlv_4= ',' ( (lv_values_5_0= ruleEnumLiteral ) )
            	    {
            	    otherlv_4=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_4, grammarAccess.getEnumerationTypeAccess().getCommaKeyword_4_0());
            	    			
            	    // InternalTurn.g:6976:4: ( (lv_values_5_0= ruleEnumLiteral ) )
            	    // InternalTurn.g:6977:5: (lv_values_5_0= ruleEnumLiteral )
            	    {
            	    // InternalTurn.g:6977:5: (lv_values_5_0= ruleEnumLiteral )
            	    // InternalTurn.g:6978:6: lv_values_5_0= ruleEnumLiteral
            	    {

            	    						newCompositeNode(grammarAccess.getEnumerationTypeAccess().getValuesEnumLiteralParserRuleCall_4_1_0());
            	    					
            	    pushFollow(FOLLOW_16);
            	    lv_values_5_0=ruleEnumLiteral();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getEnumerationTypeRule());
            	    						}
            	    						add(
            	    							current,
            	    							"values",
            	    							lv_values_5_0,
            	    							"org.xtext.project.turn.Turn.EnumLiteral");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop131;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumerationType"


    // $ANTLR start "entryRuleReferenceToScenarioDef"
    // InternalTurn.g:7000:1: entryRuleReferenceToScenarioDef returns [EObject current=null] : iv_ruleReferenceToScenarioDef= ruleReferenceToScenarioDef EOF ;
    public final EObject entryRuleReferenceToScenarioDef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceToScenarioDef = null;


        try {
            // InternalTurn.g:7000:63: (iv_ruleReferenceToScenarioDef= ruleReferenceToScenarioDef EOF )
            // InternalTurn.g:7001:2: iv_ruleReferenceToScenarioDef= ruleReferenceToScenarioDef EOF
            {
             newCompositeNode(grammarAccess.getReferenceToScenarioDefRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceToScenarioDef=ruleReferenceToScenarioDef();

            state._fsp--;

             current =iv_ruleReferenceToScenarioDef; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceToScenarioDef"


    // $ANTLR start "ruleReferenceToScenarioDef"
    // InternalTurn.g:7007:1: ruleReferenceToScenarioDef returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) ) ;
    public final EObject ruleReferenceToScenarioDef() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:7013:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) ) )
            // InternalTurn.g:7014:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )
            {
            // InternalTurn.g:7014:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )
            // InternalTurn.g:7015:3: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
            {
            // InternalTurn.g:7015:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalTurn.g:7016:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:7016:4: (lv_name_0_0= ruleQualifiedName )
            // InternalTurn.g:7017:5: lv_name_0_0= ruleQualifiedName
            {

            					newCompositeNode(grammarAccess.getReferenceToScenarioDefAccess().getNameQualifiedNameParserRuleCall_0_0());
            				
            pushFollow(FOLLOW_76);
            lv_name_0_0=ruleQualifiedName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceToScenarioDefRule());
            					}
            					set(
            						current,
            						"name",
            						lv_name_0_0,
            						"org.xtext.project.turn.Turn.QualifiedName");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalTurn.g:7034:3: ( (lv_longName_1_0= ruleLongName ) )
            // InternalTurn.g:7035:4: (lv_longName_1_0= ruleLongName )
            {
            // InternalTurn.g:7035:4: (lv_longName_1_0= ruleLongName )
            // InternalTurn.g:7036:5: lv_longName_1_0= ruleLongName
            {

            					newCompositeNode(grammarAccess.getReferenceToScenarioDefAccess().getLongNameLongNameParserRuleCall_1_0());
            				
            pushFollow(FOLLOW_2);
            lv_longName_1_0=ruleLongName();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getReferenceToScenarioDefRule());
            					}
            					set(
            						current,
            						"longName",
            						lv_longName_1_0,
            						"org.xtext.project.turn.Turn.LongName");
            					afterParserOrEnumRuleCall();
            				

            }


            }


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceToScenarioDef"


    // $ANTLR start "entryRuleReferenceToVariable"
    // InternalTurn.g:7057:1: entryRuleReferenceToVariable returns [String current=null] : iv_ruleReferenceToVariable= ruleReferenceToVariable EOF ;
    public final String entryRuleReferenceToVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReferenceToVariable = null;


        try {
            // InternalTurn.g:7057:59: (iv_ruleReferenceToVariable= ruleReferenceToVariable EOF )
            // InternalTurn.g:7058:2: iv_ruleReferenceToVariable= ruleReferenceToVariable EOF
            {
             newCompositeNode(grammarAccess.getReferenceToVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceToVariable=ruleReferenceToVariable();

            state._fsp--;

             current =iv_ruleReferenceToVariable.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceToVariable"


    // $ANTLR start "ruleReferenceToVariable"
    // InternalTurn.g:7064:1: ruleReferenceToVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleReferenceToVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7070:2: (this_ID_0= RULE_ID )
            // InternalTurn.g:7071:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getReferenceToVariableAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceToVariable"


    // $ANTLR start "entryRuleReferenceToEnumVariable"
    // InternalTurn.g:7081:1: entryRuleReferenceToEnumVariable returns [String current=null] : iv_ruleReferenceToEnumVariable= ruleReferenceToEnumVariable EOF ;
    public final String entryRuleReferenceToEnumVariable() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReferenceToEnumVariable = null;


        try {
            // InternalTurn.g:7081:63: (iv_ruleReferenceToEnumVariable= ruleReferenceToEnumVariable EOF )
            // InternalTurn.g:7082:2: iv_ruleReferenceToEnumVariable= ruleReferenceToEnumVariable EOF
            {
             newCompositeNode(grammarAccess.getReferenceToEnumVariableRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceToEnumVariable=ruleReferenceToEnumVariable();

            state._fsp--;

             current =iv_ruleReferenceToEnumVariable.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceToEnumVariable"


    // $ANTLR start "ruleReferenceToEnumVariable"
    // InternalTurn.g:7088:1: ruleReferenceToEnumVariable returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleReferenceToEnumVariable() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7094:2: (this_ID_0= RULE_ID )
            // InternalTurn.g:7095:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getReferenceToEnumVariableAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceToEnumVariable"


    // $ANTLR start "entryRuleReferenceToEnumerationType"
    // InternalTurn.g:7105:1: entryRuleReferenceToEnumerationType returns [String current=null] : iv_ruleReferenceToEnumerationType= ruleReferenceToEnumerationType EOF ;
    public final String entryRuleReferenceToEnumerationType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleReferenceToEnumerationType = null;


        try {
            // InternalTurn.g:7105:66: (iv_ruleReferenceToEnumerationType= ruleReferenceToEnumerationType EOF )
            // InternalTurn.g:7106:2: iv_ruleReferenceToEnumerationType= ruleReferenceToEnumerationType EOF
            {
             newCompositeNode(grammarAccess.getReferenceToEnumerationTypeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleReferenceToEnumerationType=ruleReferenceToEnumerationType();

            state._fsp--;

             current =iv_ruleReferenceToEnumerationType.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleReferenceToEnumerationType"


    // $ANTLR start "ruleReferenceToEnumerationType"
    // InternalTurn.g:7112:1: ruleReferenceToEnumerationType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleReferenceToEnumerationType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7118:2: (this_ID_0= RULE_ID )
            // InternalTurn.g:7119:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getReferenceToEnumerationTypeAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleReferenceToEnumerationType"


    // $ANTLR start "entryRuleQualifiedReferenceToStartPoint"
    // InternalTurn.g:7129:1: entryRuleQualifiedReferenceToStartPoint returns [String current=null] : iv_ruleQualifiedReferenceToStartPoint= ruleQualifiedReferenceToStartPoint EOF ;
    public final String entryRuleQualifiedReferenceToStartPoint() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedReferenceToStartPoint = null;


        try {
            // InternalTurn.g:7129:70: (iv_ruleQualifiedReferenceToStartPoint= ruleQualifiedReferenceToStartPoint EOF )
            // InternalTurn.g:7130:2: iv_ruleQualifiedReferenceToStartPoint= ruleQualifiedReferenceToStartPoint EOF
            {
             newCompositeNode(grammarAccess.getQualifiedReferenceToStartPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedReferenceToStartPoint=ruleQualifiedReferenceToStartPoint();

            state._fsp--;

             current =iv_ruleQualifiedReferenceToStartPoint.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedReferenceToStartPoint"


    // $ANTLR start "ruleQualifiedReferenceToStartPoint"
    // InternalTurn.g:7136:1: ruleQualifiedReferenceToStartPoint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_QualifiedName_0= ruleQualifiedName ;
    public final AntlrDatatypeRuleToken ruleQualifiedReferenceToStartPoint() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:7142:2: (this_QualifiedName_0= ruleQualifiedName )
            // InternalTurn.g:7143:2: this_QualifiedName_0= ruleQualifiedName
            {

            		newCompositeNode(grammarAccess.getQualifiedReferenceToStartPointAccess().getQualifiedNameParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
            	

            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedReferenceToStartPoint"


    // $ANTLR start "entryRuleQualifiedReferenceToEndPoint"
    // InternalTurn.g:7156:1: entryRuleQualifiedReferenceToEndPoint returns [String current=null] : iv_ruleQualifiedReferenceToEndPoint= ruleQualifiedReferenceToEndPoint EOF ;
    public final String entryRuleQualifiedReferenceToEndPoint() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedReferenceToEndPoint = null;


        try {
            // InternalTurn.g:7156:68: (iv_ruleQualifiedReferenceToEndPoint= ruleQualifiedReferenceToEndPoint EOF )
            // InternalTurn.g:7157:2: iv_ruleQualifiedReferenceToEndPoint= ruleQualifiedReferenceToEndPoint EOF
            {
             newCompositeNode(grammarAccess.getQualifiedReferenceToEndPointRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedReferenceToEndPoint=ruleQualifiedReferenceToEndPoint();

            state._fsp--;

             current =iv_ruleQualifiedReferenceToEndPoint.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedReferenceToEndPoint"


    // $ANTLR start "ruleQualifiedReferenceToEndPoint"
    // InternalTurn.g:7163:1: ruleQualifiedReferenceToEndPoint returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_QualifiedName_0= ruleQualifiedName ;
    public final AntlrDatatypeRuleToken ruleQualifiedReferenceToEndPoint() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_QualifiedName_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:7169:2: (this_QualifiedName_0= ruleQualifiedName )
            // InternalTurn.g:7170:2: this_QualifiedName_0= ruleQualifiedName
            {

            		newCompositeNode(grammarAccess.getQualifiedReferenceToEndPointAccess().getQualifiedNameParserRuleCall());
            	
            pushFollow(FOLLOW_2);
            this_QualifiedName_0=ruleQualifiedName();

            state._fsp--;


            		current.merge(this_QualifiedName_0);
            	

            		afterParserOrEnumRuleCall();
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedReferenceToEndPoint"


    // $ANTLR start "entryRuleExpression"
    // InternalTurn.g:7183:1: entryRuleExpression returns [String current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final String entryRuleExpression() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleExpression = null;


        try {
            // InternalTurn.g:7183:50: (iv_ruleExpression= ruleExpression EOF )
            // InternalTurn.g:7184:2: iv_ruleExpression= ruleExpression EOF
            {
             newCompositeNode(grammarAccess.getExpressionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;

             current =iv_ruleExpression.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalTurn.g:7190:1: ruleExpression returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_STRING_0= RULE_STRING ;
    public final AntlrDatatypeRuleToken ruleExpression() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7196:2: (this_STRING_0= RULE_STRING )
            // InternalTurn.g:7197:2: this_STRING_0= RULE_STRING
            {
            this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            		current.merge(this_STRING_0);
            	

            		newLeafNode(this_STRING_0, grammarAccess.getExpressionAccess().getSTRINGTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleEnumLiteral"
    // InternalTurn.g:7207:1: entryRuleEnumLiteral returns [String current=null] : iv_ruleEnumLiteral= ruleEnumLiteral EOF ;
    public final String entryRuleEnumLiteral() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEnumLiteral = null;


        try {
            // InternalTurn.g:7207:51: (iv_ruleEnumLiteral= ruleEnumLiteral EOF )
            // InternalTurn.g:7208:2: iv_ruleEnumLiteral= ruleEnumLiteral EOF
            {
             newCompositeNode(grammarAccess.getEnumLiteralRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEnumLiteral=ruleEnumLiteral();

            state._fsp--;

             current =iv_ruleEnumLiteral.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEnumLiteral"


    // $ANTLR start "ruleEnumLiteral"
    // InternalTurn.g:7214:1: ruleEnumLiteral returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleEnumLiteral() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7220:2: (this_ID_0= RULE_ID )
            // InternalTurn.g:7221:2: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

            		current.merge(this_ID_0);
            	

            		newLeafNode(this_ID_0, grammarAccess.getEnumLiteralAccess().getIDTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEnumLiteral"


    // $ANTLR start "entryRulePositiveInteger"
    // InternalTurn.g:7231:1: entryRulePositiveInteger returns [String current=null] : iv_rulePositiveInteger= rulePositiveInteger EOF ;
    public final String entryRulePositiveInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePositiveInteger = null;


        try {
            // InternalTurn.g:7231:55: (iv_rulePositiveInteger= rulePositiveInteger EOF )
            // InternalTurn.g:7232:2: iv_rulePositiveInteger= rulePositiveInteger EOF
            {
             newCompositeNode(grammarAccess.getPositiveIntegerRule()); 
            pushFollow(FOLLOW_1);
            iv_rulePositiveInteger=rulePositiveInteger();

            state._fsp--;

             current =iv_rulePositiveInteger.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePositiveInteger"


    // $ANTLR start "rulePositiveInteger"
    // InternalTurn.g:7238:1: rulePositiveInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken rulePositiveInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalTurn.g:7244:2: (this_INT_0= RULE_INT )
            // InternalTurn.g:7245:2: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_2); 

            		current.merge(this_INT_0);
            	

            		newLeafNode(this_INT_0, grammarAccess.getPositiveIntegerAccess().getINTTerminalRuleCall());
            	

            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePositiveInteger"


    // $ANTLR start "entryRuleText"
    // InternalTurn.g:7255:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalTurn.g:7255:45: (iv_ruleText= ruleText EOF )
            // InternalTurn.g:7256:2: iv_ruleText= ruleText EOF
            {
             newCompositeNode(grammarAccess.getTextRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleText=ruleText();

            state._fsp--;

             current =iv_ruleText; 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleText"


    // $ANTLR start "ruleText"
    // InternalTurn.g:7262:1: ruleText returns [EObject current=null] : ( (lv_content_0_0= ruleTextContent ) )+ ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_content_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:7268:2: ( ( (lv_content_0_0= ruleTextContent ) )+ )
            // InternalTurn.g:7269:2: ( (lv_content_0_0= ruleTextContent ) )+
            {
            // InternalTurn.g:7269:2: ( (lv_content_0_0= ruleTextContent ) )+
            int cnt132=0;
            loop132:
            do {
                int alt132=2;
                int LA132_0 = input.LA(1);

                if ( (LA132_0==RULE_ID) ) {
                    int LA132_2 = input.LA(2);

                    if ( (LA132_2==EOF||(LA132_2>=RULE_ID && LA132_2<=RULE_INT)||(LA132_2>=11 && LA132_2<=12)||LA132_2==21||LA132_2==24||(LA132_2>=26 && LA132_2<=27)||LA132_2==30||LA132_2==32||(LA132_2>=40 && LA132_2<=41)||LA132_2==47||(LA132_2>=51 && LA132_2<=53)||(LA132_2>=56 && LA132_2<=57)||LA132_2==82||(LA132_2>=92 && LA132_2<=93)||(LA132_2>=97 && LA132_2<=99)||(LA132_2>=101 && LA132_2<=103)) ) {
                        alt132=1;
                    }
                    else if ( (LA132_2==100) ) {
                        alt132=1;
                    }


                }
                else if ( (LA132_0==RULE_INT||LA132_0==24||LA132_0==82||(LA132_0>=100 && LA132_0<=103)) ) {
                    alt132=1;
                }


                switch (alt132) {
            	case 1 :
            	    // InternalTurn.g:7270:3: (lv_content_0_0= ruleTextContent )
            	    {
            	    // InternalTurn.g:7270:3: (lv_content_0_0= ruleTextContent )
            	    // InternalTurn.g:7271:4: lv_content_0_0= ruleTextContent
            	    {

            	    				newCompositeNode(grammarAccess.getTextAccess().getContentTextContentParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_117);
            	    lv_content_0_0=ruleTextContent();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getTextRule());
            	    				}
            	    				add(
            	    					current,
            	    					"content",
            	    					lv_content_0_0,
            	    					"org.xtext.project.turn.Turn.TextContent");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt132 >= 1 ) break loop132;
                        EarlyExitException eee =
                            new EarlyExitException(132, input);
                        throw eee;
                }
                cnt132++;
            } while (true);


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleText"


    // $ANTLR start "entryRuleTextContent"
    // InternalTurn.g:7291:1: entryRuleTextContent returns [String current=null] : iv_ruleTextContent= ruleTextContent EOF ;
    public final String entryRuleTextContent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTextContent = null;


        try {
            // InternalTurn.g:7291:51: (iv_ruleTextContent= ruleTextContent EOF )
            // InternalTurn.g:7292:2: iv_ruleTextContent= ruleTextContent EOF
            {
             newCompositeNode(grammarAccess.getTextContentRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleTextContent=ruleTextContent();

            state._fsp--;

             current =iv_ruleTextContent.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTextContent"


    // $ANTLR start "ruleTextContent"
    // InternalTurn.g:7298:1: ruleTextContent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleTextContent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalTurn.g:7304:2: ( (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) )
            // InternalTurn.g:7305:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            {
            // InternalTurn.g:7305:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            int alt133=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt133=1;
                }
                break;
            case 100:
                {
                alt133=2;
                }
                break;
            case 24:
                {
                alt133=3;
                }
                break;
            case 101:
                {
                alt133=4;
                }
                break;
            case 102:
                {
                alt133=5;
                }
                break;
            case 103:
                {
                alt133=6;
                }
                break;
            case 82:
                {
                alt133=7;
                }
                break;
            case RULE_INT:
                {
                alt133=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 133, 0, input);

                throw nvae;
            }

            switch (alt133) {
                case 1 :
                    // InternalTurn.g:7306:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getTextContentAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:7314:3: kw= '@'
                    {
                    kw=(Token)match(input,100,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getCommercialAtKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:7320:3: kw= '#'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getNumberSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:7326:3: kw= '!'
                    {
                    kw=(Token)match(input,101,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getExclamationMarkKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalTurn.g:7332:3: kw= '%'
                    {
                    kw=(Token)match(input,102,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getPercentSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalTurn.g:7338:3: kw= '&'
                    {
                    kw=(Token)match(input,103,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalTurn.g:7344:3: kw= '*'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAsteriskKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalTurn.g:7350:3: this_INT_7= RULE_INT
                    {
                    this_INT_7=(Token)match(input,RULE_INT,FOLLOW_2); 

                    			current.merge(this_INT_7);
                    		

                    			newLeafNode(this_INT_7, grammarAccess.getTextContentAccess().getINTTerminalRuleCall_7());
                    		

                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTextContent"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalTurn.g:7361:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTurn.g:7361:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTurn.g:7362:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_2); 

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // InternalTurn.g:7368:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTurn.g:7374:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTurn.g:7375:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTurn.g:7375:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTurn.g:7376:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_118); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTurn.g:7383:3: (kw= '.' this_ID_2= RULE_ID )*
            loop134:
            do {
                int alt134=2;
                int LA134_0 = input.LA(1);

                if ( (LA134_0==78) ) {
                    int LA134_2 = input.LA(2);

                    if ( (LA134_2==RULE_ID) ) {
                        alt134=1;
                    }


                }


                switch (alt134) {
            	case 1 :
            	    // InternalTurn.g:7384:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,78,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_118); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop134;
                }
            } while (true);


            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "ruleQualitativeLabel"
    // InternalTurn.g:7401:1: ruleQualitativeLabel returns [Enumerator current=null] : ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) ;
    public final Enumerator ruleQualitativeLabel() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalTurn.g:7407:2: ( ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) )
            // InternalTurn.g:7408:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            {
            // InternalTurn.g:7408:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            int alt135=7;
            switch ( input.LA(1) ) {
            case 104:
                {
                alt135=1;
                }
                break;
            case 105:
                {
                alt135=2;
                }
                break;
            case 106:
                {
                alt135=3;
                }
                break;
            case 107:
                {
                alt135=4;
                }
                break;
            case 108:
                {
                alt135=5;
                }
                break;
            case 109:
                {
                alt135=6;
                }
                break;
            case 110:
                {
                alt135=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 135, 0, input);

                throw nvae;
            }

            switch (alt135) {
                case 1 :
                    // InternalTurn.g:7409:3: (enumLiteral_0= 'denied' )
                    {
                    // InternalTurn.g:7409:3: (enumLiteral_0= 'denied' )
                    // InternalTurn.g:7410:4: enumLiteral_0= 'denied'
                    {
                    enumLiteral_0=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7417:3: (enumLiteral_1= 'weaklyDenied' )
                    {
                    // InternalTurn.g:7417:3: (enumLiteral_1= 'weaklyDenied' )
                    // InternalTurn.g:7418:4: enumLiteral_1= 'weaklyDenied'
                    {
                    enumLiteral_1=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7425:3: (enumLiteral_2= 'weaklySatisfied' )
                    {
                    // InternalTurn.g:7425:3: (enumLiteral_2= 'weaklySatisfied' )
                    // InternalTurn.g:7426:4: enumLiteral_2= 'weaklySatisfied'
                    {
                    enumLiteral_2=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7433:3: (enumLiteral_3= 'satisfied' )
                    {
                    // InternalTurn.g:7433:3: (enumLiteral_3= 'satisfied' )
                    // InternalTurn.g:7434:4: enumLiteral_3= 'satisfied'
                    {
                    enumLiteral_3=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7441:3: (enumLiteral_4= 'conflict' )
                    {
                    // InternalTurn.g:7441:3: (enumLiteral_4= 'conflict' )
                    // InternalTurn.g:7442:4: enumLiteral_4= 'conflict'
                    {
                    enumLiteral_4=(Token)match(input,108,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7449:3: (enumLiteral_5= 'unknown' )
                    {
                    // InternalTurn.g:7449:3: (enumLiteral_5= 'unknown' )
                    // InternalTurn.g:7450:4: enumLiteral_5= 'unknown'
                    {
                    enumLiteral_5=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTurn.g:7457:3: (enumLiteral_6= 'none' )
                    {
                    // InternalTurn.g:7457:3: (enumLiteral_6= 'none' )
                    // InternalTurn.g:7458:4: enumLiteral_6= 'none'
                    {
                    enumLiteral_6=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getNoneEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getQualitativeLabelAccess().getNoneEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualitativeLabel"


    // $ANTLR start "ruleIntentionalElementType"
    // InternalTurn.g:7468:1: ruleIntentionalElementType returns [Enumerator current=null] : ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) ;
    public final Enumerator ruleIntentionalElementType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTurn.g:7474:2: ( ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) )
            // InternalTurn.g:7475:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            {
            // InternalTurn.g:7475:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            int alt136=6;
            switch ( input.LA(1) ) {
            case 111:
                {
                alt136=1;
                }
                break;
            case 112:
                {
                alt136=2;
                }
                break;
            case 113:
                {
                alt136=3;
                }
                break;
            case 114:
                {
                alt136=4;
                }
                break;
            case 115:
                {
                alt136=5;
                }
                break;
            case 116:
                {
                alt136=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 136, 0, input);

                throw nvae;
            }

            switch (alt136) {
                case 1 :
                    // InternalTurn.g:7476:3: (enumLiteral_0= 'softgoal' )
                    {
                    // InternalTurn.g:7476:3: (enumLiteral_0= 'softgoal' )
                    // InternalTurn.g:7477:4: enumLiteral_0= 'softgoal'
                    {
                    enumLiteral_0=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7484:3: (enumLiteral_1= 'goal' )
                    {
                    // InternalTurn.g:7484:3: (enumLiteral_1= 'goal' )
                    // InternalTurn.g:7485:4: enumLiteral_1= 'goal'
                    {
                    enumLiteral_1=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7492:3: (enumLiteral_2= 'task' )
                    {
                    // InternalTurn.g:7492:3: (enumLiteral_2= 'task' )
                    // InternalTurn.g:7493:4: enumLiteral_2= 'task'
                    {
                    enumLiteral_2=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7500:3: (enumLiteral_3= 'resource' )
                    {
                    // InternalTurn.g:7500:3: (enumLiteral_3= 'resource' )
                    // InternalTurn.g:7501:4: enumLiteral_3= 'resource'
                    {
                    enumLiteral_3=(Token)match(input,114,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7508:3: (enumLiteral_4= 'belief' )
                    {
                    // InternalTurn.g:7508:3: (enumLiteral_4= 'belief' )
                    // InternalTurn.g:7509:4: enumLiteral_4= 'belief'
                    {
                    enumLiteral_4=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7516:3: (enumLiteral_5= 'indicator' )
                    {
                    // InternalTurn.g:7516:3: (enumLiteral_5= 'indicator' )
                    // InternalTurn.g:7517:4: enumLiteral_5= 'indicator'
                    {
                    enumLiteral_5=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getIndicatorEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getIntentionalElementTypeAccess().getIndicatorEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIntentionalElementType"


    // $ANTLR start "ruleContributionType"
    // InternalTurn.g:7527:1: ruleContributionType returns [Enumerator current=null] : ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) ) ;
    public final Enumerator ruleContributionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;
        Token enumLiteral_6=null;


        	enterRule();

        try {
            // InternalTurn.g:7533:2: ( ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) ) )
            // InternalTurn.g:7534:2: ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) )
            {
            // InternalTurn.g:7534:2: ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) )
            int alt137=7;
            switch ( input.LA(1) ) {
            case 117:
                {
                alt137=1;
                }
                break;
            case 118:
                {
                alt137=2;
                }
                break;
            case 119:
                {
                alt137=3;
                }
                break;
            case 109:
                {
                alt137=4;
                }
                break;
            case 120:
                {
                alt137=5;
                }
                break;
            case 121:
                {
                alt137=6;
                }
                break;
            case 122:
                {
                alt137=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 137, 0, input);

                throw nvae;
            }

            switch (alt137) {
                case 1 :
                    // InternalTurn.g:7535:3: (enumLiteral_0= 'make' )
                    {
                    // InternalTurn.g:7535:3: (enumLiteral_0= 'make' )
                    // InternalTurn.g:7536:4: enumLiteral_0= 'make'
                    {
                    enumLiteral_0=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7543:3: (enumLiteral_1= 'help' )
                    {
                    // InternalTurn.g:7543:3: (enumLiteral_1= 'help' )
                    // InternalTurn.g:7544:4: enumLiteral_1= 'help'
                    {
                    enumLiteral_1=(Token)match(input,118,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7551:3: (enumLiteral_2= 'somePositive' )
                    {
                    // InternalTurn.g:7551:3: (enumLiteral_2= 'somePositive' )
                    // InternalTurn.g:7552:4: enumLiteral_2= 'somePositive'
                    {
                    enumLiteral_2=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7559:3: (enumLiteral_3= 'unknown' )
                    {
                    // InternalTurn.g:7559:3: (enumLiteral_3= 'unknown' )
                    // InternalTurn.g:7560:4: enumLiteral_3= 'unknown'
                    {
                    enumLiteral_3=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7567:3: (enumLiteral_4= 'someNegative' )
                    {
                    // InternalTurn.g:7567:3: (enumLiteral_4= 'someNegative' )
                    // InternalTurn.g:7568:4: enumLiteral_4= 'someNegative'
                    {
                    enumLiteral_4=(Token)match(input,120,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7575:3: (enumLiteral_5= 'hurt' )
                    {
                    // InternalTurn.g:7575:3: (enumLiteral_5= 'hurt' )
                    // InternalTurn.g:7576:4: enumLiteral_5= 'hurt'
                    {
                    enumLiteral_5=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTurn.g:7583:3: (enumLiteral_6= 'break' )
                    {
                    // InternalTurn.g:7583:3: (enumLiteral_6= 'break' )
                    // InternalTurn.g:7584:4: enumLiteral_6= 'break'
                    {
                    enumLiteral_6=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getBreakEnumLiteralDeclaration_6().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_6, grammarAccess.getContributionTypeAccess().getBreakEnumLiteralDeclaration_6());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleContributionType"


    // $ANTLR start "ruleImportanceType"
    // InternalTurn.g:7594:1: ruleImportanceType returns [Enumerator current=null] : ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) ;
    public final Enumerator ruleImportanceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTurn.g:7600:2: ( ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) )
            // InternalTurn.g:7601:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            {
            // InternalTurn.g:7601:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            int alt138=4;
            switch ( input.LA(1) ) {
            case 123:
                {
                alt138=1;
                }
                break;
            case 124:
                {
                alt138=2;
                }
                break;
            case 125:
                {
                alt138=3;
                }
                break;
            case 110:
                {
                alt138=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 138, 0, input);

                throw nvae;
            }

            switch (alt138) {
                case 1 :
                    // InternalTurn.g:7602:3: (enumLiteral_0= 'high' )
                    {
                    // InternalTurn.g:7602:3: (enumLiteral_0= 'high' )
                    // InternalTurn.g:7603:4: enumLiteral_0= 'high'
                    {
                    enumLiteral_0=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7610:3: (enumLiteral_1= 'medium' )
                    {
                    // InternalTurn.g:7610:3: (enumLiteral_1= 'medium' )
                    // InternalTurn.g:7611:4: enumLiteral_1= 'medium'
                    {
                    enumLiteral_1=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7618:3: (enumLiteral_2= 'low' )
                    {
                    // InternalTurn.g:7618:3: (enumLiteral_2= 'low' )
                    // InternalTurn.g:7619:4: enumLiteral_2= 'low'
                    {
                    enumLiteral_2=(Token)match(input,125,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7626:3: (enumLiteral_3= 'none' )
                    {
                    // InternalTurn.g:7626:3: (enumLiteral_3= 'none' )
                    // InternalTurn.g:7627:4: enumLiteral_3= 'none'
                    {
                    enumLiteral_3=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getNoneEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getImportanceTypeAccess().getNoneEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleImportanceType"


    // $ANTLR start "ruleDecompositionType"
    // InternalTurn.g:7637:1: ruleDecompositionType returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) ;
    public final Enumerator ruleDecompositionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTurn.g:7643:2: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) )
            // InternalTurn.g:7644:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            {
            // InternalTurn.g:7644:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            int alt139=3;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt139=1;
                }
                break;
            case 79:
                {
                alt139=2;
                }
                break;
            case 126:
                {
                alt139=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 139, 0, input);

                throw nvae;
            }

            switch (alt139) {
                case 1 :
                    // InternalTurn.g:7645:3: (enumLiteral_0= 'and' )
                    {
                    // InternalTurn.g:7645:3: (enumLiteral_0= 'and' )
                    // InternalTurn.g:7646:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7653:3: (enumLiteral_1= 'or' )
                    {
                    // InternalTurn.g:7653:3: (enumLiteral_1= 'or' )
                    // InternalTurn.g:7654:4: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7661:3: (enumLiteral_2= 'xor' )
                    {
                    // InternalTurn.g:7661:3: (enumLiteral_2= 'xor' )
                    // InternalTurn.g:7662:4: enumLiteral_2= 'xor'
                    {
                    enumLiteral_2=(Token)match(input,126,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getXorEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getDecompositionTypeAccess().getXorEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleDecompositionType"


    // $ANTLR start "ruleWAITKIND"
    // InternalTurn.g:7672:1: ruleWAITKIND returns [Enumerator current=null] : ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) ;
    public final Enumerator ruleWAITKIND() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTurn.g:7678:2: ( ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) )
            // InternalTurn.g:7679:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            {
            // InternalTurn.g:7679:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            int alt140=2;
            int LA140_0 = input.LA(1);

            if ( (LA140_0==127) ) {
                alt140=1;
            }
            else if ( (LA140_0==128) ) {
                alt140=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 140, 0, input);

                throw nvae;
            }
            switch (alt140) {
                case 1 :
                    // InternalTurn.g:7680:3: (enumLiteral_0= 'persistent' )
                    {
                    // InternalTurn.g:7680:3: (enumLiteral_0= 'persistent' )
                    // InternalTurn.g:7681:4: enumLiteral_0= 'persistent'
                    {
                    enumLiteral_0=(Token)match(input,127,FOLLOW_2); 

                    				current = grammarAccess.getWAITKINDAccess().getPersistentEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getWAITKINDAccess().getPersistentEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7688:3: (enumLiteral_1= 'transient' )
                    {
                    // InternalTurn.g:7688:3: (enumLiteral_1= 'transient' )
                    // InternalTurn.g:7689:4: enumLiteral_1= 'transient'
                    {
                    enumLiteral_1=(Token)match(input,128,FOLLOW_2); 

                    				current = grammarAccess.getWAITKINDAccess().getTransientEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getWAITKINDAccess().getTransientEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleWAITKIND"


    // $ANTLR start "ruleCOMPONENTKIND"
    // InternalTurn.g:7699:1: ruleCOMPONENTKIND returns [Enumerator current=null] : ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) ;
    public final Enumerator ruleCOMPONENTKIND() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;
        Token enumLiteral_5=null;


        	enterRule();

        try {
            // InternalTurn.g:7705:2: ( ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) )
            // InternalTurn.g:7706:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            {
            // InternalTurn.g:7706:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            int alt141=6;
            switch ( input.LA(1) ) {
            case 129:
                {
                alt141=1;
                }
                break;
            case 130:
                {
                alt141=2;
                }
                break;
            case 131:
                {
                alt141=3;
                }
                break;
            case 132:
                {
                alt141=4;
                }
                break;
            case 32:
                {
                alt141=5;
                }
                break;
            case 133:
                {
                alt141=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 141, 0, input);

                throw nvae;
            }

            switch (alt141) {
                case 1 :
                    // InternalTurn.g:7707:3: (enumLiteral_0= 'team' )
                    {
                    // InternalTurn.g:7707:3: (enumLiteral_0= 'team' )
                    // InternalTurn.g:7708:4: enumLiteral_0= 'team'
                    {
                    enumLiteral_0=(Token)match(input,129,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getTeamEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCOMPONENTKINDAccess().getTeamEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:7715:3: (enumLiteral_1= 'object' )
                    {
                    // InternalTurn.g:7715:3: (enumLiteral_1= 'object' )
                    // InternalTurn.g:7716:4: enumLiteral_1= 'object'
                    {
                    enumLiteral_1=(Token)match(input,130,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCOMPONENTKINDAccess().getObjectEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:7723:3: (enumLiteral_2= 'process' )
                    {
                    // InternalTurn.g:7723:3: (enumLiteral_2= 'process' )
                    // InternalTurn.g:7724:4: enumLiteral_2= 'process'
                    {
                    enumLiteral_2=(Token)match(input,131,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getProcessEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCOMPONENTKINDAccess().getProcessEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:7731:3: (enumLiteral_3= 'agent' )
                    {
                    // InternalTurn.g:7731:3: (enumLiteral_3= 'agent' )
                    // InternalTurn.g:7732:4: enumLiteral_3= 'agent'
                    {
                    enumLiteral_3=(Token)match(input,132,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getAgentEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCOMPONENTKINDAccess().getAgentEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:7739:3: (enumLiteral_4= 'actor' )
                    {
                    // InternalTurn.g:7739:3: (enumLiteral_4= 'actor' )
                    // InternalTurn.g:7740:4: enumLiteral_4= 'actor'
                    {
                    enumLiteral_4=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getActorEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCOMPONENTKINDAccess().getActorEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:7747:3: (enumLiteral_5= 'parent' )
                    {
                    // InternalTurn.g:7747:3: (enumLiteral_5= 'parent' )
                    // InternalTurn.g:7748:4: enumLiteral_5= 'parent'
                    {
                    enumLiteral_5=(Token)match(input,133,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getParentEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getCOMPONENTKINDAccess().getParentEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;

            }


            }


            	leaveRule();

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCOMPONENTKIND"

    // Delegated rules


    protected DFA16 dfa16 = new DFA16(this);
    protected DFA23 dfa23 = new DFA23(this);
    protected DFA33 dfa33 = new DFA33(this);
    protected DFA60 dfa60 = new DFA60(this);
    protected DFA73 dfa73 = new DFA73(this);
    protected DFA102 dfa102 = new DFA102(this);
    protected DFA117 dfa117 = new DFA117(this);
    protected DFA118 dfa118 = new DFA118(this);
    static final String dfa_1s = "\22\uffff";
    static final String dfa_2s = "\1\1\21\uffff";
    static final String dfa_3s = "\1\5\21\uffff";
    static final String dfa_4s = "\1\143\21\uffff";
    static final String dfa_5s = "\1\uffff\1\21\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16\1\17\1\20";
    static final String dfa_6s = "\1\0\21\uffff}>";
    static final String[] dfa_7s = {
            "\1\15\5\uffff\1\2\1\4\10\uffff\1\17\5\uffff\1\20\2\uffff\1\21\1\uffff\1\3\7\uffff\1\5\1\6\5\uffff\1\7\3\uffff\1\7\1\10\1\11\2\uffff\2\12\42\uffff\1\13\1\14\3\uffff\2\15\1\16",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA16 extends DFA {

        public DFA16(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 16;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenGroups_12_0= ruleScenarioGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_scenDefs_13_0= ruleScenarioDef ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_variables_14_0= ruleVariable ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_enumTypes_15_0= ruleEnumerationType ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_16_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_17_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_18_0= ruleMetadata ) ) )+ ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA16_0 = input.LA(1);

                         
                        int index16_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA16_0==EOF) ) {s = 1;}

                        else if ( LA16_0 == 11 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {s = 2;}

                        else if ( LA16_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {s = 3;}

                        else if ( LA16_0 == 12 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {s = 4;}

                        else if ( LA16_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {s = 5;}

                        else if ( LA16_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {s = 6;}

                        else if ( ( LA16_0 == 47 || LA16_0 == 51 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {s = 7;}

                        else if ( LA16_0 == 52 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {s = 8;}

                        else if ( LA16_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {s = 9;}

                        else if ( LA16_0 >= 56 && LA16_0 <= 57 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {s = 10;}

                        else if ( LA16_0 == 92 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {s = 11;}

                        else if ( LA16_0 == 93 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {s = 12;}

                        else if ( ( LA16_0 == RULE_ID || LA16_0 >= 97 && LA16_0 <= 98 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {s = 13;}

                        else if ( LA16_0 == 99 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 12) ) {s = 14;}

                        else if ( LA16_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 13) ) {s = 15;}

                        else if ( LA16_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 14) ) {s = 16;}

                        else if ( LA16_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 15) ) {s = 17;}

                         
                        input.seek(index16_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 16, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\6\uffff";
    static final String dfa_9s = "\1\5\1\26\1\uffff\1\5\1\uffff\1\26";
    static final String dfa_10s = "\1\34\1\116\1\uffff\1\5\1\uffff\1\116";
    static final String dfa_11s = "\2\uffff\1\2\1\uffff\1\1\1\uffff";
    static final String dfa_12s = "\6\uffff}>";
    static final String[] dfa_13s = {
            "\1\1\26\uffff\1\2",
            "\1\4\1\uffff\1\4\4\uffff\1\2\60\uffff\1\3",
            "",
            "\1\5",
            "",
            "\1\4\1\uffff\1\4\4\uffff\1\2\60\uffff\1\3"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA23 extends DFA {

        public DFA23(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 23;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "1062:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?";
        }
    }
    static final String dfa_14s = "\12\uffff";
    static final String dfa_15s = "\1\5\1\30\3\uffff\1\5\1\4\1\30\2\43";
    static final String dfa_16s = "\2\176\3\uffff\2\5\3\176";
    static final String dfa_17s = "\2\uffff\1\1\1\2\1\3\5\uffff";
    static final String dfa_18s = "\12\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\35\uffff\1\2\3\uffff\1\4\47\uffff\1\3\1\uffff\1\3\54\uffff\1\3",
            "\1\6\12\uffff\1\2\3\uffff\1\4\46\uffff\1\5\1\3\1\uffff\1\3\54\uffff\1\3",
            "",
            "",
            "",
            "\1\7",
            "\1\11\1\10",
            "\1\6\12\uffff\1\2\3\uffff\1\4\46\uffff\1\5\1\3\1\uffff\1\3\54\uffff\1\3",
            "\1\2\3\uffff\1\4\47\uffff\1\3\1\uffff\1\3\54\uffff\1\3",
            "\1\2\3\uffff\1\4\47\uffff\1\3\1\uffff\1\3\54\uffff\1\3"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA33 extends DFA {

        public DFA33(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 33;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1580:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )";
        }
    }
    static final String dfa_20s = "\11\uffff";
    static final String dfa_21s = "\1\5\1\uffff\2\5\1\4\1\uffff\3\5";
    static final String dfa_22s = "\1\u0085\1\uffff\1\u0085\2\5\1\uffff\3\u0085";
    static final String dfa_23s = "\1\uffff\1\2\3\uffff\1\1\3\uffff";
    static final String dfa_24s = "\11\uffff}>";
    static final String[] dfa_25s = {
            "\1\2\16\uffff\1\1\13\uffff\1\1\31\uffff\1\1\3\uffff\2\1\32\uffff\1\1\46\uffff\5\1",
            "",
            "\1\1\16\uffff\1\1\1\uffff\1\1\1\uffff\1\4\6\uffff\1\5\1\1\55\uffff\1\3\13\uffff\1\1\46\uffff\5\1",
            "\1\6",
            "\1\10\1\7",
            "",
            "\1\1\16\uffff\1\1\1\uffff\1\1\1\uffff\1\4\6\uffff\1\5\1\1\55\uffff\1\3\13\uffff\1\1\46\uffff\5\1",
            "\1\1\16\uffff\1\1\1\uffff\1\1\10\uffff\1\5\1\1\71\uffff\1\1\46\uffff\5\1",
            "\1\1\16\uffff\1\1\1\uffff\1\1\10\uffff\1\5\1\1\71\uffff\1\1\46\uffff\5\1"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA60 extends DFA {

        public DFA60(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 60;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "()* loopback of 3263:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*";
        }
    }
    static final String dfa_26s = "\1\103\3\uffff\2\110\4\uffff";
    static final String dfa_27s = "\1\u0080\3\uffff\2\111\4\uffff";
    static final String dfa_28s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\1\7";
    static final String[] dfa_29s = {
            "\1\2\1\3\3\1\1\6\1\10\1\uffff\1\11\1\7\62\uffff\1\4\1\5",
            "",
            "",
            "",
            "\1\6\1\10",
            "\1\6\1\10",
            "",
            "",
            "",
            ""
    };
    static final char[] dfa_26 = DFA.unpackEncodedStringToUnsignedChars(dfa_26s);
    static final char[] dfa_27 = DFA.unpackEncodedStringToUnsignedChars(dfa_27s);
    static final short[] dfa_28 = DFA.unpackEncodedString(dfa_28s);
    static final short[][] dfa_29 = unpackEncodedStringArray(dfa_29s);

    class DFA73 extends DFA {

        public DFA73(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 73;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_18;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "3874:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )";
        }
    }
    static final String dfa_30s = "\1\uffff\1\4\3\uffff\1\4";
    static final String dfa_31s = "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String dfa_32s = "\1\126\1\u0085\1\uffff\1\5\1\uffff\1\u0085";
    static final String dfa_33s = "\2\uffff\1\1\1\uffff\1\2\1\uffff";
    static final String[] dfa_34s = {
            "\1\1\120\uffff\1\2",
            "\1\4\7\uffff\1\4\6\uffff\1\4\3\uffff\1\2\1\4\6\uffff\1\4\31\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\3\1\uffff\1\4\1\uffff\1\4\3\uffff\1\2\1\uffff\1\4\1\uffff\1\4\46\uffff\5\4",
            "",
            "\1\5",
            "",
            "\1\4\7\uffff\1\4\6\uffff\1\4\3\uffff\1\2\1\4\6\uffff\1\4\31\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\3\1\uffff\1\4\1\uffff\1\4\3\uffff\1\2\1\uffff\1\4\1\uffff\1\4\46\uffff\5\4"
    };
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA102 extends DFA {

        public DFA102(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 102;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_12;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5279:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )";
        }
    }
    static final String dfa_35s = "\3\5\2\uffff\1\5";
    static final String dfa_36s = "\1\5\1\u0085\1\5\2\uffff\1\u0085";
    static final String dfa_37s = "\3\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_38s = {
            "\1\1",
            "\1\4\16\uffff\1\4\2\uffff\1\4\10\uffff\1\4\55\uffff\1\2\13\uffff\1\4\1\3\45\uffff\5\4",
            "\1\5",
            "",
            "",
            "\1\4\16\uffff\1\4\2\uffff\1\4\10\uffff\1\4\55\uffff\1\2\13\uffff\1\4\1\3\45\uffff\5\4"
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA117 extends DFA {

        public DFA117(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 117;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_12;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "5942:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )";
        }
    }
    static final String dfa_39s = "\10\uffff";
    static final String dfa_40s = "\1\5\1\37\2\5\1\37\3\uffff";
    static final String dfa_41s = "\1\5\1\116\1\5\1\130\1\116\3\uffff";
    static final String dfa_42s = "\5\uffff\1\1\1\2\1\3";
    static final String dfa_43s = "\10\uffff}>";
    static final String[] dfa_44s = {
            "\1\1",
            "\1\3\56\uffff\1\2",
            "\1\4",
            "\1\7\73\uffff\1\5\26\uffff\1\6",
            "\1\3\56\uffff\1\2",
            "",
            "",
            ""
    };

    static final short[] dfa_39 = DFA.unpackEncodedString(dfa_39s);
    static final char[] dfa_40 = DFA.unpackEncodedStringToUnsignedChars(dfa_40s);
    static final char[] dfa_41 = DFA.unpackEncodedStringToUnsignedChars(dfa_41s);
    static final short[] dfa_42 = DFA.unpackEncodedString(dfa_42s);
    static final short[] dfa_43 = DFA.unpackEncodedString(dfa_43s);
    static final short[][] dfa_44 = unpackEncodedStringArray(dfa_44s);

    class DFA118 extends DFA {

        public DFA118(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 118;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "6072:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0338830148203822L,0x0000000E30000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000001400000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000002000020L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000060L,0x000000F000040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200100000L,0x001F800000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00C0000000000040L,0x3800400000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000100000L,0x001F800000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008E00100020L,0x4000000000028000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008C00100020L,0x4000000000028000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008800100020L,0x4000000000028000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00C0000000000040L,0x3FE0600000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000001000020L,0x4000000000028000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000020L,0x4000000000028000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008001000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000040000108020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000100020L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000580000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00C0000000000040L,0x38007F0000000000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x0000000000000050L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0004000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0000480000000000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0000480000100000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xC400000100100020L,0x0000000004000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000100100020L,0x0000000004000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000002000022L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0800000001000000L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0800000000000002L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x1000000000000000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x2000000000000000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000000002L,0x00000000003AA000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000000000022L,0x0000000000000001L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000001L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000002L});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x8000000000001BF8L,0x0000000000000001L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x8000000000001BF8L,0x0000000000000001L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000100L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000200L});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000002002022L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000003002000L});
    public static final BitSet FOLLOW_81 = new BitSet(new long[]{0x0000000002002002L});
    public static final BitSet FOLLOW_82 = new BitSet(new long[]{0x0000000002100000L,0x0000000000000404L});
    public static final BitSet FOLLOW_83 = new BitSet(new long[]{0x0000000002100000L,0x0000000000000004L});
    public static final BitSet FOLLOW_84 = new BitSet(new long[]{0x0000000000100000L,0x0000000000000004L});
    public static final BitSet FOLLOW_85 = new BitSet(new long[]{0x1000000002000022L});
    public static final BitSet FOLLOW_86 = new BitSet(new long[]{0x1000000003000000L});
    public static final BitSet FOLLOW_87 = new BitSet(new long[]{0x1000000002000002L});
    public static final BitSet FOLLOW_88 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_89 = new BitSet(new long[]{0x0000000002000020L,0x0000000000004000L});
    public static final BitSet FOLLOW_90 = new BitSet(new long[]{0x0000000003000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_91 = new BitSet(new long[]{0x0000000002000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_92 = new BitSet(new long[]{0x0000000000000000L,0x0000000000004000L});
    public static final BitSet FOLLOW_93 = new BitSet(new long[]{0x0000000002002020L});
    public static final BitSet FOLLOW_94 = new BitSet(new long[]{0x0000000000000002L,0x0000000000010000L});
    public static final BitSet FOLLOW_95 = new BitSet(new long[]{0x0000000000002020L});
    public static final BitSet FOLLOW_96 = new BitSet(new long[]{0x0000000000100000L,0x0000000000040000L});
    public static final BitSet FOLLOW_97 = new BitSet(new long[]{0x0000000000000000L,0x0000000000080000L});
    public static final BitSet FOLLOW_98 = new BitSet(new long[]{0x0000000000000020L,0x0000000000400002L});
    public static final BitSet FOLLOW_99 = new BitSet(new long[]{0x0000000000000020L,0x0000000000400000L});
    public static final BitSet FOLLOW_100 = new BitSet(new long[]{0x0000000001000020L,0x0000000000400000L});
    public static final BitSet FOLLOW_101 = new BitSet(new long[]{0x0000000000002002L,0x0000000000000004L});
    public static final BitSet FOLLOW_102 = new BitSet(new long[]{0x0000000000100000L,0x0000000001000000L});
    public static final BitSet FOLLOW_103 = new BitSet(new long[]{0x0000000002000020L,0x0000000002800000L});
    public static final BitSet FOLLOW_104 = new BitSet(new long[]{0x0000000081000000L});
    public static final BitSet FOLLOW_105 = new BitSet(new long[]{0x0002000000000000L,0x0000000000000004L});
    public static final BitSet FOLLOW_106 = new BitSet(new long[]{0x0000000000000020L,0x0000000002000000L});
    public static final BitSet FOLLOW_107 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000100000020L,0x0000000000000000L,0x000000000000003EL});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0400040000100000L,0x00000001C0002000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0400040000100000L,0x0000000180002000L});
    public static final BitSet FOLLOW_114 = new BitSet(new long[]{0x0400040000100000L,0x0000000100002000L});
    public static final BitSet FOLLOW_115 = new BitSet(new long[]{0x0000040000900000L,0x0000000000002000L});
    public static final BitSet FOLLOW_116 = new BitSet(new long[]{0x0000040000900000L});
    public static final BitSet FOLLOW_117 = new BitSet(new long[]{0x0000000001000062L,0x000000F000040000L});
    public static final BitSet FOLLOW_118 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});

}
