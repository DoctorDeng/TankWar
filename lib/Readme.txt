1.��substance.jar��ӵ���·����
2.�����д�����ӵ���ĳ������ִ�����main()�����У�
try {
UIManager.setLookAndFeel(new SubstanceLookAndFeel());
JFrame.setDefaultLookAndFeelDecorated(true);
JDialog.setDefaultLookAndFeelDecorated(true);
SubstanceLookAndFeel.setCurrentTheme(new SubstanceTerracottaTheme());
// SubstanceLookAndFeel.setSkin(new EmeraldDuskSkin());
// SubstanceLookAndFeel.setCurrentButtonShaper(new ClassicButtonShaper());
// SubstanceLookAndFeel.setCurrentWatermark(new SubstanceBubblesWatermark());
// SubstanceLookAndFeel.setCurrentBorderPainter(new StandardBorderPainter());
// SubstanceLookAndFeel.setCurrentGradientPainter(new StandardGradientPainter());
// SubstanceLookAndFeel.setCurrentTitlePainter(new FlatTitePainter());
} catch (Exception e) {
System.err.println("Something went wrong!");
}

����ط���Ҫ����һ�¹���ʹ��substance.jar��װ����ʱ�Խ���Ч���ļ�����������ã���ҪҪ���⣬Ƥ������ť���ͣ�ˮӡ���߿���Ⱦ��������Ⱦ���������Ⱦ��

����22��Ƥ����69�����⡣

1. ��������substance.jar���󣬽�ѹJAR�ļ������Կ����ڡ�org/jvnet/substance/skin������������ЩƤ������LookAndFeel.class��β���ļ�����

SubstanceAutumnLookAndFeel.class

SubstanceBusinessBlackSteelLookAndFeel.class

SubstanceBusinessBlueSteelLookAndFeel.class

SubstanceBusinessLookAndFeel.class

SubstanceChallengerDeepLookAndFeel.class

SubstanceCremeLookAndFeel.class

SubstanceEmeraldDuskLookAndFeel.class

SubstanceFieldOfWheatLookAndFeel.class

SubstanceGreenMagicLookAndFeel.class

SubstanceMagmaLookAndFeel.class

SubstanceMangoLookAndFeel.class

SubstanceMistAquaLookAndFeel.class

SubstanceMistSilverLookAndFeel.class

SubstanceModerateLookAndFeel.class

SubstanceNebulaBrickWallLookAndFeel.class

SubstanceNebulaLookAndFeel.class

SubstanceOfficeBlue2007LookAndFeel.class

SubstanceOfficeSilver2007LookAndFeel.class

SubstanceRavenGraphiteGlassLookAndFeel.class

SubstanceRavenGraphiteLookAndFeel.class

SubstanceRavenLookAndFeel.class

SubstanceSaharaLookAndFeel.class

?

Ҫʹ������Ƥ���ܼ򵥣�ֻҪ��main�����е���������뼴�ɣ�

//��Ҫ����Ƥ�������⻹�а�ť��ˮӡ��ѡ����������Լ�ˮӡ��

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessLookAndFeel");

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel");

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceSaharaLookAndFeel");

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel");

UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");

?

2.?org/jvnet/substance/theme �������п��õ����⣺

SubstanceAquaTheme.class

SubstanceBarbyPinkTheme.class

SubstanceBlendBiTheme.class

SubstanceBottleGreenTheme.class

SubstanceBrownTheme.class

SubstanceCharcoalTheme.class

SubstanceColorBlindTheme.class

SubstanceComplexTheme.class

SubstanceCremeTheme.class

SubstanceDarkVioletTheme.class

SubstanceDesertSandTheme.class

SubstanceDeuteranopiaTheme.class

SubstanceEbonyTheme.class

SubstanceHueShiftTheme.class

SubstanceInvertedTheme.class

SubstanceJadeForestTheme.class

SubstanceLightAquaTheme.class

SubstanceLimeGreenTheme.class

SubstanceMixBiTheme.class

SubstanceMixTheme.class

SubstanceNegatedTheme.class

SubstanceOliveTheme.class

SubstanceOrangeTheme.class

SubstanceProtanopiaTheme.class

SubstancePurpleTheme.class

SubstanceRaspberryTheme.class

SubstanceSaturatedTheme.class

SubstanceSepiaTheme.class

SubstanceShadeTheme.class

SubstanceSteelBlueTheme.class

SubstanceSunGlareTheme.class

SubstanceSunsetTheme.class

SubstanceTerracottaTheme.class

SubstanceTheme$1$1.class

SubstanceTheme$1.class

SubstanceTheme$10.class

SubstanceTheme$11.class

SubstanceTheme$12.class

SubstanceTheme$13.class

SubstanceTheme$14.class

SubstanceTheme$15.class

SubstanceTheme$16.class

SubstanceTheme$17.class

SubstanceTheme$18.class

SubstanceTheme$19.class

SubstanceTheme$2.class

SubstanceTheme$20.class

SubstanceTheme$21.class

SubstanceTheme$22.class

SubstanceTheme$23.class

SubstanceTheme$24.class

SubstanceTheme$25.class

SubstanceTheme$26.class

SubstanceTheme$27.class

SubstanceTheme$28.class

SubstanceThem