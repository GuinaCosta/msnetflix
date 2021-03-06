-- noinspection SqlNoDataSourceInspectionForFile

USE [master]
GO

/****** Object:  Database [dbMsNetflix]    Script Date: 27/04/2019 13:40:24 ******/
DROP DATABASE [dbMsNetflix]
GO

/****** Object:  Database [dbMsNetflix]    Script Date: 27/04/2019 13:40:24 ******/
CREATE DATABASE [dbMsNetflix]
  CONTAINMENT = NONE
  ON  PRIMARY
  ( NAME = N'MSNetflix', FILENAME = N'/var/opt/mssql/data/MSNetflix.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
  LOG ON
  ( NAME = N'MSNetflix_log', FILENAME = N'/var/opt/mssql/data/MSNetflix_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO

ALTER DATABASE [dbMsNetflix] SET COMPATIBILITY_LEVEL = 140
GO

IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
  begin
    EXEC [dbMsNetflix].[dbo].[sp_fulltext_database] @action = 'enable'
  end
GO

ALTER DATABASE [dbMsNetflix] SET ANSI_NULL_DEFAULT OFF
GO

ALTER DATABASE [dbMsNetflix] SET ANSI_NULLS OFF
GO

ALTER DATABASE [dbMsNetflix] SET ANSI_PADDING OFF
GO

ALTER DATABASE [dbMsNetflix] SET ANSI_WARNINGS OFF
GO

ALTER DATABASE [dbMsNetflix] SET ARITHABORT OFF
GO

ALTER DATABASE [dbMsNetflix] SET AUTO_CLOSE OFF
GO

ALTER DATABASE [dbMsNetflix] SET AUTO_SHRINK OFF
GO

ALTER DATABASE [dbMsNetflix] SET AUTO_UPDATE_STATISTICS ON
GO

ALTER DATABASE [dbMsNetflix] SET CURSOR_CLOSE_ON_COMMIT OFF
GO

ALTER DATABASE [dbMsNetflix] SET CURSOR_DEFAULT  GLOBAL
GO

ALTER DATABASE [dbMsNetflix] SET CONCAT_NULL_YIELDS_NULL OFF
GO

ALTER DATABASE [dbMsNetflix] SET NUMERIC_ROUNDABORT OFF
GO

ALTER DATABASE [dbMsNetflix] SET QUOTED_IDENTIFIER OFF
GO

ALTER DATABASE [dbMsNetflix] SET RECURSIVE_TRIGGERS OFF
GO

ALTER DATABASE [dbMsNetflix] SET  DISABLE_BROKER
GO

ALTER DATABASE [dbMsNetflix] SET AUTO_UPDATE_STATISTICS_ASYNC OFF
GO

ALTER DATABASE [dbMsNetflix] SET DATE_CORRELATION_OPTIMIZATION OFF
GO

ALTER DATABASE [dbMsNetflix] SET TRUSTWORTHY OFF
GO

ALTER DATABASE [dbMsNetflix] SET ALLOW_SNAPSHOT_ISOLATION OFF
GO

ALTER DATABASE [dbMsNetflix] SET PARAMETERIZATION SIMPLE
GO

ALTER DATABASE [dbMsNetflix] SET READ_COMMITTED_SNAPSHOT OFF
GO

ALTER DATABASE [dbMsNetflix] SET HONOR_BROKER_PRIORITY OFF
GO

ALTER DATABASE [dbMsNetflix] SET RECOVERY FULL
GO

ALTER DATABASE [dbMsNetflix] SET  MULTI_USER
GO

ALTER DATABASE [dbMsNetflix] SET PAGE_VERIFY CHECKSUM
GO

ALTER DATABASE [dbMsNetflix] SET DB_CHAINING OFF
GO

ALTER DATABASE [dbMsNetflix] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF )
GO

ALTER DATABASE [dbMsNetflix] SET TARGET_RECOVERY_TIME = 60 SECONDS
GO

ALTER DATABASE [dbMsNetflix] SET DELAYED_DURABILITY = DISABLED
GO

ALTER DATABASE [dbMsNetflix] SET QUERY_STORE = OFF
GO

ALTER DATABASE [dbMsNetflix] SET  READ_WRITE
GO




USE [dbMsNetflix]
GO
/****** Object:  Table [dbo].[tbCatalogoUsuario]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbCatalogoUsuario'))
BEGIN
	DROP TABLE tbCatalogoUsuario
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCatalogoUsuario](
	[CatalogoUsuario_Id] [int] IDENTITY(1,1) NOT NULL,
	[catalog_Id] [int] NOT NULL,
	[usuario_id] [int] NOT NULL,
	[notaAvalida] [int] NULL,
	[AssitiuCompleto] [bit] NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbCatalogoUsuarioAndamento]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbCatalogoUsuarioAndamento'))
BEGIN
	DROP TABLE tbCatalogoUsuarioAndamento
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCatalogoUsuarioAndamento](
	[CatalogoUsuarioAndamento] [int] IDENTITY(1,1) NOT NULL,
	[catalog_Id] [int] NOT NULL,
	[usuario_id] [int] NOT NULL,
	[tempoDeFilme] [varchar](20) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbCategoria]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbCategoria'))
BEGIN
	DROP TABLE tbCategoria
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCategoria](
	[categoria_id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbCatologo]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbCatologo'))
BEGIN
	DROP TABLE tbCatologo
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbCatologo](
	[catalog_Id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](255) NULL,
	[produtor] [varchar](255) NULL,
	[dataLancamento] [datetime] NULL,
	[diretor] [varchar](100) NULL,
	[elenco] [varchar](max) NULL,
	[categoria_id] [int] NOT NULL,
	[link] [varchar](100) NULL,
	[Duracao] [varchar](100) NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbGenero]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbGenero'))
BEGIN
	DROP TABLE tbGenero
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbGenero](
	[genero_Id] [int] IDENTITY(1,1) NOT NULL,
	[genero] [varchar](50) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbGeneroCatalogo]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbGeneroCatalogo'))
	BEGIN
		DROP TABLE tbGeneroCatalogo
	END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE TABLE [dbo].[tbGeneroCatalogo](
	[GeneroCatalogo_Id] [int] IDENTITY(1,1) NOT NULL,
	[genero] varchar(50) NOT NULL,
	[catalog_Id] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[tbUsuario]    Script Date: 19/04/2019 02:06:48 ******/
IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbUsuario'))
BEGIN
	DROP TABLE tbUsuario
END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbUsuario](
	[usuario_id] [int] IDENTITY(1,1) NOT NULL,
	[nome] [varchar](100) NULL
) ON [PRIMARY]
GO

IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbPalavrasChaveCatalogo'))
	BEGIN
		DROP TABLE tbPalavrasChaveCatalogo
	END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE TABLE [dbo].[tbPalavrasChaveCatalogo](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[palavra_chave] varchar(50) NOT NULL,
	[catalog_Id] [int] NOT NULL
) ON [PRIMARY]
GO

SET IDENTITY_INSERT [dbo].[tbCatalogoUsuario] ON 

INSERT [dbo].[tbCatalogoUsuario] ([CatalogoUsuario_Id], [catalog_Id], [usuario_id], [notaAvalida], [AssitiuCompleto]) VALUES (1, 1, 1, 8, 1)
INSERT [dbo].[tbCatalogoUsuario] ([CatalogoUsuario_Id], [catalog_Id], [usuario_id], [notaAvalida], [AssitiuCompleto]) VALUES (2, 2, 2, 9, 1)
INSERT [dbo].[tbCatalogoUsuario] ([CatalogoUsuario_Id], [catalog_Id], [usuario_id], [notaAvalida], [AssitiuCompleto]) VALUES (3, 3, 3, 3, 0)
SET IDENTITY_INSERT [dbo].[tbCatalogoUsuario] OFF
SET IDENTITY_INSERT [dbo].[tbCatalogoUsuarioAndamento] ON 

INSERT [dbo].[tbCatalogoUsuarioAndamento] ([CatalogoUsuarioAndamento], [catalog_Id], [usuario_id], [tempoDeFilme]) VALUES (1, 1, 2, N'1:05:35')
INSERT [dbo].[tbCatalogoUsuarioAndamento] ([CatalogoUsuarioAndamento], [catalog_Id], [usuario_id], [tempoDeFilme]) VALUES (2, 3, 1, N'0:40:12')
INSERT [dbo].[tbCatalogoUsuarioAndamento] ([CatalogoUsuarioAndamento], [catalog_Id], [usuario_id], [tempoDeFilme]) VALUES (3, 1, 3, N'0:15:10')
SET IDENTITY_INSERT [dbo].[tbCatalogoUsuarioAndamento] OFF
SET IDENTITY_INSERT [dbo].[tbCategoria] ON 

INSERT [dbo].[tbCategoria] ([categoria_id], [nome]) VALUES (1, N'Filme')
INSERT [dbo].[tbCategoria] ([categoria_id], [nome]) VALUES (2, N'Serie')
INSERT [dbo].[tbCategoria] ([categoria_id], [nome]) VALUES (3, N'Documentarios')
SET IDENTITY_INSERT [dbo].[tbCategoria] OFF
SET IDENTITY_INSERT [dbo].[tbCatologo] ON 

INSERT [dbo].[tbCatologo] ([catalog_Id], [nome], [produtor], [dataLancamento], [diretor], [elenco], [categoria_id], [link], [Duracao]) VALUES (1, N'Avengers: Infinity War', N'Disney', CAST(N'2018-01-04T00:00:00.000' AS DateTime), N'Anthony Russo, Joe Russo', N'Josh Brolin, Chris Pratt, Tom Hiddleston, Chadwick Boseman, Elizabeth Olsen, Paul Bettany, Anthony Mackie, Stan Sebastian, Dave Bautista, Vin Diesel, Bradley Cooper, Robert Downey Jr., Pom Klementieff, Tom Holland, Chris Hemsworth, Chris Evans, Scarlett Johansson, Mark Ruffalo, Benedict Cumberbatch, Zoe Saldana', 1, N'www.Disney.com/avengers', N'2 Horas 24 Minutos')
INSERT [dbo].[tbCatologo] ([catalog_Id], [nome], [produtor], [dataLancamento], [diretor], [elenco], [categoria_id], [link], [Duracao]) VALUES (2, N'Jurassic Park III', N'Fox Filmes', CAST(N'2018-01-04T00:00:00.000' AS DateTime), N'Joe Johnston', N'Sam Neill, William H. Macy, Téa Leoni', 1, N'www.fox.com', N'1 Hora 28 Minutos')
INSERT [dbo].[tbCatologo] ([catalog_Id], [nome], [produtor], [dataLancamento], [diretor], [elenco], [categoria_id], [link], [Duracao]) VALUES (3, N'Rambo: First Blood Part II', N'paris filmes', CAST(N'1985-01-09T00:00:00.000' AS DateTime), N'George P. Cosmatos', N'Sylvester Stallone, Steven Berkoff, Charles Napier, Julia Nickson, Richard Crenna', 1, N'www.filmes.com', N'1 Hora 35 Minutos')
SET IDENTITY_INSERT [dbo].[tbCatologo] OFF
SET IDENTITY_INSERT [dbo].[tbGenero] ON 

INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (1, N'Ação')
INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (2, N'Aventura')
INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (3, N'Comedia')
INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (4, N'Terror')
INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (5, N'Suspence')
INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (6, N'Drama')
INSERT [dbo].[tbGenero] ([genero_Id], [genero]) VALUES (7, N'Romance')
SET IDENTITY_INSERT [dbo].[tbGenero] OFF
SET IDENTITY_INSERT [dbo].[tbGeneroCatalogo] ON 

INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (1, 'Ação', 1)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (2, 'Ação', 2)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (3, 'Aventura', 2)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (4, 'Aventura', 3)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (5, 'Aventura', 5)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (6, 'Comedia', 1)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (7, 'Comedia', 2)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (8, 'Comedia', 6)
INSERT [dbo].[tbGeneroCatalogo] ([GeneroCatalogo_Id], [genero], [catalog_Id]) VALUES (9, 'Comedia', 5)
SET IDENTITY_INSERT [dbo].[tbGeneroCatalogo] OFF
SET IDENTITY_INSERT [dbo].[tbUsuario] ON 

INSERT [dbo].[tbUsuario] ([usuario_id], [nome]) VALUES (1, N'Lucas')
INSERT [dbo].[tbUsuario] ([usuario_id], [nome]) VALUES (2, N'Agnaldo')
INSERT [dbo].[tbUsuario] ([usuario_id], [nome]) VALUES (3, N'Mauricio')
INSERT [dbo].[tbUsuario] ([usuario_id], [nome]) VALUES (4, N'Tadeu')
SET IDENTITY_INSERT [dbo].[tbUsuario] OFF
GO

IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbHelpDesk'))
BEGIN
	DROP TABLE tbHelpDesk
END
GO
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbHelpDesk](
		 [id] [int] IDENTITY(1,1) NOT NULL,
		 [usuario_id] [int] NOT NULL,
		 [dataCriacao] [datetime] NOT NULL DEFAULT GETDATE(),
		 [descricao] VARCHAR(MAX) NOT NULL,
		 [solucao] VARCHAR(MAX) NULL,
		 [dataConclusao] [datetime] NULL
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[tbHelpDesk] ON

IF (EXISTS(SELECT 1 FROM sys.all_objects WHERE name = 'tbRankingAssistidos'))
	BEGIN
		DROP TABLE tbRankingAssistidos
	END
GO

SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO


CREATE TABLE [dbo].[tbRankingAssistidos](
																					[ranking_id] [int] IDENTITY(1,1) NOT NULL,
																					[catalogo_id] [int] NOT NULL,
																					[catalogo_nome] varchar(50) NOT NULL,
																					[categoria] varchar(50) NOT NULL,
																					[contador] [int] NOT NULL,
) ON [PRIMARY]
GO

ALTER TABLE [dbo].[tbRankingAssistidos]
	ADD DEFAULT(0) FOR [contador]
GO

SET IDENTITY_INSERT [dbo].[tbRankingAssistidos] ON
