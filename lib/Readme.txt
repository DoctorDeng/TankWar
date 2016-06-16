1.将substance.jar添加到类路径中
2.将下列代码添加到你的程序的主执行类的main()方法中：
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

这个地方主要介绍一下关于使用substance.jar包装程序时对界面效果的几个方面的设置，主要要主题，皮肤，按钮类型，水印，边框渲染，渐变渲染与标题栏渲染．

共有22种皮肤，69种主题。

1. 下载下来substance.jar包后，解压JAR文件，可以看到在“org/jvnet/substance/skin”下有下面这些皮肤（以LookAndFeel.class结尾的文件）。

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

要使用上述皮肤很简单，只要在main函数中调用下面代码即可：

//主要设置皮肤、主题还有按钮、水印、选项卡、滑动条以及水印等

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessLookAndFeel");

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeSilver2007LookAndFeel");

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceSaharaLookAndFeel");

//UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceOfficeBlue2007LookAndFeel");

UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceBusinessBlackSteelLookAndFeel");

?

2.?org/jvnet/substance/theme 下有所有可用的主题：

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