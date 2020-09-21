<map version="freeplane 1.7.0">
<!--To view this file, download free mind mapping software Freeplane from http://freeplane.sourceforge.net -->
<node TEXT="tomcat&#x8bbe;&#x8ba1;&#x601d;&#x60f3;" FOLDED="false" ID="ID_770194759" CREATED="1596952530094" MODIFIED="1596952546110" STYLE="oval">
<font SIZE="18"/>
<hook NAME="MapStyle">
    <properties fit_to_viewport="false" edgeColorConfiguration="#808080ff,#ff0000ff,#0000ffff,#00ff00ff,#ff00ffff,#00ffffff,#7c0000ff,#00007cff,#007c00ff,#7c007cff,#007c7cff,#7c7c00ff"/>

<map_styles>
<stylenode LOCALIZED_TEXT="styles.root_node" STYLE="oval" UNIFORM_SHAPE="true" VGAP_QUANTITY="24.0 pt">
<font SIZE="24"/>
<stylenode LOCALIZED_TEXT="styles.predefined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="default" ICON_SIZE="12.0 pt" COLOR="#000000" STYLE="fork">
<font NAME="SansSerif" SIZE="10" BOLD="false" ITALIC="false"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.details"/>
<stylenode LOCALIZED_TEXT="defaultstyle.attributes">
<font SIZE="9"/>
</stylenode>
<stylenode LOCALIZED_TEXT="defaultstyle.note" COLOR="#000000" BACKGROUND_COLOR="#ffffff" TEXT_ALIGN="LEFT"/>
<stylenode LOCALIZED_TEXT="defaultstyle.floating">
<edge STYLE="hide_edge"/>
<cloud COLOR="#f0f0f0" SHAPE="ROUND_RECT"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.user-defined" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="styles.topic" COLOR="#18898b" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subtopic" COLOR="#cc3300" STYLE="fork">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.subsubtopic" COLOR="#669900">
<font NAME="Liberation Sans" SIZE="10" BOLD="true"/>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.important">
<icon BUILTIN="yes"/>
</stylenode>
</stylenode>
<stylenode LOCALIZED_TEXT="styles.AutomaticLayout" POSITION="right" STYLE="bubble">
<stylenode LOCALIZED_TEXT="AutomaticLayout.level.root" COLOR="#000000" STYLE="oval" SHAPE_HORIZONTAL_MARGIN="10.0 pt" SHAPE_VERTICAL_MARGIN="10.0 pt">
<font SIZE="18"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,1" COLOR="#0033ff">
<font SIZE="16"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,2" COLOR="#00b439">
<font SIZE="14"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,3" COLOR="#990000">
<font SIZE="12"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,4" COLOR="#111111">
<font SIZE="10"/>
</stylenode>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,5"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,6"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,7"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,8"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,9"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,10"/>
<stylenode LOCALIZED_TEXT="AutomaticLayout.level,11"/>
</stylenode>
</stylenode>
</map_styles>
</hook>
<hook NAME="AutomaticEdgeColor" COUNTER="5" RULE="ON_BRANCH_CREATION"/>
<node TEXT="HttpServer" POSITION="right" ID="ID_1486840713" CREATED="1596952584398" MODIFIED="1596974473698" BACKGROUND_COLOR="#ccccff">
<edge COLOR="#ff0000"/>
<node TEXT="HttpServer" ID="ID_323687160" CREATED="1596952675450" MODIFIED="1596974509709" BACKGROUND_COLOR="#ffcccc">
<node TEXT="BootStrap" ID="ID_688484842" CREATED="1596973818259" MODIFIED="1596974532242" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="HttpConnector" ID="ID_184139801" CREATED="1596973890850" MODIFIED="1596974532246" BACKGROUND_COLOR="#ccffcc"/>
</node>
<node TEXT="" ID="ID_1809918228" CREATED="1596974418421" MODIFIED="1596974418422">
<hook NAME="FirstGroupNode"/>
</node>
<node TEXT="ServletProcessor" ID="ID_685460888" CREATED="1596952686781" MODIFIED="1596974509713" BACKGROUND_COLOR="#ffcccc"/>
<node TEXT="StaticResourceProcessor" ID="ID_712989322" CREATED="1596952770490" MODIFIED="1596974509714" BACKGROUND_COLOR="#ffcccc"/>
<node TEXT="" ID="ID_244879892" CREATED="1596974418417" MODIFIED="1596974418420">
<hook NAME="SummaryNode"/>
<hook NAME="AlwaysUnfoldedNode"/>
<node TEXT="httpProcessor" ID="ID_815152340" CREATED="1596974395704" MODIFIED="1596974532246" BACKGROUND_COLOR="#ccffcc">
<node TEXT="ServletProcessor" ID="ID_30484113" CREATED="1596973837620" MODIFIED="1596974532246" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="StaticResourceProcessor" ID="ID_999426261" CREATED="1596973858293" MODIFIED="1596974532247" BACKGROUND_COLOR="#ccffcc"/>
</node>
</node>
</node>
<node TEXT="Request" POSITION="right" ID="ID_1155179475" CREATED="1596952604094" MODIFIED="1596974473705" BACKGROUND_COLOR="#ccccff">
<edge COLOR="#0000ff"/>
<node TEXT="Request" ID="ID_1525702148" CREATED="1596952699439" MODIFIED="1596974509716" BACKGROUND_COLOR="#ffcccc">
<node TEXT="HttpRequest" ID="ID_698609660" CREATED="1596973875464" MODIFIED="1596974532247" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="HttpRequestLine" ID="ID_101929279" CREATED="1596973934166" MODIFIED="1596974532248" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="HttpHeader" ID="ID_1779465223" CREATED="1596973909477" MODIFIED="1596974532248" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="RequestStream" ID="ID_722966256" CREATED="1596974110287" MODIFIED="1596974532248" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="SocketInputStream" ID="ID_598384873" CREATED="1596974237969" MODIFIED="1596974532247" BACKGROUND_COLOR="#ccffcc"/>
</node>
<node TEXT="RequestFacade" ID="ID_1004110832" CREATED="1596952798098" MODIFIED="1596974509717" BACKGROUND_COLOR="#ffcccc">
<node TEXT="HttpRequestFacade" ID="ID_1659745711" CREATED="1596974252938" MODIFIED="1596974532249" BACKGROUND_COLOR="#ccffcc"/>
</node>
</node>
<node TEXT="Response" POSITION="right" ID="ID_434309681" CREATED="1596952606975" MODIFIED="1596974473706" BACKGROUND_COLOR="#ccccff">
<edge COLOR="#00ff00"/>
<node TEXT="Response" ID="ID_630583679" CREATED="1596952812154" MODIFIED="1596974509719" BACKGROUND_COLOR="#ffcccc">
<node TEXT="HttpResponse" ID="ID_1363744015" CREATED="1596974134383" MODIFIED="1596974532249" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="ResponseStream" ID="ID_206675506" CREATED="1596974159165" MODIFIED="1596974532250" BACKGROUND_COLOR="#ccffcc"/>
<node TEXT="ResponseWriter" ID="ID_952485662" CREATED="1596974192623" MODIFIED="1596974532251" BACKGROUND_COLOR="#ccffcc"/>
</node>
<node TEXT="ResponseFacade" ID="ID_290697231" CREATED="1596952815155" MODIFIED="1596974509720" BACKGROUND_COLOR="#ffcccc">
<node TEXT="HttpResponseFacade" ID="ID_1622483744" CREATED="1596974130490" MODIFIED="1596974532253" BACKGROUND_COLOR="#ccffcc"/>
</node>
</node>
<node TEXT="1) &#x7236;&#x5bb9;&#x5668;&#x901a;&#x8fc7;&#x5bb9;&#x5668;&#x7c7b;&#x5b58;&#x50a8;&#x5b50;&#x5bb9;&#x5668;" POSITION="left" ID="ID_1587540489" CREATED="1600591414339" MODIFIED="1600591462864">
<edge COLOR="#ff00ff"/>
</node>
<node TEXT="2) HttpProcessor&#x5177;&#x4f53;&#x662f;&#x505a;&#x4ec0;&#x4e48;&#x7684;&#x54ea;&#x4e00;&#x9636;&#x6bb5;&#x542f;&#x4f5c;&#x7528;" POSITION="left" ID="ID_1320380984" CREATED="1600593613509" MODIFIED="1600593669459">
<edge COLOR="#00ffff"/>
</node>
</node>
</map>
