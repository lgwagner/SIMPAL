/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LimpFactoryImpl extends EFactoryImpl implements LimpFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static LimpFactory init()
  {
    try
    {
      LimpFactory theLimpFactory = (LimpFactory)EPackage.Registry.INSTANCE.getEFactory(LimpPackage.eNS_URI);
      if (theLimpFactory != null)
      {
        return theLimpFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new LimpFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LimpFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case LimpPackage.SPECIFICATION: return createSpecification();
      case LimpPackage.DECLARATION: return createDeclaration();
      case LimpPackage.COMMENT: return createComment();
      case LimpPackage.IMPORT: return createImport();
      case LimpPackage.EXTERNAL_FUNCTION: return createExternalFunction();
      case LimpPackage.EXTERNAL_PROCEDURE: return createExternalProcedure();
      case LimpPackage.LOCAL_FUNCTION: return createLocalFunction();
      case LimpPackage.LOCAL_PROCEDURE: return createLocalProcedure();
      case LimpPackage.TYPE_DECLARATION: return createTypeDeclaration();
      case LimpPackage.VAR_BLOCK: return createVarBlock();
      case LimpPackage.ENUM_TYPE_DEF: return createEnumTypeDef();
      case LimpPackage.ENUM_VALUE: return createEnumValue();
      case LimpPackage.RECORD_TYPE_DEF: return createRecordTypeDef();
      case LimpPackage.ARRAY_TYPE_DEF: return createArrayTypeDef();
      case LimpPackage.ABSTRACT_TYPE_DEF: return createAbstractTypeDef();
      case LimpPackage.RECORD_FIELD_TYPE: return createRecordFieldType();
      case LimpPackage.CONSTANT_DECLARATION: return createConstantDeclaration();
      case LimpPackage.GLOBAL_DECLARATION: return createGlobalDeclaration();
      case LimpPackage.VARIABLE_REF: return createVariableRef();
      case LimpPackage.INPUT_ARG_LIST: return createInputArgList();
      case LimpPackage.INPUT_ARG: return createInputArg();
      case LimpPackage.LOCAL_ARG: return createLocalArg();
      case LimpPackage.OUTPUT_ARG_LIST: return createOutputArgList();
      case LimpPackage.OUTPUT_ARG: return createOutputArg();
      case LimpPackage.TYPE: return createType();
      case LimpPackage.ATTRIBUTE_BLOCK: return createAttributeBlock();
      case LimpPackage.ATTRIBUTE: return createAttribute();
      case LimpPackage.PRECONDITION: return createPrecondition();
      case LimpPackage.POSTCONDITION: return createPostcondition();
      case LimpPackage.DEFINE_USE_REF: return createDefineUseRef();
      case LimpPackage.DEFINE: return createDefine();
      case LimpPackage.USES: return createUses();
      case LimpPackage.STATEMENT_BLOCK: return createStatementBlock();
      case LimpPackage.STATEMENT: return createStatement();
      case LimpPackage.VOID_STATEMENT: return createVoidStatement();
      case LimpPackage.ASSIGNMENT_STATEMENT: return createAssignmentStatement();
      case LimpPackage.IF_THEN_ELSE_STATEMENT: return createIfThenElseStatement();
      case LimpPackage.ELSE: return createElse();
      case LimpPackage.WHILE_STATEMENT: return createWhileStatement();
      case LimpPackage.FOR_STATEMENT: return createForStatement();
      case LimpPackage.LABEL_STATEMENT: return createLabelStatement();
      case LimpPackage.GOTO_STATEMENT: return createGotoStatement();
      case LimpPackage.EQUATION_BLOCK: return createEquationBlock();
      case LimpPackage.EQUATION: return createEquation();
      case LimpPackage.ID_LIST: return createIdList();
      case LimpPackage.EXPR: return createExpr();
      case LimpPackage.FUNCTION_REF: return createFunctionRef();
      case LimpPackage.ARRAY_EXPR: return createArrayExpr();
      case LimpPackage.RECORD_EXPR: return createRecordExpr();
      case LimpPackage.RECORD_FIELD_EXPR: return createRecordFieldExpr();
      case LimpPackage.EXPR_LIST: return createExprList();
      case LimpPackage.TYPE_ALIAS: return createTypeAlias();
      case LimpPackage.SOME_VAR_BLOCK: return createSomeVarBlock();
      case LimpPackage.NO_VAR_BLOCK: return createNoVarBlock();
      case LimpPackage.VOID_TYPE: return createVoidType();
      case LimpPackage.BOOL_TYPE: return createBoolType();
      case LimpPackage.INTEGER_TYPE: return createIntegerType();
      case LimpPackage.REAL_TYPE: return createRealType();
      case LimpPackage.STRING_TYPE: return createStringType();
      case LimpPackage.ENUM_TYPE: return createEnumType();
      case LimpPackage.RECORD_TYPE: return createRecordType();
      case LimpPackage.ARRAY_TYPE: return createArrayType();
      case LimpPackage.ABSTRACT_TYPE: return createAbstractType();
      case LimpPackage.NAMED_TYPE: return createNamedType();
      case LimpPackage.SOME_ATTRIBUTE_BLOCK: return createSomeAttributeBlock();
      case LimpPackage.NO_ATTRIBUTE_BLOCK: return createNoAttributeBlock();
      case LimpPackage.BREAK_STATEMENT: return createBreakStatement();
      case LimpPackage.CONTINUE_STATEMENT: return createContinueStatement();
      case LimpPackage.RETURN_STATEMENT: return createReturnStatement();
      case LimpPackage.ELSE_BLOCK: return createElseBlock();
      case LimpPackage.ELSE_IF: return createElseIf();
      case LimpPackage.NO_ELSE: return createNoElse();
      case LimpPackage.IF_THEN_ELSE_EXPR: return createIfThenElseExpr();
      case LimpPackage.CHOICE_EXPR: return createChoiceExpr();
      case LimpPackage.BINARY_EXPR: return createBinaryExpr();
      case LimpPackage.UNARY_NEGATION_EXPR: return createUnaryNegationExpr();
      case LimpPackage.UNARY_MINUS_EXPR: return createUnaryMinusExpr();
      case LimpPackage.RECORD_ACCESS_EXPR: return createRecordAccessExpr();
      case LimpPackage.RECORD_UPDATE_EXPR: return createRecordUpdateExpr();
      case LimpPackage.ARRAY_ACCESS_EXPR: return createArrayAccessExpr();
      case LimpPackage.ARRAY_UPDATE_EXPR: return createArrayUpdateExpr();
      case LimpPackage.BOOLEAN_LITERAL_EXPR: return createBooleanLiteralExpr();
      case LimpPackage.INTEGER_LITERAL_EXPR: return createIntegerLiteralExpr();
      case LimpPackage.INTEGER_WILD_CARD_EXPR: return createIntegerWildCardExpr();
      case LimpPackage.REAL_LITERAL_EXPR: return createRealLiteralExpr();
      case LimpPackage.STRING_LITERAL_EXPR: return createStringLiteralExpr();
      case LimpPackage.INIT_EXPR: return createInitExpr();
      case LimpPackage.SECOND_INIT: return createSecondInit();
      case LimpPackage.ID_EXPR: return createIdExpr();
      case LimpPackage.FCN_CALL_EXPR: return createFcnCallExpr();
      case LimpPackage.TUPLE_TYPE: return createTupleType();
      case LimpPackage.FRESH_VARIABLE: return createFreshVariable();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Specification createSpecification()
  {
    SpecificationImpl specification = new SpecificationImpl();
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Declaration createDeclaration()
  {
    DeclarationImpl declaration = new DeclarationImpl();
    return declaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Comment createComment()
  {
    CommentImpl comment = new CommentImpl();
    return comment;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Import createImport()
  {
    ImportImpl import_ = new ImportImpl();
    return import_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalFunction createExternalFunction()
  {
    ExternalFunctionImpl externalFunction = new ExternalFunctionImpl();
    return externalFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExternalProcedure createExternalProcedure()
  {
    ExternalProcedureImpl externalProcedure = new ExternalProcedureImpl();
    return externalProcedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalFunction createLocalFunction()
  {
    LocalFunctionImpl localFunction = new LocalFunctionImpl();
    return localFunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalProcedure createLocalProcedure()
  {
    LocalProcedureImpl localProcedure = new LocalProcedureImpl();
    return localProcedure;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeDeclaration createTypeDeclaration()
  {
    TypeDeclarationImpl typeDeclaration = new TypeDeclarationImpl();
    return typeDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VarBlock createVarBlock()
  {
    VarBlockImpl varBlock = new VarBlockImpl();
    return varBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumTypeDef createEnumTypeDef()
  {
    EnumTypeDefImpl enumTypeDef = new EnumTypeDefImpl();
    return enumTypeDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumValue createEnumValue()
  {
    EnumValueImpl enumValue = new EnumValueImpl();
    return enumValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordTypeDef createRecordTypeDef()
  {
    RecordTypeDefImpl recordTypeDef = new RecordTypeDefImpl();
    return recordTypeDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayTypeDef createArrayTypeDef()
  {
    ArrayTypeDefImpl arrayTypeDef = new ArrayTypeDefImpl();
    return arrayTypeDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractTypeDef createAbstractTypeDef()
  {
    AbstractTypeDefImpl abstractTypeDef = new AbstractTypeDefImpl();
    return abstractTypeDef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldType createRecordFieldType()
  {
    RecordFieldTypeImpl recordFieldType = new RecordFieldTypeImpl();
    return recordFieldType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstantDeclaration createConstantDeclaration()
  {
    ConstantDeclarationImpl constantDeclaration = new ConstantDeclarationImpl();
    return constantDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GlobalDeclaration createGlobalDeclaration()
  {
    GlobalDeclarationImpl globalDeclaration = new GlobalDeclarationImpl();
    return globalDeclaration;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VariableRef createVariableRef()
  {
    VariableRefImpl variableRef = new VariableRefImpl();
    return variableRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputArgList createInputArgList()
  {
    InputArgListImpl inputArgList = new InputArgListImpl();
    return inputArgList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InputArg createInputArg()
  {
    InputArgImpl inputArg = new InputArgImpl();
    return inputArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LocalArg createLocalArg()
  {
    LocalArgImpl localArg = new LocalArgImpl();
    return localArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputArgList createOutputArgList()
  {
    OutputArgListImpl outputArgList = new OutputArgListImpl();
    return outputArgList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutputArg createOutputArg()
  {
    OutputArgImpl outputArg = new OutputArgImpl();
    return outputArg;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Type createType()
  {
    TypeImpl type = new TypeImpl();
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AttributeBlock createAttributeBlock()
  {
    AttributeBlockImpl attributeBlock = new AttributeBlockImpl();
    return attributeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Attribute createAttribute()
  {
    AttributeImpl attribute = new AttributeImpl();
    return attribute;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Precondition createPrecondition()
  {
    PreconditionImpl precondition = new PreconditionImpl();
    return precondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Postcondition createPostcondition()
  {
    PostconditionImpl postcondition = new PostconditionImpl();
    return postcondition;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefineUseRef createDefineUseRef()
  {
    DefineUseRefImpl defineUseRef = new DefineUseRefImpl();
    return defineUseRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Define createDefine()
  {
    DefineImpl define = new DefineImpl();
    return define;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Uses createUses()
  {
    UsesImpl uses = new UsesImpl();
    return uses;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StatementBlock createStatementBlock()
  {
    StatementBlockImpl statementBlock = new StatementBlockImpl();
    return statementBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Statement createStatement()
  {
    StatementImpl statement = new StatementImpl();
    return statement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VoidStatement createVoidStatement()
  {
    VoidStatementImpl voidStatement = new VoidStatementImpl();
    return voidStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssignmentStatement createAssignmentStatement()
  {
    AssignmentStatementImpl assignmentStatement = new AssignmentStatementImpl();
    return assignmentStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfThenElseStatement createIfThenElseStatement()
  {
    IfThenElseStatementImpl ifThenElseStatement = new IfThenElseStatementImpl();
    return ifThenElseStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Else createElse()
  {
    ElseImpl else_ = new ElseImpl();
    return else_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WhileStatement createWhileStatement()
  {
    WhileStatementImpl whileStatement = new WhileStatementImpl();
    return whileStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ForStatement createForStatement()
  {
    ForStatementImpl forStatement = new ForStatementImpl();
    return forStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LabelStatement createLabelStatement()
  {
    LabelStatementImpl labelStatement = new LabelStatementImpl();
    return labelStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GotoStatement createGotoStatement()
  {
    GotoStatementImpl gotoStatement = new GotoStatementImpl();
    return gotoStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EquationBlock createEquationBlock()
  {
    EquationBlockImpl equationBlock = new EquationBlockImpl();
    return equationBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Equation createEquation()
  {
    EquationImpl equation = new EquationImpl();
    return equation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdList createIdList()
  {
    IdListImpl idList = new IdListImpl();
    return idList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expr createExpr()
  {
    ExprImpl expr = new ExprImpl();
    return expr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FunctionRef createFunctionRef()
  {
    FunctionRefImpl functionRef = new FunctionRefImpl();
    return functionRef;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayExpr createArrayExpr()
  {
    ArrayExprImpl arrayExpr = new ArrayExprImpl();
    return arrayExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordExpr createRecordExpr()
  {
    RecordExprImpl recordExpr = new RecordExprImpl();
    return recordExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordFieldExpr createRecordFieldExpr()
  {
    RecordFieldExprImpl recordFieldExpr = new RecordFieldExprImpl();
    return recordFieldExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExprList createExprList()
  {
    ExprListImpl exprList = new ExprListImpl();
    return exprList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeAlias createTypeAlias()
  {
    TypeAliasImpl typeAlias = new TypeAliasImpl();
    return typeAlias;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SomeVarBlock createSomeVarBlock()
  {
    SomeVarBlockImpl someVarBlock = new SomeVarBlockImpl();
    return someVarBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoVarBlock createNoVarBlock()
  {
    NoVarBlockImpl noVarBlock = new NoVarBlockImpl();
    return noVarBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public VoidType createVoidType()
  {
    VoidTypeImpl voidType = new VoidTypeImpl();
    return voidType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BoolType createBoolType()
  {
    BoolTypeImpl boolType = new BoolTypeImpl();
    return boolType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerType createIntegerType()
  {
    IntegerTypeImpl integerType = new IntegerTypeImpl();
    return integerType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealType createRealType()
  {
    RealTypeImpl realType = new RealTypeImpl();
    return realType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringType createStringType()
  {
    StringTypeImpl stringType = new StringTypeImpl();
    return stringType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EnumType createEnumType()
  {
    EnumTypeImpl enumType = new EnumTypeImpl();
    return enumType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordType createRecordType()
  {
    RecordTypeImpl recordType = new RecordTypeImpl();
    return recordType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayType createArrayType()
  {
    ArrayTypeImpl arrayType = new ArrayTypeImpl();
    return arrayType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractType createAbstractType()
  {
    AbstractTypeImpl abstractType = new AbstractTypeImpl();
    return abstractType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedType createNamedType()
  {
    NamedTypeImpl namedType = new NamedTypeImpl();
    return namedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SomeAttributeBlock createSomeAttributeBlock()
  {
    SomeAttributeBlockImpl someAttributeBlock = new SomeAttributeBlockImpl();
    return someAttributeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoAttributeBlock createNoAttributeBlock()
  {
    NoAttributeBlockImpl noAttributeBlock = new NoAttributeBlockImpl();
    return noAttributeBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BreakStatement createBreakStatement()
  {
    BreakStatementImpl breakStatement = new BreakStatementImpl();
    return breakStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContinueStatement createContinueStatement()
  {
    ContinueStatementImpl continueStatement = new ContinueStatementImpl();
    return continueStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ReturnStatement createReturnStatement()
  {
    ReturnStatementImpl returnStatement = new ReturnStatementImpl();
    return returnStatement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseBlock createElseBlock()
  {
    ElseBlockImpl elseBlock = new ElseBlockImpl();
    return elseBlock;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ElseIf createElseIf()
  {
    ElseIfImpl elseIf = new ElseIfImpl();
    return elseIf;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NoElse createNoElse()
  {
    NoElseImpl noElse = new NoElseImpl();
    return noElse;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfThenElseExpr createIfThenElseExpr()
  {
    IfThenElseExprImpl ifThenElseExpr = new IfThenElseExprImpl();
    return ifThenElseExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ChoiceExpr createChoiceExpr()
  {
    ChoiceExprImpl choiceExpr = new ChoiceExprImpl();
    return choiceExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryExpr createBinaryExpr()
  {
    BinaryExprImpl binaryExpr = new BinaryExprImpl();
    return binaryExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryNegationExpr createUnaryNegationExpr()
  {
    UnaryNegationExprImpl unaryNegationExpr = new UnaryNegationExprImpl();
    return unaryNegationExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnaryMinusExpr createUnaryMinusExpr()
  {
    UnaryMinusExprImpl unaryMinusExpr = new UnaryMinusExprImpl();
    return unaryMinusExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordAccessExpr createRecordAccessExpr()
  {
    RecordAccessExprImpl recordAccessExpr = new RecordAccessExprImpl();
    return recordAccessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RecordUpdateExpr createRecordUpdateExpr()
  {
    RecordUpdateExprImpl recordUpdateExpr = new RecordUpdateExprImpl();
    return recordUpdateExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayAccessExpr createArrayAccessExpr()
  {
    ArrayAccessExprImpl arrayAccessExpr = new ArrayAccessExprImpl();
    return arrayAccessExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ArrayUpdateExpr createArrayUpdateExpr()
  {
    ArrayUpdateExprImpl arrayUpdateExpr = new ArrayUpdateExprImpl();
    return arrayUpdateExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteralExpr createBooleanLiteralExpr()
  {
    BooleanLiteralExprImpl booleanLiteralExpr = new BooleanLiteralExprImpl();
    return booleanLiteralExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerLiteralExpr createIntegerLiteralExpr()
  {
    IntegerLiteralExprImpl integerLiteralExpr = new IntegerLiteralExprImpl();
    return integerLiteralExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IntegerWildCardExpr createIntegerWildCardExpr()
  {
    IntegerWildCardExprImpl integerWildCardExpr = new IntegerWildCardExprImpl();
    return integerWildCardExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RealLiteralExpr createRealLiteralExpr()
  {
    RealLiteralExprImpl realLiteralExpr = new RealLiteralExprImpl();
    return realLiteralExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteralExpr createStringLiteralExpr()
  {
    StringLiteralExprImpl stringLiteralExpr = new StringLiteralExprImpl();
    return stringLiteralExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InitExpr createInitExpr()
  {
    InitExprImpl initExpr = new InitExprImpl();
    return initExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SecondInit createSecondInit()
  {
    SecondInitImpl secondInit = new SecondInitImpl();
    return secondInit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IdExpr createIdExpr()
  {
    IdExprImpl idExpr = new IdExprImpl();
    return idExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FcnCallExpr createFcnCallExpr()
  {
    FcnCallExprImpl fcnCallExpr = new FcnCallExprImpl();
    return fcnCallExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleType createTupleType()
  {
    TupleTypeImpl tupleType = new TupleTypeImpl();
    return tupleType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public FreshVariable createFreshVariable()
  {
    FreshVariableImpl freshVariable = new FreshVariableImpl();
    return freshVariable;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LimpPackage getLimpPackage()
  {
    return (LimpPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static LimpPackage getPackage()
  {
    return LimpPackage.eINSTANCE;
  }

} //LimpFactoryImpl
