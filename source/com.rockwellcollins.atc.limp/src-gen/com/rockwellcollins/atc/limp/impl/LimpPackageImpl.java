/**
 */
package com.rockwellcollins.atc.limp.impl;

import com.rockwellcollins.atc.limp.AbstractType;
import com.rockwellcollins.atc.limp.AbstractTypeDef;
import com.rockwellcollins.atc.limp.ArrayAccessExpr;
import com.rockwellcollins.atc.limp.ArrayExpr;
import com.rockwellcollins.atc.limp.ArrayType;
import com.rockwellcollins.atc.limp.ArrayTypeDef;
import com.rockwellcollins.atc.limp.ArrayUpdateExpr;
import com.rockwellcollins.atc.limp.AssignmentStatement;
import com.rockwellcollins.atc.limp.Attribute;
import com.rockwellcollins.atc.limp.AttributeBlock;
import com.rockwellcollins.atc.limp.BinaryExpr;
import com.rockwellcollins.atc.limp.BoolType;
import com.rockwellcollins.atc.limp.BooleanLiteralExpr;
import com.rockwellcollins.atc.limp.BreakStatement;
import com.rockwellcollins.atc.limp.ChoiceExpr;
import com.rockwellcollins.atc.limp.Comment;
import com.rockwellcollins.atc.limp.ConstantDeclaration;
import com.rockwellcollins.atc.limp.ContinueStatement;
import com.rockwellcollins.atc.limp.Declaration;
import com.rockwellcollins.atc.limp.Define;
import com.rockwellcollins.atc.limp.DefineUseRef;
import com.rockwellcollins.atc.limp.Else;
import com.rockwellcollins.atc.limp.ElseBlock;
import com.rockwellcollins.atc.limp.ElseIf;
import com.rockwellcollins.atc.limp.EnumType;
import com.rockwellcollins.atc.limp.EnumTypeDef;
import com.rockwellcollins.atc.limp.EnumValue;
import com.rockwellcollins.atc.limp.Equation;
import com.rockwellcollins.atc.limp.EquationBlock;
import com.rockwellcollins.atc.limp.Expr;
import com.rockwellcollins.atc.limp.ExprList;
import com.rockwellcollins.atc.limp.ExternalFunction;
import com.rockwellcollins.atc.limp.ExternalProcedure;
import com.rockwellcollins.atc.limp.FcnCallExpr;
import com.rockwellcollins.atc.limp.ForStatement;
import com.rockwellcollins.atc.limp.FreshVariable;
import com.rockwellcollins.atc.limp.FunctionRef;
import com.rockwellcollins.atc.limp.GlobalDeclaration;
import com.rockwellcollins.atc.limp.GotoStatement;
import com.rockwellcollins.atc.limp.IdExpr;
import com.rockwellcollins.atc.limp.IdList;
import com.rockwellcollins.atc.limp.IfThenElseExpr;
import com.rockwellcollins.atc.limp.IfThenElseStatement;
import com.rockwellcollins.atc.limp.Import;
import com.rockwellcollins.atc.limp.InitExpr;
import com.rockwellcollins.atc.limp.InputArg;
import com.rockwellcollins.atc.limp.InputArgList;
import com.rockwellcollins.atc.limp.IntegerLiteralExpr;
import com.rockwellcollins.atc.limp.IntegerType;
import com.rockwellcollins.atc.limp.IntegerWildCardExpr;
import com.rockwellcollins.atc.limp.LabelStatement;
import com.rockwellcollins.atc.limp.LimpFactory;
import com.rockwellcollins.atc.limp.LimpPackage;
import com.rockwellcollins.atc.limp.LocalArg;
import com.rockwellcollins.atc.limp.LocalFunction;
import com.rockwellcollins.atc.limp.LocalProcedure;
import com.rockwellcollins.atc.limp.NamedType;
import com.rockwellcollins.atc.limp.NoAttributeBlock;
import com.rockwellcollins.atc.limp.NoElse;
import com.rockwellcollins.atc.limp.NoVarBlock;
import com.rockwellcollins.atc.limp.OutputArg;
import com.rockwellcollins.atc.limp.OutputArgList;
import com.rockwellcollins.atc.limp.Postcondition;
import com.rockwellcollins.atc.limp.Precondition;
import com.rockwellcollins.atc.limp.RealLiteralExpr;
import com.rockwellcollins.atc.limp.RealType;
import com.rockwellcollins.atc.limp.RecordAccessExpr;
import com.rockwellcollins.atc.limp.RecordExpr;
import com.rockwellcollins.atc.limp.RecordFieldExpr;
import com.rockwellcollins.atc.limp.RecordFieldType;
import com.rockwellcollins.atc.limp.RecordType;
import com.rockwellcollins.atc.limp.RecordTypeDef;
import com.rockwellcollins.atc.limp.RecordUpdateExpr;
import com.rockwellcollins.atc.limp.ReturnStatement;
import com.rockwellcollins.atc.limp.SecondInit;
import com.rockwellcollins.atc.limp.SomeAttributeBlock;
import com.rockwellcollins.atc.limp.SomeVarBlock;
import com.rockwellcollins.atc.limp.Specification;
import com.rockwellcollins.atc.limp.Statement;
import com.rockwellcollins.atc.limp.StatementBlock;
import com.rockwellcollins.atc.limp.StringLiteralExpr;
import com.rockwellcollins.atc.limp.StringType;
import com.rockwellcollins.atc.limp.TupleType;
import com.rockwellcollins.atc.limp.Type;
import com.rockwellcollins.atc.limp.TypeAlias;
import com.rockwellcollins.atc.limp.TypeDeclaration;
import com.rockwellcollins.atc.limp.UnaryMinusExpr;
import com.rockwellcollins.atc.limp.UnaryNegationExpr;
import com.rockwellcollins.atc.limp.Uses;
import com.rockwellcollins.atc.limp.VarBlock;
import com.rockwellcollins.atc.limp.VariableRef;
import com.rockwellcollins.atc.limp.VoidStatement;
import com.rockwellcollins.atc.limp.VoidType;
import com.rockwellcollins.atc.limp.WhileStatement;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class LimpPackageImpl extends EPackageImpl implements LimpPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass declarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass commentEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass importEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass externalProcedureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localFunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localProcedureEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass varBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumTypeDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumValueEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordTypeDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayTypeDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractTypeDefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordFieldTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constantDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass globalDeclarationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass variableRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputArgListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass inputArgEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass localArgEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputArgListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass outputArgEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass attributeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass preconditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass postconditionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineUseRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defineEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass usesEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass statementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass voidStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass assignmentStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifThenElseStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass whileStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass forStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass labelStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass gotoStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equationBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass equationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionRefEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordFieldExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass exprListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeAliasEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass someVarBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass noVarBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass voidTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass boolTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass enumTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass someAttributeBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass noAttributeBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass breakStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass continueStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass returnStatementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elseBlockEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass elseIfEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass noElseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifThenElseExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass choiceExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryNegationExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unaryMinusExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordAccessExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass recordUpdateExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayAccessExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass arrayUpdateExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerLiteralExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass integerWildCardExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass realLiteralExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass initExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass secondInitEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass idExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fcnCallExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleTypeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass freshVariableEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see com.rockwellcollins.atc.limp.LimpPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private LimpPackageImpl()
  {
    super(eNS_URI, LimpFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link LimpPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static LimpPackage init()
  {
    if (isInited) return (LimpPackage)EPackage.Registry.INSTANCE.getEPackage(LimpPackage.eNS_URI);

    // Obtain or create and register package
    LimpPackageImpl theLimpPackage = (LimpPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof LimpPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new LimpPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theLimpPackage.createPackageContents();

    // Initialize created meta-data
    theLimpPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theLimpPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(LimpPackage.eNS_URI, theLimpPackage);
    return theLimpPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecification()
  {
    return specificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecification_Declarations()
  {
    return (EReference)specificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDeclaration()
  {
    return declarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getComment()
  {
    return commentEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getComment_Comment()
  {
    return (EAttribute)commentEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getImport()
  {
    return importEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getImport_ImportURI()
  {
    return (EAttribute)importEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalFunction()
  {
    return externalFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalFunction_Name()
  {
    return (EAttribute)externalFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalFunction_Inputs()
  {
    return (EReference)externalFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalFunction_Output()
  {
    return (EReference)externalFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExternalProcedure()
  {
    return externalProcedureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getExternalProcedure_Name()
  {
    return (EAttribute)externalProcedureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalProcedure_Inputs()
  {
    return (EReference)externalProcedureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalProcedure_Outputs()
  {
    return (EReference)externalProcedureEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExternalProcedure_AttributeBlock()
  {
    return (EReference)externalProcedureEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalFunction()
  {
    return localFunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocalFunction_Name()
  {
    return (EAttribute)localFunctionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalFunction_Inputs()
  {
    return (EReference)localFunctionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalFunction_Output()
  {
    return (EReference)localFunctionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalFunction_VarBlock()
  {
    return (EReference)localFunctionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalFunction_EquationBlock()
  {
    return (EReference)localFunctionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalProcedure()
  {
    return localProcedureEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLocalProcedure_Name()
  {
    return (EAttribute)localProcedureEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalProcedure_Inputs()
  {
    return (EReference)localProcedureEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalProcedure_Outputs()
  {
    return (EReference)localProcedureEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalProcedure_VarBlock()
  {
    return (EReference)localProcedureEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalProcedure_AttributeBlock()
  {
    return (EReference)localProcedureEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalProcedure_Statementblock()
  {
    return (EReference)localProcedureEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeDeclaration()
  {
    return typeDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeDeclaration_Name()
  {
    return (EAttribute)typeDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVarBlock()
  {
    return varBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumTypeDef()
  {
    return enumTypeDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumTypeDef_Enumerations()
  {
    return (EReference)enumTypeDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumValue()
  {
    return enumValueEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordTypeDef()
  {
    return recordTypeDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordTypeDef_Fields()
  {
    return (EReference)recordTypeDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayTypeDef()
  {
    return arrayTypeDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayTypeDef_BaseType()
  {
    return (EReference)arrayTypeDefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getArrayTypeDef_Size()
  {
    return (EAttribute)arrayTypeDefEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractTypeDef()
  {
    return abstractTypeDefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordFieldType()
  {
    return recordFieldTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordFieldType_FieldName()
  {
    return (EAttribute)recordFieldTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordFieldType_FieldType()
  {
    return (EReference)recordFieldTypeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstantDeclaration()
  {
    return constantDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDeclaration_Type()
  {
    return (EReference)constantDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstantDeclaration_Expr()
  {
    return (EReference)constantDeclarationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGlobalDeclaration()
  {
    return globalDeclarationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGlobalDeclaration_Type()
  {
    return (EReference)globalDeclarationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVariableRef()
  {
    return variableRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getVariableRef_Name()
  {
    return (EAttribute)variableRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputArgList()
  {
    return inputArgListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputArgList_InputArgs()
  {
    return (EReference)inputArgListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInputArg()
  {
    return inputArgEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInputArg_Type()
  {
    return (EReference)inputArgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLocalArg()
  {
    return localArgEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLocalArg_Type()
  {
    return (EReference)localArgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutputArgList()
  {
    return outputArgListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputArgList_OutputArgs()
  {
    return (EReference)outputArgListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOutputArg()
  {
    return outputArgEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOutputArg_Type()
  {
    return (EReference)outputArgEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getType()
  {
    return typeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttributeBlock()
  {
    return attributeBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAttribute()
  {
    return attributeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrecondition()
  {
    return preconditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPrecondition_Name()
  {
    return (EAttribute)preconditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrecondition_Expr()
  {
    return (EReference)preconditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPostcondition()
  {
    return postconditionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getPostcondition_Name()
  {
    return (EAttribute)postconditionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPostcondition_Expr()
  {
    return (EReference)postconditionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefineUseRef()
  {
    return defineUseRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefineUseRef_ReferenceExpr()
  {
    return (EReference)defineUseRefEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefine()
  {
    return defineEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefine_Elements()
  {
    return (EReference)defineEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUses()
  {
    return usesEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUses_Elements()
  {
    return (EReference)usesEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatementBlock()
  {
    return statementBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getStatementBlock_Statements()
  {
    return (EReference)statementBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStatement()
  {
    return statementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVoidStatement()
  {
    return voidStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getVoidStatement_Expr()
  {
    return (EReference)voidStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAssignmentStatement()
  {
    return assignmentStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentStatement_Ids()
  {
    return (EReference)assignmentStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAssignmentStatement_Rhs()
  {
    return (EReference)assignmentStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfThenElseStatement()
  {
    return ifThenElseStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseStatement_Cond()
  {
    return (EReference)ifThenElseStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseStatement_ThenBlock()
  {
    return (EReference)ifThenElseStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseStatement_Else()
  {
    return (EReference)ifThenElseStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElse()
  {
    return elseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWhileStatement()
  {
    return whileStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Cond()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWhileStatement_Block()
  {
    return (EReference)whileStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getForStatement()
  {
    return forStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_InitStatement()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_LimitExpr()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_IncrementStatement()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getForStatement_Block()
  {
    return (EReference)forStatementEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLabelStatement()
  {
    return labelStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLabelStatement_Name()
  {
    return (EAttribute)labelStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGotoStatement()
  {
    return gotoStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGotoStatement_Label()
  {
    return (EReference)gotoStatementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getGotoStatement_WhenExpr()
  {
    return (EReference)gotoStatementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEquationBlock()
  {
    return equationBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEquationBlock_Equations()
  {
    return (EReference)equationBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEquation()
  {
    return equationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdList()
  {
    return idListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIdList_Ids()
  {
    return (EReference)idListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpr()
  {
    return exprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunctionRef()
  {
    return functionRefEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayExpr()
  {
    return arrayExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayExpr_ArrayDefinition()
  {
    return (EReference)arrayExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayExpr_ExprList()
  {
    return (EReference)arrayExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordExpr()
  {
    return recordExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_RecordDefinition()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordExpr_FieldExprList()
  {
    return (EReference)recordExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordFieldExpr()
  {
    return recordFieldExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordFieldExpr_FieldName()
  {
    return (EAttribute)recordFieldExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordFieldExpr_FieldExpr()
  {
    return (EReference)recordFieldExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExprList()
  {
    return exprListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExprList_ExprList()
  {
    return (EReference)exprListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeAlias()
  {
    return typeAliasEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeAlias_Type()
  {
    return (EReference)typeAliasEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSomeVarBlock()
  {
    return someVarBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSomeVarBlock_Locals()
  {
    return (EReference)someVarBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNoVarBlock()
  {
    return noVarBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getVoidType()
  {
    return voidTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBoolType()
  {
    return boolTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerType()
  {
    return integerTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealType()
  {
    return realTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringType()
  {
    return stringTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEnumType()
  {
    return enumTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getEnumType_EnumDef()
  {
    return (EReference)enumTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordType()
  {
    return recordTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordType_RecordDef()
  {
    return (EReference)recordTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayType()
  {
    return arrayTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayType_ArrayDef()
  {
    return (EReference)arrayTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractType()
  {
    return abstractTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractType_AbstractDef()
  {
    return (EReference)abstractTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedType()
  {
    return namedTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNamedType_Alias()
  {
    return (EReference)namedTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSomeAttributeBlock()
  {
    return someAttributeBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSomeAttributeBlock_AttributeList()
  {
    return (EReference)someAttributeBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNoAttributeBlock()
  {
    return noAttributeBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBreakStatement()
  {
    return breakStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContinueStatement()
  {
    return continueStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getReturnStatement()
  {
    return returnStatementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElseBlock()
  {
    return elseBlockEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseBlock_Block()
  {
    return (EReference)elseBlockEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getElseIf()
  {
    return elseIfEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getElseIf_IfThenElse()
  {
    return (EReference)elseIfEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNoElse()
  {
    return noElseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfThenElseExpr()
  {
    return ifThenElseExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseExpr_CondExpr()
  {
    return (EReference)ifThenElseExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseExpr_ThenExpr()
  {
    return (EReference)ifThenElseExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfThenElseExpr_ElseExpr()
  {
    return (EReference)ifThenElseExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getChoiceExpr()
  {
    return choiceExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoiceExpr_First()
  {
    return (EReference)choiceExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getChoiceExpr_Second()
  {
    return (EReference)choiceExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryExpr()
  {
    return binaryExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryExpr_Left()
  {
    return (EReference)binaryExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinaryExpr_Op()
  {
    return (EAttribute)binaryExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getBinaryExpr_Right()
  {
    return (EReference)binaryExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryNegationExpr()
  {
    return unaryNegationExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryNegationExpr_Expr()
  {
    return (EReference)unaryNegationExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnaryMinusExpr()
  {
    return unaryMinusExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnaryMinusExpr_Expr()
  {
    return (EReference)unaryMinusExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordAccessExpr()
  {
    return recordAccessExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordAccessExpr_Record()
  {
    return (EReference)recordAccessExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordAccessExpr_Field()
  {
    return (EAttribute)recordAccessExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRecordUpdateExpr()
  {
    return recordUpdateExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordUpdateExpr_Record()
  {
    return (EReference)recordUpdateExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRecordUpdateExpr_Field()
  {
    return (EAttribute)recordUpdateExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRecordUpdateExpr_Value()
  {
    return (EReference)recordUpdateExprEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayAccessExpr()
  {
    return arrayAccessExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayAccessExpr_Array()
  {
    return (EReference)arrayAccessExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayAccessExpr_Index()
  {
    return (EReference)arrayAccessExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getArrayUpdateExpr()
  {
    return arrayUpdateExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayUpdateExpr_Access()
  {
    return (EReference)arrayUpdateExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getArrayUpdateExpr_Value()
  {
    return (EReference)arrayUpdateExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteralExpr()
  {
    return booleanLiteralExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanLiteralExpr_BoolVal()
  {
    return (EAttribute)booleanLiteralExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerLiteralExpr()
  {
    return integerLiteralExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIntegerLiteralExpr_IntVal()
  {
    return (EAttribute)integerLiteralExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIntegerWildCardExpr()
  {
    return integerWildCardExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRealLiteralExpr()
  {
    return realLiteralExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRealLiteralExpr_RealVal()
  {
    return (EAttribute)realLiteralExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteralExpr()
  {
    return stringLiteralExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteralExpr_StringVal()
  {
    return (EAttribute)stringLiteralExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInitExpr()
  {
    return initExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInitExpr_Id()
  {
    return (EReference)initExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSecondInit()
  {
    return secondInitEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSecondInit_Id()
  {
    return (EReference)secondInitEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIdExpr()
  {
    return idExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIdExpr_Id()
  {
    return (EReference)idExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFcnCallExpr()
  {
    return fcnCallExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFcnCallExpr_Id()
  {
    return (EReference)fcnCallExprEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getFcnCallExpr_Exprs()
  {
    return (EReference)fcnCallExprEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleType()
  {
    return tupleTypeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleType_TypeList()
  {
    return (EReference)tupleTypeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFreshVariable()
  {
    return freshVariableEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFreshVariable_Value()
  {
    return (EAttribute)freshVariableEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LimpFactory getLimpFactory()
  {
    return (LimpFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    specificationEClass = createEClass(SPECIFICATION);
    createEReference(specificationEClass, SPECIFICATION__DECLARATIONS);

    declarationEClass = createEClass(DECLARATION);

    commentEClass = createEClass(COMMENT);
    createEAttribute(commentEClass, COMMENT__COMMENT);

    importEClass = createEClass(IMPORT);
    createEAttribute(importEClass, IMPORT__IMPORT_URI);

    externalFunctionEClass = createEClass(EXTERNAL_FUNCTION);
    createEAttribute(externalFunctionEClass, EXTERNAL_FUNCTION__NAME);
    createEReference(externalFunctionEClass, EXTERNAL_FUNCTION__INPUTS);
    createEReference(externalFunctionEClass, EXTERNAL_FUNCTION__OUTPUT);

    externalProcedureEClass = createEClass(EXTERNAL_PROCEDURE);
    createEAttribute(externalProcedureEClass, EXTERNAL_PROCEDURE__NAME);
    createEReference(externalProcedureEClass, EXTERNAL_PROCEDURE__INPUTS);
    createEReference(externalProcedureEClass, EXTERNAL_PROCEDURE__OUTPUTS);
    createEReference(externalProcedureEClass, EXTERNAL_PROCEDURE__ATTRIBUTE_BLOCK);

    localFunctionEClass = createEClass(LOCAL_FUNCTION);
    createEAttribute(localFunctionEClass, LOCAL_FUNCTION__NAME);
    createEReference(localFunctionEClass, LOCAL_FUNCTION__INPUTS);
    createEReference(localFunctionEClass, LOCAL_FUNCTION__OUTPUT);
    createEReference(localFunctionEClass, LOCAL_FUNCTION__VAR_BLOCK);
    createEReference(localFunctionEClass, LOCAL_FUNCTION__EQUATION_BLOCK);

    localProcedureEClass = createEClass(LOCAL_PROCEDURE);
    createEAttribute(localProcedureEClass, LOCAL_PROCEDURE__NAME);
    createEReference(localProcedureEClass, LOCAL_PROCEDURE__INPUTS);
    createEReference(localProcedureEClass, LOCAL_PROCEDURE__OUTPUTS);
    createEReference(localProcedureEClass, LOCAL_PROCEDURE__VAR_BLOCK);
    createEReference(localProcedureEClass, LOCAL_PROCEDURE__ATTRIBUTE_BLOCK);
    createEReference(localProcedureEClass, LOCAL_PROCEDURE__STATEMENTBLOCK);

    typeDeclarationEClass = createEClass(TYPE_DECLARATION);
    createEAttribute(typeDeclarationEClass, TYPE_DECLARATION__NAME);

    varBlockEClass = createEClass(VAR_BLOCK);

    enumTypeDefEClass = createEClass(ENUM_TYPE_DEF);
    createEReference(enumTypeDefEClass, ENUM_TYPE_DEF__ENUMERATIONS);

    enumValueEClass = createEClass(ENUM_VALUE);

    recordTypeDefEClass = createEClass(RECORD_TYPE_DEF);
    createEReference(recordTypeDefEClass, RECORD_TYPE_DEF__FIELDS);

    arrayTypeDefEClass = createEClass(ARRAY_TYPE_DEF);
    createEReference(arrayTypeDefEClass, ARRAY_TYPE_DEF__BASE_TYPE);
    createEAttribute(arrayTypeDefEClass, ARRAY_TYPE_DEF__SIZE);

    abstractTypeDefEClass = createEClass(ABSTRACT_TYPE_DEF);

    recordFieldTypeEClass = createEClass(RECORD_FIELD_TYPE);
    createEAttribute(recordFieldTypeEClass, RECORD_FIELD_TYPE__FIELD_NAME);
    createEReference(recordFieldTypeEClass, RECORD_FIELD_TYPE__FIELD_TYPE);

    constantDeclarationEClass = createEClass(CONSTANT_DECLARATION);
    createEReference(constantDeclarationEClass, CONSTANT_DECLARATION__TYPE);
    createEReference(constantDeclarationEClass, CONSTANT_DECLARATION__EXPR);

    globalDeclarationEClass = createEClass(GLOBAL_DECLARATION);
    createEReference(globalDeclarationEClass, GLOBAL_DECLARATION__TYPE);

    variableRefEClass = createEClass(VARIABLE_REF);
    createEAttribute(variableRefEClass, VARIABLE_REF__NAME);

    inputArgListEClass = createEClass(INPUT_ARG_LIST);
    createEReference(inputArgListEClass, INPUT_ARG_LIST__INPUT_ARGS);

    inputArgEClass = createEClass(INPUT_ARG);
    createEReference(inputArgEClass, INPUT_ARG__TYPE);

    localArgEClass = createEClass(LOCAL_ARG);
    createEReference(localArgEClass, LOCAL_ARG__TYPE);

    outputArgListEClass = createEClass(OUTPUT_ARG_LIST);
    createEReference(outputArgListEClass, OUTPUT_ARG_LIST__OUTPUT_ARGS);

    outputArgEClass = createEClass(OUTPUT_ARG);
    createEReference(outputArgEClass, OUTPUT_ARG__TYPE);

    typeEClass = createEClass(TYPE);

    attributeBlockEClass = createEClass(ATTRIBUTE_BLOCK);

    attributeEClass = createEClass(ATTRIBUTE);

    preconditionEClass = createEClass(PRECONDITION);
    createEAttribute(preconditionEClass, PRECONDITION__NAME);
    createEReference(preconditionEClass, PRECONDITION__EXPR);

    postconditionEClass = createEClass(POSTCONDITION);
    createEAttribute(postconditionEClass, POSTCONDITION__NAME);
    createEReference(postconditionEClass, POSTCONDITION__EXPR);

    defineUseRefEClass = createEClass(DEFINE_USE_REF);
    createEReference(defineUseRefEClass, DEFINE_USE_REF__REFERENCE_EXPR);

    defineEClass = createEClass(DEFINE);
    createEReference(defineEClass, DEFINE__ELEMENTS);

    usesEClass = createEClass(USES);
    createEReference(usesEClass, USES__ELEMENTS);

    statementBlockEClass = createEClass(STATEMENT_BLOCK);
    createEReference(statementBlockEClass, STATEMENT_BLOCK__STATEMENTS);

    statementEClass = createEClass(STATEMENT);

    voidStatementEClass = createEClass(VOID_STATEMENT);
    createEReference(voidStatementEClass, VOID_STATEMENT__EXPR);

    assignmentStatementEClass = createEClass(ASSIGNMENT_STATEMENT);
    createEReference(assignmentStatementEClass, ASSIGNMENT_STATEMENT__IDS);
    createEReference(assignmentStatementEClass, ASSIGNMENT_STATEMENT__RHS);

    ifThenElseStatementEClass = createEClass(IF_THEN_ELSE_STATEMENT);
    createEReference(ifThenElseStatementEClass, IF_THEN_ELSE_STATEMENT__COND);
    createEReference(ifThenElseStatementEClass, IF_THEN_ELSE_STATEMENT__THEN_BLOCK);
    createEReference(ifThenElseStatementEClass, IF_THEN_ELSE_STATEMENT__ELSE);

    elseEClass = createEClass(ELSE);

    whileStatementEClass = createEClass(WHILE_STATEMENT);
    createEReference(whileStatementEClass, WHILE_STATEMENT__COND);
    createEReference(whileStatementEClass, WHILE_STATEMENT__BLOCK);

    forStatementEClass = createEClass(FOR_STATEMENT);
    createEReference(forStatementEClass, FOR_STATEMENT__INIT_STATEMENT);
    createEReference(forStatementEClass, FOR_STATEMENT__LIMIT_EXPR);
    createEReference(forStatementEClass, FOR_STATEMENT__INCREMENT_STATEMENT);
    createEReference(forStatementEClass, FOR_STATEMENT__BLOCK);

    labelStatementEClass = createEClass(LABEL_STATEMENT);
    createEAttribute(labelStatementEClass, LABEL_STATEMENT__NAME);

    gotoStatementEClass = createEClass(GOTO_STATEMENT);
    createEReference(gotoStatementEClass, GOTO_STATEMENT__LABEL);
    createEReference(gotoStatementEClass, GOTO_STATEMENT__WHEN_EXPR);

    equationBlockEClass = createEClass(EQUATION_BLOCK);
    createEReference(equationBlockEClass, EQUATION_BLOCK__EQUATIONS);

    equationEClass = createEClass(EQUATION);

    idListEClass = createEClass(ID_LIST);
    createEReference(idListEClass, ID_LIST__IDS);

    exprEClass = createEClass(EXPR);

    functionRefEClass = createEClass(FUNCTION_REF);

    arrayExprEClass = createEClass(ARRAY_EXPR);
    createEReference(arrayExprEClass, ARRAY_EXPR__ARRAY_DEFINITION);
    createEReference(arrayExprEClass, ARRAY_EXPR__EXPR_LIST);

    recordExprEClass = createEClass(RECORD_EXPR);
    createEReference(recordExprEClass, RECORD_EXPR__RECORD_DEFINITION);
    createEReference(recordExprEClass, RECORD_EXPR__FIELD_EXPR_LIST);

    recordFieldExprEClass = createEClass(RECORD_FIELD_EXPR);
    createEAttribute(recordFieldExprEClass, RECORD_FIELD_EXPR__FIELD_NAME);
    createEReference(recordFieldExprEClass, RECORD_FIELD_EXPR__FIELD_EXPR);

    exprListEClass = createEClass(EXPR_LIST);
    createEReference(exprListEClass, EXPR_LIST__EXPR_LIST);

    typeAliasEClass = createEClass(TYPE_ALIAS);
    createEReference(typeAliasEClass, TYPE_ALIAS__TYPE);

    someVarBlockEClass = createEClass(SOME_VAR_BLOCK);
    createEReference(someVarBlockEClass, SOME_VAR_BLOCK__LOCALS);

    noVarBlockEClass = createEClass(NO_VAR_BLOCK);

    voidTypeEClass = createEClass(VOID_TYPE);

    boolTypeEClass = createEClass(BOOL_TYPE);

    integerTypeEClass = createEClass(INTEGER_TYPE);

    realTypeEClass = createEClass(REAL_TYPE);

    stringTypeEClass = createEClass(STRING_TYPE);

    enumTypeEClass = createEClass(ENUM_TYPE);
    createEReference(enumTypeEClass, ENUM_TYPE__ENUM_DEF);

    recordTypeEClass = createEClass(RECORD_TYPE);
    createEReference(recordTypeEClass, RECORD_TYPE__RECORD_DEF);

    arrayTypeEClass = createEClass(ARRAY_TYPE);
    createEReference(arrayTypeEClass, ARRAY_TYPE__ARRAY_DEF);

    abstractTypeEClass = createEClass(ABSTRACT_TYPE);
    createEReference(abstractTypeEClass, ABSTRACT_TYPE__ABSTRACT_DEF);

    namedTypeEClass = createEClass(NAMED_TYPE);
    createEReference(namedTypeEClass, NAMED_TYPE__ALIAS);

    someAttributeBlockEClass = createEClass(SOME_ATTRIBUTE_BLOCK);
    createEReference(someAttributeBlockEClass, SOME_ATTRIBUTE_BLOCK__ATTRIBUTE_LIST);

    noAttributeBlockEClass = createEClass(NO_ATTRIBUTE_BLOCK);

    breakStatementEClass = createEClass(BREAK_STATEMENT);

    continueStatementEClass = createEClass(CONTINUE_STATEMENT);

    returnStatementEClass = createEClass(RETURN_STATEMENT);

    elseBlockEClass = createEClass(ELSE_BLOCK);
    createEReference(elseBlockEClass, ELSE_BLOCK__BLOCK);

    elseIfEClass = createEClass(ELSE_IF);
    createEReference(elseIfEClass, ELSE_IF__IF_THEN_ELSE);

    noElseEClass = createEClass(NO_ELSE);

    ifThenElseExprEClass = createEClass(IF_THEN_ELSE_EXPR);
    createEReference(ifThenElseExprEClass, IF_THEN_ELSE_EXPR__COND_EXPR);
    createEReference(ifThenElseExprEClass, IF_THEN_ELSE_EXPR__THEN_EXPR);
    createEReference(ifThenElseExprEClass, IF_THEN_ELSE_EXPR__ELSE_EXPR);

    choiceExprEClass = createEClass(CHOICE_EXPR);
    createEReference(choiceExprEClass, CHOICE_EXPR__FIRST);
    createEReference(choiceExprEClass, CHOICE_EXPR__SECOND);

    binaryExprEClass = createEClass(BINARY_EXPR);
    createEReference(binaryExprEClass, BINARY_EXPR__LEFT);
    createEAttribute(binaryExprEClass, BINARY_EXPR__OP);
    createEReference(binaryExprEClass, BINARY_EXPR__RIGHT);

    unaryNegationExprEClass = createEClass(UNARY_NEGATION_EXPR);
    createEReference(unaryNegationExprEClass, UNARY_NEGATION_EXPR__EXPR);

    unaryMinusExprEClass = createEClass(UNARY_MINUS_EXPR);
    createEReference(unaryMinusExprEClass, UNARY_MINUS_EXPR__EXPR);

    recordAccessExprEClass = createEClass(RECORD_ACCESS_EXPR);
    createEReference(recordAccessExprEClass, RECORD_ACCESS_EXPR__RECORD);
    createEAttribute(recordAccessExprEClass, RECORD_ACCESS_EXPR__FIELD);

    recordUpdateExprEClass = createEClass(RECORD_UPDATE_EXPR);
    createEReference(recordUpdateExprEClass, RECORD_UPDATE_EXPR__RECORD);
    createEAttribute(recordUpdateExprEClass, RECORD_UPDATE_EXPR__FIELD);
    createEReference(recordUpdateExprEClass, RECORD_UPDATE_EXPR__VALUE);

    arrayAccessExprEClass = createEClass(ARRAY_ACCESS_EXPR);
    createEReference(arrayAccessExprEClass, ARRAY_ACCESS_EXPR__ARRAY);
    createEReference(arrayAccessExprEClass, ARRAY_ACCESS_EXPR__INDEX);

    arrayUpdateExprEClass = createEClass(ARRAY_UPDATE_EXPR);
    createEReference(arrayUpdateExprEClass, ARRAY_UPDATE_EXPR__ACCESS);
    createEReference(arrayUpdateExprEClass, ARRAY_UPDATE_EXPR__VALUE);

    booleanLiteralExprEClass = createEClass(BOOLEAN_LITERAL_EXPR);
    createEAttribute(booleanLiteralExprEClass, BOOLEAN_LITERAL_EXPR__BOOL_VAL);

    integerLiteralExprEClass = createEClass(INTEGER_LITERAL_EXPR);
    createEAttribute(integerLiteralExprEClass, INTEGER_LITERAL_EXPR__INT_VAL);

    integerWildCardExprEClass = createEClass(INTEGER_WILD_CARD_EXPR);

    realLiteralExprEClass = createEClass(REAL_LITERAL_EXPR);
    createEAttribute(realLiteralExprEClass, REAL_LITERAL_EXPR__REAL_VAL);

    stringLiteralExprEClass = createEClass(STRING_LITERAL_EXPR);
    createEAttribute(stringLiteralExprEClass, STRING_LITERAL_EXPR__STRING_VAL);

    initExprEClass = createEClass(INIT_EXPR);
    createEReference(initExprEClass, INIT_EXPR__ID);

    secondInitEClass = createEClass(SECOND_INIT);
    createEReference(secondInitEClass, SECOND_INIT__ID);

    idExprEClass = createEClass(ID_EXPR);
    createEReference(idExprEClass, ID_EXPR__ID);

    fcnCallExprEClass = createEClass(FCN_CALL_EXPR);
    createEReference(fcnCallExprEClass, FCN_CALL_EXPR__ID);
    createEReference(fcnCallExprEClass, FCN_CALL_EXPR__EXPRS);

    tupleTypeEClass = createEClass(TUPLE_TYPE);
    createEReference(tupleTypeEClass, TUPLE_TYPE__TYPE_LIST);

    freshVariableEClass = createEClass(FRESH_VARIABLE);
    createEAttribute(freshVariableEClass, FRESH_VARIABLE__VALUE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    commentEClass.getESuperTypes().add(this.getDeclaration());
    importEClass.getESuperTypes().add(this.getDeclaration());
    externalFunctionEClass.getESuperTypes().add(this.getDeclaration());
    externalFunctionEClass.getESuperTypes().add(this.getFunctionRef());
    externalProcedureEClass.getESuperTypes().add(this.getDeclaration());
    externalProcedureEClass.getESuperTypes().add(this.getFunctionRef());
    localFunctionEClass.getESuperTypes().add(this.getDeclaration());
    localFunctionEClass.getESuperTypes().add(this.getFunctionRef());
    localProcedureEClass.getESuperTypes().add(this.getDeclaration());
    localProcedureEClass.getESuperTypes().add(this.getFunctionRef());
    typeDeclarationEClass.getESuperTypes().add(this.getDeclaration());
    enumTypeDefEClass.getESuperTypes().add(this.getTypeDeclaration());
    enumValueEClass.getESuperTypes().add(this.getVariableRef());
    recordTypeDefEClass.getESuperTypes().add(this.getTypeDeclaration());
    arrayTypeDefEClass.getESuperTypes().add(this.getTypeDeclaration());
    abstractTypeDefEClass.getESuperTypes().add(this.getTypeDeclaration());
    constantDeclarationEClass.getESuperTypes().add(this.getDeclaration());
    constantDeclarationEClass.getESuperTypes().add(this.getVariableRef());
    globalDeclarationEClass.getESuperTypes().add(this.getDeclaration());
    globalDeclarationEClass.getESuperTypes().add(this.getVariableRef());
    inputArgEClass.getESuperTypes().add(this.getVariableRef());
    localArgEClass.getESuperTypes().add(this.getVariableRef());
    outputArgEClass.getESuperTypes().add(this.getVariableRef());
    preconditionEClass.getESuperTypes().add(this.getAttribute());
    postconditionEClass.getESuperTypes().add(this.getAttribute());
    defineEClass.getESuperTypes().add(this.getAttribute());
    usesEClass.getESuperTypes().add(this.getAttribute());
    voidStatementEClass.getESuperTypes().add(this.getStatement());
    voidStatementEClass.getESuperTypes().add(this.getEquation());
    assignmentStatementEClass.getESuperTypes().add(this.getStatement());
    assignmentStatementEClass.getESuperTypes().add(this.getEquation());
    ifThenElseStatementEClass.getESuperTypes().add(this.getStatement());
    whileStatementEClass.getESuperTypes().add(this.getStatement());
    forStatementEClass.getESuperTypes().add(this.getStatement());
    labelStatementEClass.getESuperTypes().add(this.getStatement());
    gotoStatementEClass.getESuperTypes().add(this.getStatement());
    arrayExprEClass.getESuperTypes().add(this.getExpr());
    recordExprEClass.getESuperTypes().add(this.getExpr());
    typeAliasEClass.getESuperTypes().add(this.getTypeDeclaration());
    someVarBlockEClass.getESuperTypes().add(this.getVarBlock());
    noVarBlockEClass.getESuperTypes().add(this.getVarBlock());
    voidTypeEClass.getESuperTypes().add(this.getType());
    boolTypeEClass.getESuperTypes().add(this.getType());
    integerTypeEClass.getESuperTypes().add(this.getType());
    realTypeEClass.getESuperTypes().add(this.getType());
    stringTypeEClass.getESuperTypes().add(this.getType());
    enumTypeEClass.getESuperTypes().add(this.getType());
    recordTypeEClass.getESuperTypes().add(this.getType());
    arrayTypeEClass.getESuperTypes().add(this.getType());
    abstractTypeEClass.getESuperTypes().add(this.getType());
    namedTypeEClass.getESuperTypes().add(this.getType());
    someAttributeBlockEClass.getESuperTypes().add(this.getAttributeBlock());
    noAttributeBlockEClass.getESuperTypes().add(this.getAttributeBlock());
    breakStatementEClass.getESuperTypes().add(this.getStatement());
    continueStatementEClass.getESuperTypes().add(this.getStatement());
    returnStatementEClass.getESuperTypes().add(this.getStatement());
    elseBlockEClass.getESuperTypes().add(this.getElse());
    elseIfEClass.getESuperTypes().add(this.getElse());
    noElseEClass.getESuperTypes().add(this.getElse());
    ifThenElseExprEClass.getESuperTypes().add(this.getExpr());
    choiceExprEClass.getESuperTypes().add(this.getExpr());
    binaryExprEClass.getESuperTypes().add(this.getExpr());
    unaryNegationExprEClass.getESuperTypes().add(this.getExpr());
    unaryMinusExprEClass.getESuperTypes().add(this.getExpr());
    recordAccessExprEClass.getESuperTypes().add(this.getExpr());
    recordUpdateExprEClass.getESuperTypes().add(this.getExpr());
    arrayAccessExprEClass.getESuperTypes().add(this.getExpr());
    arrayUpdateExprEClass.getESuperTypes().add(this.getExpr());
    booleanLiteralExprEClass.getESuperTypes().add(this.getExpr());
    integerLiteralExprEClass.getESuperTypes().add(this.getExpr());
    integerWildCardExprEClass.getESuperTypes().add(this.getExpr());
    realLiteralExprEClass.getESuperTypes().add(this.getExpr());
    stringLiteralExprEClass.getESuperTypes().add(this.getExpr());
    initExprEClass.getESuperTypes().add(this.getExpr());
    secondInitEClass.getESuperTypes().add(this.getExpr());
    idExprEClass.getESuperTypes().add(this.getExpr());
    fcnCallExprEClass.getESuperTypes().add(this.getExpr());
    tupleTypeEClass.getESuperTypes().add(this.getType());
    freshVariableEClass.getESuperTypes().add(this.getExpr());

    // Initialize classes and features; add operations and parameters
    initEClass(specificationEClass, Specification.class, "Specification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSpecification_Declarations(), this.getDeclaration(), null, "declarations", null, 0, -1, Specification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(declarationEClass, Declaration.class, "Declaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(commentEClass, Comment.class, "Comment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getComment_Comment(), ecorePackage.getEString(), "comment", null, 0, 1, Comment.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(importEClass, Import.class, "Import", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getImport_ImportURI(), ecorePackage.getEString(), "importURI", null, 0, 1, Import.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalFunctionEClass, ExternalFunction.class, "ExternalFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExternalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalFunction_Inputs(), this.getInputArgList(), null, "inputs", null, 0, 1, ExternalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalFunction_Output(), this.getOutputArg(), null, "output", null, 0, 1, ExternalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(externalProcedureEClass, ExternalProcedure.class, "ExternalProcedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getExternalProcedure_Name(), ecorePackage.getEString(), "name", null, 0, 1, ExternalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalProcedure_Inputs(), this.getInputArgList(), null, "inputs", null, 0, 1, ExternalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalProcedure_Outputs(), this.getOutputArgList(), null, "outputs", null, 0, 1, ExternalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExternalProcedure_AttributeBlock(), this.getAttributeBlock(), null, "attributeBlock", null, 0, 1, ExternalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(localFunctionEClass, LocalFunction.class, "LocalFunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocalFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, LocalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalFunction_Inputs(), this.getInputArgList(), null, "inputs", null, 0, 1, LocalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalFunction_Output(), this.getOutputArg(), null, "output", null, 0, 1, LocalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalFunction_VarBlock(), this.getVarBlock(), null, "varBlock", null, 0, 1, LocalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalFunction_EquationBlock(), this.getEquationBlock(), null, "equationBlock", null, 0, 1, LocalFunction.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(localProcedureEClass, LocalProcedure.class, "LocalProcedure", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLocalProcedure_Name(), ecorePackage.getEString(), "name", null, 0, 1, LocalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalProcedure_Inputs(), this.getInputArgList(), null, "inputs", null, 0, 1, LocalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalProcedure_Outputs(), this.getOutputArgList(), null, "outputs", null, 0, 1, LocalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalProcedure_VarBlock(), this.getVarBlock(), null, "varBlock", null, 0, 1, LocalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalProcedure_AttributeBlock(), this.getAttributeBlock(), null, "attributeBlock", null, 0, 1, LocalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLocalProcedure_Statementblock(), this.getStatementBlock(), null, "statementblock", null, 0, 1, LocalProcedure.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeDeclarationEClass, TypeDeclaration.class, "TypeDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTypeDeclaration_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(varBlockEClass, VarBlock.class, "VarBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumTypeDefEClass, EnumTypeDef.class, "EnumTypeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumTypeDef_Enumerations(), this.getEnumValue(), null, "enumerations", null, 0, -1, EnumTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(enumValueEClass, EnumValue.class, "EnumValue", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(recordTypeDefEClass, RecordTypeDef.class, "RecordTypeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordTypeDef_Fields(), this.getRecordFieldType(), null, "fields", null, 0, -1, RecordTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayTypeDefEClass, ArrayTypeDef.class, "ArrayTypeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayTypeDef_BaseType(), this.getType(), null, "baseType", null, 0, 1, ArrayTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getArrayTypeDef_Size(), ecorePackage.getEBigInteger(), "size", null, 0, 1, ArrayTypeDef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractTypeDefEClass, AbstractTypeDef.class, "AbstractTypeDef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(recordFieldTypeEClass, RecordFieldType.class, "RecordFieldType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordFieldType_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, RecordFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordFieldType_FieldType(), this.getType(), null, "fieldType", null, 0, 1, RecordFieldType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constantDeclarationEClass, ConstantDeclaration.class, "ConstantDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstantDeclaration_Type(), this.getType(), null, "type", null, 0, 1, ConstantDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstantDeclaration_Expr(), this.getExpr(), null, "expr", null, 0, 1, ConstantDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(globalDeclarationEClass, GlobalDeclaration.class, "GlobalDeclaration", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGlobalDeclaration_Type(), this.getType(), null, "type", null, 0, 1, GlobalDeclaration.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(variableRefEClass, VariableRef.class, "VariableRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getVariableRef_Name(), ecorePackage.getEString(), "name", null, 0, 1, VariableRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputArgListEClass, InputArgList.class, "InputArgList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInputArgList_InputArgs(), this.getInputArg(), null, "inputArgs", null, 0, -1, InputArgList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(inputArgEClass, InputArg.class, "InputArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInputArg_Type(), this.getType(), null, "type", null, 0, 1, InputArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(localArgEClass, LocalArg.class, "LocalArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLocalArg_Type(), this.getType(), null, "type", null, 0, 1, LocalArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputArgListEClass, OutputArgList.class, "OutputArgList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutputArgList_OutputArgs(), this.getOutputArg(), null, "outputArgs", null, 0, -1, OutputArgList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(outputArgEClass, OutputArg.class, "OutputArg", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOutputArg_Type(), this.getType(), null, "type", null, 0, 1, OutputArg.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeEClass, Type.class, "Type", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeBlockEClass, AttributeBlock.class, "AttributeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(attributeEClass, Attribute.class, "Attribute", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(preconditionEClass, Precondition.class, "Precondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPrecondition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Precondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrecondition_Expr(), this.getExpr(), null, "expr", null, 0, 1, Precondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(postconditionEClass, Postcondition.class, "Postcondition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getPostcondition_Name(), ecorePackage.getEString(), "name", null, 0, 1, Postcondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPostcondition_Expr(), this.getExpr(), null, "expr", null, 0, 1, Postcondition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineUseRefEClass, DefineUseRef.class, "DefineUseRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefineUseRef_ReferenceExpr(), this.getExpr(), null, "referenceExpr", null, 0, 1, DefineUseRef.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defineEClass, Define.class, "Define", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDefine_Elements(), this.getDefineUseRef(), null, "elements", null, 0, -1, Define.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(usesEClass, Uses.class, "Uses", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUses_Elements(), this.getDefineUseRef(), null, "elements", null, 0, -1, Uses.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementBlockEClass, StatementBlock.class, "StatementBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getStatementBlock_Statements(), this.getStatement(), null, "statements", null, 0, -1, StatementBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(statementEClass, Statement.class, "Statement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(voidStatementEClass, VoidStatement.class, "VoidStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getVoidStatement_Expr(), this.getExpr(), null, "expr", null, 0, 1, VoidStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(assignmentStatementEClass, AssignmentStatement.class, "AssignmentStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAssignmentStatement_Ids(), this.getIdList(), null, "ids", null, 0, 1, AssignmentStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAssignmentStatement_Rhs(), this.getExpr(), null, "rhs", null, 0, 1, AssignmentStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ifThenElseStatementEClass, IfThenElseStatement.class, "IfThenElseStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfThenElseStatement_Cond(), this.getExpr(), null, "cond", null, 0, 1, IfThenElseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElseStatement_ThenBlock(), this.getStatementBlock(), null, "thenBlock", null, 0, 1, IfThenElseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElseStatement_Else(), this.getElse(), null, "else", null, 0, 1, IfThenElseStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elseEClass, Else.class, "Else", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(whileStatementEClass, WhileStatement.class, "WhileStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWhileStatement_Cond(), this.getExpr(), null, "cond", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWhileStatement_Block(), this.getStatementBlock(), null, "block", null, 0, 1, WhileStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(forStatementEClass, ForStatement.class, "ForStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getForStatement_InitStatement(), this.getAssignmentStatement(), null, "initStatement", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_LimitExpr(), this.getExpr(), null, "limitExpr", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_IncrementStatement(), this.getAssignmentStatement(), null, "incrementStatement", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getForStatement_Block(), this.getStatementBlock(), null, "block", null, 0, 1, ForStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(labelStatementEClass, LabelStatement.class, "LabelStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLabelStatement_Name(), ecorePackage.getEString(), "name", null, 0, 1, LabelStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(gotoStatementEClass, GotoStatement.class, "GotoStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getGotoStatement_Label(), this.getLabelStatement(), null, "label", null, 0, 1, GotoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getGotoStatement_WhenExpr(), this.getExpr(), null, "whenExpr", null, 0, 1, GotoStatement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equationBlockEClass, EquationBlock.class, "EquationBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEquationBlock_Equations(), this.getEquation(), null, "equations", null, 0, -1, EquationBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(equationEClass, Equation.class, "Equation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(idListEClass, IdList.class, "IdList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIdList_Ids(), this.getVariableRef(), null, "ids", null, 0, -1, IdList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exprEClass, Expr.class, "Expr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(functionRefEClass, FunctionRef.class, "FunctionRef", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(arrayExprEClass, ArrayExpr.class, "ArrayExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayExpr_ArrayDefinition(), this.getArrayTypeDef(), null, "arrayDefinition", null, 0, 1, ArrayExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayExpr_ExprList(), this.getExpr(), null, "exprList", null, 0, -1, ArrayExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordExprEClass, RecordExpr.class, "RecordExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordExpr_RecordDefinition(), this.getRecordTypeDef(), null, "recordDefinition", null, 0, 1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordExpr_FieldExprList(), this.getRecordFieldExpr(), null, "fieldExprList", null, 0, -1, RecordExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordFieldExprEClass, RecordFieldExpr.class, "RecordFieldExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRecordFieldExpr_FieldName(), ecorePackage.getEString(), "fieldName", null, 0, 1, RecordFieldExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordFieldExpr_FieldExpr(), this.getExpr(), null, "fieldExpr", null, 0, 1, RecordFieldExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(exprListEClass, ExprList.class, "ExprList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExprList_ExprList(), this.getExpr(), null, "exprList", null, 0, -1, ExprList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeAliasEClass, TypeAlias.class, "TypeAlias", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeAlias_Type(), this.getType(), null, "type", null, 0, 1, TypeAlias.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(someVarBlockEClass, SomeVarBlock.class, "SomeVarBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSomeVarBlock_Locals(), this.getLocalArg(), null, "locals", null, 0, -1, SomeVarBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(noVarBlockEClass, NoVarBlock.class, "NoVarBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(voidTypeEClass, VoidType.class, "VoidType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(boolTypeEClass, BoolType.class, "BoolType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(integerTypeEClass, IntegerType.class, "IntegerType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(realTypeEClass, RealType.class, "RealType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(stringTypeEClass, StringType.class, "StringType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(enumTypeEClass, EnumType.class, "EnumType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getEnumType_EnumDef(), this.getEnumTypeDef(), null, "enumDef", null, 0, 1, EnumType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordTypeEClass, RecordType.class, "RecordType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordType_RecordDef(), this.getRecordTypeDef(), null, "recordDef", null, 0, 1, RecordType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayTypeEClass, ArrayType.class, "ArrayType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayType_ArrayDef(), this.getArrayTypeDef(), null, "arrayDef", null, 0, 1, ArrayType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractTypeEClass, AbstractType.class, "AbstractType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractType_AbstractDef(), this.getAbstractTypeDef(), null, "abstractDef", null, 0, 1, AbstractType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedTypeEClass, NamedType.class, "NamedType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNamedType_Alias(), this.getTypeAlias(), null, "alias", null, 0, 1, NamedType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(someAttributeBlockEClass, SomeAttributeBlock.class, "SomeAttributeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSomeAttributeBlock_AttributeList(), this.getAttribute(), null, "attributeList", null, 0, -1, SomeAttributeBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(noAttributeBlockEClass, NoAttributeBlock.class, "NoAttributeBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(breakStatementEClass, BreakStatement.class, "BreakStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(continueStatementEClass, ContinueStatement.class, "ContinueStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(returnStatementEClass, ReturnStatement.class, "ReturnStatement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(elseBlockEClass, ElseBlock.class, "ElseBlock", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElseBlock_Block(), this.getStatementBlock(), null, "block", null, 0, 1, ElseBlock.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(elseIfEClass, ElseIf.class, "ElseIf", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getElseIf_IfThenElse(), this.getIfThenElseStatement(), null, "ifThenElse", null, 0, 1, ElseIf.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(noElseEClass, NoElse.class, "NoElse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ifThenElseExprEClass, IfThenElseExpr.class, "IfThenElseExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfThenElseExpr_CondExpr(), this.getExpr(), null, "condExpr", null, 0, 1, IfThenElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElseExpr_ThenExpr(), this.getExpr(), null, "thenExpr", null, 0, 1, IfThenElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfThenElseExpr_ElseExpr(), this.getExpr(), null, "elseExpr", null, 0, 1, IfThenElseExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(choiceExprEClass, ChoiceExpr.class, "ChoiceExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getChoiceExpr_First(), this.getExpr(), null, "first", null, 0, 1, ChoiceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getChoiceExpr_Second(), this.getExpr(), null, "second", null, 0, 1, ChoiceExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(binaryExprEClass, BinaryExpr.class, "BinaryExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getBinaryExpr_Left(), this.getExpr(), null, "left", null, 0, 1, BinaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getBinaryExpr_Op(), ecorePackage.getEString(), "op", null, 0, 1, BinaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getBinaryExpr_Right(), this.getExpr(), null, "right", null, 0, 1, BinaryExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryNegationExprEClass, UnaryNegationExpr.class, "UnaryNegationExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryNegationExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, UnaryNegationExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unaryMinusExprEClass, UnaryMinusExpr.class, "UnaryMinusExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnaryMinusExpr_Expr(), this.getExpr(), null, "expr", null, 0, 1, UnaryMinusExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordAccessExprEClass, RecordAccessExpr.class, "RecordAccessExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordAccessExpr_Record(), this.getExpr(), null, "record", null, 0, 1, RecordAccessExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecordAccessExpr_Field(), ecorePackage.getEString(), "field", null, 0, 1, RecordAccessExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(recordUpdateExprEClass, RecordUpdateExpr.class, "RecordUpdateExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRecordUpdateExpr_Record(), this.getExpr(), null, "record", null, 0, 1, RecordUpdateExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRecordUpdateExpr_Field(), ecorePackage.getEString(), "field", null, 0, 1, RecordUpdateExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRecordUpdateExpr_Value(), this.getExpr(), null, "value", null, 0, 1, RecordUpdateExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayAccessExprEClass, ArrayAccessExpr.class, "ArrayAccessExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayAccessExpr_Array(), this.getExpr(), null, "array", null, 0, 1, ArrayAccessExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayAccessExpr_Index(), this.getExpr(), null, "index", null, 0, 1, ArrayAccessExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(arrayUpdateExprEClass, ArrayUpdateExpr.class, "ArrayUpdateExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getArrayUpdateExpr_Access(), this.getArrayAccessExpr(), null, "access", null, 0, 1, ArrayUpdateExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getArrayUpdateExpr_Value(), this.getExpr(), null, "value", null, 0, 1, ArrayUpdateExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralExprEClass, BooleanLiteralExpr.class, "BooleanLiteralExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteralExpr_BoolVal(), ecorePackage.getEString(), "boolVal", null, 0, 1, BooleanLiteralExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerLiteralExprEClass, IntegerLiteralExpr.class, "IntegerLiteralExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getIntegerLiteralExpr_IntVal(), ecorePackage.getEBigInteger(), "intVal", null, 0, 1, IntegerLiteralExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(integerWildCardExprEClass, IntegerWildCardExpr.class, "IntegerWildCardExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(realLiteralExprEClass, RealLiteralExpr.class, "RealLiteralExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRealLiteralExpr_RealVal(), ecorePackage.getEString(), "realVal", null, 0, 1, RealLiteralExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralExprEClass, StringLiteralExpr.class, "StringLiteralExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteralExpr_StringVal(), ecorePackage.getEString(), "stringVal", null, 0, 1, StringLiteralExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(initExprEClass, InitExpr.class, "InitExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInitExpr_Id(), this.getVariableRef(), null, "id", null, 0, 1, InitExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(secondInitEClass, SecondInit.class, "SecondInit", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSecondInit_Id(), this.getVariableRef(), null, "id", null, 0, 1, SecondInit.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(idExprEClass, IdExpr.class, "IdExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIdExpr_Id(), this.getVariableRef(), null, "id", null, 0, 1, IdExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fcnCallExprEClass, FcnCallExpr.class, "FcnCallExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getFcnCallExpr_Id(), this.getFunctionRef(), null, "id", null, 0, 1, FcnCallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getFcnCallExpr_Exprs(), this.getExprList(), null, "exprs", null, 0, 1, FcnCallExpr.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleTypeEClass, TupleType.class, "TupleType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleType_TypeList(), this.getType(), null, "typeList", null, 0, -1, TupleType.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(freshVariableEClass, FreshVariable.class, "FreshVariable", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFreshVariable_Value(), ecorePackage.getEBigInteger(), "value", null, 0, 1, FreshVariable.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //LimpPackageImpl
