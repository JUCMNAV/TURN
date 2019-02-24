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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'urnModel'", "'showAsMeansEnd'", "'{'", "'description'", "'author'", "'created'", "'modified'", "'version'", "'urnVersion'", "'}'", "'concern'", "':'", "','", "'#'", "'['", "']'", "'link'", "'type'", "'-->'", "'metadata'", "'='", "'actor'", "'importance'", "'unit'", "'contributesTo'", "'correlated'", "'with'", "'decomposes'", "'dependsOn'", "'strategiesGroup'", "'strategy'", "'includes'", "'exceeding'", "'evaluation'", "'convertedWith'", "'real'", "'linearConversion'", "'target'", "'threshold'", "'worst'", "'mappingConversion'", "'contributionContextGroup'", "'contributionContext'", "'-'", "'+'", "'singleton'", "'map'", "'start'", "'catches'", "'[['", "']]'", "'abort'", "'failure'", "';'", "'in'", "'->'", "'X'", "'join'", "'synch'", "'sync'", "'|'", "'wait'", "'timer'", "'timeout'", "'trigger'", "'fail'", "'end'", "'.'", "'or'", "'[else]'", "'and'", "'*'", "'stub'", "'synchronizing'", "'blocking'", "'('", "')'", "'out'", "'replication'", "'protected'", "'..'", "'@'", "'!'", "'%'", "'&'", "'denied'", "'weaklyDenied'", "'weaklySatisfied'", "'satisfied'", "'conflict'", "'unknown'", "'none'", "'softgoal'", "'goal'", "'task'", "'resource'", "'belief'", "'indicator'", "'make'", "'help'", "'somePositive'", "'someNegative'", "'hurt'", "'break'", "'high'", "'medium'", "'low'", "'xor'", "'persistent'", "'transient'", "'team'", "'object'", "'process'", "'agent'", "'parent'"
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
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=5;
    public static final int RULE_INT=6;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__67=67;
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__125=125;
    public static final int T__64=64;
    public static final int T__65=65;
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
    // InternalTurn.g:72:1: ruleURNspec returns [EObject current=null] : ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) ) ;
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

        EObject lv_concerns_12_0 = null;

        EObject lv_urnlinks_13_0 = null;

        EObject lv_metadata_14_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:78:2: ( ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) ) )
            // InternalTurn.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) )
            {
            // InternalTurn.g:79:2: ( ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?) ) )
            // InternalTurn.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?) )
            {
            // InternalTurn.g:80:3: ( ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?) )
            // InternalTurn.g:81:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?)
            {
             
            			  getUnorderedGroupHelper().enter(grammarAccess.getURNspecAccess().getUnorderedGroup());
            			
            // InternalTurn.g:84:4: ( ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?)
            // InternalTurn.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+ {...}?
            {
            // InternalTurn.g:85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=13;
                alt12 = dfa12.predict(input);
                switch (alt12) {
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
            	    // InternalTurn.g:358:3: ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) )
            	    {
            	    // InternalTurn.g:358:3: ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) )
            	    // InternalTurn.g:359:4: {...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9)");
            	    }
            	    // InternalTurn.g:359:101: ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ )
            	    // InternalTurn.g:360:5: ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9);
            	    				
            	    // InternalTurn.g:363:8: ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+
            	    int cnt9=0;
            	    loop9:
            	    do {
            	        int alt9=2;
            	        int LA9_0 = input.LA(1);

            	        if ( (LA9_0==21) ) {
            	            int LA9_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt9=1;
            	            }


            	        }


            	        switch (alt9) {
            	    	case 1 :
            	    	    // InternalTurn.g:363:9: {...}? => ( (lv_concerns_12_0= ruleConcern ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:363:18: ( (lv_concerns_12_0= ruleConcern ) )
            	    	    // InternalTurn.g:363:19: (lv_concerns_12_0= ruleConcern )
            	    	    {
            	    	    // InternalTurn.g:363:19: (lv_concerns_12_0= ruleConcern )
            	    	    // InternalTurn.g:364:9: lv_concerns_12_0= ruleConcern
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getConcernsConcernParserRuleCall_9_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_concerns_12_0=ruleConcern();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"concerns",
            	    	    										lv_concerns_12_0,
            	    	    										"org.xtext.project.turn.Turn.Concern");
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
            	    // InternalTurn.g:386:3: ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) )
            	    {
            	    // InternalTurn.g:386:3: ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) )
            	    // InternalTurn.g:387:4: {...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10)");
            	    }
            	    // InternalTurn.g:387:102: ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ )
            	    // InternalTurn.g:388:5: ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10);
            	    				
            	    // InternalTurn.g:391:8: ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+
            	    int cnt10=0;
            	    loop10:
            	    do {
            	        int alt10=2;
            	        int LA10_0 = input.LA(1);

            	        if ( (LA10_0==27) ) {
            	            int LA10_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt10=1;
            	            }


            	        }


            	        switch (alt10) {
            	    	case 1 :
            	    	    // InternalTurn.g:391:9: {...}? => ( (lv_urnlinks_13_0= ruleURNlink ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:391:18: ( (lv_urnlinks_13_0= ruleURNlink ) )
            	    	    // InternalTurn.g:391:19: (lv_urnlinks_13_0= ruleURNlink )
            	    	    {
            	    	    // InternalTurn.g:391:19: (lv_urnlinks_13_0= ruleURNlink )
            	    	    // InternalTurn.g:392:9: lv_urnlinks_13_0= ruleURNlink
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getUrnlinksURNlinkParserRuleCall_10_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_urnlinks_13_0=ruleURNlink();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"urnlinks",
            	    	    										lv_urnlinks_13_0,
            	    	    										"org.xtext.project.turn.Turn.URNlink");
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
            	    // InternalTurn.g:414:3: ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) )
            	    {
            	    // InternalTurn.g:414:3: ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) )
            	    // InternalTurn.g:415:4: {...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ )
            	    {
            	    if ( ! getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {
            	        throw new FailedPredicateException(input, "ruleURNspec", "getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11)");
            	    }
            	    // InternalTurn.g:415:102: ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ )
            	    // InternalTurn.g:416:5: ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+
            	    {

            	    					getUnorderedGroupHelper().select(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11);
            	    				
            	    // InternalTurn.g:419:8: ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+
            	    int cnt11=0;
            	    loop11:
            	    do {
            	        int alt11=2;
            	        int LA11_0 = input.LA(1);

            	        if ( (LA11_0==30) ) {
            	            int LA11_2 = input.LA(2);

            	            if ( ((true)) ) {
            	                alt11=1;
            	            }


            	        }


            	        switch (alt11) {
            	    	case 1 :
            	    	    // InternalTurn.g:419:9: {...}? => ( (lv_metadata_14_0= ruleMetadata ) )
            	    	    {
            	    	    if ( !((true)) ) {
            	    	        throw new FailedPredicateException(input, "ruleURNspec", "true");
            	    	    }
            	    	    // InternalTurn.g:419:18: ( (lv_metadata_14_0= ruleMetadata ) )
            	    	    // InternalTurn.g:419:19: (lv_metadata_14_0= ruleMetadata )
            	    	    {
            	    	    // InternalTurn.g:419:19: (lv_metadata_14_0= ruleMetadata )
            	    	    // InternalTurn.g:420:9: lv_metadata_14_0= ruleMetadata
            	    	    {

            	    	    									newCompositeNode(grammarAccess.getURNspecAccess().getMetadataMetadataParserRuleCall_11_0());
            	    	    								
            	    	    pushFollow(FOLLOW_4);
            	    	    lv_metadata_14_0=ruleMetadata();

            	    	    state._fsp--;


            	    	    									if (current==null) {
            	    	    										current = createModelElementForParent(grammarAccess.getURNspecRule());
            	    	    									}
            	    	    									add(
            	    	    										current,
            	    	    										"metadata",
            	    	    										lv_metadata_14_0,
            	    	    										"org.xtext.project.turn.Turn.Metadata");
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

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
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
    // InternalTurn.g:453:1: entryRuleConcreteURNspec returns [EObject current=null] : iv_ruleConcreteURNspec= ruleConcreteURNspec EOF ;
    public final EObject entryRuleConcreteURNspec() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteURNspec = null;


        try {
            // InternalTurn.g:453:56: (iv_ruleConcreteURNspec= ruleConcreteURNspec EOF )
            // InternalTurn.g:454:2: iv_ruleConcreteURNspec= ruleConcreteURNspec EOF
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
    // InternalTurn.g:460:1: ruleConcreteURNspec returns [EObject current=null] : (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) ;
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
            // InternalTurn.g:466:2: ( (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' ) )
            // InternalTurn.g:467:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            {
            // InternalTurn.g:467:2: (otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}' )
            // InternalTurn.g:468:3: otherlv_0= '{' otherlv_1= 'description' ( (lv_description_2_0= RULE_STRING ) ) otherlv_3= 'author' ( (lv_author_4_0= RULE_STRING ) ) otherlv_5= 'created' ( (lv_created_6_0= RULE_STRING ) ) otherlv_7= 'modified' ( (lv_modified_8_0= RULE_STRING ) ) otherlv_9= 'version' ( (lv_specVersion_10_0= RULE_STRING ) ) otherlv_11= 'urnVersion' ( (lv_urnVersion_12_0= RULE_STRING ) ) otherlv_13= '}'
            {
            otherlv_0=(Token)match(input,13,FOLLOW_5); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteURNspecAccess().getLeftCurlyBracketKeyword_0());
            		
            otherlv_1=(Token)match(input,14,FOLLOW_6); 

            			newLeafNode(otherlv_1, grammarAccess.getConcreteURNspecAccess().getDescriptionKeyword_1());
            		
            // InternalTurn.g:476:3: ( (lv_description_2_0= RULE_STRING ) )
            // InternalTurn.g:477:4: (lv_description_2_0= RULE_STRING )
            {
            // InternalTurn.g:477:4: (lv_description_2_0= RULE_STRING )
            // InternalTurn.g:478:5: lv_description_2_0= RULE_STRING
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
            		
            // InternalTurn.g:498:3: ( (lv_author_4_0= RULE_STRING ) )
            // InternalTurn.g:499:4: (lv_author_4_0= RULE_STRING )
            {
            // InternalTurn.g:499:4: (lv_author_4_0= RULE_STRING )
            // InternalTurn.g:500:5: lv_author_4_0= RULE_STRING
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
            		
            // InternalTurn.g:520:3: ( (lv_created_6_0= RULE_STRING ) )
            // InternalTurn.g:521:4: (lv_created_6_0= RULE_STRING )
            {
            // InternalTurn.g:521:4: (lv_created_6_0= RULE_STRING )
            // InternalTurn.g:522:5: lv_created_6_0= RULE_STRING
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
            		
            // InternalTurn.g:542:3: ( (lv_modified_8_0= RULE_STRING ) )
            // InternalTurn.g:543:4: (lv_modified_8_0= RULE_STRING )
            {
            // InternalTurn.g:543:4: (lv_modified_8_0= RULE_STRING )
            // InternalTurn.g:544:5: lv_modified_8_0= RULE_STRING
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
            		
            // InternalTurn.g:564:3: ( (lv_specVersion_10_0= RULE_STRING ) )
            // InternalTurn.g:565:4: (lv_specVersion_10_0= RULE_STRING )
            {
            // InternalTurn.g:565:4: (lv_specVersion_10_0= RULE_STRING )
            // InternalTurn.g:566:5: lv_specVersion_10_0= RULE_STRING
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
            		
            // InternalTurn.g:586:3: ( (lv_urnVersion_12_0= RULE_STRING ) )
            // InternalTurn.g:587:4: (lv_urnVersion_12_0= RULE_STRING )
            {
            // InternalTurn.g:587:4: (lv_urnVersion_12_0= RULE_STRING )
            // InternalTurn.g:588:5: lv_urnVersion_12_0= RULE_STRING
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
    // InternalTurn.g:612:1: entryRuleConcern returns [EObject current=null] : iv_ruleConcern= ruleConcern EOF ;
    public final EObject entryRuleConcern() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcern = null;


        try {
            // InternalTurn.g:612:48: (iv_ruleConcern= ruleConcern EOF )
            // InternalTurn.g:613:2: iv_ruleConcern= ruleConcern EOF
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
    // InternalTurn.g:619:1: ruleConcern returns [EObject current=null] : (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* ) ;
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
            // InternalTurn.g:625:2: ( (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* ) )
            // InternalTurn.g:626:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )
            {
            // InternalTurn.g:626:2: (otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )* )
            // InternalTurn.g:627:3: otherlv_0= 'concern' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (lv_condition_4_0= ruleCondition ) )? ( ( ruleQualifiedName ) ) (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            {
            otherlv_0=(Token)match(input,21,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConcernAccess().getConcernKeyword_0());
            		
            // InternalTurn.g:631:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:632:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:632:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:633:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:650:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:651:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:651:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:652:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:673:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==25) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalTurn.g:674:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTurn.g:674:4: (lv_condition_4_0= ruleCondition )
                    // InternalTurn.g:675:5: lv_condition_4_0= ruleCondition
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

            // InternalTurn.g:692:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:693:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:693:4: ( ruleQualifiedName )
            // InternalTurn.g:694:5: ruleQualifiedName
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

            // InternalTurn.g:708:3: (otherlv_6= ',' ( ( ruleQualifiedName ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==23) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalTurn.g:709:4: otherlv_6= ',' ( ( ruleQualifiedName ) )
            	    {
            	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_6, grammarAccess.getConcernAccess().getCommaKeyword_6_0());
            	    			
            	    // InternalTurn.g:713:4: ( ( ruleQualifiedName ) )
            	    // InternalTurn.g:714:5: ( ruleQualifiedName )
            	    {
            	    // InternalTurn.g:714:5: ( ruleQualifiedName )
            	    // InternalTurn.g:715:6: ruleQualifiedName
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
            	    break loop14;
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
    // InternalTurn.g:734:1: entryRuleLongName returns [EObject current=null] : iv_ruleLongName= ruleLongName EOF ;
    public final EObject entryRuleLongName() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongName = null;


        try {
            // InternalTurn.g:734:49: (iv_ruleLongName= ruleLongName EOF )
            // InternalTurn.g:735:2: iv_ruleLongName= ruleLongName EOF
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
    // InternalTurn.g:741:1: ruleLongName returns [EObject current=null] : ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) ;
    public final EObject ruleLongName() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_longname_2_1=null;
        Token lv_longname_2_2=null;


        	enterRule();

        try {
            // InternalTurn.g:747:2: ( ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? ) )
            // InternalTurn.g:748:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            {
            // InternalTurn.g:748:2: ( () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )? )
            // InternalTurn.g:749:3: () (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            {
            // InternalTurn.g:749:3: ()
            // InternalTurn.g:750:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getLongNameAccess().getLongNameAction_0(),
            					current);
            			

            }

            // InternalTurn.g:756:3: (otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==24) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalTurn.g:757:4: otherlv_1= '#' ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_17); 

                    				newLeafNode(otherlv_1, grammarAccess.getLongNameAccess().getNumberSignKeyword_1_0());
                    			
                    // InternalTurn.g:761:4: ( ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) ) )
                    // InternalTurn.g:762:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    {
                    // InternalTurn.g:762:5: ( (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING ) )
                    // InternalTurn.g:763:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    {
                    // InternalTurn.g:763:6: (lv_longname_2_1= RULE_ID | lv_longname_2_2= RULE_STRING )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==RULE_ID) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==RULE_STRING) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // InternalTurn.g:764:7: lv_longname_2_1= RULE_ID
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
                            // InternalTurn.g:779:7: lv_longname_2_2= RULE_STRING
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
    // InternalTurn.g:801:1: entryRuleCondition returns [EObject current=null] : iv_ruleCondition= ruleCondition EOF ;
    public final EObject entryRuleCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCondition = null;


        try {
            // InternalTurn.g:801:50: (iv_ruleCondition= ruleCondition EOF )
            // InternalTurn.g:802:2: iv_ruleCondition= ruleCondition EOF
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
    // InternalTurn.g:808:1: ruleCondition returns [EObject current=null] : (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) ;
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
            // InternalTurn.g:814:2: ( (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? ) )
            // InternalTurn.g:815:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            {
            // InternalTurn.g:815:2: (otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )? )
            // InternalTurn.g:816:3: otherlv_0= '[' ( (lv_expression_1_0= ruleText ) ) otherlv_2= ']' (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_18); 

            			newLeafNode(otherlv_0, grammarAccess.getConditionAccess().getLeftSquareBracketKeyword_0());
            		
            // InternalTurn.g:820:3: ( (lv_expression_1_0= ruleText ) )
            // InternalTurn.g:821:4: (lv_expression_1_0= ruleText )
            {
            // InternalTurn.g:821:4: (lv_expression_1_0= ruleText )
            // InternalTurn.g:822:5: lv_expression_1_0= ruleText
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
            		
            // InternalTurn.g:843:3: (otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==13) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalTurn.g:844:4: otherlv_3= '{' ( (lv_info_4_0= ruleConcreteCondition ) )? otherlv_5= '}'
                    {
                    otherlv_3=(Token)match(input,13,FOLLOW_21); 

                    				newLeafNode(otherlv_3, grammarAccess.getConditionAccess().getLeftCurlyBracketKeyword_3_0());
                    			
                    // InternalTurn.g:848:4: ( (lv_info_4_0= ruleConcreteCondition ) )?
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==RULE_STRING) ) {
                        alt17=1;
                    }
                    switch (alt17) {
                        case 1 :
                            // InternalTurn.g:849:5: (lv_info_4_0= ruleConcreteCondition )
                            {
                            // InternalTurn.g:849:5: (lv_info_4_0= ruleConcreteCondition )
                            // InternalTurn.g:850:6: lv_info_4_0= ruleConcreteCondition
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
    // InternalTurn.g:876:1: entryRuleConcreteCondition returns [EObject current=null] : iv_ruleConcreteCondition= ruleConcreteCondition EOF ;
    public final EObject entryRuleConcreteCondition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteCondition = null;


        try {
            // InternalTurn.g:876:58: (iv_ruleConcreteCondition= ruleConcreteCondition EOF )
            // InternalTurn.g:877:2: iv_ruleConcreteCondition= ruleConcreteCondition EOF
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
    // InternalTurn.g:883:1: ruleConcreteCondition returns [EObject current=null] : ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteCondition() throws RecognitionException {
        EObject current = null;

        Token lv_label_0_0=null;
        Token lv_description_1_0=null;


        	enterRule();

        try {
            // InternalTurn.g:889:2: ( ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) ) )
            // InternalTurn.g:890:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            {
            // InternalTurn.g:890:2: ( ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) ) )
            // InternalTurn.g:891:3: ( (lv_label_0_0= RULE_STRING ) ) ( (lv_description_1_0= RULE_STRING ) )
            {
            // InternalTurn.g:891:3: ( (lv_label_0_0= RULE_STRING ) )
            // InternalTurn.g:892:4: (lv_label_0_0= RULE_STRING )
            {
            // InternalTurn.g:892:4: (lv_label_0_0= RULE_STRING )
            // InternalTurn.g:893:5: lv_label_0_0= RULE_STRING
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

            // InternalTurn.g:909:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalTurn.g:910:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalTurn.g:910:4: (lv_description_1_0= RULE_STRING )
            // InternalTurn.g:911:5: lv_description_1_0= RULE_STRING
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
    // InternalTurn.g:931:1: entryRuleURNlink returns [EObject current=null] : iv_ruleURNlink= ruleURNlink EOF ;
    public final EObject entryRuleURNlink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleURNlink = null;


        try {
            // InternalTurn.g:931:48: (iv_ruleURNlink= ruleURNlink EOF )
            // InternalTurn.g:932:2: iv_ruleURNlink= ruleURNlink EOF
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
    // InternalTurn.g:938:1: ruleURNlink returns [EObject current=null] : (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) ;
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
            // InternalTurn.g:944:2: ( (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:945:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:945:2: (otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:946:3: otherlv_0= 'link' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )? (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )? ( ( ruleQualifiedName ) ) otherlv_7= '-->' ( ( ruleQualifiedName ) )
            {
            otherlv_0=(Token)match(input,27,FOLLOW_22); 

            			newLeafNode(otherlv_0, grammarAccess.getURNlinkAccess().getLinkKeyword_0());
            		
            // InternalTurn.g:950:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?
            int alt19=2;
            alt19 = dfa19.predict(input);
            switch (alt19) {
                case 1 :
                    // InternalTurn.g:951:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':'
                    {
                    // InternalTurn.g:951:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:952:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:952:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:953:6: lv_name_1_0= ruleQualifiedName
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

                    // InternalTurn.g:970:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:971:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:971:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:972:6: lv_longName_2_0= ruleLongName
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

            // InternalTurn.g:994:3: (otherlv_4= 'type' ( (lv_type_5_0= ruleText ) ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==28) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalTurn.g:995:4: otherlv_4= 'type' ( (lv_type_5_0= ruleText ) )
                    {
                    otherlv_4=(Token)match(input,28,FOLLOW_18); 

                    				newLeafNode(otherlv_4, grammarAccess.getURNlinkAccess().getTypeKeyword_2_0());
                    			
                    // InternalTurn.g:999:4: ( (lv_type_5_0= ruleText ) )
                    // InternalTurn.g:1000:5: (lv_type_5_0= ruleText )
                    {
                    // InternalTurn.g:1000:5: (lv_type_5_0= ruleText )
                    // InternalTurn.g:1001:6: lv_type_5_0= ruleText
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

            // InternalTurn.g:1019:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1020:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1020:4: ( ruleQualifiedName )
            // InternalTurn.g:1021:5: ruleQualifiedName
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
            		
            // InternalTurn.g:1039:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1040:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1040:4: ( ruleQualifiedName )
            // InternalTurn.g:1041:5: ruleQualifiedName
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
    // InternalTurn.g:1059:1: entryRuleMetadata returns [EObject current=null] : iv_ruleMetadata= ruleMetadata EOF ;
    public final EObject entryRuleMetadata() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMetadata = null;


        try {
            // InternalTurn.g:1059:49: (iv_ruleMetadata= ruleMetadata EOF )
            // InternalTurn.g:1060:2: iv_ruleMetadata= ruleMetadata EOF
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
    // InternalTurn.g:1066:1: ruleMetadata returns [EObject current=null] : (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) ) ;
    public final EObject ruleMetadata() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        EObject lv_value_5_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1072:2: ( (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) ) )
            // InternalTurn.g:1073:2: (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) )
            {
            // InternalTurn.g:1073:2: (otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) ) )
            // InternalTurn.g:1074:3: otherlv_0= 'metadata' ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )? ( (lv_name_3_0= RULE_ID ) ) otherlv_4= '=' ( (lv_value_5_0= ruleText ) )
            {
            otherlv_0=(Token)match(input,30,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getMetadataAccess().getMetadataKeyword_0());
            		
            // InternalTurn.g:1078:3: ( ( ( ruleQualifiedName ) ) otherlv_2= ':' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==RULE_ID) ) {
                int LA21_1 = input.LA(2);

                if ( (LA21_1==22||LA21_1==78) ) {
                    alt21=1;
                }
            }
            switch (alt21) {
                case 1 :
                    // InternalTurn.g:1079:4: ( ( ruleQualifiedName ) ) otherlv_2= ':'
                    {
                    // InternalTurn.g:1079:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:1080:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:1080:5: ( ruleQualifiedName )
                    // InternalTurn.g:1081:6: ruleQualifiedName
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

            // InternalTurn.g:1100:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalTurn.g:1101:4: (lv_name_3_0= RULE_ID )
            {
            // InternalTurn.g:1101:4: (lv_name_3_0= RULE_ID )
            // InternalTurn.g:1102:5: lv_name_3_0= RULE_ID
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
            		
            // InternalTurn.g:1122:3: ( (lv_value_5_0= ruleText ) )
            // InternalTurn.g:1123:4: (lv_value_5_0= ruleText )
            {
            // InternalTurn.g:1123:4: (lv_value_5_0= ruleText )
            // InternalTurn.g:1124:5: lv_value_5_0= ruleText
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
    // InternalTurn.g:1145:1: entryRuleActor returns [EObject current=null] : iv_ruleActor= ruleActor EOF ;
    public final EObject entryRuleActor() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActor = null;


        try {
            // InternalTurn.g:1145:46: (iv_ruleActor= ruleActor EOF )
            // InternalTurn.g:1146:2: iv_ruleActor= ruleActor EOF
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
    // InternalTurn.g:1152:1: ruleActor returns [EObject current=null] : (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) ;
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
            // InternalTurn.g:1158:2: ( (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' ) )
            // InternalTurn.g:1159:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            {
            // InternalTurn.g:1159:2: (otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}' )
            // InternalTurn.g:1160:3: otherlv_0= 'actor' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? ( (lv_elems_7_0= ruleIntentionalElement ) )* otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,32,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getActorAccess().getActorKeyword_0());
            		
            // InternalTurn.g:1164:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1165:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1165:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1166:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:1183:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1184:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1184:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1185:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:1206:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalTurn.g:1207:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_28); 

                    				newLeafNode(otherlv_4, grammarAccess.getActorAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTurn.g:1211:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt22=2;
                    int LA22_0 = input.LA(1);

                    if ( (LA22_0==102||(LA22_0>=115 && LA22_0<=117)) ) {
                        alt22=1;
                    }
                    else if ( (LA22_0==RULE_INT||(LA22_0>=54 && LA22_0<=55)) ) {
                        alt22=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 22, 0, input);

                        throw nvae;
                    }
                    switch (alt22) {
                        case 1 :
                            // InternalTurn.g:1212:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTurn.g:1212:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTurn.g:1213:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTurn.g:1213:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTurn.g:1214:7: lv_importance_5_0= ruleImportanceType
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
                            // InternalTurn.g:1232:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:1232:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:1233:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:1233:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTurn.g:1234:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
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

            // InternalTurn.g:1253:3: ( (lv_elems_7_0= ruleIntentionalElement ) )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( ((LA24_0>=103 && LA24_0<=108)) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // InternalTurn.g:1254:4: (lv_elems_7_0= ruleIntentionalElement )
            	    {
            	    // InternalTurn.g:1254:4: (lv_elems_7_0= ruleIntentionalElement )
            	    // InternalTurn.g:1255:5: lv_elems_7_0= ruleIntentionalElement
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
            	    break loop24;
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
    // InternalTurn.g:1280:1: entryRuleIntentionalElement returns [EObject current=null] : iv_ruleIntentionalElement= ruleIntentionalElement EOF ;
    public final EObject entryRuleIntentionalElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIntentionalElement = null;


        try {
            // InternalTurn.g:1280:59: (iv_ruleIntentionalElement= ruleIntentionalElement EOF )
            // InternalTurn.g:1281:2: iv_ruleIntentionalElement= ruleIntentionalElement EOF
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
    // InternalTurn.g:1287:1: ruleIntentionalElement returns [EObject current=null] : ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) ;
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
            // InternalTurn.g:1293:2: ( ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' ) )
            // InternalTurn.g:1294:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            {
            // InternalTurn.g:1294:2: ( ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}' )
            // InternalTurn.g:1295:3: ( (lv_type_0_0= ruleIntentionalElementType ) ) ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )? (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )? ( (lv_linksSrc_9_0= ruleElementLink ) )* otherlv_10= '}'
            {
            // InternalTurn.g:1295:3: ( (lv_type_0_0= ruleIntentionalElementType ) )
            // InternalTurn.g:1296:4: (lv_type_0_0= ruleIntentionalElementType )
            {
            // InternalTurn.g:1296:4: (lv_type_0_0= ruleIntentionalElementType )
            // InternalTurn.g:1297:5: lv_type_0_0= ruleIntentionalElementType
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

            // InternalTurn.g:1314:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1315:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1315:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1316:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:1333:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1334:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1334:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1335:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:1356:3: (otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==33) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalTurn.g:1357:4: otherlv_4= 'importance' ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_4=(Token)match(input,33,FOLLOW_28); 

                    				newLeafNode(otherlv_4, grammarAccess.getIntentionalElementAccess().getImportanceKeyword_4_0());
                    			
                    // InternalTurn.g:1361:4: ( ( (lv_importance_5_0= ruleImportanceType ) ) | ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) ) )
                    int alt25=2;
                    int LA25_0 = input.LA(1);

                    if ( (LA25_0==102||(LA25_0>=115 && LA25_0<=117)) ) {
                        alt25=1;
                    }
                    else if ( (LA25_0==RULE_INT||(LA25_0>=54 && LA25_0<=55)) ) {
                        alt25=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 25, 0, input);

                        throw nvae;
                    }
                    switch (alt25) {
                        case 1 :
                            // InternalTurn.g:1362:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            {
                            // InternalTurn.g:1362:5: ( (lv_importance_5_0= ruleImportanceType ) )
                            // InternalTurn.g:1363:6: (lv_importance_5_0= ruleImportanceType )
                            {
                            // InternalTurn.g:1363:6: (lv_importance_5_0= ruleImportanceType )
                            // InternalTurn.g:1364:7: lv_importance_5_0= ruleImportanceType
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
                            // InternalTurn.g:1382:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:1382:5: ( (lv_importanceQuantitative_6_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:1383:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:1383:6: (lv_importanceQuantitative_6_0= ruleQuantitativeValue )
                            // InternalTurn.g:1384:7: lv_importanceQuantitative_6_0= ruleQuantitativeValue
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

            // InternalTurn.g:1403:3: (otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==34) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalTurn.g:1404:4: otherlv_7= 'unit' ( (lv_unit_8_0= RULE_STRING ) )
                    {
                    otherlv_7=(Token)match(input,34,FOLLOW_6); 

                    				newLeafNode(otherlv_7, grammarAccess.getIntentionalElementAccess().getUnitKeyword_5_0());
                    			
                    // InternalTurn.g:1408:4: ( (lv_unit_8_0= RULE_STRING ) )
                    // InternalTurn.g:1409:5: (lv_unit_8_0= RULE_STRING )
                    {
                    // InternalTurn.g:1409:5: (lv_unit_8_0= RULE_STRING )
                    // InternalTurn.g:1410:6: lv_unit_8_0= RULE_STRING
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

            // InternalTurn.g:1427:3: ( (lv_linksSrc_9_0= ruleElementLink ) )*
            loop28:
            do {
                int alt28=2;
                int LA28_0 = input.LA(1);

                if ( (LA28_0==RULE_ID||LA28_0==35||LA28_0==39||LA28_0==79||LA28_0==81||LA28_0==118) ) {
                    alt28=1;
                }


                switch (alt28) {
            	case 1 :
            	    // InternalTurn.g:1428:4: (lv_linksSrc_9_0= ruleElementLink )
            	    {
            	    // InternalTurn.g:1428:4: (lv_linksSrc_9_0= ruleElementLink )
            	    // InternalTurn.g:1429:5: lv_linksSrc_9_0= ruleElementLink
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
            	    break loop28;
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
    // InternalTurn.g:1454:1: entryRuleElementLink returns [EObject current=null] : iv_ruleElementLink= ruleElementLink EOF ;
    public final EObject entryRuleElementLink() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElementLink = null;


        try {
            // InternalTurn.g:1454:52: (iv_ruleElementLink= ruleElementLink EOF )
            // InternalTurn.g:1455:2: iv_ruleElementLink= ruleElementLink EOF
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
    // InternalTurn.g:1461:1: ruleElementLink returns [EObject current=null] : (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) ;
    public final EObject ruleElementLink() throws RecognitionException {
        EObject current = null;

        EObject this_Contribution_0 = null;

        EObject this_Decomposition_1 = null;

        EObject this_Dependency_2 = null;



        	enterRule();

        try {
            // InternalTurn.g:1467:2: ( (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency ) )
            // InternalTurn.g:1468:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            {
            // InternalTurn.g:1468:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )
            int alt29=3;
            alt29 = dfa29.predict(input);
            switch (alt29) {
                case 1 :
                    // InternalTurn.g:1469:3: this_Contribution_0= ruleContribution
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
                    // InternalTurn.g:1478:3: this_Decomposition_1= ruleDecomposition
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
                    // InternalTurn.g:1487:3: this_Dependency_2= ruleDependency
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
    // InternalTurn.g:1499:1: entryRuleContribution returns [EObject current=null] : iv_ruleContribution= ruleContribution EOF ;
    public final EObject entryRuleContribution() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContribution = null;


        try {
            // InternalTurn.g:1499:53: (iv_ruleContribution= ruleContribution EOF )
            // InternalTurn.g:1500:2: iv_ruleContribution= ruleContribution EOF
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
    // InternalTurn.g:1506:1: ruleContribution returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) ;
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
            // InternalTurn.g:1512:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:1513:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:1513:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:1514:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'contributesTo' ( ( ruleQualifiedName ) ) ( (lv_correlation_4_0= 'correlated' ) )? otherlv_5= 'with' ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:1514:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==RULE_ID) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalTurn.g:1515:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1515:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1516:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1516:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1517:6: lv_name_0_0= ruleQualifiedName
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

                    // InternalTurn.g:1534:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1535:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1535:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1536:6: lv_longName_1_0= ruleLongName
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
            		
            // InternalTurn.g:1558:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1559:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1559:4: ( ruleQualifiedName )
            // InternalTurn.g:1560:5: ruleQualifiedName
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

            // InternalTurn.g:1574:3: ( (lv_correlation_4_0= 'correlated' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==36) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalTurn.g:1575:4: (lv_correlation_4_0= 'correlated' )
                    {
                    // InternalTurn.g:1575:4: (lv_correlation_4_0= 'correlated' )
                    // InternalTurn.g:1576:5: lv_correlation_4_0= 'correlated'
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
            		
            // InternalTurn.g:1592:3: ( ( (lv_contribution_6_0= ruleContributionType ) ) | ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) ) )
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==101||(LA32_0>=109 && LA32_0<=114)) ) {
                alt32=1;
            }
            else if ( (LA32_0==RULE_INT||(LA32_0>=54 && LA32_0<=55)) ) {
                alt32=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 32, 0, input);

                throw nvae;
            }
            switch (alt32) {
                case 1 :
                    // InternalTurn.g:1593:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    {
                    // InternalTurn.g:1593:4: ( (lv_contribution_6_0= ruleContributionType ) )
                    // InternalTurn.g:1594:5: (lv_contribution_6_0= ruleContributionType )
                    {
                    // InternalTurn.g:1594:5: (lv_contribution_6_0= ruleContributionType )
                    // InternalTurn.g:1595:6: lv_contribution_6_0= ruleContributionType
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
                    // InternalTurn.g:1613:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:1613:4: ( (lv_quantitativeContribution_7_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:1614:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:1614:5: (lv_quantitativeContribution_7_0= ruleQuantitativeValue )
                    // InternalTurn.g:1615:6: lv_quantitativeContribution_7_0= ruleQuantitativeValue
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
    // InternalTurn.g:1637:1: entryRuleDecomposition returns [EObject current=null] : iv_ruleDecomposition= ruleDecomposition EOF ;
    public final EObject entryRuleDecomposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDecomposition = null;


        try {
            // InternalTurn.g:1637:54: (iv_ruleDecomposition= ruleDecomposition EOF )
            // InternalTurn.g:1638:2: iv_ruleDecomposition= ruleDecomposition EOF
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
    // InternalTurn.g:1644:1: ruleDecomposition returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDecomposition() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        Enumerator lv_decompositionType_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1650:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:1651:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:1651:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:1652:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? ( (lv_decompositionType_2_0= ruleDecompositionType ) ) otherlv_3= 'decomposes' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:1652:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==RULE_ID) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalTurn.g:1653:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1653:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1654:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1654:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1655:6: lv_name_0_0= ruleQualifiedName
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

                    // InternalTurn.g:1672:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1673:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1673:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1674:6: lv_longName_1_0= ruleLongName
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

            // InternalTurn.g:1692:3: ( (lv_decompositionType_2_0= ruleDecompositionType ) )
            // InternalTurn.g:1693:4: (lv_decompositionType_2_0= ruleDecompositionType )
            {
            // InternalTurn.g:1693:4: (lv_decompositionType_2_0= ruleDecompositionType )
            // InternalTurn.g:1694:5: lv_decompositionType_2_0= ruleDecompositionType
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
            		
            // InternalTurn.g:1715:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1716:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1716:4: ( ruleQualifiedName )
            // InternalTurn.g:1717:5: ruleQualifiedName
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
    // InternalTurn.g:1735:1: entryRuleDependency returns [EObject current=null] : iv_ruleDependency= ruleDependency EOF ;
    public final EObject entryRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDependency = null;


        try {
            // InternalTurn.g:1735:51: (iv_ruleDependency= ruleDependency EOF )
            // InternalTurn.g:1736:2: iv_ruleDependency= ruleDependency EOF
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
    // InternalTurn.g:1742:1: ruleDependency returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:1748:2: ( ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:1749:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:1749:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:1750:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )? otherlv_2= 'dependsOn' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:1750:3: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) )?
            int alt34=2;
            int LA34_0 = input.LA(1);

            if ( (LA34_0==RULE_ID) ) {
                alt34=1;
            }
            switch (alt34) {
                case 1 :
                    // InternalTurn.g:1751:4: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) )
                    {
                    // InternalTurn.g:1751:4: ( (lv_name_0_0= ruleQualifiedName ) )
                    // InternalTurn.g:1752:5: (lv_name_0_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:1752:5: (lv_name_0_0= ruleQualifiedName )
                    // InternalTurn.g:1753:6: lv_name_0_0= ruleQualifiedName
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

                    // InternalTurn.g:1770:4: ( (lv_longName_1_0= ruleLongName ) )
                    // InternalTurn.g:1771:5: (lv_longName_1_0= ruleLongName )
                    {
                    // InternalTurn.g:1771:5: (lv_longName_1_0= ruleLongName )
                    // InternalTurn.g:1772:6: lv_longName_1_0= ruleLongName
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
            		
            // InternalTurn.g:1794:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:1795:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:1795:4: ( ruleQualifiedName )
            // InternalTurn.g:1796:5: ruleQualifiedName
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
    // InternalTurn.g:1814:1: entryRuleArtificialRule returns [EObject current=null] : iv_ruleArtificialRule= ruleArtificialRule EOF ;
    public final EObject entryRuleArtificialRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleArtificialRule = null;


        try {
            // InternalTurn.g:1814:55: (iv_ruleArtificialRule= ruleArtificialRule EOF )
            // InternalTurn.g:1815:2: iv_ruleArtificialRule= ruleArtificialRule EOF
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
    // InternalTurn.g:1821:1: ruleArtificialRule returns [EObject current=null] : ( (lv_longName_0_0= RULE_STRING ) )? ;
    public final EObject ruleArtificialRule() throws RecognitionException {
        EObject current = null;

        Token lv_longName_0_0=null;


        	enterRule();

        try {
            // InternalTurn.g:1827:2: ( ( (lv_longName_0_0= RULE_STRING ) )? )
            // InternalTurn.g:1828:2: ( (lv_longName_0_0= RULE_STRING ) )?
            {
            // InternalTurn.g:1828:2: ( (lv_longName_0_0= RULE_STRING ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==RULE_STRING) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalTurn.g:1829:3: (lv_longName_0_0= RULE_STRING )
                    {
                    // InternalTurn.g:1829:3: (lv_longName_0_0= RULE_STRING )
                    // InternalTurn.g:1830:4: lv_longName_0_0= RULE_STRING
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
    // InternalTurn.g:1849:1: entryRuleStrategiesGroup returns [EObject current=null] : iv_ruleStrategiesGroup= ruleStrategiesGroup EOF ;
    public final EObject entryRuleStrategiesGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStrategiesGroup = null;


        try {
            // InternalTurn.g:1849:56: (iv_ruleStrategiesGroup= ruleStrategiesGroup EOF )
            // InternalTurn.g:1850:2: iv_ruleStrategiesGroup= ruleStrategiesGroup EOF
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
    // InternalTurn.g:1856:1: ruleStrategiesGroup returns [EObject current=null] : (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
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
            // InternalTurn.g:1862:2: ( (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:1863:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:1863:2: (otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:1864:3: otherlv_0= 'strategiesGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,40,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getStrategiesGroupAccess().getStrategiesGroupKeyword_0());
            		
            // InternalTurn.g:1868:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1869:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1869:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1870:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:1887:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1888:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1888:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1889:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:1910:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:1911:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:1911:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:1912:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getStrategiesGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getStrategiesGroupAccess().getEvalStrategyEvaluationStrategyCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:1923:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop36:
            do {
                int alt36=2;
                int LA36_0 = input.LA(1);

                if ( (LA36_0==23) ) {
                    alt36=1;
                }


                switch (alt36) {
            	case 1 :
            	    // InternalTurn.g:1924:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getStrategiesGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:1928:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:1929:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:1929:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:1930:6: otherlv_6= RULE_ID
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
            	    break loop36;
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
    // InternalTurn.g:1946:1: entryRuleEvaluationStrategy returns [EObject current=null] : iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF ;
    public final EObject entryRuleEvaluationStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluationStrategy = null;


        try {
            // InternalTurn.g:1946:59: (iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF )
            // InternalTurn.g:1947:2: iv_ruleEvaluationStrategy= ruleEvaluationStrategy EOF
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
    // InternalTurn.g:1953:1: ruleEvaluationStrategy returns [EObject current=null] : (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' ) ;
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
            // InternalTurn.g:1959:2: ( (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' ) )
            // InternalTurn.g:1960:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' )
            {
            // InternalTurn.g:1960:2: (otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}' )
            // InternalTurn.g:1961:3: otherlv_0= 'strategy' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_info_4_0= ruleConcreteStrategy ) )? ( (lv_evaluations_5_0= ruleEvaluation ) )* (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )? otherlv_10= '}'
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getEvaluationStrategyAccess().getStrategyKeyword_0());
            		
            // InternalTurn.g:1965:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:1966:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:1966:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:1967:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:1984:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:1985:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:1985:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:1986:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:2007:3: ( (lv_info_4_0= ruleConcreteStrategy ) )?
            int alt37=2;
            int LA37_0 = input.LA(1);

            if ( (LA37_0==15) ) {
                alt37=1;
            }
            switch (alt37) {
                case 1 :
                    // InternalTurn.g:2008:4: (lv_info_4_0= ruleConcreteStrategy )
                    {
                    // InternalTurn.g:2008:4: (lv_info_4_0= ruleConcreteStrategy )
                    // InternalTurn.g:2009:5: lv_info_4_0= ruleConcreteStrategy
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

            // InternalTurn.g:2026:3: ( (lv_evaluations_5_0= ruleEvaluation ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalTurn.g:2027:4: (lv_evaluations_5_0= ruleEvaluation )
            	    {
            	    // InternalTurn.g:2027:4: (lv_evaluations_5_0= ruleEvaluation )
            	    // InternalTurn.g:2028:5: lv_evaluations_5_0= ruleEvaluation
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
            	    break loop38;
                }
            } while (true);

            // InternalTurn.g:2045:3: (otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )* )?
            int alt40=2;
            int LA40_0 = input.LA(1);

            if ( (LA40_0==42) ) {
                alt40=1;
            }
            switch (alt40) {
                case 1 :
                    // InternalTurn.g:2046:4: otherlv_6= 'includes' ( (otherlv_7= RULE_ID ) ) (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    {
                    otherlv_6=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_6, grammarAccess.getEvaluationStrategyAccess().getIncludesKeyword_6_0());
                    			
                    // InternalTurn.g:2050:4: ( (otherlv_7= RULE_ID ) )
                    // InternalTurn.g:2051:5: (otherlv_7= RULE_ID )
                    {
                    // InternalTurn.g:2051:5: (otherlv_7= RULE_ID )
                    // InternalTurn.g:2052:6: otherlv_7= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getEvaluationStrategyRule());
                    						}
                    					
                    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_45); 

                    						newLeafNode(otherlv_7, grammarAccess.getEvaluationStrategyAccess().getIncludedStrategyEvaluationStrategyCrossReference_6_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:2063:4: (otherlv_8= ',' ( (otherlv_9= RULE_ID ) ) )*
                    loop39:
                    do {
                        int alt39=2;
                        int LA39_0 = input.LA(1);

                        if ( (LA39_0==23) ) {
                            alt39=1;
                        }


                        switch (alt39) {
                    	case 1 :
                    	    // InternalTurn.g:2064:5: otherlv_8= ',' ( (otherlv_9= RULE_ID ) )
                    	    {
                    	    otherlv_8=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_8, grammarAccess.getEvaluationStrategyAccess().getCommaKeyword_6_2_0());
                    	    				
                    	    // InternalTurn.g:2068:5: ( (otherlv_9= RULE_ID ) )
                    	    // InternalTurn.g:2069:6: (otherlv_9= RULE_ID )
                    	    {
                    	    // InternalTurn.g:2069:6: (otherlv_9= RULE_ID )
                    	    // InternalTurn.g:2070:7: otherlv_9= RULE_ID
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
                    	    break loop39;
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
    // InternalTurn.g:2091:1: entryRuleConcreteStrategy returns [EObject current=null] : iv_ruleConcreteStrategy= ruleConcreteStrategy EOF ;
    public final EObject entryRuleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcreteStrategy = null;


        try {
            // InternalTurn.g:2091:57: (iv_ruleConcreteStrategy= ruleConcreteStrategy EOF )
            // InternalTurn.g:2092:2: iv_ruleConcreteStrategy= ruleConcreteStrategy EOF
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
    // InternalTurn.g:2098:1: ruleConcreteStrategy returns [EObject current=null] : (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) ;
    public final EObject ruleConcreteStrategy() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_author_1_0=null;


        	enterRule();

        try {
            // InternalTurn.g:2104:2: ( (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) ) )
            // InternalTurn.g:2105:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            {
            // InternalTurn.g:2105:2: (otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) ) )
            // InternalTurn.g:2106:3: otherlv_0= 'author' ( (lv_author_1_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,15,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getConcreteStrategyAccess().getAuthorKeyword_0());
            		
            // InternalTurn.g:2110:3: ( (lv_author_1_0= RULE_STRING ) )
            // InternalTurn.g:2111:4: (lv_author_1_0= RULE_STRING )
            {
            // InternalTurn.g:2111:4: (lv_author_1_0= RULE_STRING )
            // InternalTurn.g:2112:5: lv_author_1_0= RULE_STRING
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
    // InternalTurn.g:2132:1: entryRuleEvaluation returns [EObject current=null] : iv_ruleEvaluation= ruleEvaluation EOF ;
    public final EObject entryRuleEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvaluation = null;


        try {
            // InternalTurn.g:2132:51: (iv_ruleEvaluation= ruleEvaluation EOF )
            // InternalTurn.g:2133:2: iv_ruleEvaluation= ruleEvaluation EOF
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
    // InternalTurn.g:2139:1: ruleEvaluation returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) ;
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
            // InternalTurn.g:2145:2: ( ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) ) )
            // InternalTurn.g:2146:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            {
            // InternalTurn.g:2146:2: ( ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) ) )
            // InternalTurn.g:2147:3: ( ( ruleQualifiedName ) ) ( (lv_exceeds_1_0= 'exceeding' ) )? ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            {
            // InternalTurn.g:2147:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:2148:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:2148:4: ( ruleQualifiedName )
            // InternalTurn.g:2149:5: ruleQualifiedName
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

            // InternalTurn.g:2163:3: ( (lv_exceeds_1_0= 'exceeding' ) )?
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==43) ) {
                alt41=1;
            }
            switch (alt41) {
                case 1 :
                    // InternalTurn.g:2164:4: (lv_exceeds_1_0= 'exceeding' )
                    {
                    // InternalTurn.g:2164:4: (lv_exceeds_1_0= 'exceeding' )
                    // InternalTurn.g:2165:5: lv_exceeds_1_0= 'exceeding'
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

            // InternalTurn.g:2177:3: ( (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) ) | ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==44) ) {
                alt43=1;
            }
            else if ( (LA43_0==46) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // InternalTurn.g:2178:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    {
                    // InternalTurn.g:2178:4: (otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) ) )
                    // InternalTurn.g:2179:5: otherlv_2= 'evaluation' ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    {
                    otherlv_2=(Token)match(input,44,FOLLOW_47); 

                    					newLeafNode(otherlv_2, grammarAccess.getEvaluationAccess().getEvaluationKeyword_2_0_0());
                    				
                    // InternalTurn.g:2183:5: ( ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_4_0= ruleQuantitativeValue ) ) )
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( ((LA42_0>=96 && LA42_0<=102)) ) {
                        alt42=1;
                    }
                    else if ( (LA42_0==RULE_INT||(LA42_0>=54 && LA42_0<=55)) ) {
                        alt42=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 42, 0, input);

                        throw nvae;
                    }
                    switch (alt42) {
                        case 1 :
                            // InternalTurn.g:2184:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            {
                            // InternalTurn.g:2184:6: ( (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel ) )
                            // InternalTurn.g:2185:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            {
                            // InternalTurn.g:2185:7: (lv_qualitativeEvaluation_3_0= ruleQualitativeLabel )
                            // InternalTurn.g:2186:8: lv_qualitativeEvaluation_3_0= ruleQualitativeLabel
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
                            // InternalTurn.g:2204:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            {
                            // InternalTurn.g:2204:6: ( (lv_evaluation_4_0= ruleQuantitativeValue ) )
                            // InternalTurn.g:2205:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            {
                            // InternalTurn.g:2205:7: (lv_evaluation_4_0= ruleQuantitativeValue )
                            // InternalTurn.g:2206:8: lv_evaluation_4_0= ruleQuantitativeValue
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
                    // InternalTurn.g:2226:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    {
                    // InternalTurn.g:2226:4: ( ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) ) )
                    // InternalTurn.g:2227:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) ) otherlv_6= 'convertedWith' ( (otherlv_7= RULE_ID ) )
                    {
                    // InternalTurn.g:2227:5: ( (lv_indicatorEval_5_0= ruleIndicatorEvaluation ) )
                    // InternalTurn.g:2228:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    {
                    // InternalTurn.g:2228:6: (lv_indicatorEval_5_0= ruleIndicatorEvaluation )
                    // InternalTurn.g:2229:7: lv_indicatorEval_5_0= ruleIndicatorEvaluation
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
                    				
                    // InternalTurn.g:2250:5: ( (otherlv_7= RULE_ID ) )
                    // InternalTurn.g:2251:6: (otherlv_7= RULE_ID )
                    {
                    // InternalTurn.g:2251:6: (otherlv_7= RULE_ID )
                    // InternalTurn.g:2252:7: otherlv_7= RULE_ID
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
    // InternalTurn.g:2269:1: entryRuleIndicatorEvaluation returns [EObject current=null] : iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF ;
    public final EObject entryRuleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorEvaluation = null;


        try {
            // InternalTurn.g:2269:60: (iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF )
            // InternalTurn.g:2270:2: iv_ruleIndicatorEvaluation= ruleIndicatorEvaluation EOF
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
    // InternalTurn.g:2276:1: ruleIndicatorEvaluation returns [EObject current=null] : (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) ;
    public final EObject ruleIndicatorEvaluation() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_realWorldLabel_1_0=null;
        Token lv_realWorldValue_2_0=null;


        	enterRule();

        try {
            // InternalTurn.g:2282:2: ( (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) ) )
            // InternalTurn.g:2283:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            {
            // InternalTurn.g:2283:2: (otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) ) )
            // InternalTurn.g:2284:3: otherlv_0= 'real' ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_49); 

            			newLeafNode(otherlv_0, grammarAccess.getIndicatorEvaluationAccess().getRealKeyword_0());
            		
            // InternalTurn.g:2288:3: ( ( (lv_realWorldLabel_1_0= RULE_STRING ) ) | ( (lv_realWorldValue_2_0= RULE_INT ) ) )
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==RULE_STRING) ) {
                alt44=1;
            }
            else if ( (LA44_0==RULE_INT) ) {
                alt44=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 44, 0, input);

                throw nvae;
            }
            switch (alt44) {
                case 1 :
                    // InternalTurn.g:2289:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    {
                    // InternalTurn.g:2289:4: ( (lv_realWorldLabel_1_0= RULE_STRING ) )
                    // InternalTurn.g:2290:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    {
                    // InternalTurn.g:2290:5: (lv_realWorldLabel_1_0= RULE_STRING )
                    // InternalTurn.g:2291:6: lv_realWorldLabel_1_0= RULE_STRING
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
                    // InternalTurn.g:2308:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    {
                    // InternalTurn.g:2308:4: ( (lv_realWorldValue_2_0= RULE_INT ) )
                    // InternalTurn.g:2309:5: (lv_realWorldValue_2_0= RULE_INT )
                    {
                    // InternalTurn.g:2309:5: (lv_realWorldValue_2_0= RULE_INT )
                    // InternalTurn.g:2310:6: lv_realWorldValue_2_0= RULE_INT
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
    // InternalTurn.g:2331:1: entryRuleIndicatorConversion returns [EObject current=null] : iv_ruleIndicatorConversion= ruleIndicatorConversion EOF ;
    public final EObject entryRuleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIndicatorConversion = null;


        try {
            // InternalTurn.g:2331:60: (iv_ruleIndicatorConversion= ruleIndicatorConversion EOF )
            // InternalTurn.g:2332:2: iv_ruleIndicatorConversion= ruleIndicatorConversion EOF
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
    // InternalTurn.g:2338:1: ruleIndicatorConversion returns [EObject current=null] : (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) ;
    public final EObject ruleIndicatorConversion() throws RecognitionException {
        EObject current = null;

        EObject this_LinearConversion_0 = null;

        EObject this_QualToQMappings_1 = null;



        	enterRule();

        try {
            // InternalTurn.g:2344:2: ( (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings ) )
            // InternalTurn.g:2345:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            {
            // InternalTurn.g:2345:2: (this_LinearConversion_0= ruleLinearConversion | this_QualToQMappings_1= ruleQualToQMappings )
            int alt45=2;
            int LA45_0 = input.LA(1);

            if ( (LA45_0==47) ) {
                alt45=1;
            }
            else if ( (LA45_0==51) ) {
                alt45=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }
            switch (alt45) {
                case 1 :
                    // InternalTurn.g:2346:3: this_LinearConversion_0= ruleLinearConversion
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
                    // InternalTurn.g:2355:3: this_QualToQMappings_1= ruleQualToQMappings
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
    // InternalTurn.g:2367:1: entryRuleLinearConversion returns [EObject current=null] : iv_ruleLinearConversion= ruleLinearConversion EOF ;
    public final EObject entryRuleLinearConversion() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLinearConversion = null;


        try {
            // InternalTurn.g:2367:57: (iv_ruleLinearConversion= ruleLinearConversion EOF )
            // InternalTurn.g:2368:2: iv_ruleLinearConversion= ruleLinearConversion EOF
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
    // InternalTurn.g:2374:1: ruleLinearConversion returns [EObject current=null] : (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) ;
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
            // InternalTurn.g:2380:2: ( (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' ) )
            // InternalTurn.g:2381:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            {
            // InternalTurn.g:2381:2: (otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}' )
            // InternalTurn.g:2382:3: otherlv_0= 'linearConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) otherlv_6= 'target' ( (lv_targetValue_7_0= RULE_INT ) ) otherlv_8= 'threshold' ( (lv_thresholdValue_9_0= RULE_INT ) ) otherlv_10= 'worst' ( (lv_worstValue_11_0= RULE_INT ) ) otherlv_12= '}'
            {
            otherlv_0=(Token)match(input,47,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getLinearConversionAccess().getLinearConversionKeyword_0());
            		
            // InternalTurn.g:2386:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2387:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2387:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2388:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:2405:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2406:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2406:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2407:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:2432:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTurn.g:2433:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTurn.g:2433:4: (lv_unit_5_0= RULE_STRING )
            // InternalTurn.g:2434:5: lv_unit_5_0= RULE_STRING
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
            		
            // InternalTurn.g:2454:3: ( (lv_targetValue_7_0= RULE_INT ) )
            // InternalTurn.g:2455:4: (lv_targetValue_7_0= RULE_INT )
            {
            // InternalTurn.g:2455:4: (lv_targetValue_7_0= RULE_INT )
            // InternalTurn.g:2456:5: lv_targetValue_7_0= RULE_INT
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
            		
            // InternalTurn.g:2476:3: ( (lv_thresholdValue_9_0= RULE_INT ) )
            // InternalTurn.g:2477:4: (lv_thresholdValue_9_0= RULE_INT )
            {
            // InternalTurn.g:2477:4: (lv_thresholdValue_9_0= RULE_INT )
            // InternalTurn.g:2478:5: lv_thresholdValue_9_0= RULE_INT
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
            		
            // InternalTurn.g:2498:3: ( (lv_worstValue_11_0= RULE_INT ) )
            // InternalTurn.g:2499:4: (lv_worstValue_11_0= RULE_INT )
            {
            // InternalTurn.g:2499:4: (lv_worstValue_11_0= RULE_INT )
            // InternalTurn.g:2500:5: lv_worstValue_11_0= RULE_INT
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
    // InternalTurn.g:2524:1: entryRuleQualToQMappings returns [EObject current=null] : iv_ruleQualToQMappings= ruleQualToQMappings EOF ;
    public final EObject entryRuleQualToQMappings() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMappings = null;


        try {
            // InternalTurn.g:2524:56: (iv_ruleQualToQMappings= ruleQualToQMappings EOF )
            // InternalTurn.g:2525:2: iv_ruleQualToQMappings= ruleQualToQMappings EOF
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
    // InternalTurn.g:2531:1: ruleQualToQMappings returns [EObject current=null] : (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) ;
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
            // InternalTurn.g:2537:2: ( (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' ) )
            // InternalTurn.g:2538:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            {
            // InternalTurn.g:2538:2: (otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}' )
            // InternalTurn.g:2539:3: otherlv_0= 'mappingConversion' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' otherlv_4= 'unit' ( (lv_unit_5_0= RULE_STRING ) ) ( (lv_mappings_6_0= ruleQualToQMapping ) )+ otherlv_7= '}'
            {
            otherlv_0=(Token)match(input,51,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getQualToQMappingsAccess().getMappingConversionKeyword_0());
            		
            // InternalTurn.g:2543:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2544:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2544:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2545:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:2562:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2563:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2563:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2564:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:2589:3: ( (lv_unit_5_0= RULE_STRING ) )
            // InternalTurn.g:2590:4: (lv_unit_5_0= RULE_STRING )
            {
            // InternalTurn.g:2590:4: (lv_unit_5_0= RULE_STRING )
            // InternalTurn.g:2591:5: lv_unit_5_0= RULE_STRING
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

            // InternalTurn.g:2607:3: ( (lv_mappings_6_0= ruleQualToQMapping ) )+
            int cnt46=0;
            loop46:
            do {
                int alt46=2;
                int LA46_0 = input.LA(1);

                if ( (LA46_0==43||LA46_0==46) ) {
                    alt46=1;
                }


                switch (alt46) {
            	case 1 :
            	    // InternalTurn.g:2608:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    {
            	    // InternalTurn.g:2608:4: (lv_mappings_6_0= ruleQualToQMapping )
            	    // InternalTurn.g:2609:5: lv_mappings_6_0= ruleQualToQMapping
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
            	    if ( cnt46 >= 1 ) break loop46;
                        EarlyExitException eee =
                            new EarlyExitException(46, input);
                        throw eee;
                }
                cnt46++;
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
    // InternalTurn.g:2634:1: entryRuleQualToQMapping returns [EObject current=null] : iv_ruleQualToQMapping= ruleQualToQMapping EOF ;
    public final EObject entryRuleQualToQMapping() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleQualToQMapping = null;


        try {
            // InternalTurn.g:2634:55: (iv_ruleQualToQMapping= ruleQualToQMapping EOF )
            // InternalTurn.g:2635:2: iv_ruleQualToQMapping= ruleQualToQMapping EOF
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
    // InternalTurn.g:2641:1: ruleQualToQMapping returns [EObject current=null] : ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) ;
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
            // InternalTurn.g:2647:2: ( ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:2648:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:2648:2: ( ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:2649:3: ( (lv_exceeds_0_0= 'exceeding' ) )? otherlv_1= 'real' ( (lv_realWorldLabel_2_0= RULE_STRING ) ) otherlv_3= '-->' ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:2649:3: ( (lv_exceeds_0_0= 'exceeding' ) )?
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==43) ) {
                alt47=1;
            }
            switch (alt47) {
                case 1 :
                    // InternalTurn.g:2650:4: (lv_exceeds_0_0= 'exceeding' )
                    {
                    // InternalTurn.g:2650:4: (lv_exceeds_0_0= 'exceeding' )
                    // InternalTurn.g:2651:5: lv_exceeds_0_0= 'exceeding'
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
            		
            // InternalTurn.g:2667:3: ( (lv_realWorldLabel_2_0= RULE_STRING ) )
            // InternalTurn.g:2668:4: (lv_realWorldLabel_2_0= RULE_STRING )
            {
            // InternalTurn.g:2668:4: (lv_realWorldLabel_2_0= RULE_STRING )
            // InternalTurn.g:2669:5: lv_realWorldLabel_2_0= RULE_STRING
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
            		
            // InternalTurn.g:2689:3: ( ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) ) | ( (lv_evaluation_5_0= ruleQuantitativeValue ) ) )
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( ((LA48_0>=96 && LA48_0<=102)) ) {
                alt48=1;
            }
            else if ( (LA48_0==RULE_INT||(LA48_0>=54 && LA48_0<=55)) ) {
                alt48=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 48, 0, input);

                throw nvae;
            }
            switch (alt48) {
                case 1 :
                    // InternalTurn.g:2690:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    {
                    // InternalTurn.g:2690:4: ( (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel ) )
                    // InternalTurn.g:2691:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    {
                    // InternalTurn.g:2691:5: (lv_qualitativeEvaluation_4_0= ruleQualitativeLabel )
                    // InternalTurn.g:2692:6: lv_qualitativeEvaluation_4_0= ruleQualitativeLabel
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
                    // InternalTurn.g:2710:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:2710:4: ( (lv_evaluation_5_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:2711:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:2711:5: (lv_evaluation_5_0= ruleQuantitativeValue )
                    // InternalTurn.g:2712:6: lv_evaluation_5_0= ruleQuantitativeValue
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
    // InternalTurn.g:2734:1: entryRuleContributionContextGroup returns [EObject current=null] : iv_ruleContributionContextGroup= ruleContributionContextGroup EOF ;
    public final EObject entryRuleContributionContextGroup() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContextGroup = null;


        try {
            // InternalTurn.g:2734:65: (iv_ruleContributionContextGroup= ruleContributionContextGroup EOF )
            // InternalTurn.g:2735:2: iv_ruleContributionContextGroup= ruleContributionContextGroup EOF
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
    // InternalTurn.g:2741:1: ruleContributionContextGroup returns [EObject current=null] : (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) ;
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
            // InternalTurn.g:2747:2: ( (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* ) )
            // InternalTurn.g:2748:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            {
            // InternalTurn.g:2748:2: (otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* )
            // InternalTurn.g:2749:3: otherlv_0= 'contributionContextGroup' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            {
            otherlv_0=(Token)match(input,52,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextGroupAccess().getContributionContextGroupKeyword_0());
            		
            // InternalTurn.g:2753:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2754:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2754:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2755:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:2772:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2773:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2773:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2774:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:2795:3: ( (otherlv_4= RULE_ID ) )
            // InternalTurn.g:2796:4: (otherlv_4= RULE_ID )
            {
            // InternalTurn.g:2796:4: (otherlv_4= RULE_ID )
            // InternalTurn.g:2797:5: otherlv_4= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getContributionContextGroupRule());
            					}
            				
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_16); 

            					newLeafNode(otherlv_4, grammarAccess.getContributionContextGroupAccess().getContribContributionContextCrossReference_4_0());
            				

            }


            }

            // InternalTurn.g:2808:3: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop49:
            do {
                int alt49=2;
                int LA49_0 = input.LA(1);

                if ( (LA49_0==23) ) {
                    alt49=1;
                }


                switch (alt49) {
            	case 1 :
            	    // InternalTurn.g:2809:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,23,FOLLOW_3); 

            	    				newLeafNode(otherlv_5, grammarAccess.getContributionContextGroupAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalTurn.g:2813:4: ( (otherlv_6= RULE_ID ) )
            	    // InternalTurn.g:2814:5: (otherlv_6= RULE_ID )
            	    {
            	    // InternalTurn.g:2814:5: (otherlv_6= RULE_ID )
            	    // InternalTurn.g:2815:6: otherlv_6= RULE_ID
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
            	    break loop49;
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
    // InternalTurn.g:2831:1: entryRuleContributionContext returns [EObject current=null] : iv_ruleContributionContext= ruleContributionContext EOF ;
    public final EObject entryRuleContributionContext() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionContext = null;


        try {
            // InternalTurn.g:2831:60: (iv_ruleContributionContext= ruleContributionContext EOF )
            // InternalTurn.g:2832:2: iv_ruleContributionContext= ruleContributionContext EOF
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
    // InternalTurn.g:2838:1: ruleContributionContext returns [EObject current=null] : (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' ) ;
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
            // InternalTurn.g:2844:2: ( (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' ) )
            // InternalTurn.g:2845:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' )
            {
            // InternalTurn.g:2845:2: (otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}' )
            // InternalTurn.g:2846:3: otherlv_0= 'contributionContext' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= '{' ( (lv_changes_4_0= ruleContributionChange ) )* (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )? otherlv_9= '}'
            {
            otherlv_0=(Token)match(input,53,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getContributionContextAccess().getContributionContextKeyword_0());
            		
            // InternalTurn.g:2850:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:2851:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:2851:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:2852:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:2869:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:2870:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:2870:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:2871:5: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:2892:3: ( (lv_changes_4_0= ruleContributionChange ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( (LA50_0==RULE_ID) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalTurn.g:2893:4: (lv_changes_4_0= ruleContributionChange )
            	    {
            	    // InternalTurn.g:2893:4: (lv_changes_4_0= ruleContributionChange )
            	    // InternalTurn.g:2894:5: lv_changes_4_0= ruleContributionChange
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
            	    break loop50;
                }
            } while (true);

            // InternalTurn.g:2911:3: (otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )* )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==42) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // InternalTurn.g:2912:4: otherlv_5= 'includes' ( (otherlv_6= RULE_ID ) ) (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )*
                    {
                    otherlv_5=(Token)match(input,42,FOLLOW_3); 

                    				newLeafNode(otherlv_5, grammarAccess.getContributionContextAccess().getIncludesKeyword_5_0());
                    			
                    // InternalTurn.g:2916:4: ( (otherlv_6= RULE_ID ) )
                    // InternalTurn.g:2917:5: (otherlv_6= RULE_ID )
                    {
                    // InternalTurn.g:2917:5: (otherlv_6= RULE_ID )
                    // InternalTurn.g:2918:6: otherlv_6= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getContributionContextRule());
                    						}
                    					
                    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_45); 

                    						newLeafNode(otherlv_6, grammarAccess.getContributionContextAccess().getIncludedContextContributionContextCrossReference_5_1_0());
                    					

                    }


                    }

                    // InternalTurn.g:2929:4: (otherlv_7= ',' ( (otherlv_8= RULE_ID ) ) )*
                    loop51:
                    do {
                        int alt51=2;
                        int LA51_0 = input.LA(1);

                        if ( (LA51_0==23) ) {
                            alt51=1;
                        }


                        switch (alt51) {
                    	case 1 :
                    	    // InternalTurn.g:2930:5: otherlv_7= ',' ( (otherlv_8= RULE_ID ) )
                    	    {
                    	    otherlv_7=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_7, grammarAccess.getContributionContextAccess().getCommaKeyword_5_2_0());
                    	    				
                    	    // InternalTurn.g:2934:5: ( (otherlv_8= RULE_ID ) )
                    	    // InternalTurn.g:2935:6: (otherlv_8= RULE_ID )
                    	    {
                    	    // InternalTurn.g:2935:6: (otherlv_8= RULE_ID )
                    	    // InternalTurn.g:2936:7: otherlv_8= RULE_ID
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
                    	    break loop51;
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
    // InternalTurn.g:2957:1: entryRuleContributionChange returns [EObject current=null] : iv_ruleContributionChange= ruleContributionChange EOF ;
    public final EObject entryRuleContributionChange() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContributionChange = null;


        try {
            // InternalTurn.g:2957:59: (iv_ruleContributionChange= ruleContributionChange EOF )
            // InternalTurn.g:2958:2: iv_ruleContributionChange= ruleContributionChange EOF
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
    // InternalTurn.g:2964:1: ruleContributionChange returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) ;
    public final EObject ruleContributionChange() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_newContribution_2_0 = null;

        AntlrDatatypeRuleToken lv_newQuantitativeContribution_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:2970:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) ) )
            // InternalTurn.g:2971:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            {
            // InternalTurn.g:2971:2: ( ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) ) )
            // InternalTurn.g:2972:3: ( ( ruleQualifiedName ) ) otherlv_1= 'with' ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            {
            // InternalTurn.g:2972:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:2973:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:2973:4: ( ruleQualifiedName )
            // InternalTurn.g:2974:5: ruleQualifiedName
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
            		
            // InternalTurn.g:2992:3: ( ( (lv_newContribution_2_0= ruleContributionType ) ) | ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) ) )
            int alt53=2;
            int LA53_0 = input.LA(1);

            if ( (LA53_0==101||(LA53_0>=109 && LA53_0<=114)) ) {
                alt53=1;
            }
            else if ( (LA53_0==RULE_INT||(LA53_0>=54 && LA53_0<=55)) ) {
                alt53=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 53, 0, input);

                throw nvae;
            }
            switch (alt53) {
                case 1 :
                    // InternalTurn.g:2993:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    {
                    // InternalTurn.g:2993:4: ( (lv_newContribution_2_0= ruleContributionType ) )
                    // InternalTurn.g:2994:5: (lv_newContribution_2_0= ruleContributionType )
                    {
                    // InternalTurn.g:2994:5: (lv_newContribution_2_0= ruleContributionType )
                    // InternalTurn.g:2995:6: lv_newContribution_2_0= ruleContributionType
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
                    // InternalTurn.g:3013:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    {
                    // InternalTurn.g:3013:4: ( (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue ) )
                    // InternalTurn.g:3014:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    {
                    // InternalTurn.g:3014:5: (lv_newQuantitativeContribution_3_0= ruleQuantitativeValue )
                    // InternalTurn.g:3015:6: lv_newQuantitativeContribution_3_0= ruleQuantitativeValue
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
    // InternalTurn.g:3037:1: entryRuleQuantitativeValue returns [String current=null] : iv_ruleQuantitativeValue= ruleQuantitativeValue EOF ;
    public final String entryRuleQuantitativeValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQuantitativeValue = null;


        try {
            // InternalTurn.g:3037:57: (iv_ruleQuantitativeValue= ruleQuantitativeValue EOF )
            // InternalTurn.g:3038:2: iv_ruleQuantitativeValue= ruleQuantitativeValue EOF
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
    // InternalTurn.g:3044:1: ruleQuantitativeValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleQuantitativeValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_2=null;


        	enterRule();

        try {
            // InternalTurn.g:3050:2: ( ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT ) )
            // InternalTurn.g:3051:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            {
            // InternalTurn.g:3051:2: ( (kw= '-' | kw= '+' )? this_INT_2= RULE_INT )
            // InternalTurn.g:3052:3: (kw= '-' | kw= '+' )? this_INT_2= RULE_INT
            {
            // InternalTurn.g:3052:3: (kw= '-' | kw= '+' )?
            int alt54=3;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==54) ) {
                alt54=1;
            }
            else if ( (LA54_0==55) ) {
                alt54=2;
            }
            switch (alt54) {
                case 1 :
                    // InternalTurn.g:3053:4: kw= '-'
                    {
                    kw=(Token)match(input,54,FOLLOW_52); 

                    				current.merge(kw);
                    				newLeafNode(kw, grammarAccess.getQuantitativeValueAccess().getHyphenMinusKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3059:4: kw= '+'
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
    // InternalTurn.g:3076:1: entryRuleUCMmap returns [EObject current=null] : iv_ruleUCMmap= ruleUCMmap EOF ;
    public final EObject entryRuleUCMmap() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUCMmap = null;


        try {
            // InternalTurn.g:3076:47: (iv_ruleUCMmap= ruleUCMmap EOF )
            // InternalTurn.g:3077:2: iv_ruleUCMmap= ruleUCMmap EOF
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
    // InternalTurn.g:3083:1: ruleUCMmap returns [EObject current=null] : ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) ;
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
            // InternalTurn.g:3089:2: ( ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' ) )
            // InternalTurn.g:3090:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            {
            // InternalTurn.g:3090:2: ( ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}' )
            // InternalTurn.g:3091:3: ( (lv_singleton_0_0= 'singleton' ) )? otherlv_1= 'map' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) otherlv_4= '{' ( (lv_stubs_5_0= ruleStubDeclaration ) )* ( (lv_paths_6_0= rulePath ) )* ( (lv_components_7_0= ruleComponentRef ) )* otherlv_8= '}'
            {
            // InternalTurn.g:3091:3: ( (lv_singleton_0_0= 'singleton' ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==56) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // InternalTurn.g:3092:4: (lv_singleton_0_0= 'singleton' )
                    {
                    // InternalTurn.g:3092:4: (lv_singleton_0_0= 'singleton' )
                    // InternalTurn.g:3093:5: lv_singleton_0_0= 'singleton'
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
            		
            // InternalTurn.g:3109:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:3110:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:3110:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:3111:5: lv_name_2_0= ruleQualifiedName
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

            // InternalTurn.g:3128:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:3129:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:3129:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:3130:5: lv_longName_3_0= ruleLongName
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
            		
            // InternalTurn.g:3151:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*
            loop56:
            do {
                int alt56=2;
                alt56 = dfa56.predict(input);
                switch (alt56) {
            	case 1 :
            	    // InternalTurn.g:3152:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    {
            	    // InternalTurn.g:3152:4: (lv_stubs_5_0= ruleStubDeclaration )
            	    // InternalTurn.g:3153:5: lv_stubs_5_0= ruleStubDeclaration
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
            	    break loop56;
                }
            } while (true);

            // InternalTurn.g:3170:3: ( (lv_paths_6_0= rulePath ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==58||(LA57_0>=62 && LA57_0<=63)) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalTurn.g:3171:4: (lv_paths_6_0= rulePath )
            	    {
            	    // InternalTurn.g:3171:4: (lv_paths_6_0= rulePath )
            	    // InternalTurn.g:3172:5: lv_paths_6_0= rulePath
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
            	    break loop57;
                }
            } while (true);

            // InternalTurn.g:3189:3: ( (lv_components_7_0= ruleComponentRef ) )*
            loop58:
            do {
                int alt58=2;
                int LA58_0 = input.LA(1);

                if ( (LA58_0==RULE_ID||LA58_0==32||LA58_0==90||(LA58_0>=121 && LA58_0<=125)) ) {
                    alt58=1;
                }


                switch (alt58) {
            	case 1 :
            	    // InternalTurn.g:3190:4: (lv_components_7_0= ruleComponentRef )
            	    {
            	    // InternalTurn.g:3190:4: (lv_components_7_0= ruleComponentRef )
            	    // InternalTurn.g:3191:5: lv_components_7_0= ruleComponentRef
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
            	    break loop58;
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
    // InternalTurn.g:3216:1: entryRulePath returns [EObject current=null] : iv_rulePath= rulePath EOF ;
    public final EObject entryRulePath() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePath = null;


        try {
            // InternalTurn.g:3216:45: (iv_rulePath= rulePath EOF )
            // InternalTurn.g:3217:2: iv_rulePath= rulePath EOF
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
    // InternalTurn.g:3223:1: rulePath returns [EObject current=null] : ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject rulePath() throws RecognitionException {
        EObject current = null;

        EObject lv_startPoint_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3229:2: ( ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTurn.g:3230:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTurn.g:3230:2: ( ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTurn.g:3231:3: ( (lv_startPoint_0_0= ruleStartPoint ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTurn.g:3231:3: ( (lv_startPoint_0_0= ruleStartPoint ) )
            // InternalTurn.g:3232:4: (lv_startPoint_0_0= ruleStartPoint )
            {
            // InternalTurn.g:3232:4: (lv_startPoint_0_0= ruleStartPoint )
            // InternalTurn.g:3233:5: lv_startPoint_0_0= ruleStartPoint
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

            // InternalTurn.g:3250:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTurn.g:3251:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTurn.g:3251:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTurn.g:3252:5: lv_pathBody_1_0= rulePathBody
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
    // InternalTurn.g:3273:1: entryRuleStartPoint returns [EObject current=null] : iv_ruleStartPoint= ruleStartPoint EOF ;
    public final EObject entryRuleStartPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStartPoint = null;


        try {
            // InternalTurn.g:3273:51: (iv_ruleStartPoint= ruleStartPoint EOF )
            // InternalTurn.g:3274:2: iv_ruleStartPoint= ruleStartPoint EOF
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
    // InternalTurn.g:3280:1: ruleStartPoint returns [EObject current=null] : ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) ) ;
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
            // InternalTurn.g:3286:2: ( ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) ) )
            // InternalTurn.g:3287:2: ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) )
            {
            // InternalTurn.g:3287:2: ( (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? ) | ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? ) )
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==58) ) {
                alt62=1;
            }
            else if ( ((LA62_0>=62 && LA62_0<=63)) ) {
                alt62=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 62, 0, input);

                throw nvae;
            }
            switch (alt62) {
                case 1 :
                    // InternalTurn.g:3288:3: (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? )
                    {
                    // InternalTurn.g:3288:3: (otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )? )
                    // InternalTurn.g:3289:4: otherlv_0= 'start' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_precondition_3_0= ruleCondition ) )?
                    {
                    otherlv_0=(Token)match(input,58,FOLLOW_62); 

                    				newLeafNode(otherlv_0, grammarAccess.getStartPointAccess().getStartKeyword_0_0());
                    			
                    // InternalTurn.g:3293:4: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==RULE_ID) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // InternalTurn.g:3294:5: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTurn.g:3294:5: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTurn.g:3295:6: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:3295:6: (lv_name_1_0= ruleQualifiedName )
                            // InternalTurn.g:3296:7: lv_name_1_0= ruleQualifiedName
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

                            // InternalTurn.g:3313:5: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTurn.g:3314:6: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTurn.g:3314:6: (lv_longName_2_0= ruleLongName )
                            // InternalTurn.g:3315:7: lv_longName_2_0= ruleLongName
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

                    // InternalTurn.g:3333:4: ( (lv_precondition_3_0= ruleCondition ) )?
                    int alt60=2;
                    int LA60_0 = input.LA(1);

                    if ( (LA60_0==25) ) {
                        alt60=1;
                    }
                    switch (alt60) {
                        case 1 :
                            // InternalTurn.g:3334:5: (lv_precondition_3_0= ruleCondition )
                            {
                            // InternalTurn.g:3334:5: (lv_precondition_3_0= ruleCondition )
                            // InternalTurn.g:3335:6: lv_precondition_3_0= ruleCondition
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
                    // InternalTurn.g:3354:3: ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? )
                    {
                    // InternalTurn.g:3354:3: ( ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )? )
                    // InternalTurn.g:3355:4: ( (lv_failKind_4_0= ruleFailureKind ) ) ( (lv_name_5_0= ruleQualifiedName ) ) ( (lv_longName_6_0= ruleLongName ) ) (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )?
                    {
                    // InternalTurn.g:3355:4: ( (lv_failKind_4_0= ruleFailureKind ) )
                    // InternalTurn.g:3356:5: (lv_failKind_4_0= ruleFailureKind )
                    {
                    // InternalTurn.g:3356:5: (lv_failKind_4_0= ruleFailureKind )
                    // InternalTurn.g:3357:6: lv_failKind_4_0= ruleFailureKind
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

                    // InternalTurn.g:3374:4: ( (lv_name_5_0= ruleQualifiedName ) )
                    // InternalTurn.g:3375:5: (lv_name_5_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:3375:5: (lv_name_5_0= ruleQualifiedName )
                    // InternalTurn.g:3376:6: lv_name_5_0= ruleQualifiedName
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

                    // InternalTurn.g:3393:4: ( (lv_longName_6_0= ruleLongName ) )
                    // InternalTurn.g:3394:5: (lv_longName_6_0= ruleLongName )
                    {
                    // InternalTurn.g:3394:5: (lv_longName_6_0= ruleLongName )
                    // InternalTurn.g:3395:6: lv_longName_6_0= ruleLongName
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

                    // InternalTurn.g:3412:4: (otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]' )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==59) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // InternalTurn.g:3413:5: otherlv_7= 'catches' otherlv_8= '[[' ( (lv_catches_9_0= RULE_STRING ) ) otherlv_10= ']]'
                            {
                            otherlv_7=(Token)match(input,59,FOLLOW_67); 

                            					newLeafNode(otherlv_7, grammarAccess.getStartPointAccess().getCatchesKeyword_1_3_0());
                            				
                            otherlv_8=(Token)match(input,60,FOLLOW_6); 

                            					newLeafNode(otherlv_8, grammarAccess.getStartPointAccess().getLeftSquareBracketLeftSquareBracketKeyword_1_3_1());
                            				
                            // InternalTurn.g:3421:5: ( (lv_catches_9_0= RULE_STRING ) )
                            // InternalTurn.g:3422:6: (lv_catches_9_0= RULE_STRING )
                            {
                            // InternalTurn.g:3422:6: (lv_catches_9_0= RULE_STRING )
                            // InternalTurn.g:3423:7: lv_catches_9_0= RULE_STRING
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
    // InternalTurn.g:3449:1: entryRuleFailureKind returns [String current=null] : iv_ruleFailureKind= ruleFailureKind EOF ;
    public final String entryRuleFailureKind() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFailureKind = null;


        try {
            // InternalTurn.g:3449:51: (iv_ruleFailureKind= ruleFailureKind EOF )
            // InternalTurn.g:3450:2: iv_ruleFailureKind= ruleFailureKind EOF
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
    // InternalTurn.g:3456:1: ruleFailureKind returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'abort' | kw= 'failure' ) ;
    public final AntlrDatatypeRuleToken ruleFailureKind() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:3462:2: ( (kw= 'abort' | kw= 'failure' ) )
            // InternalTurn.g:3463:2: (kw= 'abort' | kw= 'failure' )
            {
            // InternalTurn.g:3463:2: (kw= 'abort' | kw= 'failure' )
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==62) ) {
                alt63=1;
            }
            else if ( (LA63_0==63) ) {
                alt63=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 63, 0, input);

                throw nvae;
            }
            switch (alt63) {
                case 1 :
                    // InternalTurn.g:3464:3: kw= 'abort'
                    {
                    kw=(Token)match(input,62,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getFailureKindAccess().getAbortKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:3470:3: kw= 'failure'
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
    // InternalTurn.g:3479:1: entryRulePathBody returns [EObject current=null] : iv_rulePathBody= rulePathBody EOF ;
    public final EObject entryRulePathBody() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBody = null;


        try {
            // InternalTurn.g:3479:49: (iv_rulePathBody= rulePathBody EOF )
            // InternalTurn.g:3480:2: iv_rulePathBody= rulePathBody EOF
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
    // InternalTurn.g:3486:1: rulePathBody returns [EObject current=null] : this_PathWithRegularEnd_0= rulePathWithRegularEnd ;
    public final EObject rulePathBody() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithRegularEnd_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3492:2: (this_PathWithRegularEnd_0= rulePathWithRegularEnd )
            // InternalTurn.g:3493:2: this_PathWithRegularEnd_0= rulePathWithRegularEnd
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
    // InternalTurn.g:3504:1: entryRulePathWithRegularEnd returns [EObject current=null] : iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF ;
    public final EObject entryRulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithRegularEnd = null;


        try {
            // InternalTurn.g:3504:59: (iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF )
            // InternalTurn.g:3505:2: iv_rulePathWithRegularEnd= rulePathWithRegularEnd EOF
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
    // InternalTurn.g:3511:1: rulePathWithRegularEnd returns [EObject current=null] : (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) ;
    public final EObject rulePathWithRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_PathWithReferencedEnd_0 = null;

        EObject lv_pathEnd_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3517:2: ( (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? ) )
            // InternalTurn.g:3518:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            {
            // InternalTurn.g:3518:2: (this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )? )
            // InternalTurn.g:3519:3: this_PathWithReferencedEnd_0= rulePathWithReferencedEnd ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            {

            			newCompositeNode(grammarAccess.getPathWithRegularEndAccess().getPathWithReferencedEndParserRuleCall_0());
            		
            pushFollow(FOLLOW_69);
            this_PathWithReferencedEnd_0=rulePathWithReferencedEnd();

            state._fsp--;


            			current = this_PathWithReferencedEnd_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3527:3: ( (lv_pathEnd_1_0= ruleRegularEnd ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==77||LA64_0==79||LA64_0==81||(LA64_0>=83 && LA64_0<=85)) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalTurn.g:3528:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    {
                    // InternalTurn.g:3528:4: (lv_pathEnd_1_0= ruleRegularEnd )
                    // InternalTurn.g:3529:5: lv_pathEnd_1_0= ruleRegularEnd
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
    // InternalTurn.g:3550:1: entryRulePathWithReferencedEnd returns [EObject current=null] : iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF ;
    public final EObject entryRulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedEnd = null;


        try {
            // InternalTurn.g:3550:62: (iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF )
            // InternalTurn.g:3551:2: iv_rulePathWithReferencedEnd= rulePathWithReferencedEnd EOF
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
    // InternalTurn.g:3557:1: rulePathWithReferencedEnd returns [EObject current=null] : (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) ;
    public final EObject rulePathWithReferencedEnd() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject this_PathWithReferencedStub_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3563:2: ( (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? ) )
            // InternalTurn.g:3564:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            {
            // InternalTurn.g:3564:2: (this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )? )
            // InternalTurn.g:3565:3: this_PathWithReferencedStub_0= rulePathWithReferencedStub ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedEndAccess().getPathWithReferencedStubParserRuleCall_0());
            		
            pushFollow(FOLLOW_70);
            this_PathWithReferencedStub_0=rulePathWithReferencedStub();

            state._fsp--;


            			current = this_PathWithReferencedStub_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3573:3: ( ( (otherlv_1= RULE_ID ) )? otherlv_2= ';' )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==RULE_ID) ) {
                int LA66_1 = input.LA(2);

                if ( (LA66_1==64) ) {
                    alt66=1;
                }
            }
            else if ( (LA66_0==64) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalTurn.g:3574:4: ( (otherlv_1= RULE_ID ) )? otherlv_2= ';'
                    {
                    // InternalTurn.g:3574:4: ( (otherlv_1= RULE_ID ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==RULE_ID) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // InternalTurn.g:3575:5: (otherlv_1= RULE_ID )
                            {
                            // InternalTurn.g:3575:5: (otherlv_1= RULE_ID )
                            // InternalTurn.g:3576:6: otherlv_1= RULE_ID
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
    // InternalTurn.g:3596:1: entryRulePathWithReferencedStub returns [EObject current=null] : iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF ;
    public final EObject entryRulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathWithReferencedStub = null;


        try {
            // InternalTurn.g:3596:63: (iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF )
            // InternalTurn.g:3597:2: iv_rulePathWithReferencedStub= rulePathWithReferencedStub EOF
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
    // InternalTurn.g:3603:1: rulePathWithReferencedStub returns [EObject current=null] : (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) ;
    public final EObject rulePathWithReferencedStub() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject this_PathBodyNodes_0 = null;

        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3609:2: ( (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? ) )
            // InternalTurn.g:3610:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            {
            // InternalTurn.g:3610:2: (this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )? )
            // InternalTurn.g:3611:3: this_PathBodyNodes_0= rulePathBodyNodes (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            {

            			newCompositeNode(grammarAccess.getPathWithReferencedStubAccess().getPathBodyNodesParserRuleCall_0());
            		
            pushFollow(FOLLOW_72);
            this_PathBodyNodes_0=rulePathBodyNodes();

            state._fsp--;


            			current = this_PathBodyNodes_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:3619:3: (otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';' )?
            int alt67=2;
            int LA67_0 = input.LA(1);

            if ( (LA67_0==65) ) {
                alt67=1;
            }
            switch (alt67) {
                case 1 :
                    // InternalTurn.g:3620:4: otherlv_1= 'in' ( ( ruleQualifiedName ) ) ( (lv_index_3_0= rulePositiveInteger ) ) otherlv_4= ';'
                    {
                    otherlv_1=(Token)match(input,65,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getPathWithReferencedStubAccess().getInKeyword_1_0());
                    			
                    // InternalTurn.g:3624:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:3625:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:3625:5: ( ruleQualifiedName )
                    // InternalTurn.g:3626:6: ruleQualifiedName
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

                    // InternalTurn.g:3640:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTurn.g:3641:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:3641:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTurn.g:3642:6: lv_index_3_0= rulePositiveInteger
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
    // InternalTurn.g:3668:1: entryRulePathBodyNodes returns [EObject current=null] : iv_rulePathBodyNodes= rulePathBodyNodes EOF ;
    public final EObject entryRulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNodes = null;


        try {
            // InternalTurn.g:3668:54: (iv_rulePathBodyNodes= rulePathBodyNodes EOF )
            // InternalTurn.g:3669:2: iv_rulePathBodyNodes= rulePathBodyNodes EOF
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
    // InternalTurn.g:3675:1: rulePathBodyNodes returns [EObject current=null] : ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) ;
    public final EObject rulePathBodyNodes() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject lv_pathNodes_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3681:2: ( ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* ) )
            // InternalTurn.g:3682:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            {
            // InternalTurn.g:3682:2: ( () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )* )
            // InternalTurn.g:3683:3: () ruleArrow ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            {
            // InternalTurn.g:3683:3: ()
            // InternalTurn.g:3684:4: 
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
            		
            // InternalTurn.g:3697:3: ( ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->' )*
            loop68:
            do {
                int alt68=2;
                int LA68_0 = input.LA(1);

                if ( ((LA68_0>=67 && LA68_0<=73)||(LA68_0>=75 && LA68_0<=76)||(LA68_0>=119 && LA68_0<=120)) ) {
                    alt68=1;
                }


                switch (alt68) {
            	case 1 :
            	    // InternalTurn.g:3698:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) ) otherlv_3= '->'
            	    {
            	    // InternalTurn.g:3698:4: ( (lv_pathNodes_2_0= rulePathBodyNode ) )
            	    // InternalTurn.g:3699:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    {
            	    // InternalTurn.g:3699:5: (lv_pathNodes_2_0= rulePathBodyNode )
            	    // InternalTurn.g:3700:6: lv_pathNodes_2_0= rulePathBodyNode
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
            	    break loop68;
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
    // InternalTurn.g:3726:1: entryRuleArrow returns [String current=null] : iv_ruleArrow= ruleArrow EOF ;
    public final String entryRuleArrow() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrow = null;


        try {
            // InternalTurn.g:3726:45: (iv_ruleArrow= ruleArrow EOF )
            // InternalTurn.g:3727:2: iv_ruleArrow= ruleArrow EOF
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
    // InternalTurn.g:3733:1: ruleArrow returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : kw= '->' ;
    public final AntlrDatatypeRuleToken ruleArrow() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:3739:2: (kw= '->' )
            // InternalTurn.g:3740:2: kw= '->'
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
    // InternalTurn.g:3748:1: entryRulePathBodyNode returns [EObject current=null] : iv_rulePathBodyNode= rulePathBodyNode EOF ;
    public final EObject entryRulePathBodyNode() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathBodyNode = null;


        try {
            // InternalTurn.g:3748:53: (iv_rulePathBodyNode= rulePathBodyNode EOF )
            // InternalTurn.g:3749:2: iv_rulePathBodyNode= rulePathBodyNode EOF
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
    // InternalTurn.g:3755:1: rulePathBodyNode returns [EObject current=null] : (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) ;
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
            // InternalTurn.g:3761:2: ( (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect ) )
            // InternalTurn.g:3762:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            {
            // InternalTurn.g:3762:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )
            int alt69=7;
            alt69 = dfa69.predict(input);
            switch (alt69) {
                case 1 :
                    // InternalTurn.g:3763:3: this_AndJoin_0= ruleAndJoin
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
                    // InternalTurn.g:3772:3: this_RespRef_1= ruleRespRef
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
                    // InternalTurn.g:3781:3: this_OrJoin_2= ruleOrJoin
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
                    // InternalTurn.g:3790:3: this_WaitingPlace_3= ruleWaitingPlace
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
                    // InternalTurn.g:3799:3: this_FailurePoint_4= ruleFailurePoint
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
                    // InternalTurn.g:3808:3: this_Timer_5= ruleTimer
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
                    // InternalTurn.g:3817:3: this_Connect_6= ruleConnect
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
    // InternalTurn.g:3829:1: entryRuleRegularEnd returns [EObject current=null] : iv_ruleRegularEnd= ruleRegularEnd EOF ;
    public final EObject entryRuleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularEnd = null;


        try {
            // InternalTurn.g:3829:51: (iv_ruleRegularEnd= ruleRegularEnd EOF )
            // InternalTurn.g:3830:2: iv_ruleRegularEnd= ruleRegularEnd EOF
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
    // InternalTurn.g:3836:1: ruleRegularEnd returns [EObject current=null] : (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) ;
    public final EObject ruleRegularEnd() throws RecognitionException {
        EObject current = null;

        EObject this_EndpointWithConnect_0 = null;

        EObject this_AndFork_1 = null;

        EObject this_OrFork_2 = null;

        EObject this_Stub_3 = null;



        	enterRule();

        try {
            // InternalTurn.g:3842:2: ( (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub ) )
            // InternalTurn.g:3843:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            {
            // InternalTurn.g:3843:2: (this_EndpointWithConnect_0= ruleEndpointWithConnect | this_AndFork_1= ruleAndFork | this_OrFork_2= ruleOrFork | this_Stub_3= ruleStub )
            int alt70=4;
            switch ( input.LA(1) ) {
            case 77:
                {
                alt70=1;
                }
                break;
            case 81:
                {
                alt70=2;
                }
                break;
            case 79:
                {
                alt70=3;
                }
                break;
            case 83:
            case 84:
            case 85:
                {
                alt70=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 70, 0, input);

                throw nvae;
            }

            switch (alt70) {
                case 1 :
                    // InternalTurn.g:3844:3: this_EndpointWithConnect_0= ruleEndpointWithConnect
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
                    // InternalTurn.g:3853:3: this_AndFork_1= ruleAndFork
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
                    // InternalTurn.g:3862:3: this_OrFork_2= ruleOrFork
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
                    // InternalTurn.g:3871:3: this_Stub_3= ruleStub
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
    // InternalTurn.g:3883:1: entryRuleEndpointWithConnect returns [EObject current=null] : iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF ;
    public final EObject entryRuleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndpointWithConnect = null;


        try {
            // InternalTurn.g:3883:60: (iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF )
            // InternalTurn.g:3884:2: iv_ruleEndpointWithConnect= ruleEndpointWithConnect EOF
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
    // InternalTurn.g:3890:1: ruleEndpointWithConnect returns [EObject current=null] : ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) ;
    public final EObject ruleEndpointWithConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_regularEnd_0_0 = null;

        EObject lv_connect_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3896:2: ( ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? ) )
            // InternalTurn.g:3897:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            {
            // InternalTurn.g:3897:2: ( ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )? )
            // InternalTurn.g:3898:3: ( (lv_regularEnd_0_0= ruleEndPoint ) ) (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            {
            // InternalTurn.g:3898:3: ( (lv_regularEnd_0_0= ruleEndPoint ) )
            // InternalTurn.g:3899:4: (lv_regularEnd_0_0= ruleEndPoint )
            {
            // InternalTurn.g:3899:4: (lv_regularEnd_0_0= ruleEndPoint )
            // InternalTurn.g:3900:5: lv_regularEnd_0_0= ruleEndPoint
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

            // InternalTurn.g:3917:3: (otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) ) )?
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==66) ) {
                alt71=1;
            }
            switch (alt71) {
                case 1 :
                    // InternalTurn.g:3918:4: otherlv_1= '->' ( (lv_connect_2_0= ruleConnect ) )
                    {
                    otherlv_1=(Token)match(input,66,FOLLOW_75); 

                    				newLeafNode(otherlv_1, grammarAccess.getEndpointWithConnectAccess().getHyphenMinusGreaterThanSignKeyword_1_0());
                    			
                    // InternalTurn.g:3922:4: ( (lv_connect_2_0= ruleConnect ) )
                    // InternalTurn.g:3923:5: (lv_connect_2_0= ruleConnect )
                    {
                    // InternalTurn.g:3923:5: (lv_connect_2_0= ruleConnect )
                    // InternalTurn.g:3924:6: lv_connect_2_0= ruleConnect
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
    // InternalTurn.g:3946:1: entryRuleRespRef returns [EObject current=null] : iv_ruleRespRef= ruleRespRef EOF ;
    public final EObject entryRuleRespRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRespRef = null;


        try {
            // InternalTurn.g:3946:48: (iv_ruleRespRef= ruleRespRef EOF )
            // InternalTurn.g:3947:2: iv_ruleRespRef= ruleRespRef EOF
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
    // InternalTurn.g:3953:1: ruleRespRef returns [EObject current=null] : (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) ;
    public final EObject ruleRespRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:3959:2: ( (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) ) )
            // InternalTurn.g:3960:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            {
            // InternalTurn.g:3960:2: (otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )
            // InternalTurn.g:3961:3: otherlv_0= 'X' ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
            {
            otherlv_0=(Token)match(input,67,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getRespRefAccess().getXKeyword_0());
            		
            // InternalTurn.g:3965:3: ( (lv_name_1_0= ruleQualifiedName ) )
            // InternalTurn.g:3966:4: (lv_name_1_0= ruleQualifiedName )
            {
            // InternalTurn.g:3966:4: (lv_name_1_0= ruleQualifiedName )
            // InternalTurn.g:3967:5: lv_name_1_0= ruleQualifiedName
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

            // InternalTurn.g:3984:3: ( (lv_longName_2_0= ruleLongName ) )
            // InternalTurn.g:3985:4: (lv_longName_2_0= ruleLongName )
            {
            // InternalTurn.g:3985:4: (lv_longName_2_0= ruleLongName )
            // InternalTurn.g:3986:5: lv_longName_2_0= ruleLongName
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
    // InternalTurn.g:4007:1: entryRuleOrJoin returns [EObject current=null] : iv_ruleOrJoin= ruleOrJoin EOF ;
    public final EObject entryRuleOrJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrJoin = null;


        try {
            // InternalTurn.g:4007:47: (iv_ruleOrJoin= ruleOrJoin EOF )
            // InternalTurn.g:4008:2: iv_ruleOrJoin= ruleOrJoin EOF
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
    // InternalTurn.g:4014:1: ruleOrJoin returns [EObject current=null] : ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) ;
    public final EObject ruleOrJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4020:2: ( ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) ) )
            // InternalTurn.g:4021:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4021:2: ( () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )
            // InternalTurn.g:4022:3: () otherlv_1= 'join' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
            {
            // InternalTurn.g:4022:3: ()
            // InternalTurn.g:4023:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getOrJoinAccess().getOrJoinAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,68,FOLLOW_3); 

            			newLeafNode(otherlv_1, grammarAccess.getOrJoinAccess().getJoinKeyword_1());
            		
            // InternalTurn.g:4033:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:4034:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:4034:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:4035:5: lv_name_2_0= ruleQualifiedName
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

            // InternalTurn.g:4052:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:4053:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:4053:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:4054:5: lv_longName_3_0= ruleLongName
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
    // InternalTurn.g:4075:1: entryRuleAndJoin returns [EObject current=null] : iv_ruleAndJoin= ruleAndJoin EOF ;
    public final EObject entryRuleAndJoin() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndJoin = null;


        try {
            // InternalTurn.g:4075:48: (iv_ruleAndJoin= ruleAndJoin EOF )
            // InternalTurn.g:4076:2: iv_ruleAndJoin= ruleAndJoin EOF
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
    // InternalTurn.g:4082:1: ruleAndJoin returns [EObject current=null] : ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) ;
    public final EObject ruleAndJoin() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_3_0 = null;

        EObject lv_longName_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4088:2: ( ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) ) )
            // InternalTurn.g:4089:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            {
            // InternalTurn.g:4089:2: ( (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )
            // InternalTurn.g:4090:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' ) ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
            {
            // InternalTurn.g:4090:3: (otherlv_0= 'synch' | otherlv_1= 'sync' | otherlv_2= '|' )
            int alt72=3;
            switch ( input.LA(1) ) {
            case 69:
                {
                alt72=1;
                }
                break;
            case 70:
                {
                alt72=2;
                }
                break;
            case 71:
                {
                alt72=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalTurn.g:4091:4: otherlv_0= 'synch'
                    {
                    otherlv_0=(Token)match(input,69,FOLLOW_3); 

                    				newLeafNode(otherlv_0, grammarAccess.getAndJoinAccess().getSynchKeyword_0_0());
                    			

                    }
                    break;
                case 2 :
                    // InternalTurn.g:4096:4: otherlv_1= 'sync'
                    {
                    otherlv_1=(Token)match(input,70,FOLLOW_3); 

                    				newLeafNode(otherlv_1, grammarAccess.getAndJoinAccess().getSyncKeyword_0_1());
                    			

                    }
                    break;
                case 3 :
                    // InternalTurn.g:4101:4: otherlv_2= '|'
                    {
                    otherlv_2=(Token)match(input,71,FOLLOW_3); 

                    				newLeafNode(otherlv_2, grammarAccess.getAndJoinAccess().getVerticalLineKeyword_0_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:4106:3: ( (lv_name_3_0= ruleQualifiedName ) )
            // InternalTurn.g:4107:4: (lv_name_3_0= ruleQualifiedName )
            {
            // InternalTurn.g:4107:4: (lv_name_3_0= ruleQualifiedName )
            // InternalTurn.g:4108:5: lv_name_3_0= ruleQualifiedName
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

            // InternalTurn.g:4125:3: ( (lv_longName_4_0= ruleLongName ) )
            // InternalTurn.g:4126:4: (lv_longName_4_0= ruleLongName )
            {
            // InternalTurn.g:4126:4: (lv_longName_4_0= ruleLongName )
            // InternalTurn.g:4127:5: lv_longName_4_0= ruleLongName
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
    // InternalTurn.g:4148:1: entryRuleWaitingPlace returns [EObject current=null] : iv_ruleWaitingPlace= ruleWaitingPlace EOF ;
    public final EObject entryRuleWaitingPlace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleWaitingPlace = null;


        try {
            // InternalTurn.g:4148:53: (iv_ruleWaitingPlace= ruleWaitingPlace EOF )
            // InternalTurn.g:4149:2: iv_ruleWaitingPlace= ruleWaitingPlace EOF
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
    // InternalTurn.g:4155:1: ruleWaitingPlace returns [EObject current=null] : ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) ;
    public final EObject ruleWaitingPlace() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Enumerator lv_kind_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_longName_3_0 = null;

        EObject lv_condition_4_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4161:2: ( ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? ) )
            // InternalTurn.g:4162:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            {
            // InternalTurn.g:4162:2: ( ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )? )
            // InternalTurn.g:4163:3: ( (lv_kind_0_0= ruleWAITKIND ) )? otherlv_1= 'wait' ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )? ( (lv_condition_4_0= ruleCondition ) )?
            {
            // InternalTurn.g:4163:3: ( (lv_kind_0_0= ruleWAITKIND ) )?
            int alt73=2;
            int LA73_0 = input.LA(1);

            if ( ((LA73_0>=119 && LA73_0<=120)) ) {
                alt73=1;
            }
            switch (alt73) {
                case 1 :
                    // InternalTurn.g:4164:4: (lv_kind_0_0= ruleWAITKIND )
                    {
                    // InternalTurn.g:4164:4: (lv_kind_0_0= ruleWAITKIND )
                    // InternalTurn.g:4165:5: lv_kind_0_0= ruleWAITKIND
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
            		
            // InternalTurn.g:4186:3: ( ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalTurn.g:4187:4: ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4187:4: ( (lv_name_2_0= ruleQualifiedName ) )
                    // InternalTurn.g:4188:5: (lv_name_2_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4188:5: (lv_name_2_0= ruleQualifiedName )
                    // InternalTurn.g:4189:6: lv_name_2_0= ruleQualifiedName
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

                    // InternalTurn.g:4206:4: ( (lv_longName_3_0= ruleLongName ) )
                    // InternalTurn.g:4207:5: (lv_longName_3_0= ruleLongName )
                    {
                    // InternalTurn.g:4207:5: (lv_longName_3_0= ruleLongName )
                    // InternalTurn.g:4208:6: lv_longName_3_0= ruleLongName
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

            // InternalTurn.g:4226:3: ( (lv_condition_4_0= ruleCondition ) )?
            int alt75=2;
            int LA75_0 = input.LA(1);

            if ( (LA75_0==25) ) {
                alt75=1;
            }
            switch (alt75) {
                case 1 :
                    // InternalTurn.g:4227:4: (lv_condition_4_0= ruleCondition )
                    {
                    // InternalTurn.g:4227:4: (lv_condition_4_0= ruleCondition )
                    // InternalTurn.g:4228:5: lv_condition_4_0= ruleCondition
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
    // InternalTurn.g:4249:1: entryRuleTimer returns [EObject current=null] : iv_ruleTimer= ruleTimer EOF ;
    public final EObject entryRuleTimer() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTimer = null;


        try {
            // InternalTurn.g:4249:46: (iv_ruleTimer= ruleTimer EOF )
            // InternalTurn.g:4250:2: iv_ruleTimer= ruleTimer EOF
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
    // InternalTurn.g:4256:1: ruleTimer returns [EObject current=null] : ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? ) ;
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
            // InternalTurn.g:4262:2: ( ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? ) )
            // InternalTurn.g:4263:2: ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? )
            {
            // InternalTurn.g:4263:2: ( () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )? )
            // InternalTurn.g:4264:3: () ( (lv_kind_1_0= ruleWAITKIND ) )? otherlv_2= 'timer' ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )? (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )? ( (lv_condition_10_0= ruleCondition ) )?
            {
            // InternalTurn.g:4264:3: ()
            // InternalTurn.g:4265:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getTimerAccess().getTimerAction_0(),
            					current);
            			

            }

            // InternalTurn.g:4271:3: ( (lv_kind_1_0= ruleWAITKIND ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=119 && LA76_0<=120)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalTurn.g:4272:4: (lv_kind_1_0= ruleWAITKIND )
                    {
                    // InternalTurn.g:4272:4: (lv_kind_1_0= ruleWAITKIND )
                    // InternalTurn.g:4273:5: lv_kind_1_0= ruleWAITKIND
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
            		
            // InternalTurn.g:4294:3: ( ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) ) )?
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==RULE_ID) ) {
                alt77=1;
            }
            switch (alt77) {
                case 1 :
                    // InternalTurn.g:4295:4: ( (lv_name_3_0= ruleQualifiedName ) ) ( (lv_longName_4_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4295:4: ( (lv_name_3_0= ruleQualifiedName ) )
                    // InternalTurn.g:4296:5: (lv_name_3_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4296:5: (lv_name_3_0= ruleQualifiedName )
                    // InternalTurn.g:4297:6: lv_name_3_0= ruleQualifiedName
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

                    // InternalTurn.g:4314:4: ( (lv_longName_4_0= ruleLongName ) )
                    // InternalTurn.g:4315:5: (lv_longName_4_0= ruleLongName )
                    {
                    // InternalTurn.g:4315:5: (lv_longName_4_0= ruleLongName )
                    // InternalTurn.g:4316:6: lv_longName_4_0= ruleLongName
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

            // InternalTurn.g:4334:3: (otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}' )?
            int alt81=2;
            int LA81_0 = input.LA(1);

            if ( (LA81_0==13) ) {
                alt81=1;
            }
            switch (alt81) {
                case 1 :
                    // InternalTurn.g:4335:4: otherlv_5= '{' (otherlv_6= 'timeout' )? ( (lv_timeoutCondition_7_0= ruleCondition ) )? ( (lv_timeoutPath_8_0= rulePathBody ) )? otherlv_9= '}'
                    {
                    otherlv_5=(Token)match(input,13,FOLLOW_82); 

                    				newLeafNode(otherlv_5, grammarAccess.getTimerAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTurn.g:4339:4: (otherlv_6= 'timeout' )?
                    int alt78=2;
                    int LA78_0 = input.LA(1);

                    if ( (LA78_0==74) ) {
                        alt78=1;
                    }
                    switch (alt78) {
                        case 1 :
                            // InternalTurn.g:4340:5: otherlv_6= 'timeout'
                            {
                            otherlv_6=(Token)match(input,74,FOLLOW_83); 

                            					newLeafNode(otherlv_6, grammarAccess.getTimerAccess().getTimeoutKeyword_4_1());
                            				

                            }
                            break;

                    }

                    // InternalTurn.g:4345:4: ( (lv_timeoutCondition_7_0= ruleCondition ) )?
                    int alt79=2;
                    int LA79_0 = input.LA(1);

                    if ( (LA79_0==25) ) {
                        alt79=1;
                    }
                    switch (alt79) {
                        case 1 :
                            // InternalTurn.g:4346:5: (lv_timeoutCondition_7_0= ruleCondition )
                            {
                            // InternalTurn.g:4346:5: (lv_timeoutCondition_7_0= ruleCondition )
                            // InternalTurn.g:4347:6: lv_timeoutCondition_7_0= ruleCondition
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

                    // InternalTurn.g:4364:4: ( (lv_timeoutPath_8_0= rulePathBody ) )?
                    int alt80=2;
                    int LA80_0 = input.LA(1);

                    if ( (LA80_0==66) ) {
                        alt80=1;
                    }
                    switch (alt80) {
                        case 1 :
                            // InternalTurn.g:4365:5: (lv_timeoutPath_8_0= rulePathBody )
                            {
                            // InternalTurn.g:4365:5: (lv_timeoutPath_8_0= rulePathBody )
                            // InternalTurn.g:4366:6: lv_timeoutPath_8_0= rulePathBody
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

            // InternalTurn.g:4388:3: ( (lv_condition_10_0= ruleCondition ) )?
            int alt82=2;
            int LA82_0 = input.LA(1);

            if ( (LA82_0==25) ) {
                alt82=1;
            }
            switch (alt82) {
                case 1 :
                    // InternalTurn.g:4389:4: (lv_condition_10_0= ruleCondition )
                    {
                    // InternalTurn.g:4389:4: (lv_condition_10_0= ruleCondition )
                    // InternalTurn.g:4390:5: lv_condition_10_0= ruleCondition
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
    // InternalTurn.g:4411:1: entryRuleConnect returns [EObject current=null] : iv_ruleConnect= ruleConnect EOF ;
    public final EObject entryRuleConnect() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConnect = null;


        try {
            // InternalTurn.g:4411:48: (iv_ruleConnect= ruleConnect EOF )
            // InternalTurn.g:4412:2: iv_ruleConnect= ruleConnect EOF
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
    // InternalTurn.g:4418:1: ruleConnect returns [EObject current=null] : (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) ;
    public final EObject ruleConnect() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTurn.g:4424:2: ( (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' ) )
            // InternalTurn.g:4425:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            {
            // InternalTurn.g:4425:2: (otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';' )
            // InternalTurn.g:4426:3: otherlv_0= 'trigger' ( ( ruleQualifiedName ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,75,FOLLOW_3); 

            			newLeafNode(otherlv_0, grammarAccess.getConnectAccess().getTriggerKeyword_0());
            		
            // InternalTurn.g:4430:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:4431:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:4431:4: ( ruleQualifiedName )
            // InternalTurn.g:4432:5: ruleQualifiedName
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
    // InternalTurn.g:4454:1: entryRuleFailurePoint returns [EObject current=null] : iv_ruleFailurePoint= ruleFailurePoint EOF ;
    public final EObject entryRuleFailurePoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailurePoint = null;


        try {
            // InternalTurn.g:4454:53: (iv_ruleFailurePoint= ruleFailurePoint EOF )
            // InternalTurn.g:4455:2: iv_ruleFailurePoint= ruleFailurePoint EOF
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
    // InternalTurn.g:4461:1: ruleFailurePoint returns [EObject current=null] : (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) ;
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
            // InternalTurn.g:4467:2: ( (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? ) )
            // InternalTurn.g:4468:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            {
            // InternalTurn.g:4468:2: (otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )? )
            // InternalTurn.g:4469:3: otherlv_0= 'fail' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            {
            otherlv_0=(Token)match(input,76,FOLLOW_85); 

            			newLeafNode(otherlv_0, grammarAccess.getFailurePointAccess().getFailKeyword_0());
            		
            // InternalTurn.g:4473:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt83=2;
            int LA83_0 = input.LA(1);

            if ( (LA83_0==RULE_ID) ) {
                alt83=1;
            }
            switch (alt83) {
                case 1 :
                    // InternalTurn.g:4474:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4474:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:4475:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4475:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:4476:6: lv_name_1_0= ruleQualifiedName
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

                    // InternalTurn.g:4493:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:4494:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:4494:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:4495:6: lv_longName_2_0= ruleLongName
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

            // InternalTurn.g:4513:3: ( ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) ) | ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) ) )?
            int alt84=3;
            int LA84_0 = input.LA(1);

            if ( (LA84_0==25) ) {
                alt84=1;
            }
            else if ( (LA84_0==60) ) {
                alt84=2;
            }
            switch (alt84) {
                case 1 :
                    // InternalTurn.g:4514:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    {
                    // InternalTurn.g:4514:4: ( ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) ) )
                    // InternalTurn.g:4515:5: ( (lv_condition_3_0= ruleCondition ) ) ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    {
                    // InternalTurn.g:4515:5: ( (lv_condition_3_0= ruleCondition ) )
                    // InternalTurn.g:4516:6: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTurn.g:4516:6: (lv_condition_3_0= ruleCondition )
                    // InternalTurn.g:4517:7: lv_condition_3_0= ruleCondition
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

                    // InternalTurn.g:4534:5: ( (lv_failLabel_4_0= ruleFailureLabel ) )
                    // InternalTurn.g:4535:6: (lv_failLabel_4_0= ruleFailureLabel )
                    {
                    // InternalTurn.g:4535:6: (lv_failLabel_4_0= ruleFailureLabel )
                    // InternalTurn.g:4536:7: lv_failLabel_4_0= ruleFailureLabel
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
                    // InternalTurn.g:4555:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    {
                    // InternalTurn.g:4555:4: ( ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) ) )
                    // InternalTurn.g:4556:5: ( (lv_failLabel_5_0= ruleFailureLabel ) ) ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTurn.g:4556:5: ( (lv_failLabel_5_0= ruleFailureLabel ) )
                    // InternalTurn.g:4557:6: (lv_failLabel_5_0= ruleFailureLabel )
                    {
                    // InternalTurn.g:4557:6: (lv_failLabel_5_0= ruleFailureLabel )
                    // InternalTurn.g:4558:7: lv_failLabel_5_0= ruleFailureLabel
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

                    // InternalTurn.g:4575:5: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTurn.g:4576:6: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTurn.g:4576:6: (lv_condition_6_0= ruleCondition )
                    // InternalTurn.g:4577:7: lv_condition_6_0= ruleCondition
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
    // InternalTurn.g:4600:1: entryRuleEndPoint returns [EObject current=null] : iv_ruleEndPoint= ruleEndPoint EOF ;
    public final EObject entryRuleEndPoint() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEndPoint = null;


        try {
            // InternalTurn.g:4600:49: (iv_ruleEndPoint= ruleEndPoint EOF )
            // InternalTurn.g:4601:2: iv_ruleEndPoint= ruleEndPoint EOF
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
    // InternalTurn.g:4607:1: ruleEndPoint returns [EObject current=null] : (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) ;
    public final EObject ruleEndPoint() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_longName_2_0 = null;

        EObject lv_condition_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4613:2: ( (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' ) )
            // InternalTurn.g:4614:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            {
            // InternalTurn.g:4614:2: (otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.' )
            // InternalTurn.g:4615:3: otherlv_0= 'end' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? ( (lv_condition_3_0= ruleCondition ) )? otherlv_4= '.'
            {
            otherlv_0=(Token)match(input,77,FOLLOW_89); 

            			newLeafNode(otherlv_0, grammarAccess.getEndPointAccess().getEndKeyword_0());
            		
            // InternalTurn.g:4619:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt85=2;
            int LA85_0 = input.LA(1);

            if ( (LA85_0==RULE_ID) ) {
                alt85=1;
            }
            switch (alt85) {
                case 1 :
                    // InternalTurn.g:4620:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:4620:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:4621:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:4621:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:4622:6: lv_name_1_0= ruleQualifiedName
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

                    // InternalTurn.g:4639:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:4640:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:4640:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:4641:6: lv_longName_2_0= ruleLongName
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

            // InternalTurn.g:4659:3: ( (lv_condition_3_0= ruleCondition ) )?
            int alt86=2;
            int LA86_0 = input.LA(1);

            if ( (LA86_0==25) ) {
                alt86=1;
            }
            switch (alt86) {
                case 1 :
                    // InternalTurn.g:4660:4: (lv_condition_3_0= ruleCondition )
                    {
                    // InternalTurn.g:4660:4: (lv_condition_3_0= ruleCondition )
                    // InternalTurn.g:4661:5: lv_condition_3_0= ruleCondition
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
    // InternalTurn.g:4686:1: entryRuleOrFork returns [EObject current=null] : iv_ruleOrFork= ruleOrFork EOF ;
    public final EObject entryRuleOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrFork = null;


        try {
            // InternalTurn.g:4686:47: (iv_ruleOrFork= ruleOrFork EOF )
            // InternalTurn.g:4687:2: iv_ruleOrFork= ruleOrFork EOF
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
    // InternalTurn.g:4693:1: ruleOrFork returns [EObject current=null] : (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? ) ;
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
            // InternalTurn.g:4699:2: ( (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? ) )
            // InternalTurn.g:4700:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? )
            {
            // InternalTurn.g:4700:2: (otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )? )
            // InternalTurn.g:4701:3: otherlv_0= 'or' ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) ) ( (lv_connectingOrBody_7_0= rulePathBody ) )?
            {
            otherlv_0=(Token)match(input,79,FOLLOW_93); 

            			newLeafNode(otherlv_0, grammarAccess.getOrForkAccess().getOrKeyword_0());
            		
            // InternalTurn.g:4705:3: ( ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' ) | ( (lv_condition_6_0= ruleCondition ) ) )
            int alt88=2;
            int LA88_0 = input.LA(1);

            if ( (LA88_0==RULE_ID||LA88_0==13) ) {
                alt88=1;
            }
            else if ( (LA88_0==25) ) {
                alt88=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 88, 0, input);

                throw nvae;
            }
            switch (alt88) {
                case 1 :
                    // InternalTurn.g:4706:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    {
                    // InternalTurn.g:4706:4: ( ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}' )
                    // InternalTurn.g:4707:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' ( (lv_body_4_0= ruleOrBody ) ) otherlv_5= '}'
                    {
                    // InternalTurn.g:4707:5: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
                    int alt87=2;
                    int LA87_0 = input.LA(1);

                    if ( (LA87_0==RULE_ID) ) {
                        alt87=1;
                    }
                    switch (alt87) {
                        case 1 :
                            // InternalTurn.g:4708:6: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                            {
                            // InternalTurn.g:4708:6: ( (lv_name_1_0= ruleQualifiedName ) )
                            // InternalTurn.g:4709:7: (lv_name_1_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:4709:7: (lv_name_1_0= ruleQualifiedName )
                            // InternalTurn.g:4710:8: lv_name_1_0= ruleQualifiedName
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

                            // InternalTurn.g:4727:6: ( (lv_longName_2_0= ruleLongName ) )
                            // InternalTurn.g:4728:7: (lv_longName_2_0= ruleLongName )
                            {
                            // InternalTurn.g:4728:7: (lv_longName_2_0= ruleLongName )
                            // InternalTurn.g:4729:8: lv_longName_2_0= ruleLongName
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
                    				
                    // InternalTurn.g:4751:5: ( (lv_body_4_0= ruleOrBody ) )
                    // InternalTurn.g:4752:6: (lv_body_4_0= ruleOrBody )
                    {
                    // InternalTurn.g:4752:6: (lv_body_4_0= ruleOrBody )
                    // InternalTurn.g:4753:7: lv_body_4_0= ruleOrBody
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
                    // InternalTurn.g:4776:4: ( (lv_condition_6_0= ruleCondition ) )
                    {
                    // InternalTurn.g:4776:4: ( (lv_condition_6_0= ruleCondition ) )
                    // InternalTurn.g:4777:5: (lv_condition_6_0= ruleCondition )
                    {
                    // InternalTurn.g:4777:5: (lv_condition_6_0= ruleCondition )
                    // InternalTurn.g:4778:6: lv_condition_6_0= ruleCondition
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

            // InternalTurn.g:4796:3: ( (lv_connectingOrBody_7_0= rulePathBody ) )?
            int alt89=2;
            int LA89_0 = input.LA(1);

            if ( (LA89_0==66) ) {
                alt89=1;
            }
            switch (alt89) {
                case 1 :
                    // InternalTurn.g:4797:4: (lv_connectingOrBody_7_0= rulePathBody )
                    {
                    // InternalTurn.g:4797:4: (lv_connectingOrBody_7_0= rulePathBody )
                    // InternalTurn.g:4798:5: lv_connectingOrBody_7_0= rulePathBody
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
    // InternalTurn.g:4819:1: entryRuleOrBody returns [EObject current=null] : iv_ruleOrBody= ruleOrBody EOF ;
    public final EObject entryRuleOrBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBody = null;


        try {
            // InternalTurn.g:4819:47: (iv_ruleOrBody= ruleOrBody EOF )
            // InternalTurn.g:4820:2: iv_ruleOrBody= ruleOrBody EOF
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
    // InternalTurn.g:4826:1: ruleOrBody returns [EObject current=null] : this_ElseOrForkBody_0= ruleElseOrForkBody ;
    public final EObject ruleOrBody() throws RecognitionException {
        EObject current = null;

        EObject this_ElseOrForkBody_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4832:2: (this_ElseOrForkBody_0= ruleElseOrForkBody )
            // InternalTurn.g:4833:2: this_ElseOrForkBody_0= ruleElseOrForkBody
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
    // InternalTurn.g:4844:1: entryRuleElseOrForkBody returns [EObject current=null] : iv_ruleElseOrForkBody= ruleElseOrForkBody EOF ;
    public final EObject entryRuleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseOrForkBody = null;


        try {
            // InternalTurn.g:4844:55: (iv_ruleElseOrForkBody= ruleElseOrForkBody EOF )
            // InternalTurn.g:4845:2: iv_ruleElseOrForkBody= ruleElseOrForkBody EOF
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
    // InternalTurn.g:4851:1: ruleElseOrForkBody returns [EObject current=null] : (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) ;
    public final EObject ruleElseOrForkBody() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject this_OrForkBody_0 = null;

        EObject lv_elseBody_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4857:2: ( (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? ) )
            // InternalTurn.g:4858:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            {
            // InternalTurn.g:4858:2: (this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )? )
            // InternalTurn.g:4859:3: this_OrForkBody_0= ruleOrForkBody (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            {

            			newCompositeNode(grammarAccess.getElseOrForkBodyAccess().getOrForkBodyParserRuleCall_0());
            		
            pushFollow(FOLLOW_94);
            this_OrForkBody_0=ruleOrForkBody();

            state._fsp--;


            			current = this_OrForkBody_0;
            			afterParserOrEnumRuleCall();
            		
            // InternalTurn.g:4867:3: (otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) ) )?
            int alt90=2;
            int LA90_0 = input.LA(1);

            if ( (LA90_0==80) ) {
                alt90=1;
            }
            switch (alt90) {
                case 1 :
                    // InternalTurn.g:4868:4: otherlv_1= '[else]' ( (lv_elseBody_2_0= rulePathBody ) )
                    {
                    otherlv_1=(Token)match(input,80,FOLLOW_61); 

                    				newLeafNode(otherlv_1, grammarAccess.getElseOrForkBodyAccess().getElseKeyword_1_0());
                    			
                    // InternalTurn.g:4872:4: ( (lv_elseBody_2_0= rulePathBody ) )
                    // InternalTurn.g:4873:5: (lv_elseBody_2_0= rulePathBody )
                    {
                    // InternalTurn.g:4873:5: (lv_elseBody_2_0= rulePathBody )
                    // InternalTurn.g:4874:6: lv_elseBody_2_0= rulePathBody
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
    // InternalTurn.g:4896:1: entryRuleOrForkBody returns [EObject current=null] : iv_ruleOrForkBody= ruleOrForkBody EOF ;
    public final EObject entryRuleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrForkBody = null;


        try {
            // InternalTurn.g:4896:51: (iv_ruleOrForkBody= ruleOrForkBody EOF )
            // InternalTurn.g:4897:2: iv_ruleOrForkBody= ruleOrForkBody EOF
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
    // InternalTurn.g:4903:1: ruleOrForkBody returns [EObject current=null] : ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ ;
    public final EObject ruleOrForkBody() throws RecognitionException {
        EObject current = null;

        EObject lv_regularBody_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4909:2: ( ( (lv_regularBody_0_0= ruleRegularOrFork ) )+ )
            // InternalTurn.g:4910:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            {
            // InternalTurn.g:4910:2: ( (lv_regularBody_0_0= ruleRegularOrFork ) )+
            int cnt91=0;
            loop91:
            do {
                int alt91=2;
                int LA91_0 = input.LA(1);

                if ( (LA91_0==25) ) {
                    alt91=1;
                }


                switch (alt91) {
            	case 1 :
            	    // InternalTurn.g:4911:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    {
            	    // InternalTurn.g:4911:3: (lv_regularBody_0_0= ruleRegularOrFork )
            	    // InternalTurn.g:4912:4: lv_regularBody_0_0= ruleRegularOrFork
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
            	    if ( cnt91 >= 1 ) break loop91;
                        EarlyExitException eee =
                            new EarlyExitException(91, input);
                        throw eee;
                }
                cnt91++;
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
    // InternalTurn.g:4932:1: entryRuleRegularOrFork returns [EObject current=null] : iv_ruleRegularOrFork= ruleRegularOrFork EOF ;
    public final EObject entryRuleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRegularOrFork = null;


        try {
            // InternalTurn.g:4932:54: (iv_ruleRegularOrFork= ruleRegularOrFork EOF )
            // InternalTurn.g:4933:2: iv_ruleRegularOrFork= ruleRegularOrFork EOF
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
    // InternalTurn.g:4939:1: ruleRegularOrFork returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) ;
    public final EObject ruleRegularOrFork() throws RecognitionException {
        EObject current = null;

        EObject lv_condition_0_0 = null;

        EObject lv_pathBody_1_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:4945:2: ( ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) ) )
            // InternalTurn.g:4946:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            {
            // InternalTurn.g:4946:2: ( ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) ) )
            // InternalTurn.g:4947:3: ( (lv_condition_0_0= ruleCondition ) ) ( (lv_pathBody_1_0= rulePathBody ) )
            {
            // InternalTurn.g:4947:3: ( (lv_condition_0_0= ruleCondition ) )
            // InternalTurn.g:4948:4: (lv_condition_0_0= ruleCondition )
            {
            // InternalTurn.g:4948:4: (lv_condition_0_0= ruleCondition )
            // InternalTurn.g:4949:5: lv_condition_0_0= ruleCondition
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

            // InternalTurn.g:4966:3: ( (lv_pathBody_1_0= rulePathBody ) )
            // InternalTurn.g:4967:4: (lv_pathBody_1_0= rulePathBody )
            {
            // InternalTurn.g:4967:4: (lv_pathBody_1_0= rulePathBody )
            // InternalTurn.g:4968:5: lv_pathBody_1_0= rulePathBody
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
    // InternalTurn.g:4989:1: entryRuleAndFork returns [EObject current=null] : iv_ruleAndFork= ruleAndFork EOF ;
    public final EObject entryRuleAndFork() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndFork = null;


        try {
            // InternalTurn.g:4989:48: (iv_ruleAndFork= ruleAndFork EOF )
            // InternalTurn.g:4990:2: iv_ruleAndFork= ruleAndFork EOF
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
    // InternalTurn.g:4996:1: ruleAndFork returns [EObject current=null] : (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? ) ;
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
            // InternalTurn.g:5002:2: ( (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? ) )
            // InternalTurn.g:5003:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? )
            {
            // InternalTurn.g:5003:2: (otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )? )
            // InternalTurn.g:5004:3: otherlv_0= 'and' ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )? otherlv_3= '{' (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )* otherlv_6= '}' ( (lv_connectingAndBody_7_0= rulePathBody ) )?
            {
            otherlv_0=(Token)match(input,81,FOLLOW_95); 

            			newLeafNode(otherlv_0, grammarAccess.getAndForkAccess().getAndKeyword_0());
            		
            // InternalTurn.g:5008:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) )?
            int alt92=2;
            int LA92_0 = input.LA(1);

            if ( (LA92_0==RULE_ID) ) {
                alt92=1;
            }
            switch (alt92) {
                case 1 :
                    // InternalTurn.g:5009:4: ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) )
                    {
                    // InternalTurn.g:5009:4: ( (lv_name_1_0= ruleQualifiedName ) )
                    // InternalTurn.g:5010:5: (lv_name_1_0= ruleQualifiedName )
                    {
                    // InternalTurn.g:5010:5: (lv_name_1_0= ruleQualifiedName )
                    // InternalTurn.g:5011:6: lv_name_1_0= ruleQualifiedName
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

                    // InternalTurn.g:5028:4: ( (lv_longName_2_0= ruleLongName ) )
                    // InternalTurn.g:5029:5: (lv_longName_2_0= ruleLongName )
                    {
                    // InternalTurn.g:5029:5: (lv_longName_2_0= ruleLongName )
                    // InternalTurn.g:5030:6: lv_longName_2_0= ruleLongName
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
            		
            // InternalTurn.g:5052:3: (otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) ) )*
            loop93:
            do {
                int alt93=2;
                int LA93_0 = input.LA(1);

                if ( (LA93_0==82) ) {
                    alt93=1;
                }


                switch (alt93) {
            	case 1 :
            	    // InternalTurn.g:5053:4: otherlv_4= '*' ( (lv_pathbody_5_0= rulePathBody ) )
            	    {
            	    otherlv_4=(Token)match(input,82,FOLLOW_61); 

            	    				newLeafNode(otherlv_4, grammarAccess.getAndForkAccess().getAsteriskKeyword_3_0());
            	    			
            	    // InternalTurn.g:5057:4: ( (lv_pathbody_5_0= rulePathBody ) )
            	    // InternalTurn.g:5058:5: (lv_pathbody_5_0= rulePathBody )
            	    {
            	    // InternalTurn.g:5058:5: (lv_pathbody_5_0= rulePathBody )
            	    // InternalTurn.g:5059:6: lv_pathbody_5_0= rulePathBody
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
            	    break loop93;
                }
            } while (true);

            otherlv_6=(Token)match(input,20,FOLLOW_74); 

            			newLeafNode(otherlv_6, grammarAccess.getAndForkAccess().getRightCurlyBracketKeyword_4());
            		
            // InternalTurn.g:5081:3: ( (lv_connectingAndBody_7_0= rulePathBody ) )?
            int alt94=2;
            int LA94_0 = input.LA(1);

            if ( (LA94_0==66) ) {
                alt94=1;
            }
            switch (alt94) {
                case 1 :
                    // InternalTurn.g:5082:4: (lv_connectingAndBody_7_0= rulePathBody )
                    {
                    // InternalTurn.g:5082:4: (lv_connectingAndBody_7_0= rulePathBody )
                    // InternalTurn.g:5083:5: lv_connectingAndBody_7_0= rulePathBody
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
    // InternalTurn.g:5104:1: entryRuleStub returns [EObject current=null] : iv_ruleStub= ruleStub EOF ;
    public final EObject entryRuleStub() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStub = null;


        try {
            // InternalTurn.g:5104:45: (iv_ruleStub= ruleStub EOF )
            // InternalTurn.g:5105:2: iv_ruleStub= ruleStub EOF
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
    // InternalTurn.g:5111:1: ruleStub returns [EObject current=null] : ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? ) ;
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
            // InternalTurn.g:5117:2: ( ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? ) )
            // InternalTurn.g:5118:2: ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? )
            {
            // InternalTurn.g:5118:2: ( ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )? )
            // InternalTurn.g:5119:3: ( (lv_stubType_0_0= ruleStubType ) )? otherlv_1= 'stub' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )? ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) ) (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )? ( (lv_connectingStubBody_11_0= rulePathBody ) )?
            {
            // InternalTurn.g:5119:3: ( (lv_stubType_0_0= ruleStubType ) )?
            int alt95=2;
            int LA95_0 = input.LA(1);

            if ( ((LA95_0>=84 && LA95_0<=85)) ) {
                alt95=1;
            }
            switch (alt95) {
                case 1 :
                    // InternalTurn.g:5120:4: (lv_stubType_0_0= ruleStubType )
                    {
                    // InternalTurn.g:5120:4: (lv_stubType_0_0= ruleStubType )
                    // InternalTurn.g:5121:5: lv_stubType_0_0= ruleStubType
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
            		
            // InternalTurn.g:5142:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )?
            int alt96=2;
            int LA96_0 = input.LA(1);

            if ( (LA96_0==65) ) {
                alt96=1;
            }
            switch (alt96) {
                case 1 :
                    // InternalTurn.g:5143:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
                    {
                    otherlv_2=(Token)match(input,65,FOLLOW_52); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubAccess().getInKeyword_2_0());
                    			
                    // InternalTurn.g:5147:4: ( (lv_index_3_0= rulePositiveInteger ) )
                    // InternalTurn.g:5148:5: (lv_index_3_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5148:5: (lv_index_3_0= rulePositiveInteger )
                    // InternalTurn.g:5149:6: lv_index_3_0= rulePositiveInteger
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

            // InternalTurn.g:5167:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )
            int alt98=2;
            alt98 = dfa98.predict(input);
            switch (alt98) {
                case 1 :
                    // InternalTurn.g:5168:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    {
                    // InternalTurn.g:5168:4: ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) )
                    // InternalTurn.g:5169:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) )
                    {
                    // InternalTurn.g:5169:5: ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )?
                    int alt97=2;
                    int LA97_0 = input.LA(1);

                    if ( (LA97_0==RULE_ID) ) {
                        alt97=1;
                    }
                    switch (alt97) {
                        case 1 :
                            // InternalTurn.g:5170:6: ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) )
                            {
                            // InternalTurn.g:5170:6: ( (lv_name_4_0= ruleQualifiedName ) )
                            // InternalTurn.g:5171:7: (lv_name_4_0= ruleQualifiedName )
                            {
                            // InternalTurn.g:5171:7: (lv_name_4_0= ruleQualifiedName )
                            // InternalTurn.g:5172:8: lv_name_4_0= ruleQualifiedName
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

                            // InternalTurn.g:5189:6: ( (lv_longName_5_0= ruleLongName ) )
                            // InternalTurn.g:5190:7: (lv_longName_5_0= ruleLongName )
                            {
                            // InternalTurn.g:5190:7: (lv_longName_5_0= ruleLongName )
                            // InternalTurn.g:5191:8: lv_longName_5_0= ruleLongName
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

                    // InternalTurn.g:5209:5: ( (lv_params_6_0= ruleStubParameters ) )
                    // InternalTurn.g:5210:6: (lv_params_6_0= ruleStubParameters )
                    {
                    // InternalTurn.g:5210:6: (lv_params_6_0= ruleStubParameters )
                    // InternalTurn.g:5211:7: lv_params_6_0= ruleStubParameters
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
                    // InternalTurn.g:5230:4: ( ( ruleQualifiedName ) )
                    {
                    // InternalTurn.g:5230:4: ( ( ruleQualifiedName ) )
                    // InternalTurn.g:5231:5: ( ruleQualifiedName )
                    {
                    // InternalTurn.g:5231:5: ( ruleQualifiedName )
                    // InternalTurn.g:5232:6: ruleQualifiedName
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

            // InternalTurn.g:5247:3: (otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}' )?
            int alt100=2;
            int LA100_0 = input.LA(1);

            if ( (LA100_0==13) ) {
                alt100=1;
            }
            switch (alt100) {
                case 1 :
                    // InternalTurn.g:5248:4: otherlv_8= '{' ( (lv_outPaths_9_0= ruleStubOutPath ) )* otherlv_10= '}'
                    {
                    otherlv_8=(Token)match(input,13,FOLLOW_102); 

                    				newLeafNode(otherlv_8, grammarAccess.getStubAccess().getLeftCurlyBracketKeyword_4_0());
                    			
                    // InternalTurn.g:5252:4: ( (lv_outPaths_9_0= ruleStubOutPath ) )*
                    loop99:
                    do {
                        int alt99=2;
                        int LA99_0 = input.LA(1);

                        if ( (LA99_0==88) ) {
                            alt99=1;
                        }


                        switch (alt99) {
                    	case 1 :
                    	    // InternalTurn.g:5253:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    {
                    	    // InternalTurn.g:5253:5: (lv_outPaths_9_0= ruleStubOutPath )
                    	    // InternalTurn.g:5254:6: lv_outPaths_9_0= ruleStubOutPath
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
                    	    break loop99;
                        }
                    } while (true);

                    otherlv_10=(Token)match(input,20,FOLLOW_74); 

                    				newLeafNode(otherlv_10, grammarAccess.getStubAccess().getRightCurlyBracketKeyword_4_2());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5276:3: ( (lv_connectingStubBody_11_0= rulePathBody ) )?
            int alt101=2;
            int LA101_0 = input.LA(1);

            if ( (LA101_0==66) ) {
                alt101=1;
            }
            switch (alt101) {
                case 1 :
                    // InternalTurn.g:5277:4: (lv_connectingStubBody_11_0= rulePathBody )
                    {
                    // InternalTurn.g:5277:4: (lv_connectingStubBody_11_0= rulePathBody )
                    // InternalTurn.g:5278:5: lv_connectingStubBody_11_0= rulePathBody
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
    // InternalTurn.g:5299:1: entryRuleStubType returns [String current=null] : iv_ruleStubType= ruleStubType EOF ;
    public final String entryRuleStubType() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleStubType = null;


        try {
            // InternalTurn.g:5299:48: (iv_ruleStubType= ruleStubType EOF )
            // InternalTurn.g:5300:2: iv_ruleStubType= ruleStubType EOF
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
    // InternalTurn.g:5306:1: ruleStubType returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'synchronizing' | kw= 'blocking' ) ;
    public final AntlrDatatypeRuleToken ruleStubType() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalTurn.g:5312:2: ( (kw= 'synchronizing' | kw= 'blocking' ) )
            // InternalTurn.g:5313:2: (kw= 'synchronizing' | kw= 'blocking' )
            {
            // InternalTurn.g:5313:2: (kw= 'synchronizing' | kw= 'blocking' )
            int alt102=2;
            int LA102_0 = input.LA(1);

            if ( (LA102_0==84) ) {
                alt102=1;
            }
            else if ( (LA102_0==85) ) {
                alt102=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 102, 0, input);

                throw nvae;
            }
            switch (alt102) {
                case 1 :
                    // InternalTurn.g:5314:3: kw= 'synchronizing'
                    {
                    kw=(Token)match(input,84,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getStubTypeAccess().getSynchronizingKeyword_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:5320:3: kw= 'blocking'
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
    // InternalTurn.g:5329:1: entryRuleStubParameters returns [EObject current=null] : iv_ruleStubParameters= ruleStubParameters EOF ;
    public final EObject entryRuleStubParameters() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubParameters = null;


        try {
            // InternalTurn.g:5329:55: (iv_ruleStubParameters= ruleStubParameters EOF )
            // InternalTurn.g:5330:2: iv_ruleStubParameters= ruleStubParameters EOF
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
    // InternalTurn.g:5336:1: ruleStubParameters returns [EObject current=null] : ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) ;
    public final EObject ruleStubParameters() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_plugin_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5342:2: ( ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' ) )
            // InternalTurn.g:5343:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            {
            // InternalTurn.g:5343:2: ( () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')' )
            // InternalTurn.g:5344:3: () otherlv_1= '(' ( (lv_plugin_2_0= rulePluginBinding ) )* otherlv_3= ')'
            {
            // InternalTurn.g:5344:3: ()
            // InternalTurn.g:5345:4: 
            {

            				current = forceCreateModelElement(
            					grammarAccess.getStubParametersAccess().getStubParametersAction_0(),
            					current);
            			

            }

            otherlv_1=(Token)match(input,86,FOLLOW_103); 

            			newLeafNode(otherlv_1, grammarAccess.getStubParametersAccess().getLeftParenthesisKeyword_1());
            		
            // InternalTurn.g:5355:3: ( (lv_plugin_2_0= rulePluginBinding ) )*
            loop103:
            do {
                int alt103=2;
                int LA103_0 = input.LA(1);

                if ( (LA103_0==RULE_ID||LA103_0==25||LA103_0==89) ) {
                    alt103=1;
                }


                switch (alt103) {
            	case 1 :
            	    // InternalTurn.g:5356:4: (lv_plugin_2_0= rulePluginBinding )
            	    {
            	    // InternalTurn.g:5356:4: (lv_plugin_2_0= rulePluginBinding )
            	    // InternalTurn.g:5357:5: lv_plugin_2_0= rulePluginBinding
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
            	    break loop103;
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
    // InternalTurn.g:5382:1: entryRuleStubDeclaration returns [EObject current=null] : iv_ruleStubDeclaration= ruleStubDeclaration EOF ;
    public final EObject entryRuleStubDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubDeclaration = null;


        try {
            // InternalTurn.g:5382:56: (iv_ruleStubDeclaration= ruleStubDeclaration EOF )
            // InternalTurn.g:5383:2: iv_ruleStubDeclaration= ruleStubDeclaration EOF
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
    // InternalTurn.g:5389:1: ruleStubDeclaration returns [EObject current=null] : ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) ;
    public final EObject ruleStubDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_longName_1_0 = null;

        EObject lv_params_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5395:2: ( ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) ) )
            // InternalTurn.g:5396:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            {
            // InternalTurn.g:5396:2: ( ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) ) )
            // InternalTurn.g:5397:3: ( (lv_name_0_0= ruleQualifiedName ) ) ( (lv_longName_1_0= ruleLongName ) ) otherlv_2= '=' ( (lv_params_3_0= ruleStubParameters ) )
            {
            // InternalTurn.g:5397:3: ( (lv_name_0_0= ruleQualifiedName ) )
            // InternalTurn.g:5398:4: (lv_name_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:5398:4: (lv_name_0_0= ruleQualifiedName )
            // InternalTurn.g:5399:5: lv_name_0_0= ruleQualifiedName
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

            // InternalTurn.g:5416:3: ( (lv_longName_1_0= ruleLongName ) )
            // InternalTurn.g:5417:4: (lv_longName_1_0= ruleLongName )
            {
            // InternalTurn.g:5417:4: (lv_longName_1_0= ruleLongName )
            // InternalTurn.g:5418:5: lv_longName_1_0= ruleLongName
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
            		
            // InternalTurn.g:5439:3: ( (lv_params_3_0= ruleStubParameters ) )
            // InternalTurn.g:5440:4: (lv_params_3_0= ruleStubParameters )
            {
            // InternalTurn.g:5440:4: (lv_params_3_0= ruleStubParameters )
            // InternalTurn.g:5441:5: lv_params_3_0= ruleStubParameters
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
    // InternalTurn.g:5462:1: entryRuleStubOutPath returns [EObject current=null] : iv_ruleStubOutPath= ruleStubOutPath EOF ;
    public final EObject entryRuleStubOutPath() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStubOutPath = null;


        try {
            // InternalTurn.g:5462:52: (iv_ruleStubOutPath= ruleStubOutPath EOF )
            // InternalTurn.g:5463:2: iv_ruleStubOutPath= ruleStubOutPath EOF
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
    // InternalTurn.g:5469:1: ruleStubOutPath returns [EObject current=null] : ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) ;
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
            // InternalTurn.g:5475:2: ( ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) ) )
            // InternalTurn.g:5476:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            {
            // InternalTurn.g:5476:2: ( (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) ) )
            // InternalTurn.g:5477:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) ) (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )? ( (lv_path_6_0= rulePathBody ) )
            {
            // InternalTurn.g:5477:3: (otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) ) )
            // InternalTurn.g:5478:4: otherlv_0= 'out' ( (lv_index_1_0= rulePositiveInteger ) )
            {
            otherlv_0=(Token)match(input,88,FOLLOW_52); 

            				newLeafNode(otherlv_0, grammarAccess.getStubOutPathAccess().getOutKeyword_0_0());
            			
            // InternalTurn.g:5482:4: ( (lv_index_1_0= rulePositiveInteger ) )
            // InternalTurn.g:5483:5: (lv_index_1_0= rulePositiveInteger )
            {
            // InternalTurn.g:5483:5: (lv_index_1_0= rulePositiveInteger )
            // InternalTurn.g:5484:6: lv_index_1_0= rulePositiveInteger
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

            // InternalTurn.g:5502:3: (otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']' )?
            int alt104=2;
            int LA104_0 = input.LA(1);

            if ( (LA104_0==49) ) {
                alt104=1;
            }
            switch (alt104) {
                case 1 :
                    // InternalTurn.g:5503:4: otherlv_2= 'threshold' otherlv_3= '[' ( (lv_threshold_4_0= rulePositiveInteger ) ) otherlv_5= ']'
                    {
                    otherlv_2=(Token)match(input,49,FOLLOW_88); 

                    				newLeafNode(otherlv_2, grammarAccess.getStubOutPathAccess().getThresholdKeyword_1_0());
                    			
                    otherlv_3=(Token)match(input,25,FOLLOW_52); 

                    				newLeafNode(otherlv_3, grammarAccess.getStubOutPathAccess().getLeftSquareBracketKeyword_1_1());
                    			
                    // InternalTurn.g:5511:4: ( (lv_threshold_4_0= rulePositiveInteger ) )
                    // InternalTurn.g:5512:5: (lv_threshold_4_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5512:5: (lv_threshold_4_0= rulePositiveInteger )
                    // InternalTurn.g:5513:6: lv_threshold_4_0= rulePositiveInteger
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

            // InternalTurn.g:5535:3: ( (lv_path_6_0= rulePathBody ) )
            // InternalTurn.g:5536:4: (lv_path_6_0= rulePathBody )
            {
            // InternalTurn.g:5536:4: (lv_path_6_0= rulePathBody )
            // InternalTurn.g:5537:5: lv_path_6_0= rulePathBody
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
    // InternalTurn.g:5558:1: entryRulePluginBinding returns [EObject current=null] : iv_rulePluginBinding= rulePluginBinding EOF ;
    public final EObject entryRulePluginBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePluginBinding = null;


        try {
            // InternalTurn.g:5558:54: (iv_rulePluginBinding= rulePluginBinding EOF )
            // InternalTurn.g:5559:2: iv_rulePluginBinding= rulePluginBinding EOF
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
    // InternalTurn.g:5565:1: rulePluginBinding returns [EObject current=null] : ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) ;
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
            // InternalTurn.g:5571:2: ( ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? ) )
            // InternalTurn.g:5572:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            {
            // InternalTurn.g:5572:2: ( ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )? )
            // InternalTurn.g:5573:3: ( (lv_condition_0_0= ruleCondition ) )? (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )? ( (otherlv_3= RULE_ID ) ) (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            {
            // InternalTurn.g:5573:3: ( (lv_condition_0_0= ruleCondition ) )?
            int alt105=2;
            int LA105_0 = input.LA(1);

            if ( (LA105_0==25) ) {
                alt105=1;
            }
            switch (alt105) {
                case 1 :
                    // InternalTurn.g:5574:4: (lv_condition_0_0= ruleCondition )
                    {
                    // InternalTurn.g:5574:4: (lv_condition_0_0= ruleCondition )
                    // InternalTurn.g:5575:5: lv_condition_0_0= ruleCondition
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

            // InternalTurn.g:5592:3: (otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) ) )?
            int alt106=2;
            int LA106_0 = input.LA(1);

            if ( (LA106_0==89) ) {
                alt106=1;
            }
            switch (alt106) {
                case 1 :
                    // InternalTurn.g:5593:4: otherlv_1= 'replication' ( (lv_replication_2_0= rulePositiveInteger ) )
                    {
                    otherlv_1=(Token)match(input,89,FOLLOW_52); 

                    				newLeafNode(otherlv_1, grammarAccess.getPluginBindingAccess().getReplicationKeyword_1_0());
                    			
                    // InternalTurn.g:5597:4: ( (lv_replication_2_0= rulePositiveInteger ) )
                    // InternalTurn.g:5598:5: (lv_replication_2_0= rulePositiveInteger )
                    {
                    // InternalTurn.g:5598:5: (lv_replication_2_0= rulePositiveInteger )
                    // InternalTurn.g:5599:6: lv_replication_2_0= rulePositiveInteger
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

            // InternalTurn.g:5617:3: ( (otherlv_3= RULE_ID ) )
            // InternalTurn.g:5618:4: (otherlv_3= RULE_ID )
            {
            // InternalTurn.g:5618:4: (otherlv_3= RULE_ID )
            // InternalTurn.g:5619:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getPluginBindingRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_107); 

            					newLeafNode(otherlv_3, grammarAccess.getPluginBindingAccess().getMapUCMmapCrossReference_2_0());
            				

            }


            }

            // InternalTurn.g:5630:3: (otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )* )?
            int alt108=2;
            int LA108_0 = input.LA(1);

            if ( (LA108_0==22) ) {
                alt108=1;
            }
            switch (alt108) {
                case 1 :
                    // InternalTurn.g:5631:4: otherlv_4= ':' ( (lv_binding_5_0= ruleBinding ) ) (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getPluginBindingAccess().getColonKeyword_3_0());
                    			
                    // InternalTurn.g:5635:4: ( (lv_binding_5_0= ruleBinding ) )
                    // InternalTurn.g:5636:5: (lv_binding_5_0= ruleBinding )
                    {
                    // InternalTurn.g:5636:5: (lv_binding_5_0= ruleBinding )
                    // InternalTurn.g:5637:6: lv_binding_5_0= ruleBinding
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

                    // InternalTurn.g:5654:4: (otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) ) )*
                    loop107:
                    do {
                        int alt107=2;
                        int LA107_0 = input.LA(1);

                        if ( (LA107_0==23) ) {
                            alt107=1;
                        }


                        switch (alt107) {
                    	case 1 :
                    	    // InternalTurn.g:5655:5: otherlv_6= ',' ( (lv_bindings_7_0= ruleBinding ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getPluginBindingAccess().getCommaKeyword_3_2_0());
                    	    				
                    	    // InternalTurn.g:5659:5: ( (lv_bindings_7_0= ruleBinding ) )
                    	    // InternalTurn.g:5660:6: (lv_bindings_7_0= ruleBinding )
                    	    {
                    	    // InternalTurn.g:5660:6: (lv_bindings_7_0= ruleBinding )
                    	    // InternalTurn.g:5661:7: lv_bindings_7_0= ruleBinding
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
                    	    break loop107;
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
    // InternalTurn.g:5684:1: entryRuleComponentRef returns [EObject current=null] : iv_ruleComponentRef= ruleComponentRef EOF ;
    public final EObject entryRuleComponentRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentRef = null;


        try {
            // InternalTurn.g:5684:53: (iv_ruleComponentRef= ruleComponentRef EOF )
            // InternalTurn.g:5685:2: iv_ruleComponentRef= ruleComponentRef EOF
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
    // InternalTurn.g:5691:1: ruleComponentRef returns [EObject current=null] : ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) ;
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
            // InternalTurn.g:5697:2: ( ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? ) )
            // InternalTurn.g:5698:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            {
            // InternalTurn.g:5698:2: ( (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )? )
            // InternalTurn.g:5699:3: (otherlv_0= 'protected' )? ( (lv_kind_1_0= ruleCOMPONENTKIND ) )? ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_longName_3_0= ruleLongName ) ) (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            {
            // InternalTurn.g:5699:3: (otherlv_0= 'protected' )?
            int alt109=2;
            int LA109_0 = input.LA(1);

            if ( (LA109_0==90) ) {
                alt109=1;
            }
            switch (alt109) {
                case 1 :
                    // InternalTurn.g:5700:4: otherlv_0= 'protected'
                    {
                    otherlv_0=(Token)match(input,90,FOLLOW_108); 

                    				newLeafNode(otherlv_0, grammarAccess.getComponentRefAccess().getProtectedKeyword_0());
                    			

                    }
                    break;

            }

            // InternalTurn.g:5705:3: ( (lv_kind_1_0= ruleCOMPONENTKIND ) )?
            int alt110=2;
            int LA110_0 = input.LA(1);

            if ( (LA110_0==32||(LA110_0>=121 && LA110_0<=125)) ) {
                alt110=1;
            }
            switch (alt110) {
                case 1 :
                    // InternalTurn.g:5706:4: (lv_kind_1_0= ruleCOMPONENTKIND )
                    {
                    // InternalTurn.g:5706:4: (lv_kind_1_0= ruleCOMPONENTKIND )
                    // InternalTurn.g:5707:5: lv_kind_1_0= ruleCOMPONENTKIND
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

            // InternalTurn.g:5724:3: ( (lv_name_2_0= ruleQualifiedName ) )
            // InternalTurn.g:5725:4: (lv_name_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:5725:4: (lv_name_2_0= ruleQualifiedName )
            // InternalTurn.g:5726:5: lv_name_2_0= ruleQualifiedName
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

            // InternalTurn.g:5743:3: ( (lv_longName_3_0= ruleLongName ) )
            // InternalTurn.g:5744:4: (lv_longName_3_0= ruleLongName )
            {
            // InternalTurn.g:5744:4: (lv_longName_3_0= ruleLongName )
            // InternalTurn.g:5745:5: lv_longName_3_0= ruleLongName
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

            // InternalTurn.g:5762:3: (otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )* )?
            int alt112=2;
            int LA112_0 = input.LA(1);

            if ( (LA112_0==22) ) {
                alt112=1;
            }
            switch (alt112) {
                case 1 :
                    // InternalTurn.g:5763:4: otherlv_4= ':' ( (lv_element_5_0= ruleBoundOption ) ) (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    {
                    otherlv_4=(Token)match(input,22,FOLLOW_3); 

                    				newLeafNode(otherlv_4, grammarAccess.getComponentRefAccess().getColonKeyword_4_0());
                    			
                    // InternalTurn.g:5767:4: ( (lv_element_5_0= ruleBoundOption ) )
                    // InternalTurn.g:5768:5: (lv_element_5_0= ruleBoundOption )
                    {
                    // InternalTurn.g:5768:5: (lv_element_5_0= ruleBoundOption )
                    // InternalTurn.g:5769:6: lv_element_5_0= ruleBoundOption
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

                    // InternalTurn.g:5786:4: (otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) ) )*
                    loop111:
                    do {
                        int alt111=2;
                        int LA111_0 = input.LA(1);

                        if ( (LA111_0==23) ) {
                            alt111=1;
                        }


                        switch (alt111) {
                    	case 1 :
                    	    // InternalTurn.g:5787:5: otherlv_6= ',' ( (lv_elements_7_0= ruleBoundOption ) )
                    	    {
                    	    otherlv_6=(Token)match(input,23,FOLLOW_3); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getComponentRefAccess().getCommaKeyword_4_2_0());
                    	    				
                    	    // InternalTurn.g:5791:5: ( (lv_elements_7_0= ruleBoundOption ) )
                    	    // InternalTurn.g:5792:6: (lv_elements_7_0= ruleBoundOption )
                    	    {
                    	    // InternalTurn.g:5792:6: (lv_elements_7_0= ruleBoundOption )
                    	    // InternalTurn.g:5793:7: lv_elements_7_0= ruleBoundOption
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
    // $ANTLR end "ruleComponentRef"


    // $ANTLR start "entryRuleBoundOption"
    // InternalTurn.g:5816:1: entryRuleBoundOption returns [EObject current=null] : iv_ruleBoundOption= ruleBoundOption EOF ;
    public final EObject entryRuleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundOption = null;


        try {
            // InternalTurn.g:5816:52: (iv_ruleBoundOption= ruleBoundOption EOF )
            // InternalTurn.g:5817:2: iv_ruleBoundOption= ruleBoundOption EOF
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
    // InternalTurn.g:5823:1: ruleBoundOption returns [EObject current=null] : (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) ;
    public final EObject ruleBoundOption() throws RecognitionException {
        EObject current = null;

        EObject this_BoundElement_0 = null;

        EObject this_LongBoundElement_1 = null;



        	enterRule();

        try {
            // InternalTurn.g:5829:2: ( (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement ) )
            // InternalTurn.g:5830:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            {
            // InternalTurn.g:5830:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )
            int alt113=2;
            alt113 = dfa113.predict(input);
            switch (alt113) {
                case 1 :
                    // InternalTurn.g:5831:3: this_BoundElement_0= ruleBoundElement
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
                    // InternalTurn.g:5840:3: this_LongBoundElement_1= ruleLongBoundElement
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
    // InternalTurn.g:5852:1: entryRuleBoundElement returns [EObject current=null] : iv_ruleBoundElement= ruleBoundElement EOF ;
    public final EObject entryRuleBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBoundElement = null;


        try {
            // InternalTurn.g:5852:53: (iv_ruleBoundElement= ruleBoundElement EOF )
            // InternalTurn.g:5853:2: iv_ruleBoundElement= ruleBoundElement EOF
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
    // InternalTurn.g:5859:1: ruleBoundElement returns [EObject current=null] : ( ( ruleQualifiedName ) ) ;
    public final EObject ruleBoundElement() throws RecognitionException {
        EObject current = null;


        	enterRule();

        try {
            // InternalTurn.g:5865:2: ( ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:5866:2: ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:5866:2: ( ( ruleQualifiedName ) )
            // InternalTurn.g:5867:3: ( ruleQualifiedName )
            {
            // InternalTurn.g:5867:3: ( ruleQualifiedName )
            // InternalTurn.g:5868:4: ruleQualifiedName
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
    // InternalTurn.g:5885:1: entryRuleLongBoundElement returns [EObject current=null] : iv_ruleLongBoundElement= ruleLongBoundElement EOF ;
    public final EObject entryRuleLongBoundElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLongBoundElement = null;


        try {
            // InternalTurn.g:5885:57: (iv_ruleLongBoundElement= ruleLongBoundElement EOF )
            // InternalTurn.g:5886:2: iv_ruleLongBoundElement= ruleLongBoundElement EOF
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
    // InternalTurn.g:5892:1: ruleLongBoundElement returns [EObject current=null] : ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) ;
    public final EObject ruleLongBoundElement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_from_0_0 = null;

        AntlrDatatypeRuleToken lv_to_2_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:5898:2: ( ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) ) )
            // InternalTurn.g:5899:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            {
            // InternalTurn.g:5899:2: ( ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) ) )
            // InternalTurn.g:5900:3: ( (lv_from_0_0= ruleQualifiedName ) ) otherlv_1= '..' ( (lv_to_2_0= ruleQualifiedName ) )
            {
            // InternalTurn.g:5900:3: ( (lv_from_0_0= ruleQualifiedName ) )
            // InternalTurn.g:5901:4: (lv_from_0_0= ruleQualifiedName )
            {
            // InternalTurn.g:5901:4: (lv_from_0_0= ruleQualifiedName )
            // InternalTurn.g:5902:5: lv_from_0_0= ruleQualifiedName
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
            		
            // InternalTurn.g:5923:3: ( (lv_to_2_0= ruleQualifiedName ) )
            // InternalTurn.g:5924:4: (lv_to_2_0= ruleQualifiedName )
            {
            // InternalTurn.g:5924:4: (lv_to_2_0= ruleQualifiedName )
            // InternalTurn.g:5925:5: lv_to_2_0= ruleQualifiedName
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
    // InternalTurn.g:5946:1: entryRuleBinding returns [EObject current=null] : iv_ruleBinding= ruleBinding EOF ;
    public final EObject entryRuleBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinding = null;


        try {
            // InternalTurn.g:5946:48: (iv_ruleBinding= ruleBinding EOF )
            // InternalTurn.g:5947:2: iv_ruleBinding= ruleBinding EOF
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
    // InternalTurn.g:5953:1: ruleBinding returns [EObject current=null] : (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) ;
    public final EObject ruleBinding() throws RecognitionException {
        EObject current = null;

        EObject this_InBinding_0 = null;

        EObject this_OutBinding_1 = null;

        EObject this_ComponentBinding_2 = null;



        	enterRule();

        try {
            // InternalTurn.g:5959:2: ( (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding ) )
            // InternalTurn.g:5960:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            {
            // InternalTurn.g:5960:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )
            int alt114=3;
            alt114 = dfa114.predict(input);
            switch (alt114) {
                case 1 :
                    // InternalTurn.g:5961:3: this_InBinding_0= ruleInBinding
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
                    // InternalTurn.g:5970:3: this_OutBinding_1= ruleOutBinding
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
                    // InternalTurn.g:5979:3: this_ComponentBinding_2= ruleComponentBinding
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
    // InternalTurn.g:5991:1: entryRuleInBinding returns [EObject current=null] : iv_ruleInBinding= ruleInBinding EOF ;
    public final EObject entryRuleInBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInBinding = null;


        try {
            // InternalTurn.g:5991:50: (iv_ruleInBinding= ruleInBinding EOF )
            // InternalTurn.g:5992:2: iv_ruleInBinding= ruleInBinding EOF
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
    // InternalTurn.g:5998:1: ruleInBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleInBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6004:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTurn.g:6005:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTurn.g:6005:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTurn.g:6006:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTurn.g:6006:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6007:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6007:4: ( ruleQualifiedName )
            // InternalTurn.g:6008:5: ruleQualifiedName
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
            		
            // InternalTurn.g:6026:3: (otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTurn.g:6027:4: otherlv_2= 'in' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,65,FOLLOW_52); 

            				newLeafNode(otherlv_2, grammarAccess.getInBindingAccess().getInKeyword_2_0());
            			
            // InternalTurn.g:6031:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTurn.g:6032:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTurn.g:6032:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTurn.g:6033:6: lv_index_3_0= rulePositiveInteger
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
    // InternalTurn.g:6055:1: entryRuleOutBinding returns [EObject current=null] : iv_ruleOutBinding= ruleOutBinding EOF ;
    public final EObject entryRuleOutBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOutBinding = null;


        try {
            // InternalTurn.g:6055:51: (iv_ruleOutBinding= ruleOutBinding EOF )
            // InternalTurn.g:6056:2: iv_ruleOutBinding= ruleOutBinding EOF
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
    // InternalTurn.g:6062:1: ruleOutBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) ;
    public final EObject ruleOutBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_index_3_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6068:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) ) )
            // InternalTurn.g:6069:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            {
            // InternalTurn.g:6069:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) ) )
            // InternalTurn.g:6070:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            {
            // InternalTurn.g:6070:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6071:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6071:4: ( ruleQualifiedName )
            // InternalTurn.g:6072:5: ruleQualifiedName
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
            		
            // InternalTurn.g:6090:3: (otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) ) )
            // InternalTurn.g:6091:4: otherlv_2= 'out' ( (lv_index_3_0= rulePositiveInteger ) )
            {
            otherlv_2=(Token)match(input,88,FOLLOW_52); 

            				newLeafNode(otherlv_2, grammarAccess.getOutBindingAccess().getOutKeyword_2_0());
            			
            // InternalTurn.g:6095:4: ( (lv_index_3_0= rulePositiveInteger ) )
            // InternalTurn.g:6096:5: (lv_index_3_0= rulePositiveInteger )
            {
            // InternalTurn.g:6096:5: (lv_index_3_0= rulePositiveInteger )
            // InternalTurn.g:6097:6: lv_index_3_0= rulePositiveInteger
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
    // InternalTurn.g:6119:1: entryRuleComponentBinding returns [EObject current=null] : iv_ruleComponentBinding= ruleComponentBinding EOF ;
    public final EObject entryRuleComponentBinding() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComponentBinding = null;


        try {
            // InternalTurn.g:6119:57: (iv_ruleComponentBinding= ruleComponentBinding EOF )
            // InternalTurn.g:6120:2: iv_ruleComponentBinding= ruleComponentBinding EOF
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
    // InternalTurn.g:6126:1: ruleComponentBinding returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) ;
    public final EObject ruleComponentBinding() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalTurn.g:6132:2: ( ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) ) )
            // InternalTurn.g:6133:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            {
            // InternalTurn.g:6133:2: ( ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) ) )
            // InternalTurn.g:6134:3: ( ( ruleQualifiedName ) ) otherlv_1= '=' ( ( ruleQualifiedName ) )
            {
            // InternalTurn.g:6134:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6135:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6135:4: ( ruleQualifiedName )
            // InternalTurn.g:6136:5: ruleQualifiedName
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
            		
            // InternalTurn.g:6154:3: ( ( ruleQualifiedName ) )
            // InternalTurn.g:6155:4: ( ruleQualifiedName )
            {
            // InternalTurn.g:6155:4: ( ruleQualifiedName )
            // InternalTurn.g:6156:5: ruleQualifiedName
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
    // InternalTurn.g:6174:1: entryRuleFailureLabel returns [EObject current=null] : iv_ruleFailureLabel= ruleFailureLabel EOF ;
    public final EObject entryRuleFailureLabel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFailureLabel = null;


        try {
            // InternalTurn.g:6174:53: (iv_ruleFailureLabel= ruleFailureLabel EOF )
            // InternalTurn.g:6175:2: iv_ruleFailureLabel= ruleFailureLabel EOF
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
    // InternalTurn.g:6181:1: ruleFailureLabel returns [EObject current=null] : (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) ;
    public final EObject ruleFailureLabel() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_failure_1_0=null;
        Token otherlv_2=null;


        	enterRule();

        try {
            // InternalTurn.g:6187:2: ( (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' ) )
            // InternalTurn.g:6188:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            {
            // InternalTurn.g:6188:2: (otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]' )
            // InternalTurn.g:6189:3: otherlv_0= '[[' ( (lv_failure_1_0= RULE_STRING ) ) otherlv_2= ']]'
            {
            otherlv_0=(Token)match(input,60,FOLLOW_6); 

            			newLeafNode(otherlv_0, grammarAccess.getFailureLabelAccess().getLeftSquareBracketLeftSquareBracketKeyword_0());
            		
            // InternalTurn.g:6193:3: ( (lv_failure_1_0= RULE_STRING ) )
            // InternalTurn.g:6194:4: (lv_failure_1_0= RULE_STRING )
            {
            // InternalTurn.g:6194:4: (lv_failure_1_0= RULE_STRING )
            // InternalTurn.g:6195:5: lv_failure_1_0= RULE_STRING
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


    // $ANTLR start "entryRulePositiveInteger"
    // InternalTurn.g:6219:1: entryRulePositiveInteger returns [String current=null] : iv_rulePositiveInteger= rulePositiveInteger EOF ;
    public final String entryRulePositiveInteger() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePositiveInteger = null;


        try {
            // InternalTurn.g:6219:55: (iv_rulePositiveInteger= rulePositiveInteger EOF )
            // InternalTurn.g:6220:2: iv_rulePositiveInteger= rulePositiveInteger EOF
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
    // InternalTurn.g:6226:1: rulePositiveInteger returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken rulePositiveInteger() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;


        	enterRule();

        try {
            // InternalTurn.g:6232:2: (this_INT_0= RULE_INT )
            // InternalTurn.g:6233:2: this_INT_0= RULE_INT
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
    // InternalTurn.g:6243:1: entryRuleText returns [EObject current=null] : iv_ruleText= ruleText EOF ;
    public final EObject entryRuleText() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleText = null;


        try {
            // InternalTurn.g:6243:45: (iv_ruleText= ruleText EOF )
            // InternalTurn.g:6244:2: iv_ruleText= ruleText EOF
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
    // InternalTurn.g:6250:1: ruleText returns [EObject current=null] : ( (lv_content_0_0= ruleTextContent ) )+ ;
    public final EObject ruleText() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_content_0_0 = null;



        	enterRule();

        try {
            // InternalTurn.g:6256:2: ( ( (lv_content_0_0= ruleTextContent ) )+ )
            // InternalTurn.g:6257:2: ( (lv_content_0_0= ruleTextContent ) )+
            {
            // InternalTurn.g:6257:2: ( (lv_content_0_0= ruleTextContent ) )+
            int cnt115=0;
            loop115:
            do {
                int alt115=2;
                int LA115_0 = input.LA(1);

                if ( (LA115_0==RULE_ID) ) {
                    int LA115_2 = input.LA(2);

                    if ( (LA115_2==EOF||(LA115_2>=RULE_ID && LA115_2<=RULE_INT)||(LA115_2>=11 && LA115_2<=12)||LA115_2==21||LA115_2==24||(LA115_2>=26 && LA115_2<=27)||LA115_2==30||LA115_2==32||(LA115_2>=40 && LA115_2<=41)||LA115_2==47||(LA115_2>=51 && LA115_2<=53)||(LA115_2>=56 && LA115_2<=57)||LA115_2==82||(LA115_2>=92 && LA115_2<=95)) ) {
                        alt115=1;
                    }


                }
                else if ( (LA115_0==RULE_INT||LA115_0==24||LA115_0==82||(LA115_0>=92 && LA115_0<=95)) ) {
                    alt115=1;
                }


                switch (alt115) {
            	case 1 :
            	    // InternalTurn.g:6258:3: (lv_content_0_0= ruleTextContent )
            	    {
            	    // InternalTurn.g:6258:3: (lv_content_0_0= ruleTextContent )
            	    // InternalTurn.g:6259:4: lv_content_0_0= ruleTextContent
            	    {

            	    				newCompositeNode(grammarAccess.getTextAccess().getContentTextContentParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_112);
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
            	    if ( cnt115 >= 1 ) break loop115;
                        EarlyExitException eee =
                            new EarlyExitException(115, input);
                        throw eee;
                }
                cnt115++;
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
    // InternalTurn.g:6279:1: entryRuleTextContent returns [String current=null] : iv_ruleTextContent= ruleTextContent EOF ;
    public final String entryRuleTextContent() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleTextContent = null;


        try {
            // InternalTurn.g:6279:51: (iv_ruleTextContent= ruleTextContent EOF )
            // InternalTurn.g:6280:2: iv_ruleTextContent= ruleTextContent EOF
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
    // InternalTurn.g:6286:1: ruleTextContent returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleTextContent() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_INT_7=null;


        	enterRule();

        try {
            // InternalTurn.g:6292:2: ( (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT ) )
            // InternalTurn.g:6293:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            {
            // InternalTurn.g:6293:2: (this_ID_0= RULE_ID | kw= '@' | kw= '#' | kw= '!' | kw= '%' | kw= '&' | kw= '*' | this_INT_7= RULE_INT )
            int alt116=8;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt116=1;
                }
                break;
            case 92:
                {
                alt116=2;
                }
                break;
            case 24:
                {
                alt116=3;
                }
                break;
            case 93:
                {
                alt116=4;
                }
                break;
            case 94:
                {
                alt116=5;
                }
                break;
            case 95:
                {
                alt116=6;
                }
                break;
            case 82:
                {
                alt116=7;
                }
                break;
            case RULE_INT:
                {
                alt116=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 116, 0, input);

                throw nvae;
            }

            switch (alt116) {
                case 1 :
                    // InternalTurn.g:6294:3: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_2); 

                    			current.merge(this_ID_0);
                    		

                    			newLeafNode(this_ID_0, grammarAccess.getTextContentAccess().getIDTerminalRuleCall_0());
                    		

                    }
                    break;
                case 2 :
                    // InternalTurn.g:6302:3: kw= '@'
                    {
                    kw=(Token)match(input,92,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getCommercialAtKeyword_1());
                    		

                    }
                    break;
                case 3 :
                    // InternalTurn.g:6308:3: kw= '#'
                    {
                    kw=(Token)match(input,24,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getNumberSignKeyword_2());
                    		

                    }
                    break;
                case 4 :
                    // InternalTurn.g:6314:3: kw= '!'
                    {
                    kw=(Token)match(input,93,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getExclamationMarkKeyword_3());
                    		

                    }
                    break;
                case 5 :
                    // InternalTurn.g:6320:3: kw= '%'
                    {
                    kw=(Token)match(input,94,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getPercentSignKeyword_4());
                    		

                    }
                    break;
                case 6 :
                    // InternalTurn.g:6326:3: kw= '&'
                    {
                    kw=(Token)match(input,95,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAmpersandKeyword_5());
                    		

                    }
                    break;
                case 7 :
                    // InternalTurn.g:6332:3: kw= '*'
                    {
                    kw=(Token)match(input,82,FOLLOW_2); 

                    			current.merge(kw);
                    			newLeafNode(kw, grammarAccess.getTextContentAccess().getAsteriskKeyword_6());
                    		

                    }
                    break;
                case 8 :
                    // InternalTurn.g:6338:3: this_INT_7= RULE_INT
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
    // InternalTurn.g:6349:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalTurn.g:6349:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalTurn.g:6350:2: iv_ruleQualifiedName= ruleQualifiedName EOF
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
    // InternalTurn.g:6356:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalTurn.g:6362:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalTurn.g:6363:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalTurn.g:6363:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalTurn.g:6364:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_113); 

            			current.merge(this_ID_0);
            		

            			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
            		
            // InternalTurn.g:6371:3: (kw= '.' this_ID_2= RULE_ID )*
            loop117:
            do {
                int alt117=2;
                int LA117_0 = input.LA(1);

                if ( (LA117_0==78) ) {
                    int LA117_2 = input.LA(2);

                    if ( (LA117_2==RULE_ID) ) {
                        alt117=1;
                    }


                }


                switch (alt117) {
            	case 1 :
            	    // InternalTurn.g:6372:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,78,FOLLOW_3); 

            	    				current.merge(kw);
            	    				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	    			
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_113); 

            	    				current.merge(this_ID_2);
            	    			

            	    				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	    			

            	    }
            	    break;

            	default :
            	    break loop117;
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
    // InternalTurn.g:6389:1: ruleQualitativeLabel returns [Enumerator current=null] : ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) ;
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
            // InternalTurn.g:6395:2: ( ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) ) )
            // InternalTurn.g:6396:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            {
            // InternalTurn.g:6396:2: ( (enumLiteral_0= 'denied' ) | (enumLiteral_1= 'weaklyDenied' ) | (enumLiteral_2= 'weaklySatisfied' ) | (enumLiteral_3= 'satisfied' ) | (enumLiteral_4= 'conflict' ) | (enumLiteral_5= 'unknown' ) | (enumLiteral_6= 'none' ) )
            int alt118=7;
            switch ( input.LA(1) ) {
            case 96:
                {
                alt118=1;
                }
                break;
            case 97:
                {
                alt118=2;
                }
                break;
            case 98:
                {
                alt118=3;
                }
                break;
            case 99:
                {
                alt118=4;
                }
                break;
            case 100:
                {
                alt118=5;
                }
                break;
            case 101:
                {
                alt118=6;
                }
                break;
            case 102:
                {
                alt118=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 118, 0, input);

                throw nvae;
            }

            switch (alt118) {
                case 1 :
                    // InternalTurn.g:6397:3: (enumLiteral_0= 'denied' )
                    {
                    // InternalTurn.g:6397:3: (enumLiteral_0= 'denied' )
                    // InternalTurn.g:6398:4: enumLiteral_0= 'denied'
                    {
                    enumLiteral_0=(Token)match(input,96,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getQualitativeLabelAccess().getDeniedEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6405:3: (enumLiteral_1= 'weaklyDenied' )
                    {
                    // InternalTurn.g:6405:3: (enumLiteral_1= 'weaklyDenied' )
                    // InternalTurn.g:6406:4: enumLiteral_1= 'weaklyDenied'
                    {
                    enumLiteral_1=(Token)match(input,97,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getQualitativeLabelAccess().getWeaklyDeniedEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:6413:3: (enumLiteral_2= 'weaklySatisfied' )
                    {
                    // InternalTurn.g:6413:3: (enumLiteral_2= 'weaklySatisfied' )
                    // InternalTurn.g:6414:4: enumLiteral_2= 'weaklySatisfied'
                    {
                    enumLiteral_2=(Token)match(input,98,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getQualitativeLabelAccess().getWeaklySatisfiedEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:6421:3: (enumLiteral_3= 'satisfied' )
                    {
                    // InternalTurn.g:6421:3: (enumLiteral_3= 'satisfied' )
                    // InternalTurn.g:6422:4: enumLiteral_3= 'satisfied'
                    {
                    enumLiteral_3=(Token)match(input,99,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getQualitativeLabelAccess().getSatisfiedEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:6429:3: (enumLiteral_4= 'conflict' )
                    {
                    // InternalTurn.g:6429:3: (enumLiteral_4= 'conflict' )
                    // InternalTurn.g:6430:4: enumLiteral_4= 'conflict'
                    {
                    enumLiteral_4=(Token)match(input,100,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getQualitativeLabelAccess().getConflictEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:6437:3: (enumLiteral_5= 'unknown' )
                    {
                    // InternalTurn.g:6437:3: (enumLiteral_5= 'unknown' )
                    // InternalTurn.g:6438:4: enumLiteral_5= 'unknown'
                    {
                    enumLiteral_5=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getQualitativeLabelAccess().getUnknownEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTurn.g:6445:3: (enumLiteral_6= 'none' )
                    {
                    // InternalTurn.g:6445:3: (enumLiteral_6= 'none' )
                    // InternalTurn.g:6446:4: enumLiteral_6= 'none'
                    {
                    enumLiteral_6=(Token)match(input,102,FOLLOW_2); 

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
    // InternalTurn.g:6456:1: ruleIntentionalElementType returns [Enumerator current=null] : ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) ;
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
            // InternalTurn.g:6462:2: ( ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) ) )
            // InternalTurn.g:6463:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            {
            // InternalTurn.g:6463:2: ( (enumLiteral_0= 'softgoal' ) | (enumLiteral_1= 'goal' ) | (enumLiteral_2= 'task' ) | (enumLiteral_3= 'resource' ) | (enumLiteral_4= 'belief' ) | (enumLiteral_5= 'indicator' ) )
            int alt119=6;
            switch ( input.LA(1) ) {
            case 103:
                {
                alt119=1;
                }
                break;
            case 104:
                {
                alt119=2;
                }
                break;
            case 105:
                {
                alt119=3;
                }
                break;
            case 106:
                {
                alt119=4;
                }
                break;
            case 107:
                {
                alt119=5;
                }
                break;
            case 108:
                {
                alt119=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 119, 0, input);

                throw nvae;
            }

            switch (alt119) {
                case 1 :
                    // InternalTurn.g:6464:3: (enumLiteral_0= 'softgoal' )
                    {
                    // InternalTurn.g:6464:3: (enumLiteral_0= 'softgoal' )
                    // InternalTurn.g:6465:4: enumLiteral_0= 'softgoal'
                    {
                    enumLiteral_0=(Token)match(input,103,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getIntentionalElementTypeAccess().getSoftgoalEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6472:3: (enumLiteral_1= 'goal' )
                    {
                    // InternalTurn.g:6472:3: (enumLiteral_1= 'goal' )
                    // InternalTurn.g:6473:4: enumLiteral_1= 'goal'
                    {
                    enumLiteral_1=(Token)match(input,104,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getIntentionalElementTypeAccess().getGoalEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:6480:3: (enumLiteral_2= 'task' )
                    {
                    // InternalTurn.g:6480:3: (enumLiteral_2= 'task' )
                    // InternalTurn.g:6481:4: enumLiteral_2= 'task'
                    {
                    enumLiteral_2=(Token)match(input,105,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getIntentionalElementTypeAccess().getTaskEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:6488:3: (enumLiteral_3= 'resource' )
                    {
                    // InternalTurn.g:6488:3: (enumLiteral_3= 'resource' )
                    // InternalTurn.g:6489:4: enumLiteral_3= 'resource'
                    {
                    enumLiteral_3=(Token)match(input,106,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getIntentionalElementTypeAccess().getResourceEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:6496:3: (enumLiteral_4= 'belief' )
                    {
                    // InternalTurn.g:6496:3: (enumLiteral_4= 'belief' )
                    // InternalTurn.g:6497:4: enumLiteral_4= 'belief'
                    {
                    enumLiteral_4=(Token)match(input,107,FOLLOW_2); 

                    				current = grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getIntentionalElementTypeAccess().getBeliefEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:6504:3: (enumLiteral_5= 'indicator' )
                    {
                    // InternalTurn.g:6504:3: (enumLiteral_5= 'indicator' )
                    // InternalTurn.g:6505:4: enumLiteral_5= 'indicator'
                    {
                    enumLiteral_5=(Token)match(input,108,FOLLOW_2); 

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
    // InternalTurn.g:6515:1: ruleContributionType returns [Enumerator current=null] : ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) ) ;
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
            // InternalTurn.g:6521:2: ( ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) ) )
            // InternalTurn.g:6522:2: ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) )
            {
            // InternalTurn.g:6522:2: ( (enumLiteral_0= 'make' ) | (enumLiteral_1= 'help' ) | (enumLiteral_2= 'somePositive' ) | (enumLiteral_3= 'unknown' ) | (enumLiteral_4= 'someNegative' ) | (enumLiteral_5= 'hurt' ) | (enumLiteral_6= 'break' ) )
            int alt120=7;
            switch ( input.LA(1) ) {
            case 109:
                {
                alt120=1;
                }
                break;
            case 110:
                {
                alt120=2;
                }
                break;
            case 111:
                {
                alt120=3;
                }
                break;
            case 101:
                {
                alt120=4;
                }
                break;
            case 112:
                {
                alt120=5;
                }
                break;
            case 113:
                {
                alt120=6;
                }
                break;
            case 114:
                {
                alt120=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 120, 0, input);

                throw nvae;
            }

            switch (alt120) {
                case 1 :
                    // InternalTurn.g:6523:3: (enumLiteral_0= 'make' )
                    {
                    // InternalTurn.g:6523:3: (enumLiteral_0= 'make' )
                    // InternalTurn.g:6524:4: enumLiteral_0= 'make'
                    {
                    enumLiteral_0=(Token)match(input,109,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getContributionTypeAccess().getMakeEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6531:3: (enumLiteral_1= 'help' )
                    {
                    // InternalTurn.g:6531:3: (enumLiteral_1= 'help' )
                    // InternalTurn.g:6532:4: enumLiteral_1= 'help'
                    {
                    enumLiteral_1=(Token)match(input,110,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getContributionTypeAccess().getHelpEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:6539:3: (enumLiteral_2= 'somePositive' )
                    {
                    // InternalTurn.g:6539:3: (enumLiteral_2= 'somePositive' )
                    // InternalTurn.g:6540:4: enumLiteral_2= 'somePositive'
                    {
                    enumLiteral_2=(Token)match(input,111,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getContributionTypeAccess().getSomePositiveEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:6547:3: (enumLiteral_3= 'unknown' )
                    {
                    // InternalTurn.g:6547:3: (enumLiteral_3= 'unknown' )
                    // InternalTurn.g:6548:4: enumLiteral_3= 'unknown'
                    {
                    enumLiteral_3=(Token)match(input,101,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getContributionTypeAccess().getUnknownEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:6555:3: (enumLiteral_4= 'someNegative' )
                    {
                    // InternalTurn.g:6555:3: (enumLiteral_4= 'someNegative' )
                    // InternalTurn.g:6556:4: enumLiteral_4= 'someNegative'
                    {
                    enumLiteral_4=(Token)match(input,112,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getContributionTypeAccess().getSomeNegativeEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:6563:3: (enumLiteral_5= 'hurt' )
                    {
                    // InternalTurn.g:6563:3: (enumLiteral_5= 'hurt' )
                    // InternalTurn.g:6564:4: enumLiteral_5= 'hurt'
                    {
                    enumLiteral_5=(Token)match(input,113,FOLLOW_2); 

                    				current = grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_5().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_5, grammarAccess.getContributionTypeAccess().getHurtEnumLiteralDeclaration_5());
                    			

                    }


                    }
                    break;
                case 7 :
                    // InternalTurn.g:6571:3: (enumLiteral_6= 'break' )
                    {
                    // InternalTurn.g:6571:3: (enumLiteral_6= 'break' )
                    // InternalTurn.g:6572:4: enumLiteral_6= 'break'
                    {
                    enumLiteral_6=(Token)match(input,114,FOLLOW_2); 

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
    // InternalTurn.g:6582:1: ruleImportanceType returns [Enumerator current=null] : ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) ;
    public final Enumerator ruleImportanceType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalTurn.g:6588:2: ( ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) ) )
            // InternalTurn.g:6589:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            {
            // InternalTurn.g:6589:2: ( (enumLiteral_0= 'high' ) | (enumLiteral_1= 'medium' ) | (enumLiteral_2= 'low' ) | (enumLiteral_3= 'none' ) )
            int alt121=4;
            switch ( input.LA(1) ) {
            case 115:
                {
                alt121=1;
                }
                break;
            case 116:
                {
                alt121=2;
                }
                break;
            case 117:
                {
                alt121=3;
                }
                break;
            case 102:
                {
                alt121=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 121, 0, input);

                throw nvae;
            }

            switch (alt121) {
                case 1 :
                    // InternalTurn.g:6590:3: (enumLiteral_0= 'high' )
                    {
                    // InternalTurn.g:6590:3: (enumLiteral_0= 'high' )
                    // InternalTurn.g:6591:4: enumLiteral_0= 'high'
                    {
                    enumLiteral_0=(Token)match(input,115,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getImportanceTypeAccess().getHighEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6598:3: (enumLiteral_1= 'medium' )
                    {
                    // InternalTurn.g:6598:3: (enumLiteral_1= 'medium' )
                    // InternalTurn.g:6599:4: enumLiteral_1= 'medium'
                    {
                    enumLiteral_1=(Token)match(input,116,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getImportanceTypeAccess().getMediumEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:6606:3: (enumLiteral_2= 'low' )
                    {
                    // InternalTurn.g:6606:3: (enumLiteral_2= 'low' )
                    // InternalTurn.g:6607:4: enumLiteral_2= 'low'
                    {
                    enumLiteral_2=(Token)match(input,117,FOLLOW_2); 

                    				current = grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getImportanceTypeAccess().getLowEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:6614:3: (enumLiteral_3= 'none' )
                    {
                    // InternalTurn.g:6614:3: (enumLiteral_3= 'none' )
                    // InternalTurn.g:6615:4: enumLiteral_3= 'none'
                    {
                    enumLiteral_3=(Token)match(input,102,FOLLOW_2); 

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
    // InternalTurn.g:6625:1: ruleDecompositionType returns [Enumerator current=null] : ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) ;
    public final Enumerator ruleDecompositionType() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalTurn.g:6631:2: ( ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) ) )
            // InternalTurn.g:6632:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            {
            // InternalTurn.g:6632:2: ( (enumLiteral_0= 'and' ) | (enumLiteral_1= 'or' ) | (enumLiteral_2= 'xor' ) )
            int alt122=3;
            switch ( input.LA(1) ) {
            case 81:
                {
                alt122=1;
                }
                break;
            case 79:
                {
                alt122=2;
                }
                break;
            case 118:
                {
                alt122=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 122, 0, input);

                throw nvae;
            }

            switch (alt122) {
                case 1 :
                    // InternalTurn.g:6633:3: (enumLiteral_0= 'and' )
                    {
                    // InternalTurn.g:6633:3: (enumLiteral_0= 'and' )
                    // InternalTurn.g:6634:4: enumLiteral_0= 'and'
                    {
                    enumLiteral_0=(Token)match(input,81,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getDecompositionTypeAccess().getAndEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6641:3: (enumLiteral_1= 'or' )
                    {
                    // InternalTurn.g:6641:3: (enumLiteral_1= 'or' )
                    // InternalTurn.g:6642:4: enumLiteral_1= 'or'
                    {
                    enumLiteral_1=(Token)match(input,79,FOLLOW_2); 

                    				current = grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getDecompositionTypeAccess().getOrEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:6649:3: (enumLiteral_2= 'xor' )
                    {
                    // InternalTurn.g:6649:3: (enumLiteral_2= 'xor' )
                    // InternalTurn.g:6650:4: enumLiteral_2= 'xor'
                    {
                    enumLiteral_2=(Token)match(input,118,FOLLOW_2); 

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
    // InternalTurn.g:6660:1: ruleWAITKIND returns [Enumerator current=null] : ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) ;
    public final Enumerator ruleWAITKIND() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalTurn.g:6666:2: ( ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) ) )
            // InternalTurn.g:6667:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            {
            // InternalTurn.g:6667:2: ( (enumLiteral_0= 'persistent' ) | (enumLiteral_1= 'transient' ) )
            int alt123=2;
            int LA123_0 = input.LA(1);

            if ( (LA123_0==119) ) {
                alt123=1;
            }
            else if ( (LA123_0==120) ) {
                alt123=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 123, 0, input);

                throw nvae;
            }
            switch (alt123) {
                case 1 :
                    // InternalTurn.g:6668:3: (enumLiteral_0= 'persistent' )
                    {
                    // InternalTurn.g:6668:3: (enumLiteral_0= 'persistent' )
                    // InternalTurn.g:6669:4: enumLiteral_0= 'persistent'
                    {
                    enumLiteral_0=(Token)match(input,119,FOLLOW_2); 

                    				current = grammarAccess.getWAITKINDAccess().getPersistentEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getWAITKINDAccess().getPersistentEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6676:3: (enumLiteral_1= 'transient' )
                    {
                    // InternalTurn.g:6676:3: (enumLiteral_1= 'transient' )
                    // InternalTurn.g:6677:4: enumLiteral_1= 'transient'
                    {
                    enumLiteral_1=(Token)match(input,120,FOLLOW_2); 

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
    // InternalTurn.g:6687:1: ruleCOMPONENTKIND returns [Enumerator current=null] : ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) ;
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
            // InternalTurn.g:6693:2: ( ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) ) )
            // InternalTurn.g:6694:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            {
            // InternalTurn.g:6694:2: ( (enumLiteral_0= 'team' ) | (enumLiteral_1= 'object' ) | (enumLiteral_2= 'process' ) | (enumLiteral_3= 'agent' ) | (enumLiteral_4= 'actor' ) | (enumLiteral_5= 'parent' ) )
            int alt124=6;
            switch ( input.LA(1) ) {
            case 121:
                {
                alt124=1;
                }
                break;
            case 122:
                {
                alt124=2;
                }
                break;
            case 123:
                {
                alt124=3;
                }
                break;
            case 124:
                {
                alt124=4;
                }
                break;
            case 32:
                {
                alt124=5;
                }
                break;
            case 125:
                {
                alt124=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 124, 0, input);

                throw nvae;
            }

            switch (alt124) {
                case 1 :
                    // InternalTurn.g:6695:3: (enumLiteral_0= 'team' )
                    {
                    // InternalTurn.g:6695:3: (enumLiteral_0= 'team' )
                    // InternalTurn.g:6696:4: enumLiteral_0= 'team'
                    {
                    enumLiteral_0=(Token)match(input,121,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getTeamEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getCOMPONENTKINDAccess().getTeamEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalTurn.g:6703:3: (enumLiteral_1= 'object' )
                    {
                    // InternalTurn.g:6703:3: (enumLiteral_1= 'object' )
                    // InternalTurn.g:6704:4: enumLiteral_1= 'object'
                    {
                    enumLiteral_1=(Token)match(input,122,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getObjectEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getCOMPONENTKINDAccess().getObjectEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalTurn.g:6711:3: (enumLiteral_2= 'process' )
                    {
                    // InternalTurn.g:6711:3: (enumLiteral_2= 'process' )
                    // InternalTurn.g:6712:4: enumLiteral_2= 'process'
                    {
                    enumLiteral_2=(Token)match(input,123,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getProcessEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getCOMPONENTKINDAccess().getProcessEnumLiteralDeclaration_2());
                    			

                    }


                    }
                    break;
                case 4 :
                    // InternalTurn.g:6719:3: (enumLiteral_3= 'agent' )
                    {
                    // InternalTurn.g:6719:3: (enumLiteral_3= 'agent' )
                    // InternalTurn.g:6720:4: enumLiteral_3= 'agent'
                    {
                    enumLiteral_3=(Token)match(input,124,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getAgentEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_3, grammarAccess.getCOMPONENTKINDAccess().getAgentEnumLiteralDeclaration_3());
                    			

                    }


                    }
                    break;
                case 5 :
                    // InternalTurn.g:6727:3: (enumLiteral_4= 'actor' )
                    {
                    // InternalTurn.g:6727:3: (enumLiteral_4= 'actor' )
                    // InternalTurn.g:6728:4: enumLiteral_4= 'actor'
                    {
                    enumLiteral_4=(Token)match(input,32,FOLLOW_2); 

                    				current = grammarAccess.getCOMPONENTKINDAccess().getActorEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_4, grammarAccess.getCOMPONENTKINDAccess().getActorEnumLiteralDeclaration_4());
                    			

                    }


                    }
                    break;
                case 6 :
                    // InternalTurn.g:6735:3: (enumLiteral_5= 'parent' )
                    {
                    // InternalTurn.g:6735:3: (enumLiteral_5= 'parent' )
                    // InternalTurn.g:6736:4: enumLiteral_5= 'parent'
                    {
                    enumLiteral_5=(Token)match(input,125,FOLLOW_2); 

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


    protected DFA12 dfa12 = new DFA12(this);
    protected DFA19 dfa19 = new DFA19(this);
    protected DFA29 dfa29 = new DFA29(this);
    protected DFA56 dfa56 = new DFA56(this);
    protected DFA69 dfa69 = new DFA69(this);
    protected DFA98 dfa98 = new DFA98(this);
    protected DFA113 dfa113 = new DFA113(this);
    protected DFA114 dfa114 = new DFA114(this);
    static final String dfa_1s = "\16\uffff";
    static final String dfa_2s = "\1\1\15\uffff";
    static final String dfa_3s = "\1\13\15\uffff";
    static final String dfa_4s = "\1\71\15\uffff";
    static final String dfa_5s = "\1\uffff\1\15\1\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\13\1\14";
    static final String dfa_6s = "\1\0\15\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\1\4\10\uffff\1\13\5\uffff\1\14\2\uffff\1\15\1\uffff\1\3\7\uffff\1\5\1\6\5\uffff\1\7\3\uffff\1\7\1\10\1\11\2\uffff\2\12",
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

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "()+ loopback of 85:5: ( ({...}? => ( ({...}? => (otherlv_1= 'urnModel' ( (lv_name_2_0= ruleQualifiedName ) ) ( (lv_info_3_0= ruleConcreteURNspec ) )? ) ) ) ) | ({...}? => ( ({...}? => ( (lv_actors_4_0= ruleActor ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_showAsMeansEnd_5_0= 'showAsMeansEnd' ) ) ) ) ) | ({...}? => ( ({...}? => ( (lv_stratGroups_6_0= ruleStrategiesGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_strategies_7_0= ruleEvaluationStrategy ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_indConversions_8_0= ruleIndicatorConversion ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContextGroups_9_0= ruleContributionContextGroup ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_contribContexts_10_0= ruleContributionContext ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_ucmMaps_11_0= ruleUCMmap ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_concerns_12_0= ruleConcern ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_urnlinks_13_0= ruleURNlink ) ) )+ ) ) | ({...}? => ( ({...}? => ( (lv_metadata_14_0= ruleMetadata ) ) )+ ) ) )+";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_0 = input.LA(1);

                         
                        int index12_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA12_0==EOF) ) {s = 1;}

                        else if ( LA12_0 == 11 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 0) ) {s = 2;}

                        else if ( LA12_0 == 32 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 1) ) {s = 3;}

                        else if ( LA12_0 == 12 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 2) ) {s = 4;}

                        else if ( LA12_0 == 40 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 3) ) {s = 5;}

                        else if ( LA12_0 == 41 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 4) ) {s = 6;}

                        else if ( ( LA12_0 == 47 || LA12_0 == 51 ) && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 5) ) {s = 7;}

                        else if ( LA12_0 == 52 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 6) ) {s = 8;}

                        else if ( LA12_0 == 53 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 7) ) {s = 9;}

                        else if ( LA12_0 >= 56 && LA12_0 <= 57 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 8) ) {s = 10;}

                        else if ( LA12_0 == 21 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 9) ) {s = 11;}

                        else if ( LA12_0 == 27 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 10) ) {s = 12;}

                        else if ( LA12_0 == 30 && getUnorderedGroupHelper().canSelect(grammarAccess.getURNspecAccess().getUnorderedGroup(), 11) ) {s = 13;}

                         
                        input.seek(index12_0);
                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
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

    class DFA19 extends DFA {

        public DFA19(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 19;
            this.eot = dfa_8;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "950:3: ( ( (lv_name_1_0= ruleQualifiedName ) ) ( (lv_longName_2_0= ruleLongName ) ) otherlv_3= ':' )?";
        }
    }
    static final String dfa_14s = "\12\uffff";
    static final String dfa_15s = "\1\5\1\30\3\uffff\1\5\1\4\1\30\2\43";
    static final String dfa_16s = "\2\166\3\uffff\2\5\3\166";
    static final String dfa_17s = "\2\uffff\1\1\1\2\1\3\5\uffff";
    static final String dfa_18s = "\12\uffff}>";
    static final String[] dfa_19s = {
            "\1\1\35\uffff\1\2\3\uffff\1\4\47\uffff\1\3\1\uffff\1\3\44\uffff\1\3",
            "\1\6\12\uffff\1\2\3\uffff\1\4\46\uffff\1\5\1\3\1\uffff\1\3\44\uffff\1\3",
            "",
            "",
            "",
            "\1\7",
            "\1\11\1\10",
            "\1\6\12\uffff\1\2\3\uffff\1\4\46\uffff\1\5\1\3\1\uffff\1\3\44\uffff\1\3",
            "\1\2\3\uffff\1\4\47\uffff\1\3\1\uffff\1\3\44\uffff\1\3",
            "\1\2\3\uffff\1\4\47\uffff\1\3\1\uffff\1\3\44\uffff\1\3"
    };

    static final short[] dfa_14 = DFA.unpackEncodedString(dfa_14s);
    static final char[] dfa_15 = DFA.unpackEncodedStringToUnsignedChars(dfa_15s);
    static final char[] dfa_16 = DFA.unpackEncodedStringToUnsignedChars(dfa_16s);
    static final short[] dfa_17 = DFA.unpackEncodedString(dfa_17s);
    static final short[] dfa_18 = DFA.unpackEncodedString(dfa_18s);
    static final short[][] dfa_19 = unpackEncodedStringArray(dfa_19s);

    class DFA29 extends DFA {

        public DFA29(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 29;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_15;
            this.max = dfa_16;
            this.accept = dfa_17;
            this.special = dfa_18;
            this.transition = dfa_19;
        }
        public String getDescription() {
            return "1468:2: (this_Contribution_0= ruleContribution | this_Decomposition_1= ruleDecomposition | this_Dependency_2= ruleDependency )";
        }
    }
    static final String dfa_20s = "\11\uffff";
    static final String dfa_21s = "\1\5\1\uffff\2\5\1\4\1\uffff\3\5";
    static final String dfa_22s = "\1\175\1\uffff\1\175\2\5\1\uffff\3\175";
    static final String dfa_23s = "\1\uffff\1\2\3\uffff\1\1\3\uffff";
    static final String dfa_24s = "\11\uffff}>";
    static final String[] dfa_25s = {
            "\1\2\16\uffff\1\1\13\uffff\1\1\31\uffff\1\1\3\uffff\2\1\32\uffff\1\1\36\uffff\5\1",
            "",
            "\1\1\16\uffff\1\1\1\uffff\1\1\1\uffff\1\4\6\uffff\1\5\1\1\55\uffff\1\3\13\uffff\1\1\36\uffff\5\1",
            "\1\6",
            "\1\10\1\7",
            "",
            "\1\1\16\uffff\1\1\1\uffff\1\1\1\uffff\1\4\6\uffff\1\5\1\1\55\uffff\1\3\13\uffff\1\1\36\uffff\5\1",
            "\1\1\16\uffff\1\1\1\uffff\1\1\10\uffff\1\5\1\1\71\uffff\1\1\36\uffff\5\1",
            "\1\1\16\uffff\1\1\1\uffff\1\1\10\uffff\1\5\1\1\71\uffff\1\1\36\uffff\5\1"
    };

    static final short[] dfa_20 = DFA.unpackEncodedString(dfa_20s);
    static final char[] dfa_21 = DFA.unpackEncodedStringToUnsignedChars(dfa_21s);
    static final char[] dfa_22 = DFA.unpackEncodedStringToUnsignedChars(dfa_22s);
    static final short[] dfa_23 = DFA.unpackEncodedString(dfa_23s);
    static final short[] dfa_24 = DFA.unpackEncodedString(dfa_24s);
    static final short[][] dfa_25 = unpackEncodedStringArray(dfa_25s);

    class DFA56 extends DFA {

        public DFA56(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 56;
            this.eot = dfa_20;
            this.eof = dfa_20;
            this.min = dfa_21;
            this.max = dfa_22;
            this.accept = dfa_23;
            this.special = dfa_24;
            this.transition = dfa_25;
        }
        public String getDescription() {
            return "()* loopback of 3151:3: ( (lv_stubs_5_0= ruleStubDeclaration ) )*";
        }
    }
    static final String dfa_26s = "\1\103\3\uffff\2\110\4\uffff";
    static final String dfa_27s = "\1\170\3\uffff\2\111\4\uffff";
    static final String dfa_28s = "\1\uffff\1\1\1\2\1\3\2\uffff\1\4\1\5\1\6\1\7";
    static final String[] dfa_29s = {
            "\1\2\1\3\3\1\1\6\1\10\1\uffff\1\11\1\7\52\uffff\1\4\1\5",
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

    class DFA69 extends DFA {

        public DFA69(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 69;
            this.eot = dfa_14;
            this.eof = dfa_14;
            this.min = dfa_26;
            this.max = dfa_27;
            this.accept = dfa_28;
            this.special = dfa_18;
            this.transition = dfa_29;
        }
        public String getDescription() {
            return "3762:2: (this_AndJoin_0= ruleAndJoin | this_RespRef_1= ruleRespRef | this_OrJoin_2= ruleOrJoin | this_WaitingPlace_3= ruleWaitingPlace | this_FailurePoint_4= ruleFailurePoint | this_Timer_5= ruleTimer | this_Connect_6= ruleConnect )";
        }
    }
    static final String dfa_30s = "\1\uffff\1\4\3\uffff\1\4";
    static final String dfa_31s = "\2\5\1\uffff\1\5\1\uffff\1\5";
    static final String dfa_32s = "\1\126\1\175\1\uffff\1\5\1\uffff\1\175";
    static final String dfa_33s = "\2\uffff\1\1\1\uffff\1\2\1\uffff";
    static final String[] dfa_34s = {
            "\1\1\120\uffff\1\2",
            "\1\4\7\uffff\1\4\6\uffff\1\4\3\uffff\1\2\1\4\6\uffff\1\4\31\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\3\1\uffff\1\4\1\uffff\1\4\3\uffff\1\2\1\uffff\1\4\1\uffff\1\4\36\uffff\5\4",
            "",
            "\1\5",
            "",
            "\1\4\7\uffff\1\4\6\uffff\1\4\3\uffff\1\2\1\4\6\uffff\1\4\31\uffff\1\4\3\uffff\2\4\2\uffff\1\4\13\uffff\1\3\1\uffff\1\4\1\uffff\1\4\3\uffff\1\2\1\uffff\1\4\1\uffff\1\4\36\uffff\5\4"
    };
    static final short[] dfa_30 = DFA.unpackEncodedString(dfa_30s);
    static final char[] dfa_31 = DFA.unpackEncodedStringToUnsignedChars(dfa_31s);
    static final char[] dfa_32 = DFA.unpackEncodedStringToUnsignedChars(dfa_32s);
    static final short[] dfa_33 = DFA.unpackEncodedString(dfa_33s);
    static final short[][] dfa_34 = unpackEncodedStringArray(dfa_34s);

    class DFA98 extends DFA {

        public DFA98(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 98;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_31;
            this.max = dfa_32;
            this.accept = dfa_33;
            this.special = dfa_12;
            this.transition = dfa_34;
        }
        public String getDescription() {
            return "5167:3: ( ( ( ( (lv_name_4_0= ruleQualifiedName ) ) ( (lv_longName_5_0= ruleLongName ) ) )? ( (lv_params_6_0= ruleStubParameters ) ) ) | ( ( ruleQualifiedName ) ) )";
        }
    }
    static final String dfa_35s = "\3\5\2\uffff\1\5";
    static final String dfa_36s = "\1\5\1\175\1\5\2\uffff\1\175";
    static final String dfa_37s = "\3\uffff\1\2\1\1\1\uffff";
    static final String[] dfa_38s = {
            "\1\1",
            "\1\4\16\uffff\1\4\2\uffff\1\4\10\uffff\1\4\55\uffff\1\2\13\uffff\1\4\1\3\35\uffff\5\4",
            "\1\5",
            "",
            "",
            "\1\4\16\uffff\1\4\2\uffff\1\4\10\uffff\1\4\55\uffff\1\2\13\uffff\1\4\1\3\35\uffff\5\4"
    };
    static final char[] dfa_35 = DFA.unpackEncodedStringToUnsignedChars(dfa_35s);
    static final char[] dfa_36 = DFA.unpackEncodedStringToUnsignedChars(dfa_36s);
    static final short[] dfa_37 = DFA.unpackEncodedString(dfa_37s);
    static final short[][] dfa_38 = unpackEncodedStringArray(dfa_38s);

    class DFA113 extends DFA {

        public DFA113(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 113;
            this.eot = dfa_8;
            this.eof = dfa_30;
            this.min = dfa_35;
            this.max = dfa_36;
            this.accept = dfa_37;
            this.special = dfa_12;
            this.transition = dfa_38;
        }
        public String getDescription() {
            return "5830:2: (this_BoundElement_0= ruleBoundElement | this_LongBoundElement_1= ruleLongBoundElement )";
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

    class DFA114 extends DFA {

        public DFA114(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 114;
            this.eot = dfa_39;
            this.eof = dfa_39;
            this.min = dfa_40;
            this.max = dfa_41;
            this.accept = dfa_42;
            this.special = dfa_43;
            this.transition = dfa_44;
        }
        public String getDescription() {
            return "5960:2: (this_InBinding_0= ruleInBinding | this_OutBinding_1= ruleOutBinding | this_ComponentBinding_2= ruleComponentBinding )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0338830148203802L});
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
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000001000060L,0x00000000F0040000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000100010L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000010000020L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000001002000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200100000L,0x00001F8000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x00C0000000000040L,0x0038004000000000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000100000L,0x00001F8000000000L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008E00100020L,0x0040000000028000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000008C00100020L,0x0040000000028000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000008800100020L,0x0040000000028000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000801000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000003000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x00C0000000000040L,0x003FE06000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000001000020L,0x0040000000028000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000000000000020L,0x0040000000028000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000008001000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000040000108020L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000040000100020L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000000000900000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000580000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00C0000000000040L,0x0038007F00000000L});
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
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0xC400000100100020L,0x3E00000004000000L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x0000000100100020L,0x3E00000004000000L});
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
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000000000002L,0x0180000000001BF8L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000004L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000000L,0x0180000000001BF8L});
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
    public static final BitSet FOLLOW_108 = new BitSet(new long[]{0x0000000100000020L,0x3E00000000000000L});
    public static final BitSet FOLLOW_109 = new BitSet(new long[]{0x0000000000000000L,0x0000000008000000L});
    public static final BitSet FOLLOW_110 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000002L});
    public static final BitSet FOLLOW_111 = new BitSet(new long[]{0x0000000000000000L,0x0000000001000000L});
    public static final BitSet FOLLOW_112 = new BitSet(new long[]{0x0000000001000062L,0x00000000F0040000L});
    public static final BitSet FOLLOW_113 = new BitSet(new long[]{0x0000000000000002L,0x0000000000004000L});

}
